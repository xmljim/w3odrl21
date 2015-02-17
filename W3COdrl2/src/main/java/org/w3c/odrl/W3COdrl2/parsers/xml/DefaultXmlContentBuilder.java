/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;

import org.w3c.dom.Document;
import org.w3c.odrl.W3COdrl2.parsers.AbstractContentBuilder;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlParser;
import org.w3c.odrl.W3COdrl2.parsers.OdrlContentBuilderException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.ext.EntityResolver2;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public class DefaultXmlContentBuilder extends AbstractContentBuilder<Document> implements IOdrlXmlContentBuilder {
    private final Schema schema;
    private final ErrorHandler errorHandler;
    private final EntityResolver2 resolver;
    /**
     * 
     */
    public DefaultXmlContentBuilder(final IOdrlParser parser, final Schema schema, final ErrorHandler errorHandler,
                    final EntityResolver2 resolver) {
        super(parser);
        this.schema = schema;
        this.errorHandler = errorHandler;
        this.resolver = resolver;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.io.File)
     */
    @Override
    public Document buildContent(final File file) throws OdrlContentBuilderException {
        try {
            final FileInputStream fis = new FileInputStream(file);
            return buildContent(fis);
        } catch (final FileNotFoundException e) {
            throw new OdrlContentBuilderException(e);
        }
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.io.InputStream)
     */
    @Override
    public Document buildContent(final InputStream stream) throws OdrlContentBuilderException {
        final InputStreamReader reader = new InputStreamReader(stream);
        return buildContent(reader);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.io.Reader)
     */
    @Override
    public Document buildContent(final Reader reader) throws OdrlContentBuilderException {
        Document d = null;
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setSchema(this.schema);
        factory.setNamespaceAware(true);
        try {
            final DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(this.resolver);
            builder.setErrorHandler(this.errorHandler);
            d = builder.parse(new InputSource(reader));
        } catch (final Throwable t) {
            throw new OdrlContentBuilderException(t);
        }

        return d;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.net.URI)
     */
    @Override
    public Document buildContent(final URI uri) throws OdrlContentBuilderException {
        try {
            return buildContent(uri.toURL().openStream());
        } catch (final MalformedURLException e) {
            throw new OdrlContentBuilderException(e);
        } catch (final IOException e) {
            throw new OdrlContentBuilderException(e);
        }
    }

}
