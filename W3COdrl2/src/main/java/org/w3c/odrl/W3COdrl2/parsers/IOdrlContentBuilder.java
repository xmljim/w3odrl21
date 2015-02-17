/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public interface IOdrlContentBuilder<D> {

    D buildContent(File file) throws OdrlContentBuilderException;

    D buildContent(InputStream stream) throws OdrlContentBuilderException;
    
    D buildContent(Reader reader) throws OdrlContentBuilderException;
    
    D buildContent(URI uri) throws OdrlContentBuilderException;

    IOdrlParser getParser();

}
