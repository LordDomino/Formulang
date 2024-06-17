package com.lorddomino.fle.parsing;

import java.util.ArrayList;
import java.util.Arrays;

import com.lorddomino.fle.exceptions.ParseErrorException;
import com.lorddomino.fle.parsing.nodes.LiteralNode;
import com.lorddomino.fle.parsing.nodes.OperatorNode;
import com.lorddomino.fle.parsing.nodes.ProgramNode;
import com.lorddomino.fle.parsing.nodes.PunctuationNode;
import com.lorddomino.fle.parsing.nodes.StatementNode;
import com.lorddomino.fle.parsing.nodes.StructureNode;
import com.lorddomino.fle.parsing.nodes.AbstractTreeNode;
import com.lorddomino.fle.parsing.nodes.BlueprintDeclarationNode;
import com.lorddomino.fle.parsing.nodes.BlueprintIdNode;
import com.lorddomino.fle.parsing.nodes.ComponentNode;
import com.lorddomino.fle.parsing.nodes.ComponentsNode;
import com.lorddomino.fle.parsing.nodes.IdNode;
import com.lorddomino.fle.parsing.nodes.IpaIdNode;
import com.lorddomino.fle.parsing.nodes.KeywordNode;

public class Parser {

  private int seqPos;
  private ArrayList<Token> tokens;
  private ArrayList<Token> nextTokens;
  private Token currentToken;

  public Parser(ArrayList<Token> tokens) {
    this.seqPos = -1;
    this.tokens = tokens;
    this.nextTokens = getNextComps(1);
    this.currentToken = null;
  }

  /**
   * Returns the components of this parser.
   * @return
   */
  public ArrayList<Token> getTokens() {
    return this.tokens;
  }

  /**
   * Retrieves components that are ahead of the current component given the
   * {@code ahead} number of components.
   * @param ahead
   * @return
   */
  private ArrayList<Token> getNextComps(int ahead) {
    ArrayList<Token> rl = new ArrayList<>();
    int curAhead = 0;
    try {
      while (curAhead < ahead) {
        curAhead += 1;
        rl.add(this.tokens.get(this.seqPos + curAhead));
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("No more components ahead due to IndexOutOfBoundsException");
    }
    return rl;
  }

  private void advance() {
    seqPos += 1;
    try {
      currentToken = tokens.get(seqPos);
    } catch(IndexOutOfBoundsException e) {
      currentToken = null;
    }
    nextTokens = getNextComps(1);
  }

  /**
   * Resets this parser to its default state as it was initialized.
   */
  private void reset() {
    this.seqPos = -1;
    this.nextTokens = getNextComps(1);
    this.currentToken = null;
  }

  private ArrayList<AbstractTreeNode> assembleNodes(AbstractTreeNode ... subnodes) {
    return new ArrayList<>(Arrays.asList(subnodes));
  }

  public ParseTree getParseTree() throws Exception {
    ParseTree pt = new ParseTree(parseProgram());
    reset();

    return pt;
  }

  /**
   * Parses the program through the production rule:
   * {@code <Program> -> <Statement>}
   * @return the program node tree
   * @throws ParseErrorException
   */
  private ProgramNode parseProgram() throws ParseErrorException {
    StatementNode statement = parseStatement();
    ProgramNode program = new ProgramNode(assembleNodes(statement));
    return program;
  }

  /**
   * Parses a statement from the production rule:
   * {@code <Statement> -> <Blueprint-declaration> <Delimiter>}
   * @return
   * @throws ParseErrorException
   */
  private StatementNode parseStatement() throws ParseErrorException {
    AbstractTreeNode bpDeclaration = parseBpDeclaration();
    PunctuationNode semicolon = new PunctuationNode(parseSymbolFromType(TokenDefinitions.DELIMITER));

    StatementNode statement = new StatementNode(assembleNodes(bpDeclaration, semicolon));
    return statement;
  }

  private BlueprintDeclarationNode parseBpDeclaration() throws ParseErrorException {
    AbstractTreeNode bpId = parseBpId();
    OperatorNode colon = new OperatorNode(parseSymbolFromType(TokenDefinitions.BLUEPRINT_ASSIGNER));
    AbstractTreeNode structure = parseStructure();

    BlueprintDeclarationNode bpDecl = new BlueprintDeclarationNode(assembleNodes(bpId, colon, structure));
    return bpDecl;
  }

  private BlueprintIdNode parseBpId() throws ParseErrorException {
    KeywordNode gamma = new KeywordNode(parseSymbolFromType(TokenDefinitions.GAMMA_KEYWORD));
    AbstractTreeNode id = parseId();

    BlueprintIdNode bpId = new BlueprintIdNode(assembleNodes(gamma, id));
    return bpId;
  }

  private IdNode parseId() throws ParseErrorException {
    return new IdNode(parseLiteral());
  }

  private AbstractTreeNode parseStructure() throws ParseErrorException {
    PunctuationNode openBrace = new PunctuationNode(parseSymbolFromType(TokenDefinitions.BRACE_OPEN));
    AbstractTreeNode components = parseComponents();
    PunctuationNode closeBrace = new PunctuationNode(parseSymbolFromType(TokenDefinitions.BRACE_CLOSE));

    StructureNode strc = new StructureNode(assembleNodes(openBrace, components, closeBrace));
    return strc;
  }

  private ComponentsNode parseComponents() throws ParseErrorException {
    ComponentNode component = parseComponent();

    ComponentsNode comps = new ComponentsNode(assembleNodes(component));
    return comps;
  }

  private ComponentNode parseComponent() throws ParseErrorException {
    if (nextTokens.get(0).getTokenType().equals(TokenDefinitions.GAMMA_KEYWORD)) {
      return new ComponentNode(assembleNodes(parseBpId()));
    } else if (nextTokens.get(0).getTokenType().equals(TokenDefinitions.BRACE_OPEN)) {
      return new ComponentNode(assembleNodes(parseStructure()));
    } else if (nextTokens.get(0).getTokenType().equals(TokenDefinitions.SLASH)) {
      return new ComponentNode(assembleNodes(parseIpaId()));
    }
    throw new ParseErrorException("Misplaced token " + nextTokens.get(0).getLiteral(), seqPos);
  }

  private IpaIdNode parseIpaId() throws ParseErrorException {
    PunctuationNode slash1 = new PunctuationNode(parseSymbolFromType(TokenDefinitions.SLASH));
    AbstractTreeNode id = parseId();
    LiteralNode slash2 = new PunctuationNode(parseSymbolFromType(TokenDefinitions.SLASH));

    IpaIdNode ipaId = new IpaIdNode(assembleNodes(slash1, id, slash2));
    return ipaId;
  }

  private String parseLiteral() throws ParseErrorException {
    advance();
    if (currentToken.getTokenType().equals(TokenDefinitions.LITERAL)) {
      return currentToken.getLiteral();
    } else {
      throw new ParseErrorException("Expected string literal at position " + seqPos + " but got " + currentToken.getTokenType().name(), seqPos);
    }
  }

  private String parseSymbol(String keyword) throws ParseErrorException {
    advance();
    if (currentToken.getLiteral().equals(keyword)) {
      return currentToken.getLiteral();
    } else {
      throw new ParseErrorException("Expected symbol " + keyword + " but got " + currentToken.getLiteral(), seqPos);
    }
  }

  private String parseSymbolFromType(TokenDefinitions token) throws ParseErrorException {
    return parseSymbol(token.getSource());
  }

  private PunctuationNode parseDelimiter() throws ParseErrorException {
    return new PunctuationNode(parseSymbolFromType(TokenDefinitions.DELIMITER));
  }

}
