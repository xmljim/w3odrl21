/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.xml;

import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentBuilder;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 9, 2014
 *
 */
public class DefaultXmlParser extends AbstractXmlParser {
    private DefaultXmlContentBuilder builder;
    private DefaultXmlContentProcessor processor;

    /**
     * 
     */
    public DefaultXmlParser() {
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.AbstractParser#getProcessor()
     */
    @SuppressWarnings("unchecked")
    @Override
    public <V, D> IOdrlContentProcessor<V, D> getProcessor() {
        if (this.processor == null) {
            this.processor = new DefaultXmlContentProcessor(this);
        }
        return (IOdrlContentProcessor<V, D>) this.processor;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.AbstractParser#getContentBuilder()
     */
    @SuppressWarnings("unchecked")
    @Override
    public <D> IOdrlContentBuilder<D> getContentBuilder() {
        if (this.builder == null) {
            this.builder = new DefaultXmlContentBuilder(this, getSchema(), getErrorHandler(), getEntityResolver());
        }

        return (IOdrlContentBuilder<D>) this.builder;
    }

}
