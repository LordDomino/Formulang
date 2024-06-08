package com.lorddomino.fle.ipa;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.lorddomino.fle.phonology.ConsonantPhone;
import com.lorddomino.fle.phonology.articulatoryproperties.ConsonantalArticulatoryProperty;
import com.lorddomino.fle.phonology.articulatoryproperties.MannerOfArticulation;
import com.lorddomino.fle.phonology.articulatoryproperties.PlaceOfArticulation;
import com.lorddomino.fle.phonology.articulatoryproperties.Voicing;

public final class IpaConsonantPhones {

  // Plosives
  public static final ConsonantPhone VOICED_BILABIAL_PLOSIVE = assembleConsonant(
    "p", Voicing.VOICED, PlaceOfArticulation.BILABIAL, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICELESS_BILABIAL_PLOSIVE = assembleConsonant(
    "b", Voicing.VOICELESS, PlaceOfArticulation.BILABIAL, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICED_ALVEOLAR_PLOSIVE = assembleConsonant(
    "t", Voicing.VOICED, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICELESS_ALVEOLAR_PLOSIVE = assembleConsonant(
    "d", Voicing.VOICELESS, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICED_RETROFLEX_PLOSIVE = assembleConsonant(
    "\u0288", Voicing.VOICED, PlaceOfArticulation.RETROFLEX, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICELESS_RETROFLEX_PLOSIVE = assembleConsonant(
    "\u0256", Voicing.VOICELESS, PlaceOfArticulation.RETROFLEX, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICED_PALATAL_PLOSIVE = assembleConsonant(
    "c", Voicing.VOICED, PlaceOfArticulation.PALATAL, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICELESS_PALATAL_PLOSIVE = assembleConsonant(
    "\u025f", Voicing.VOICELESS, PlaceOfArticulation.PALATAL, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICED_VELAR_PLOSIVE = assembleConsonant(
    "k", Voicing.VOICED, PlaceOfArticulation.VELAR, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICELESS_VELAR_PLOSIVE = assembleConsonant(
    "g", Voicing.VOICELESS, PlaceOfArticulation.VELAR, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICED_UVULAR_PLOSIVE = assembleConsonant(
    "q", Voicing.VOICED, PlaceOfArticulation.UVULAR, MannerOfArticulation.PLOSIVE);

  public static final ConsonantPhone VOICELESS_UVULAR_PLOSIVE = assembleConsonant(
    "\u0262", Voicing.VOICELESS, PlaceOfArticulation.UVULAR, MannerOfArticulation.PLOSIVE);

  // Nasals
  public static final ConsonantPhone VOICED_BILABIAL_NASAL = assembleConsonant(
    "m", Voicing.VOICED, PlaceOfArticulation.BILABIAL, MannerOfArticulation.NASAL);

  public static final ConsonantPhone VOICED_LABIODENTAL_NASAL = assembleConsonant(
    "\u0271", Voicing.VOICED, PlaceOfArticulation.LABIODENTAL, MannerOfArticulation.NASAL);

  public static final ConsonantPhone VOICED_ALVEOLAR_NASAL = assembleConsonant(
    "n", Voicing.VOICED, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.NASAL);

  public static final ConsonantPhone VOICED_RETROFLEX_NASAL = assembleConsonant(
    "\u0273", Voicing.VOICED, PlaceOfArticulation.RETROFLEX, MannerOfArticulation.NASAL);

  public static final ConsonantPhone VOICED_PALATAL_NASAL = assembleConsonant(
    "\u0272", Voicing.VOICED, PlaceOfArticulation.PALATAL, MannerOfArticulation.NASAL);

  public static final ConsonantPhone VOICED_VELAR_NASAL = assembleConsonant(
    "\u014b", Voicing.VOICED, PlaceOfArticulation.VELAR, MannerOfArticulation.NASAL);

  public static final ConsonantPhone VOICED_UVULAR_NASAL = assembleConsonant(
    "\u0274", Voicing.VOICED, PlaceOfArticulation.UVULAR, MannerOfArticulation.NASAL);

  // Trills
  public static final ConsonantPhone VOICED_BILABIAL_TRILL = assembleConsonant(
    "\u0299", Voicing.VOICED, PlaceOfArticulation.BILABIAL, MannerOfArticulation.TRILL);

  public static final ConsonantPhone VOICED_ALVEOLAR_TRILL = assembleConsonant(
    "\u0072", Voicing.VOICED, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.TRILL);

  public static final ConsonantPhone VOICED_UVULAR_TRILL = assembleConsonant(
    "\u0280", Voicing.VOICED, PlaceOfArticulation.UVULAR, MannerOfArticulation.TRILL);

  // Taps / flaps
  public static final ConsonantPhone VOICED_LABIODENTAL_TAP = assembleConsonant(
    "\u2c71", Voicing.VOICED, PlaceOfArticulation.LABIODENTAL, MannerOfArticulation.FLAP);
  public static final ConsonantPhone VOICED_LABIODENTAL_FLAP = VOICED_LABIODENTAL_TAP;

  public static final ConsonantPhone VOICED_ALVEOLAR_TAP = assembleConsonant(
    "\u027e", Voicing.VOICED, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.FLAP);
  public static final ConsonantPhone VOICED_ALVEOLAR_FLAP = VOICED_ALVEOLAR_TAP;

  public static final ConsonantPhone VOICED_RETROFLEX_TAP = assembleConsonant(
    "\u027d", Voicing.VOICED, PlaceOfArticulation.RETROFLEX, MannerOfArticulation.FLAP);

  // Fricatives
  public static final ConsonantPhone VOICELESS_BILABIAL_FRICATIVE = assembleConsonant(
    "\u0278", Voicing.VOICELESS, PlaceOfArticulation.BILABIAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICED_BILABIAL_FRICATIVE = assembleConsonant(
    "\u03b2", Voicing.VOICED, PlaceOfArticulation.BILABIAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICELESS_LABIODENTAL_FRICATIVE = assembleConsonant(
    "f", Voicing.VOICELESS, PlaceOfArticulation.LABIODENTAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICED_LABIODENTAL_FRICATIVE = assembleConsonant(
    "v", Voicing.VOICED, PlaceOfArticulation.LABIODENTAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICELESS_DENTAL_FRICATIVE = assembleConsonant(
    "\u03b8", Voicing.VOICELESS, PlaceOfArticulation.DENTAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICED_DENTAL_FRICATIVE = assembleConsonant(
    "\u00f0", Voicing.VOICED, PlaceOfArticulation.DENTAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICELESS_ALVEOLAR_FRICATIVE = assembleConsonant(
    "s", Voicing.VOICELESS, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICED_ALVEOLAR_FRICATIVE = assembleConsonant(
    "z", Voicing.VOICED, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICELESS_POSTALVEOLAR_FRICATIVE = assembleConsonant(
    "\u0283", Voicing.VOICELESS, PlaceOfArticulation.POSTALVEOLAR, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICED_POSTALVEOLAR_FRICATIVE = assembleConsonant(
    "\u0292", Voicing.VOICED, PlaceOfArticulation.POSTALVEOLAR, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICELESS_RETROFLEX_FRICATIVE = assembleConsonant(
    "\u0282", Voicing.VOICELESS, PlaceOfArticulation.RETROFLEX, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICED_RETROFLEX_FRICATIVE = assembleConsonant(
    "\u0290", Voicing.VOICED, PlaceOfArticulation.RETROFLEX, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICELESS_PALATAL_FRICATIVE = assembleConsonant(
    "\u00e7", Voicing.VOICELESS, PlaceOfArticulation.PALATAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICED_PALATAL_FRICATIVE = assembleConsonant(
    "\u029d", Voicing.VOICED, PlaceOfArticulation.PALATAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICELESS_UVULAR_FRICATIVE = assembleConsonant(
    "\u03c7", Voicing.VOICELESS, PlaceOfArticulation.UVULAR, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICED_UVULAR_FRICATIVE = assembleConsonant(
    "\u0281", Voicing.VOICED, PlaceOfArticulation.UVULAR, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICELESS_PHARYNGEAL_FRICATIVE = assembleConsonant(
    "\u0127", Voicing.VOICELESS, PlaceOfArticulation.PHARYNGEAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICED_PHARYNGEAL_FRICATIVE = assembleConsonant(
    "\u0295", Voicing.VOICED, PlaceOfArticulation.PHARYNGEAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICELESS_GLOTTAL_FRICATIVE = assembleConsonant(
    "h", Voicing.VOICELESS, PlaceOfArticulation.GLOTTAL, MannerOfArticulation.FRICATIVE);

  public static final ConsonantPhone VOICED_GLOTTAL_FRICATIVE = assembleConsonant(
    "\u0266", Voicing.VOICED, PlaceOfArticulation.GLOTTAL, MannerOfArticulation.FRICATIVE);

  // Lateral fricatives
  public static final ConsonantPhone VOICELESS_ALVEOLAR_LATERAL_FRICATIVE = assembleConsonant(
    "\u026c", Voicing.VOICELESS, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.LATERAL_FRICATIVE);

  public static final ConsonantPhone VOICED_ALVEOLAR_LATERAL_FRICATIVE = assembleConsonant(
    "\u026e", Voicing.VOICED, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.LATERAL_FRICATIVE);

  // Approximants
  public static final ConsonantPhone VOICED_LABIODENTAL_APPROXIMANT = assembleConsonant(
    "\u028b", Voicing.VOICED, PlaceOfArticulation.LABIODENTAL, MannerOfArticulation.APPROXIMANT);

  public static final ConsonantPhone VOICED_ALVEOLAR_APPROXIMANT = assembleConsonant(
    "\u0279", Voicing.VOICED, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.APPROXIMANT);

  public static final ConsonantPhone VOICED_RETROFLEX_APPROXIMANT = assembleConsonant(
    "\u027b", Voicing.VOICED, PlaceOfArticulation.RETROFLEX, MannerOfArticulation.APPROXIMANT);

  public static final ConsonantPhone VOICED_PALATAL_APPROXIMANT = assembleConsonant(
    "\u006a", Voicing.VOICED, PlaceOfArticulation.PALATAL, MannerOfArticulation.APPROXIMANT);

  public static final ConsonantPhone VOICED_VELAR_APPROXIMANT = assembleConsonant(
    "\u0270", Voicing.VOICED, PlaceOfArticulation.VELAR, MannerOfArticulation.APPROXIMANT);

  // Lateral approximants
  public static final ConsonantPhone VOICED_ALVEOLAR_LATERAL_APPROXIMANT = assembleConsonant(
    "l", Voicing.VOICED, PlaceOfArticulation.ALVEOLAR, MannerOfArticulation.LATERAL_APPROXIMANT);

  public static final ConsonantPhone VOICED_RETROFLEX_LATERAL_APPROXIMANT = assembleConsonant(
    "\u026d", Voicing.VOICED, PlaceOfArticulation.RETROFLEX, MannerOfArticulation.LATERAL_APPROXIMANT);

  public static final ConsonantPhone VOICED_PALATAL_LATERAL_APPROXIMANT = assembleConsonant(
    "\u028e", Voicing.VOICED, PlaceOfArticulation.PALATAL, MannerOfArticulation.LATERAL_APPROXIMANT);

  public static final ConsonantPhone VOICED_VELAR_LATERAL_APPROXIMANT = assembleConsonant(
    "\u029f", Voicing.VOICED, PlaceOfArticulation.VELAR, MannerOfArticulation.LATERAL_APPROXIMANT);

  public static final void load() {}

  public static final ConsonantPhone assembleConsonant(String symbol, ConsonantalArticulatoryProperty ... props) {
    Objects.requireNonNull(props, "props cannot null in RegistryAssembler");
    final LinkedHashSet<ConsonantalArticulatoryProperty> propSet = new LinkedHashSet<>(Arrays.asList(props));
    ConsonantPhone conPn = new ConsonantPhone(symbol, true, propSet);
    return conPn;
  }
}
