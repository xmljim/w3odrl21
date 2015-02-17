/**
 * 
 */
package org.w3c.odrl.W3COdrl2.model.event;

import java.util.EventObject;

import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 9, 2014
 *
 */
public class OdrlAttributeEvent extends EventObject {

    /**
     * 
     */
    private static final long serialVersionUID = -4820299106882731030L;

    /**
     * @param source
     */
    public OdrlAttributeEvent(final IOdrlAttribute<?> attribute) {
        super(attribute);

    }

    @Override
    public IOdrlAttribute<?> getSource() {
        return (IOdrlAttribute<?>) super.getSource();
    }

    public IOdrlElementBase getElement() {
        return getSource().getParent();
    }

}
