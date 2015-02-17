/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public class OdrlParserException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public OdrlParserException() {

    }

    /**
     * @param arg0
     */
    public OdrlParserException(final String arg0) {
        super(arg0);

    }

    /**
     * @param arg0
     */
    public OdrlParserException(final Throwable arg0) {
        super(arg0);

    }

    /**
     * @param arg0
     * @param arg1
     */
    public OdrlParserException(final String arg0, final Throwable arg1) {
        super(arg0, arg1);

    }

}
