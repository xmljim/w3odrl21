package com.ghotibown.json;

/**
 * @author jearley
 */
public interface JSONValue<T> {

    T getValue();

    String toString();

    /**
     * @uml.property name="type"
     * @uml.associationEnd
     */
    JSONValueType getType();

    boolean isPrimitive();

    boolean isArray();

    void setValue(T value);

}
