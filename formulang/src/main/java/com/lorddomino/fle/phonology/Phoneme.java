package com.lorddomino.fle.phonology;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractBlueprintElement;
import com.lorddomino.fle.blueprints.ClassElement;
import com.lorddomino.fle.blueprints.ComponentBlueprint;
import com.lorddomino.fle.blueprints.InstanceElement;
import com.lorddomino.fle.types.TranscriptableComponent;

public class Phoneme extends TranscriptableComponent<Phoneme> {

    private Phone baseAllophone;
    private String baseSymbol;
    private ArrayList<Phone> allophones;

    public Phoneme(Phone baseAllophone, String romanization) {
        super(baseAllophone.getOutputString(), null, null);
        this.baseAllophone = baseAllophone;
        this.baseSymbol = baseAllophone.getSymbol();
        this.allophones = new ArrayList<Phone>();
        this.allophones.add(baseAllophone);
        processProperties();
    }

    @Override
    public ArrayList<AbstractBlueprintElement> defineDefaultBlueprintElements() {
        ArrayList<AbstractBlueprintElement> e = new ArrayList<>();
        e.add(new ClassElement(Phoneme.class));
        return e;
    }

    @Override
    public String processIpaTranscript(String ipaTranscript) {
        if (ipaTranscript == null) {
            return "/" + this.baseSymbol + "/";
        } else {
            return "/" + ipaTranscript + "/";
        }
    }

    @Override
    public String processRomanization(String romanization) {
        return romanization;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equals'");
    }

    @Override
    public String processOutputString(String output) {
        if (output == null) {
            return this.baseSymbol;
        } else {
            return output;
        }
    }

    @Override
    public String processFormulangTranscript(String formulangTranscript) {
        if (formulangTranscript == null) {
            return "/" + this.baseSymbol + "/";
        } else {
            return formulangTranscript;
        }
    }

    @Override
    public ComponentBlueprint<Phoneme> processBlueprint(ComponentBlueprint<Phoneme> bp) {
        return new ComponentBlueprint<>(new InstanceElement<Phoneme>(this));
    }

    public Phone getBaseAllophone() {
        return baseAllophone;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    @Override
    public String getFlePreview() {
        return "<Phoneme " + this.getIpaTranscript() + ">";
    }
}
