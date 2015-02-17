/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public class OdrlContentBuilderException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public OdrlContentBuilderException() {

    }

    /**
     * @param message
     */
    public OdrlContentBuilderException(final String message) {
        super(message);

    }

    /**
     * @param cause
     */
    public OdrlContentBuilderException(final Throwable cause) {
        super(cause);

    }

    /**
     * @param message
     * @param cause
     */
    public OdrlContentBuilderException(final String message, final Throwable cause) {
        super(message, cause);

    }

}
