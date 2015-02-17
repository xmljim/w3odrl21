/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.json;

import org.w3c.odrl.W3COdrl2.parsers.AbstractContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlParser;


/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 * @param <V>
 *
 */
public abstract class AbstractJsonContentProcessor<D> extends AbstractContentProcessor<String, D> implements
                IOdrlJsonContentProcessor<String, D> {

    /**
     * 
     */
    public AbstractJsonContentProcessor(final IOdrlParser parser) {
        super(parser);
    }



}
