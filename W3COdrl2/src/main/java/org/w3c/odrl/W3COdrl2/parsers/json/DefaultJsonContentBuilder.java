/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.json;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;

import org.w3c.odrl.W3COdrl2.parsers.IOdrlParser;
import org.w3c.odrl.W3COdrl2.parsers.OdrlContentBuilderException;

import com.ghotibown.json.JSONFactory;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.exception.JSONParserException;
import com.ghotibown.json.parser.JSONParser;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public class DefaultJsonContentBuilder extends AbstractJsonContentBuilder<JSONObject> {

    /**
     * 
     */
    public DefaultJsonContentBuilder(final IOdrlParser parser) {
        super(parser);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.io.File)
     */
    
    public JSONObject buildContent(final File file) throws OdrlContentBuilderException {
        JSONObject result = null;
        final JSONFactory factory = JSONFactory.newFactory();
        final JSONParser parser = factory.newParser();
        try {
            result = parser.parse(file);
        } catch (final JSONParserException e) {
            throw new OdrlContentBuilderException(e);
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.io.InputStream)
     */
    @Override
    public JSONObject buildContent(final InputStream stream) throws OdrlContentBuilderException {
        JSONObject result = null;
        final JSONFactory factory = JSONFactory.newFactory();
        final JSONParser parser = factory.newParser();
        try {
            result = parser.parse(stream);
        } catch (final JSONParserException e) {
            throw new OdrlContentBuilderException(e);
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.io.Reader)
     */
    @Override
    public JSONObject buildContent(final Reader reader) throws OdrlContentBuilderException {
        JSONObject result = null;
        final JSONFactory factory = JSONFactory.newFactory();
        final JSONParser parser = factory.newParser();
        try {
            result = parser.parse(reader);
        } catch (final JSONParserException e) {
            throw new OdrlContentBuilderException(e);
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.IOdrlContentBuilder#buildContent(java.net.URI)
     */
    @Override
    public JSONObject buildContent(final URI uri) throws OdrlContentBuilderException {
        JSONObject result = null;
        final JSONFactory factory = JSONFactory.newFactory();
        final JSONParser parser = factory.newParser();
        try {
            result = parser.parse(uri.toURL());
        } catch (final JSONParserException e) {
            throw new OdrlContentBuilderException(e);
        } catch (final MalformedURLException e) {
            throw new OdrlContentBuilderException(e);
        }

        return result;
    }

}
