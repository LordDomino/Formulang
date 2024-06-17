package com.lorddomino.fle.parsing;

import com.lorddomino.fle.exceptions.UnknownTokenException;

public class FleTokenMapper {

  public static Token match(String literal) throws UnknownTokenException {
    for (TokenDefinitions tkType : TokenDefinitions.values()) {
      if (literal.matches(tkType.getRegex())) {
        return new Token(literal, tkType);
      }
    }
    throw new UnknownTokenException(literal);
  }

}
