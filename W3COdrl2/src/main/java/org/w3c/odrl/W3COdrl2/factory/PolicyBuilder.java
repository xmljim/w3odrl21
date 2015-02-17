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
public abstract class PolicyBuilder {

    /**
     * 
     */
    public PolicyBuilder() {
        // TODO Auto-generated constructor stub
    }

    public static PolicyBuilder newPolicyBuilder() {
        return new PolicyBuilderImpl();
    }

    public abstract IOdrlDocument newDocument();

    public abstract IOdrlDocument parse(IOdrlParser parser, File f) throws OdrlParserException;

    public abstract IOdrlDocument parse(IOdrlParser parser, InputStream stream) throws OdrlParserException;

    public abstract IOdrlDocument parse(IOdrlParser parser, Reader reader) throws OdrlParserException;

    public abstract IOdrlDocument parse(IOdrlParser parser, URI uri) throws OdrlParserException;
}
