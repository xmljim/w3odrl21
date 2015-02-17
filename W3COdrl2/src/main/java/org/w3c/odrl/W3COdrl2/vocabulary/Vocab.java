/**
 * 
 */
package org.w3c.odrl.W3COdrl2.vocabulary;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
public class Vocab {

	/**
	 * Private Constructor
	 */
	private Vocab() {
	}

    public static final String XML_SCHEMA_NS = "http://www.w3.org/2001/XMLSchema";

	public static final String ODRL_VOCAB = "http://w3.org/ns/odrl/vocab";
	
    public static final String ODRL_NS = "http://www.w3.org/ns/odrl/2/";
	
	public static URIQNameQCode createVocabIdentifer(final String namespaceURI, final String name) {
		return URIQNameQCode.newURIQNameQCode(namespaceURI + name);
	}
	
	public static URIQNameQCode createOdrlVocabItem(final String name) {
		return createVocabIdentifer(ODRL_NS, name);
	}
	
	public static QName createItemQName(final String nsUri, final String name) {
		return new QName(nsUri, name);
	}
}
