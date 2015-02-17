/**
 * 
 */
package org.w3c.odrl.W3COdrl2.model.event;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 9, 2014
 *
 */
public interface IOdrlElementEventListener {

    void elementAdded(OdrlElementEvent event);

    void elementRemoved(OdrlElementEvent event);

    void attributeAdded(OdrlAttributeEvent event);

    void attributeChanged(OdrlAttributeEvent event);
}
