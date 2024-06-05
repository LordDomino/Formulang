package com.lorddomino;

import org.junit.jupiter.api.Test;

import com.lorddomino.fle.blueprints.elements.ClassElement;
import com.lorddomino.fle.phonology.ConsonantPhone;
import com.lorddomino.fle.phonology.Phone;

public class CBP_Tests {

  /**
   * TEST 1 - Instance
   */
  @Test
  void Test1InstanceElements() {
    ClassElement ce1 = new ClassElement(Phone.class);
    ClassElement ie1 = new ClassElement(ConsonantPhone.class);

    System.out.println(ce1.isCompliant(ie1));
  }

}
