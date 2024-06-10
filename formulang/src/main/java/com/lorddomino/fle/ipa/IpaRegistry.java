package com.lorddomino.fle.ipa;

import java.util.HashSet;

import com.lorddomino.fle.phonology.ConsonantPhone;
import com.lorddomino.fle.phonology.Phone;
import com.lorddomino.fle.phonology.VowelPhone;
import com.lorddomino.fle.phonology.articulatoryproperties.ArticulatoryProperty;
import com.lorddomino.fle.phonology.articulatoryproperties.MannerOfArticulation;

public final class IpaRegistry {

  /**
   * The internal runtime reference of all phone objects set as the default IPA
   * phones recognized and utilized by the Formulang Language Engine.
   */
  private static final HashSet<Phone> PHONES = new HashSet<>();

  public static final HashSet<Phone> getPhones() {
    return IpaRegistry.PHONES;
  }

  public static final HashSet<ConsonantPhone> getConsonantPhones() {
    HashSet<ConsonantPhone> cl = new HashSet<>();
    for (Phone pn : PHONES) {
      if (pn instanceof ConsonantPhone) {
        cl.add((ConsonantPhone) pn);
      }
    }
    return cl;
  }

  public static final HashSet<VowelPhone> getVowelPhones() {
    HashSet<VowelPhone> cl = new HashSet<>();
    for (Phone pn : PHONES) {
      if (pn instanceof VowelPhone) {
        cl.add((VowelPhone) pn);
      }
    }
    return cl;
  }

  public static final HashSet<Phone> getByProperty(ArticulatoryProperty prop) {
    HashSet<Phone> cl = new HashSet<>();
    for (Phone pn : PHONES) {
      if (pn.containsProperty(prop)) {
        cl.add(pn);
      }
    }
    return cl;
  }

  public static final HashSet<Phone> getFricatives() {
    return getByProperty(MannerOfArticulation.FRICATIVE);
  }

  public static final HashSet<Phone> getNasals() {
    return getByProperty(MannerOfArticulation.NASAL);
  }

  public static final HashSet<Phone> getPlosives() {
    return getByProperty(MannerOfArticulation.PLOSIVE);
  }

  /**
   * Adds the given phone {@code pn} to the reference of all default IPA phone
   * objects recognized and utilized by the Formulang Language Engine.
   * @param pn the phone to add
   */
  public static final void registerPhone(Phone pn) {
    IpaRegistry.PHONES.add(pn);
  }

  /**
   * Removes the specified phone {@code pn} from the reference of all default
   * IPA phone objects recognized and utilized by the Formulang Language Engine.
   * @param pn the phone to remove
   */
  public static final void unregisterPhone(Phone pn) {
    IpaRegistry.PHONES.remove(pn);
  }
}
