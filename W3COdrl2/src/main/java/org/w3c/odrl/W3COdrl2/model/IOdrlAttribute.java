/**
 * 
 */
package org.w3c.odrl.W3COdrl2.model;

/**
 * Represents a name-value property node on an ODRL entity
 * 
 * @author Jim Earley <xml.jim@gmail.com> 2014-09-03
 *
 */
public interface IOdrlAttribute<T> extends IOdrlNode {
	
	void setValue(T value);
	
	T getValue();
	
}
