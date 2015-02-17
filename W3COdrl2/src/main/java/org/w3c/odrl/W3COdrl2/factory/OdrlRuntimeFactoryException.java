/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import org.w3c.odrl.W3COdrl2.OdrlRuntimeException;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 */
public class OdrlRuntimeFactoryException extends OdrlRuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 7568128920461192990L;

    /**
     * 
     */
    public OdrlRuntimeFactoryException() {

    }

    /**
     * @param arg0
     */
    public OdrlRuntimeFactoryException(final String arg0) {
        super(arg0);

    }

    /**
     * @param arg0
     */
    public OdrlRuntimeFactoryException(final Throwable arg0) {
        super(arg0);

    }

    /**
     * @param arg0
     * @param arg1
     */
    public OdrlRuntimeFactoryException(final String arg0, final Throwable arg1) {
        super(arg0, arg1);

    }

}
