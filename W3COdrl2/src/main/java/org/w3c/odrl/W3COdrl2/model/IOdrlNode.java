package org.w3c.odrl.W3COdrl2.model;

import javax.xml.namespace.QName;

/**
 * Common interface for all ODRL elements and attributes. This is very similar to the W3C interfaces for DOM items
 * 
 * @author Jim Earley <xml.jim@gmail.com> 2014-09-03
 *
 */

public interface IOdrlNode extends IOdrlEntity {

    /**
     * Get the node's QName
     * 
     * @return the node's QName
     */
    QName getName();

    /**
     * Return the parent node.
     * 
     * @return the parent node. For {@linkplain org.w3c.odrl.v21.model.IOdrlAttribute} nodes, this will be the parent element
     */
    IOdrlElementBase getParent();

    /**
     * Set the node's QName
     * 
     * @param name
     *            the node's QName
     */
    void setName(QName name);

    /**
     * Return the {@link IOdrlDocument} that instantiated the node
     * 
     * @return the {@link IOdrlDocument} that instantiated the node
     */
    IOdrlDocument getOwnerDocument();
}
