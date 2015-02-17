/**
 *
 */
package org.w3c.odrl.W3COdrl2.model;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
public interface IOdrlElement<T> extends IOdrlElementBase {

    void appendElement(IOdrlElementBase newElement);

    ElementList<IOdrlElementBase> getChildren();

    ElementList<IOdrlElementReference<T>> getReferencedBy();

    void insertElementAfter(IOdrlElementBase newElement, IOdrlElementBase afterElement);

    void insertElementBefore(IOdrlElementBase newElement, IOdrlElementBase beforeElement);

    IOdrlElementBase removeElement(IOdrlElementBase elementToRemove);

}
