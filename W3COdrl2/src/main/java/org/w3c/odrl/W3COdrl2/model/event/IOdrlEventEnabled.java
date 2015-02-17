/**
 * 
 */
package org.w3c.odrl.W3COdrl2.model.event;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 9, 2014
 *
 */
public interface IOdrlEventEnabled {

    void addOdrlElementEventListener(IOdrlElementEventListener listener);

    void removeOdrlElementEventListener(IOdrlElementEventListener listener);

}
