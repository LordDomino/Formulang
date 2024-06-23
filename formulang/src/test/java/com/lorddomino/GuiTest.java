package com.lorddomino;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.exceptions.InvalidFileException;
import com.lorddomino.fle.exceptions.UnknownTokenException;
import com.lorddomino.fle.parsing.FleTokenizer;
import com.lorddomino.fle.parsing.FleTokenMapper;
import com.lorddomino.fle.parsing.ParseTree;
import com.lorddomino.fle.parsing.Parser;
import com.lorddomino.fle.parsing.Token;

public class GuiTest {

  @Test
  void test() {
    File f = new File("formulang\\src\\main\\java\\com\\lorddomino\\fle\\parsing\\some_file.fml");
    FleTokenizer tokenizer;
    try {
      tokenizer = new FleTokenizer(f);
      ArrayList<String> literals = tokenizer.tokenize();
      ArrayList<Token> tokens = new ArrayList<>();
      for (String literal : literals) {
        try {
          tokens.add(FleTokenMapper.match(literal));
        } catch (UnknownTokenException e) {
        }
      }
      Parser parser = new Parser(tokens);
      try {
        ParseTree pt = parser.getParseTree();
        System.out.println(pt);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException | InvalidFileException e) {
      e.printStackTrace();
    }
  }
}
