/**
 * 
 */
package org.w3c.odrl.W3COdrl2.model;

import javax.xml.namespace.QName;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
public interface AttributeList extends NamedList<IOdrlAttribute<?>> {

    <T> IOdrlAttribute<T> getNamedItem(QName qname);

}
