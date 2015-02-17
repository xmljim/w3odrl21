/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.json;

import org.w3c.odrl.W3COdrl2.parsers.AbstractContentBuilder;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlParser;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 11, 2014
 *
 */
public abstract class AbstractJsonContentBuilder<D> extends AbstractContentBuilder<D> implements IOdrlJsonContentBuilder<D> {

    /**
     * 
     */
    public AbstractJsonContentBuilder(final IOdrlParser parser) {
        super(parser);
    }



}
