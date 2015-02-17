/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.xml;

import javax.xml.validation.Schema;

import org.w3c.odrl.W3COdrl2.parsers.AbstractParser;
import org.xml.sax.ErrorHandler;
import org.xml.sax.ext.EntityResolver2;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 9, 2014
 *
 */
public abstract class AbstractXmlParser extends AbstractParser implements IOdrlXmlParser {
    private EntityResolver2 resolver;
    private Schema schema;
    private ErrorHandler errorHandler;

    /**
     * 
     */
    public AbstractXmlParser() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.xml.IOdrlXmlParser#setEntityResolver(org.xml.sax.ext.EntityResolver2)
     */
    public void setEntityResolver(final EntityResolver2 resolver) {
        this.resolver = resolver;

    }

    protected EntityResolver2 getEntityResolver() {
        return this.resolver;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.xml.IOdrlXmlParser#setSchema(javax.xml.validation.Schema)
     */
    public void setSchema(final Schema schema) {
        this.schema = schema;

    }

    protected Schema getSchema() {
        return this.schema;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.xml.IOdrlXmlParser#setErrorHandler(org.xml.sax.ErrorHandler)
     */
    public void setErrorHandler(final ErrorHandler handler) {
        this.errorHandler = handler;

    }

    protected ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }



}
