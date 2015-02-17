/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers;

import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
public abstract class AbstractOdrlSerializer implements IOdrlSerializer {
    private final Map<String, Object> properties = new HashMap<String, Object>();

    public void setProperty(final String key, final Object value) {
        this.properties.put(key, value);
    }

    public Object getProperty(final String key) {
        Object value = null;
        if (this.properties.containsKey(key)) {
            value = this.properties.get(key);
        }

        return value;
    }

    public boolean hasProperty(final String key) {
        return this.properties.containsKey(key);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlDocument, java.io.OutputStream)
     */
    public abstract void write(IOdrlDocument odrlDocument, OutputStream output);

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlDocument, java.io.Writer)
     */
    public abstract void write(final IOdrlDocument odrlDocument, final Writer writer);

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlElement, java.io.OutputStream)
     */
    public abstract void write(final IOdrlElement<?> odrlElement, final OutputStream output);

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlElement, java.io.Writer)
     */
    public abstract void write(final IOdrlElement<?> odrlElement, final Writer writer);

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlSerializer#unmarshall(org.w3c.odrl.v21.serializers.IOdrlUnmarshaller, org.w3c.odrl.v21.model.IOdrlElement)
     */
    public <T> T unmarshall(final IOdrlUnmarshaller<T> unmarshaller, final IOdrlElement<?> element) {
        unmarshaller.unmarshall(element, this);
        return unmarshaller.getResult();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlSerializer#unmarshall(org.w3c.odrl.v21.serializers.IOdrlUnmarshaller, org.w3c.odrl.v21.model.IOdrlDocument)
     */
    public <T> T unmarshall(final IOdrlUnmarshaller<T> unmarshaller, final IOdrlDocument document) {
        unmarshaller.unmarshall(document, this);
        return unmarshaller.getResult();

    }

}
