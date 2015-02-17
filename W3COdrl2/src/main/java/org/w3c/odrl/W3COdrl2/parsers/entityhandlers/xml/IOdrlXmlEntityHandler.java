/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.entityhandlers.xml;

import javax.xml.namespace.QName;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.IOdrlEntityHandler;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 */
public interface IOdrlXmlEntityHandler extends IOdrlEntityHandler<QName, Element, Document> {

}
