/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.json;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.OdrlContentProcessorException;


/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 */
public interface IOdrlJsonContentProcessor<V, D> extends IOdrlContentProcessor<V, D> {

    IOdrlElementBase handleJsonProperty(JsonProperty property, D dataDocument, IOdrlDocument document, IOdrlElementBase parent)
                    throws OdrlContentProcessorException;
}
