package com.lorddomino.fle.utils;

public interface Preprocessable<T> {
    /**
     * Returns a pre-processed object based on the given input
     * {@code input}. The returned object is preprocessed within the
     * method implementation and it is the same type as the given input
     * reflecting a possible modification or alteration of the object.
     * @param input the object to be preprocessed
     * @return the preprocessed object based on the object {@code input}
     * @implSpec The default implementation of this method returns the
     * given object {@code input}.
     */
    public default T preprocess(T input) {
        return input;
    };

    /**
     * Returns a preprocessed object based on two given objects
     * {@code input1} and {@code input2}. The returned object is
     * pre-processed within the method implementation and it is the same
     * type as the given inputs reflecting a possible modification or
     * alteration of the objects.
     * @param input1 the first object to be preprocessed
     * @param input2 the second object to be preprocessed
     * @return the preprocessed object based on the objects
     * {@code input1} and {@code input2}
     * @implSpec The default implementation of this method returns the
     * first object {@code input1}.
     */
    public default T preprocess(T input1, T input2) {
        return input1;
    }
}
