/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.json;

import org.w3c.odrl.W3COdrl2.serializers.AbstractOdrlSerializer;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
public abstract class AbstractOdrlJsonSerializer extends AbstractOdrlSerializer implements IOdrlJsonSerializer {

    public static IOdrlJsonSerializer newJsonSerializer() {
        return new DefaultJsonSerializer();
    }

    public static IOdrlJsonSerializer newJsonSerializer(final String clazz) throws ClassNotFoundException, InstantiationException,
                    IllegalAccessException {
        @SuppressWarnings("unchecked")
        final Class<? extends IOdrlJsonSerializer> c = (Class<? extends IOdrlJsonSerializer>) Class.forName(clazz);
        return c.newInstance();
    }

    public static IOdrlJsonUnmarshaller<?> newJsonUnmarshaller() {
        return new DefaultJsonUnmarshaller();
    }

}
