/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 11, 2014
 *
 */
public abstract class AbstractContentBuilder<D> implements IOdrlContentBuilder<D> {
    private final IOdrlParser parser;

    /**
     * 
     */
    public AbstractContentBuilder(final IOdrlParser parser) {
        this.parser = parser;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.io.File)
     */
    public abstract D buildContent(File file) throws OdrlContentBuilderException;

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.io.InputStream)
     */
    public abstract D buildContent(InputStream stream) throws OdrlContentBuilderException;

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.io.Reader)
     */
    public abstract D buildContent(Reader reader) throws OdrlContentBuilderException;

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.net.URI)
     */
    public abstract D buildContent(URI uri) throws OdrlContentBuilderException;

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#getParser()
     */
    public IOdrlParser getParser() {
        return this.parser;
    }

}
