/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
abstract class AbstractOdrlAttribute<T> extends AbstractOdrlNode implements IOdrlAttribute<T> {

    private T value;

    /**
     * @param qName
     * @param ownerDocument
     */
    public AbstractOdrlAttribute(final QName qName, final T value, final IOdrlDocument ownerDocument) {
        super(qName, ownerDocument);
        setValue(value);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlAttribute#setValue(java.lang.Object)
     */
    public void setValue(final T value) {
        this.value = value;

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlAttribute#getValue()
     */
    public T getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return getName().toString() + "=" + (this.value == null ? "null" : this.value.toString());
    }


}
