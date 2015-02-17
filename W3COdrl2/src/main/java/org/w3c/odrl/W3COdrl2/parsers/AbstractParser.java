/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 9, 2014
 *
 */
public abstract class AbstractParser implements IOdrlParser {
    private final Map<String, Object> properties = new HashMap<String, Object>();

    /**
     * 
     */
    public AbstractParser() {
    }


    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlParser#getProcessor()
     */
    public abstract <V, D> IOdrlContentProcessor<V, D> getProcessor();

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlParser#getContentBuilder()
     */
    public abstract <D> IOdrlContentBuilder<D> getContentBuilder();

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlParser#parse(java.io.File)
     */
    public IOdrlDocument parse(final File file) throws OdrlParserException {
        IOdrlDocument document = null;
        try {
            document = getProcessor().processData(getContentBuilder().buildContent(file));
        } catch (final OdrlContentBuilderException e) {
            throw new OdrlParserException(e);
        }

        return document;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlParser#parse(java.io.InputStream)
     */
    public IOdrlDocument parse(final InputStream stream) throws OdrlParserException {
        IOdrlDocument document = null;
        try {
            document = getProcessor().processData(getContentBuilder().buildContent(stream));
        } catch (final OdrlContentBuilderException e) {
            throw new OdrlParserException(e);
        }

        return document;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlParser#parse(java.io.Reader)
     */
    public IOdrlDocument parse(final Reader reader) throws OdrlParserException {
        IOdrlDocument document = null;
        try {
            document = getProcessor().processData(getContentBuilder().buildContent(reader));
        } catch (final OdrlContentBuilderException e) {
            throw new OdrlParserException(e);
        }

        return document;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlParser#parse(java.net.URI)
     */
    public IOdrlDocument parse(final URI uri) throws OdrlParserException {
        IOdrlDocument document = null;
        try {
            document = getProcessor().processData(getContentBuilder().buildContent(uri));
        } catch (final OdrlContentBuilderException e) {
            throw new OdrlParserException(e);
        }

        return document;
    }

    public void setProperty(final String name, final Object value) {
        this.properties.put(name, value);
    }

    public Object getProperty(final String name) {
        return this.properties.get(name);
    }



}
