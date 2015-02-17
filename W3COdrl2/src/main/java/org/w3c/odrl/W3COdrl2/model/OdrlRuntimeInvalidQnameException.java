/**
 * 
 */
package org.w3c.odrl.W3COdrl2.model;

import org.w3c.odrl.W3COdrl2.OdrlRuntimeException;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 */
public class OdrlRuntimeInvalidQnameException extends OdrlRuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 7936293078194684574L;

    /**
     * 
     */
    public OdrlRuntimeInvalidQnameException() {
        
    }

    /**
     * @param message
     */
    public OdrlRuntimeInvalidQnameException(final String message) {
        super(message);
        
    }

    /**
     * @param cause
     */
    public OdrlRuntimeInvalidQnameException(final Throwable cause) {
        super(cause);
        
    }

    /**
     * @param message
     * @param cause
     */
    public OdrlRuntimeInvalidQnameException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
