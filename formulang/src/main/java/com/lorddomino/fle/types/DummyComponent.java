package com.lorddomino.fle.types;

import java.util.ArrayList;

import com.lorddomino.fle.blueprints.AbstractBlueprintElement;
import com.lorddomino.fle.blueprints.ComponentBlueprint;

public class DummyComponent extends AbstractComponent<AbstractComponent<?>> {

    public DummyComponent(ComponentBlueprint<AbstractComponent<?>> repBp) {
        super("", repBp, "$");
    }

    @Override
    public ArrayList<AbstractBlueprintElement> defineDefaultBlueprintElements() {
        return null;
    }

    @Override
    public String processOutputString(String output) {
        return output;
    }

    @Override
    public String processFormulangTranscript(String formulangTranscript) {
        return "$";
    }

    @Override
    public ComponentBlueprint<AbstractComponent<?>> processBlueprint(ComponentBlueprint<AbstractComponent<?>> bp) {
        return bp;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equals'");
    }

    @Override
    public String getFlePreview() {
        return "<DummyComponent $>";
    }

}
