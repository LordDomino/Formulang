package com.lorddomino.fle.phonology;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import com.lorddomino.fle.blueprints.AbstractBlueprintElement;
import com.lorddomino.fle.blueprints.ClassElement;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.InstanceElement;
import com.lorddomino.fle.types.TranscriptableComponent;

public class Phone extends TranscriptableComponent<Phone> {

    /**
     * The internal runtime reference of all phone objects set as the
     * default IPA phones recognized and utilized by the Formulang
     * Language Engine.
     */
    private static final ArrayList<Phone> IPA_DEFAULTS = new ArrayList<>();

    /**
     * Returns an ArrayList of the default IPA phone objects recognized
     * and utilized by the Formulang Language Engine.
     * @return the ArrayList of all default IPA phones
     */
    public static ArrayList<Phone> getIpaDefaults() {
        return IPA_DEFAULTS;
    }

    /**
     * Adds the given phone {@code p} to the reference of all default
     * IPA phone objects recognized and utilized by the Formulang
     * Language Engine.
     * @param p the phone to add
     */
    public static void addToIpaDefaults(Phone p) {
        IPA_DEFAULTS.add(p);
    }

    /**
     * Removes the given phone {@code p} from the reference of all
     * default IPA phone objects recognized and utilized by the
     * Formulang Language Engine.
     * @param p the phone to remove
     */
    public static void removeFromIpaDefaults(Phone p) {
        IPA_DEFAULTS.remove(p);
    }

    /**
     * Internal instance field for the phone's symbol representation.
     */
    private String symbol;

    /**
     * Internal instance flag of whether or not the phone is a default
     * IPA phone based on the private reference
     * {@code Phone.IPA_DEFAULTS}.
     */
    private boolean isIpaDefault;

    private Set<ArticulatoryProperty> articulatoryProperties;

    /**
     *
     * @param symbol
     * @param isIpaDefault
     */
    public Phone(String symbol, boolean isIpaDefault, Set<ArticulatoryProperty> atcProps) {
        super(symbol, null, symbol);
        this.symbol = symbol;
        if (isIpaDefault) {
            addToIpaDefaults(this);
        }
        this.isIpaDefault  = isIpaDefault;
        this.articulatoryProperties = atcProps;
        processProperties();
        Objects.requireNonNull(symbol);
        Objects.requireNonNull(isIpaDefault);
    }

    public String getSymbol() {
        return this.symbol;
    }

    /**
     *
     * @return
     */
    public boolean isIpaDefault() {
        return isIpaDefault;
    }

    /**
     *
     * @param isIpaDefault
     */
    public void setIpaDefault(boolean isIpaDefault) {
        this.isIpaDefault = isIpaDefault;
        if (!this.isIpaDefault) {
            removeFromIpaDefaults(this);
        }
    }

    public boolean containsProperty(ArticulatoryProperty prop) {
        if (this.articulatoryProperties.contains(prop)) {
            return true;
        } else {
            return false;
        }
    }

    public Set<ArticulatoryProperty> getArticulatoryProperties() {
        return this.articulatoryProperties;
    }

    public void removeProperty(ArticulatoryProperty prop) {
        this.articulatoryProperties.remove(prop);
    }

    public void addProperty(ArticulatoryProperty prop) {
        this.articulatoryProperties.add(prop);
    }

    public void replaceArticulatoryProperty(ArticulatoryProperty oldProp, ArticulatoryProperty newProp) {
        removeProperty(oldProp);
        addProperty(newProp);
    }

    @Override
    public String processOutputString(String output) {
        if (output == null) {
            return this.symbol;
        } else {
            return output;
        }
    }

    @Override
    public String processIpaTranscript(String ipaTranscript) {
        if (ipaTranscript == null) {
            return "[" + this.symbol + "]";
        } else {
            return "[" + ipaTranscript + "]";
        }
    }

    @Override
    public String processFormulangTranscript(String formulangTranscript) {
        return formulangTranscript;
    }

    @Override
    public ComponentBlueprint<Phone> processBlueprint(ComponentBlueprint<Phone> bp) {
        return new ComponentBlueprint<Phone>(new InstanceElement<Phone>(this));
    }

    @Override
    public String processRomanization(String romanization) {
        return romanization;
    }

    @Override
    public ArrayList<AbstractBlueprintElement> defineDefaultBlueprintElements() {
        ArrayList<AbstractBlueprintElement> e = new ArrayList<>();
        e.add(new ClassElement(Phone.class));
        return e;
    }

    public String getFlePreview() {
        if (isIpaDefault()) {
            return "<Phone " + this.getIpaTranscript() + " (IPA default)>";
        } else {
            return "<Phone " + this.getIpaTranscript() + ">";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Phone) {
            Phone object = (Phone) obj;
            if (this.symbol == object.symbol) {
                return true;
            }
        }
        return false;
    }

}
