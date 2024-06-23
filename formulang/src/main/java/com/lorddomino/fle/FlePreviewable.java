package com.lorddomino.fle;

/**
 * Interface for providing utility methods related to retrieving and printing
 * FLE object previews.
 */
public interface FlePreviewable {

  /**
   * Returns the FLE object preview of this object. The FLE object preview of
   * an FLE object is a formatted string readable representation used by the
   * Formulang Language Engine to identify and show FLE objects.
   * @return the FLE object preview string
   */
  public abstract String getFlePreview();

  /**
   * Prints the FLE object preview of the FLE object directly to the console.
   */
  default void printFlePreview() {
    System.out.println(getFlePreview());
  }
}
