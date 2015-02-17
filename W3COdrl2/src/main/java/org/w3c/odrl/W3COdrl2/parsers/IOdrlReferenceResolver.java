/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.model.IOdrlEntity;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public interface IOdrlReferenceResolver {

    IOdrlEntity resolveReference(URIQNameQCode referenceId);
}
