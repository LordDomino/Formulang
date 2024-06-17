package com.lorddomino.fle.exceptions;

public class ParseErrorException extends Exception {

  private int seqPos;

  public ParseErrorException(String message, int seqPos) {
    super(message);
    this.seqPos = seqPos;
  }

  public int getSeqPos() {
    return this.seqPos;
  }
}
