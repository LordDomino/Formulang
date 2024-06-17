package com.lorddomino.fle.parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public enum TokenDefinitions {

  /**KEYWORDS */
  LANGUAGE_KEYWORD      ("lang", "lang", TokenType.KEYWORD),
  BLUEPRINTS_KEYWORD    ("blueprints", "blueprints", TokenType.KEYWORD),
  MAIN_KEYWORD          ("main", "main", TokenType.KEYWORD),
  GAMMA_KEYWORD         ("gamma", "gamma", TokenType.KEYWORD),
  INSTANCE_KEYWORD      ("new", "new", TokenType.KEYWORD),
  USING_KEYWORD         ("using", "using", TokenType.KEYWORD),
  PRINT_KEYWORD         ("print", "print", TokenType.KEYWORD),
  PRINTIPA_KEYWORD      ("printipa", "printipa", TokenType.KEYWORD),
  PRINTFML_KEYWORD      ("printfml", "printfml", TokenType.KEYWORD),

  LITERAL               ("([a-zA-Z0-9])*", "", TokenType.IDENTIFIER),

  /**WHITESPACES */
  NEWLINE               ("\n", "\n", TokenType.WHITESPACE),

  PERIOD                ("\\.", ".", TokenType.SYNTAX),
  DELIMITER             ("\\;", ";", TokenType.SYNTAX),
  UNICODE               ("\\\\u", "\\u", TokenType.SYNTAX),
  ELLIPSIS              ("\\.\\.\\.", "...", TokenType.SYNTAX),

  /**GROUPING SYMBOLS */
  SLASH                 ("\\/", "/", TokenType.GROUPING),
  BRACE_OPEN            ("\\{", "{", TokenType.GROUPING),
  BRACE_CLOSE           ("\\}", "}", TokenType.GROUPING),
  PAREN_OPEN            ("\\(", "(", TokenType.GROUPING),
  PAREN_CLOSE           ("\\)", ")", TokenType.GROUPING),
  ANGLE_BRACKET_OPEN    ("\\<", "<", TokenType.GROUPING),
  ANGLE_BRACKET_CLOSE   ("\\>", ">", TokenType.GROUPING),

  /**OPERATORS */
  MUTATOR               ("->", "->", TokenType.OPERATOR),
  CONCATENATOR          ("\\+", "+", TokenType.OPERATOR),
  SUBTRACTOR            ("\\-", "-", TokenType.OPERATOR),
  ASSIGNMENT_OPERATOR   ("\\=", "=", TokenType.OPERATOR),
  BLUEPRINT_ASSIGNER    ("\\:", ":", TokenType.OPERATOR),

  /**MISCELLANEOUS */
  COMMENT_TAG           ("\\/\\/", "//", TokenType.SYNTAX),
  ;

  private String regex;
  private String source;
  private TokenType type;

  private TokenDefinitions(String regex, String source, TokenType type) {
    this.regex = regex;
    this.source = source;
    this.type = type;
  }

  public String getRegex() {
    return this.regex;
  }

  public String getSource() {
    return this.source;
  }

  public static String getRegexSplitter() {
    ArrayList<String> definitions = new ArrayList<>();
    ArrayList<String> splits = new ArrayList<>();
    String splitter = "";

    for (TokenDefinitions def : TokenDefinitions.values()) {
      switch(def.type) {

        default:
      }

      definitions.add(def.getRegex());
    }

    Collections.sort(definitions, new StringLengthComparator());

    for (TokenDefinitions def : TokenDefinitions.values()) {
      if (def.type == TokenType.KEYWORD) {
        continue;
      }
      switch(def) {
        case LITERAL:
          splits.add("((?<=\\|[^a-zA-Z0-9])(?=[a-zA-Z0-9])|(?<=[a-zA-Z0-9])(?=[^a-zA-Z0-9]))");
          break;
        case NEWLINE:
          splits.add("(?=\\s)(?<!\\s)|(?!\\s+)(?<=\\s)");
          break;
        case ELLIPSIS:
          splits.add("((?=" + def.regex + ")|(?<=" + def.regex + "))");
          break;
        case PERIOD:
          splits.add("((?<!"+ def.regex + ")(?=" + def.regex + ")|(?<=" + def.regex + ")(?!" + def.regex + "))");
          break;
        case SUBTRACTOR:
          splits.add("((?=" + def.regex + ")|(?<=" + def.regex + ")(?!>))");
          break;
        case ANGLE_BRACKET_CLOSE:
          splits.add("((?<!\\-)(?=" + def.regex + ")|(?<=" + def.regex + "))");
          break;
        default:
          splits.add("((?=" + def.regex + ")|(?<=" + def.regex + "))");
          break;
      }
    }
    splitter = String.join("|", splits);
    return splitter;
  }

}

enum TokenType {
  KEYWORD,
  IDENTIFIER,
  SYNTAX,
  OPERATOR,
  GROUPING,
  WHITESPACE
}

class StringLengthComparator implements Comparator<String> {

  @Override
  public int compare(String o1, String o2) {
    return (o1.length() - o2.length())*-1;
  }

}
