/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlParser;
import org.w3c.odrl.W3COdrl2.parsers.OdrlParserException;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
class PolicyBuilderImpl extends PolicyBuilder {

    /**
     * 
     */
    public PolicyBuilderImpl() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.factory.PolicyBuilder#newDocument()
     */
    @Override
    public IOdrlDocument newDocument() {
        return new OdrlDocumentImpl();
    }


        /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.factory.PolicyBuilder#parse(org.w3c.odrl.v21.parsers.IOdrlParser, java.io.File)
     */
    @Override
    public IOdrlDocument parse(final IOdrlParser parser, final File f) throws OdrlParserException {
        return parser.parse(f);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.factory.PolicyBuilder#parse(org.w3c.odrl.v21.parsers.IOdrlParser, java.io.InputStream)
     */
    @Override
    public IOdrlDocument parse(final IOdrlParser parser, final InputStream stream) throws OdrlParserException {
        return parser.parse(stream);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.factory.PolicyBuilder#parse(org.w3c.odrl.v21.parsers.IOdrlParser, java.io.Reader)
     */
    @Override
    public IOdrlDocument parse(final IOdrlParser parser, final Reader reader) throws OdrlParserException {
        return parser.parse(reader);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.factory.PolicyBuilder#parse(org.w3c.odrl.v21.parsers.IOdrlParser, java.net.URI)
     */
    @Override
    public IOdrlDocument parse(final IOdrlParser parser, final URI uri) throws OdrlParserException {
        return parser.parse(uri);
    }

}
