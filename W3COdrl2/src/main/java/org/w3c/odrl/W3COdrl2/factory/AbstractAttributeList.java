/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.AttributeList;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
class AbstractAttributeList extends AbstractNamedList<IOdrlAttribute<?>> implements AttributeList {

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.NamedList#items()
     */


    @SuppressWarnings("unchecked")
    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.AttributeList#getNamedItem(javax.xml.namespace.QName)
     */
    
    public <T> IOdrlAttribute<T> getNamedItem(final QName qname) {
        IOdrlAttribute<T> attr = null;

        for (final IOdrlAttribute<?> att : items()) {
            if (att.getName().equals(qname)) {
                attr = (IOdrlAttribute<T>) att;
            }
        }
        return attr;
    }

}
