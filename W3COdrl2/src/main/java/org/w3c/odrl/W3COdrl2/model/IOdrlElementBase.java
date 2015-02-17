/**
 *
 */
package org.w3c.odrl.W3COdrl2.model;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.event.IOdrlElementEventListener;
import org.w3c.odrl.W3COdrl2.model.event.IOdrlEventEnabled;

/**
 * Represents an ODRL element
 * 
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
public interface IOdrlElementBase extends IOdrlNode, IOdrlEventEnabled {
    /**
     * Returns the list of attributes defined for the element
     * 
     * @return the list of attributes defined for the element
     */
    AttributeList getAttributes();

    /**
     * Sets or updates an attribute on an ODRL element
     * 
     * @param attribute
     *            the instantiated {@link IOdrlAttribute}. This method requires you to define the underlying generic value type. For
     *            example:
     * 
     *            <pre>
     * // create the attribute name using fully qualified QName
     * QName attName = new QName(&quot;http://example.com/ns&quot;, &quot;myatt&quot;, &quot;ex&quot;);
     * 
     * // instantiate the attribute and value.
     * IOdrlAttribute&lt;String&gt; newAtt = currentElement.getOwnerDocument().createAttribute(attName, &quot;My value&quot;);
     * 
     * // attach the instantiated attribute on the element
     * currentElement.setAttribute(newAtt);
     * 
     * </pre>
     *            <p>
     *            <strong>Note:</strong> If the attribute was previously set, this method updates the attribute value. If any
     *            {@linkplain IOdrlElementEventListener}s have been attached to the element, it will fire the
     *            {@link IOdrlElementEventListener#attributeChanged(org.w3c.odrl.v21.model.event.OdrlAttributeEvent)} event.
     */
    void setAttribute(IOdrlAttribute<?> attribute);


    <T> void setAttribute(QName name, T value);

    <T> IOdrlAttribute<T> getAttribute(QName name);


}
