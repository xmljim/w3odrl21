/**
 * 
 */
package org.w3c.odrl.W3COdrl2.model.event;

import java.util.EventObject;

import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 9, 2014
 *
 */
public class OdrlElementEvent extends EventObject {

    /**
     * 
     */
    private static final long serialVersionUID = 2592954395818497220L;

    /**
     * @param source
     */
    public OdrlElementEvent(final IOdrlElementBase source) {
        super(source);

    }

    @Override
    public IOdrlElementBase getSource() {
        return (IOdrlElementBase) super.getSource();
    }

}
