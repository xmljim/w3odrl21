/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.json;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentBuilder;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json.IOdrlJsonEntityHandler;

/**
 * The default JSON Parser. Controls the parsing and marshalling of the ODRL object model from JSON data. It supports the ODRL v2.1 content
 * model as well as the ability to also map extension entities into the model. <h3>Default properties</h3>
 * <table border="1" style="border: solid 1pt black; border-collapse: collapse;">
 * <tr>
 * <th>Property Name</th>
 * <th>Type</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td style="vertical-align:top"><code>json.extension.prefix.map</code></td>
 * <td style="vertical-align:top"><code>Map&lt;{@link String},{@link QName}&gt;</code></td>
 * <td style="vertical-align:top">A Map of prefix-QName mappings. Where the map's key is the given prefix for an extension entity in the
 * JSON object, and the value is the QName containing the Namespace URI and local name of the element. This is only used if an
 * {@link IOdrlJsonEntityHandler} instance is not registered for the entity.</td>
 * </tr>
 * </table>
 * 
 * @author Jim Earley <xml.jim@gmail.com> Sep 10, 2014
 * 
 */
public class DefaultJsonParser extends AbstractJsonParser {
    private DefaultJsonContentProcessor processor;
    private DefaultJsonContentBuilder builder;

    public static final String EXTENSION_MAP_PROPERTY = "json.extension.prefix.map";

    public DefaultJsonParser() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.AbstractParser#getProcessor()
     */
    @SuppressWarnings("unchecked")
    public <V, D> IOdrlContentProcessor<V, D> getProcessor() {
        if (this.processor == null) {
            this.processor = new DefaultJsonContentProcessor(this);
        }

        return (IOdrlContentProcessor<V, D>) this.processor;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.AbstractParser#getContentBuilder()
     */
    @SuppressWarnings("unchecked")
    @Override
    public <D> IOdrlContentBuilder<D> getContentBuilder() {
        if (this.builder == null) {
            this.builder = new DefaultJsonContentBuilder(this);
        }

        return (IOdrlContentBuilder<D>) this.builder;
    }

}
