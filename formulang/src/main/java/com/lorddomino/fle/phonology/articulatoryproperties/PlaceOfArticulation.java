package com.lorddomino.fle.phonology.articulatoryproperties;

public enum PlaceOfArticulation implements ConsonantalArticulatoryProperty {
  BILABIAL        (6.5f, 0.0f, -2.1f),
  LABIODENTAL     (6.1f, 0.0f, -2.3f),
  DENTAL          (5.8f, 0.0f, -1.9f),
  ALVEOLAR        (5.4f, 0.0f, -1.4f),
  POSTALVEOLAR   (5.0f, 0.0f, -1.0f),
  RETROFLEX       (4.6f, 0.0f, -0.7f),
  PALATAL         (4.2f, 0.0f, -0.6f),
  VELAR           (2.5f, 0.0f, -0.5f),
  UVULAR          (0.4f, 0.0f, -1.9f),
  PHARYNGEAL      (-0.6f, 0.0f, -2.6f),
  GLOTTAL         (-0.7f, 0.0f, -6.0f);

  private float x;
  private float y;
  private float z;

  private PlaceOfArticulation(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Returns the sagittal position of this {@code PlaceOfArticulation}
   * property which describes its x location along the sagittal axis.
   * @return the x-axis float value
   */
  public float getSagittalPos() {
    return x;
  }

  /**
   * Returns the coronal position of this {@code PlaceOfArticulation}
   * property which describes its y-location along the frontal axis.
   * @return the y-axis float value
   */
  public float getFrontalPos() {
    return y;
  }

  /**
   * Returns the transversal position of this
   * {@code PlaceOfArticulation} property which describes its
   * z-location along the longitudinal axis.
   * @return
   */
  public float getLongitudinalPos() {
    return z;
  }
}
