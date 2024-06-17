package com.lorddomino.fle.parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public enum TokenDefinitions {

  NEWLINE("\\n", TokenType.WHITESPACE),

  PERIOD("\\.", TokenType.SYNTAX),
  DELIMITER("\\;", TokenType.SYNTAX),
  UNICODE("\\\\u", TokenType.SYNTAX),
  ELLIPSIS("\\.\\.\\.", TokenType.SYNTAX),

  SLASH("\\/", TokenType.GROUPING),
  BRACE_OPEN("\\{", TokenType.GROUPING),
  BRACE_CLOSE("\\}", TokenType.GROUPING),
  PAREN_OPEN("\\(", TokenType.GROUPING),
  PAREN_CLOSE("\\)", TokenType.GROUPING),
  ANGLE_BRACKET_OPEN("\\<", TokenType.GROUPING),
  ANGLE_BRACKET_CLOSE("\\>", TokenType.GROUPING),

  /**OPERATORS */
  MUTATOR("->", TokenType.OPERATOR),
  CONCATENATOR("\\+", TokenType.OPERATOR),
  SUBTRACTOR("\\-", TokenType.OPERATOR),
  ASSIGNMENT_OPERATOR("\\=", TokenType.OPERATOR),
  BLUEPRINT_ASSIGNER("\\:", TokenType.OPERATOR),

  /**KEYWORDS */
  LANGUAGE_KEYWORD("lang", TokenType.KEYWORD),
  BLUEPRINTS_KEYWORD("blueprints", TokenType.KEYWORD),
  MAIN_KEYWORD("main", TokenType.KEYWORD),
  GAMMA_KEYWORD("gamma", TokenType.KEYWORD),
  INSTANCE_KEYWORD("new", TokenType.KEYWORD),
  USING_KEYWORD("using", TokenType.KEYWORD),
  PRINT_KEYWORD("print", TokenType.KEYWORD),
  PRINTIPA_KEYWORD("printipa", TokenType.KEYWORD),
  PRINTFML_KEYWORD("printfml", TokenType.KEYWORD),

  /**MISCELLANEOUS */
  COMMENT_TAG("\\/\\/", TokenType.SYNTAX),
  ;

  private String str;
  private TokenType type;

  private TokenDefinitions(String str, TokenType type) {
    this.str = str;
    this.type = type;
  }

  public String getStr() {
    return this.str;
  }

  public static String getRegexSplitter() {
    ArrayList<String> definitions = new ArrayList<>();
    ArrayList<String> splits = new ArrayList<>();
    String splitter = "";

    for (TokenDefinitions def : TokenDefinitions.values()) {
      switch(def.type) {

        default:
      }

      definitions.add(def.getStr());
    }

    Collections.sort(definitions, new StringLengthComparator());

    for (TokenDefinitions def : TokenDefinitions.values()) {
      if (def.type == TokenType.KEYWORD) {
        continue;
      }
      switch(def) {
        case NEWLINE:
          splits.add("(?=\\s)(?<!\\s)|(?!\\s+)(?<=\\s)");
        case ELLIPSIS:
          splits.add("((?=" + def.str + ")|(?<=" + def.str + "))");
          break;
        case PERIOD:
          splits.add("((?<!"+ def.str + ")(?=" + def.str + ")|(?<=" + def.str + ")(?!" + def.str + "))");
          break;
        case SUBTRACTOR:
          splits.add("((?=" + def.str + ")|(?<=" + def.str + ")(?!>))");
          break;
        case ANGLE_BRACKET_CLOSE:
          splits.add("((?<!\\-)(?=" + def.str + ")|(?<=" + def.str + "))");
          break;
        default:
          splits.add("((?=" + def.str + ")|(?<=" + def.str + "))");
          break;
      }
    }
    splitter = String.join("|", splits);
    return splitter;
  }

}

enum TokenType {
  KEYWORD,
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
