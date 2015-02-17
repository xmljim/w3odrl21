/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.xml;

import javax.xml.validation.Schema;

import org.w3c.odrl.W3COdrl2.parsers.IOdrlParser;
import org.xml.sax.ErrorHandler;
import org.xml.sax.ext.EntityResolver2;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public interface IOdrlXmlParser extends IOdrlParser {

    void setEntityResolver(EntityResolver2 resolver);

    void setSchema(Schema schema);

    void setErrorHandler(ErrorHandler handler);
}
