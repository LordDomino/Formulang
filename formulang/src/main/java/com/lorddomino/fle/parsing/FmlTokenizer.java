package com.lorddomino.fle.parsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import com.lorddomino.fle.exceptions.InvalidFileException;

public class FmlTokenizer {

  private File file;

  public FmlTokenizer(File f) throws InvalidFileException, FileNotFoundException {
    if (!f.exists()) {
      throw new FileNotFoundException("Filepath \"" + f.getPath() + "\" does not exist");
    }
    String fname = f.getName();
    String ext = fname.substring(fname.length()-4, fname.length());
    if (!ext.equals(".fml")) {
      throw new InvalidFileException(f.getName());
    }
    this.file = f;
  }

  public File getFile() {
    return this.file;
  }

  /**
   * Returns the string contents of the tokenizer's file.
   * @throws IOException
   */
  public String getString() throws IOException {
    String cleaned = "";
    BufferedReader br = new BufferedReader(new FileReader(file));
    br.ready();

    String line = "";
    while ((line = br.readLine()) != null) {
      String[] commentSplit = line.split("\\/\\/");
      System.out.println(commentSplit[0]);
      cleaned += commentSplit[0];
    }

    br.close();
    return cleaned;
  }

  /**
   * Return the string contents of the tokenizer's file without all the
   * whitespace.
   * @throws IOException
   */
  public String getCleanStr() throws IOException {
    return getString().replace("\\s+", "");
  }

  public static void main(String[] args) {
    System.out.print("\033[H\033[2J");

    File f = new File("formulang\\src\\main\\java\\com\\lorddomino\\fle\\parsing\\some_file.fml");

    try {
      FmlTokenizer scanner = new FmlTokenizer(f);

      Pattern pattern = Pattern.compile(TokenDefinitions.getRegexSplitter());
      ArrayList<String> groups = new ArrayList<>(Arrays.asList(pattern.split(scanner.getString())));

      for (String token : groups) {
        System.out.println(token);
      }

    } catch (InvalidFileException | IOException e) {
      e.printStackTrace();
    }
  }
}
