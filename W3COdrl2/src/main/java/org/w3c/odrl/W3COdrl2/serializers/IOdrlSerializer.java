/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers;

import java.io.OutputStream;
import java.io.Writer;

import org.w3c.dom.Document;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;

/**
 * Serialize an ODRL instance into an output, either through an {@link OutputStream}, a {@link Writer}, or to an unmarshalled native
 * representation
 * 
 * @author Jim Earley <xml.jim@gmail.com> Sep 12, 2014
 *
 */
public interface IOdrlSerializer {

    /**
     * Set a serialization property. Properties can be implementation specific
     * 
     * @param key
     *            The property key
     * @param value
     *            The property value. Can be of any type necessary to store property values required by specific implementation. See
     *            additional serializeres for more details
     */
    void setProperty(String key, Object value);

    /**
     * Returns an serializer property value
     * 
     * @param key
     *            the property key
     * @return the data value for a specific serializer property
     */
    Object getProperty(String key);
    
    /**
     * Returns whether or not a property value for a given property name exists
     * @param key the property name
     * @return <code>true</code> if the property exists; <code>false</code> otherwise
     */
    boolean hasProperty(String key);

    /**
     * Write ODRL Document to an output stream
     * 
     * @param odrlDocument
     *            the ODRL Document instance
     * @param output
     *            the output stream
     */
    void write(IOdrlDocument odrlDocument, OutputStream output);

    /**
     * Write the ODRL Document to a {@link Writer}
     * 
     * @param odrlDocument
     *            the ODRL Document instance
     * @param writer
     *            the {@link Writer}
     */
    void write(IOdrlDocument odrlDocument, Writer writer);

    /**
     * Serialize a selected ODRL Element to an output stream
     * 
     * @param odrlElement
     *            The selected ODRL element
     * @param output
     *            the OutputStream
     */
    void write(IOdrlElement<?> odrlElement, OutputStream output);

    /**
     * Serialize a selected ODRL Element to a {@link Writer}
     * 
     * @param odrlElement
     *            the selected ODRL element
     * @param writer
     *            the Writer
     */
    void write(IOdrlElement<?> odrlElement, Writer writer);
    
    /**
     * Serialize a selected ODRL element to a native data structure representation, e.g. an XML {@link Document}, or a {@link JSONObject}
     * 
     * @param unmarshaller
     *            the unmarshaller responsible for converting the ODRL ELement into the selected native representation
     * @param element
     * @return the output object. For XML, this could be an XML {@link Document}; for JSON, this might be any one of several JSONObject
     *         representations. Other unmarshallers can be implemented for other output types
     */
    <T> T unmarshall(IOdrlUnmarshaller<T> unmarshaller, IOdrlElement<?> element);
    
    /**
     * Serialize an ODRL Document instance (e.g., a Policy) to a native output representation, e.g. an XML {@link Document}, or a
     * {@link JSONObject}
     * 
     * @param unmarshaller
     *            the unmarshaller responsible for converting the ODRL ELement into the selected native representation
     * @param document
     *            The ODRL document instance
     * @return the output object. For XML, this could be an XML {@link Document}; for JSON, this might be any one of several JSONObject
     *         representations. Other unmarshallers can be implemented for other output types
     */
    <T> T unmarshall(IOdrlUnmarshaller<T> unmarshaller, IOdrlDocument document);

}
