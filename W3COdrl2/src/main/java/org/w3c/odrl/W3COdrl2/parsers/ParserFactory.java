/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers;

import org.w3c.odrl.W3COdrl2.parsers.json.DefaultJsonParser;
import org.w3c.odrl.W3COdrl2.parsers.json.IOdrlJsonParser;
import org.w3c.odrl.W3COdrl2.parsers.xml.DefaultXmlParser;
import org.w3c.odrl.W3COdrl2.parsers.xml.IOdrlXmlParser;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public abstract class ParserFactory {

    /**
     * 
     */
    private ParserFactory() {

    }

    public static IOdrlXmlParser newDefaultXmlParser() {
        return new DefaultXmlParser();
    }

    public static IOdrlJsonParser newDefaultJsonParser() {
        return new DefaultJsonParser();
    }



}
