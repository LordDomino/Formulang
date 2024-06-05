package com.lorddomino.fle.ipa;

import java.util.HashSet;

import com.lorddomino.fle.phonology.ConsonantPhone;
import com.lorddomino.fle.phonology.Phone;
import com.lorddomino.fle.phonology.VowelPhone;

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
      if (pn instanceof ConsonantPhone) {
        cl.add((VowelPhone) pn);
      }
    }
    return cl;
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
