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

public class FleTokenizer {

  private File file;

  public FleTokenizer(File f) throws InvalidFileException, FileNotFoundException {
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

  /**
   * Returns the {@code File} object associated to this tokenizer.
   * @return the {@code File} object
   */
  public File getFile() {
    return this.file;
  }

  /**
   * Returns the string contents of the tokenizer's file.
   * @throws IOException If an error is encountered while reading the file
   */
  public String getString() throws IOException {
    String cleaned = "";
    BufferedReader br = new BufferedReader(new FileReader(file));
    br.ready();

    String line = "";
    while ((line = br.readLine()) != null) {
      String[] commentSplit = line.split("\\/\\/");
      cleaned += commentSplit[0];
    }

    br.close();
    return cleaned;
  }

  /**
   * Return the string contents of the tokenizer's file without all the
   * whitespace.
   * @throws IOException If an error is encountered while reading the file
   */
  public String getCleanStr() throws IOException {
    return getString().replace("\\s+", "");
  }

  /**
   * Returns the arraylist of string representing the tokens of the file.
   * @return
   */
  public ArrayList<String> tokenize() {
    Pattern pattern = Pattern.compile(TokenDefinitions.getRegexSplitter());
    ArrayList<String> groups = new ArrayList<>();
    try {
      groups = new ArrayList<>(Arrays.asList(pattern.split(getString())));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return groups;
  }
}
