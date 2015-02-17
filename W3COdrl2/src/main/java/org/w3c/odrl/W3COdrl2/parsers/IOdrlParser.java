/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;

/**
 * Base interface for all ODRL Parsers.
 * <p>
 * ODRL parsers consist of two parts:
 * </p>
 * 
 * <ul>
 * <li>A Content Builder: This class is responsible for the initial marshalling of the data into the native document format. Once it parses
 * this data, it returns the native document object back to the parser for further processing into the ODRL object model</li>
 * <li>A Content Processor: This class converts the native document object into the ODRL object model. A Content processor may have zero or
 * more Entity Handlers. These classes are responsible for instantiating specific parts of the ODRL model from the native document data. The
 * Content Processor returns the fully marshalled ODRL document instance.</li>
 * </ul>
 * <p>
 * The Content Builder and Content Processor must be able to recognize the same native document format, so its critical that you have a
 * coordinated set of both
 * </p>
 * 
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 * 
 */
public interface IOdrlParser {


    <V, D> IOdrlContentProcessor<V, D> getProcessor();


    <D> IOdrlContentBuilder<D> getContentBuilder();

    /**
     * Parse a file reference
     * 
     * @param file
     *            the local file
     * @return a new IOdrlDocument
     */
    IOdrlDocument parse(File file) throws OdrlParserException;

    /**
     * Parse an InputStream
     * 
     * @param file
     *            the InputStream
     * @return a new IOdrlDocument
     */
    IOdrlDocument parse(InputStream stream) throws OdrlParserException;

    IOdrlDocument parse(Reader reader) throws OdrlParserException;

    IOdrlDocument parse(URI uri) throws OdrlParserException;

    void setProperty(String name, Object value);

    Object getProperty(String name);
    
}
