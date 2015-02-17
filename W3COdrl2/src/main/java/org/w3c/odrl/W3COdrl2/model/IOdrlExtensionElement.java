/**
 * 
 */
package org.w3c.odrl.W3COdrl2.model;


/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 *         Interface for creating elements not in the ODRL namespace without requiring additional code to initiate that element. Developers
 *         can opt to extend this interface with their own definitions, or they can choose to use leverage the built-in implementation. Note
 *         that the internal implementation will check this element's QName and the QName of its attributes to ensure that it is in a
 *         non-null, non-ODRL namespace.
 * 
 *         Default implementations of Parsers and Serializers will interpret this element literally.
 */
public interface IOdrlExtensionElement extends IOdrlElement<IOdrlExtensionElement> {


}
