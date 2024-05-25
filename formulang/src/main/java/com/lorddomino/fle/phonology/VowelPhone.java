package com.lorddomino.fle.phonology;

import java.util.HashSet;
import java.util.Set;

public class VowelPhone extends Phone {

    public VowelPhone(String symbol, boolean isIpaDefault, Set<VocalicArticulatoryProperty> atcProps) {
        super(symbol, isIpaDefault, new HashSet<>(atcProps));
    }

}
