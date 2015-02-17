/**
 * 
 */
package org.w3c.odrl.W3COdrl2;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 */
public class OdrlRuntimeException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -9072333762622860503L;

    /**
     * 
     */
    public OdrlRuntimeException() {
        
    }

    /**
     * @param message
     */
    public OdrlRuntimeException(final String message) {
        super(message);
        
    }

    /**
     * @param cause
     */
    public OdrlRuntimeException(final Throwable cause) {
        super(cause);
        
    }

    /**
     * @param message
     * @param cause
     */
    public OdrlRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
        
    }

}
