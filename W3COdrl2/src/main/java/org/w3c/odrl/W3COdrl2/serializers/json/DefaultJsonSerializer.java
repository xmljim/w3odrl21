/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.json;

import java.io.OutputStream;
import java.io.Writer;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;

import com.ghotibown.json.JSONFactory;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.exception.JSONSerializationException;
import com.ghotibown.json.serializer.JSONSerializer;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
class DefaultJsonSerializer extends AbstractOdrlJsonSerializer {


    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlDocument, java.io.OutputStream)
     */
    @Override
    public void write(final IOdrlDocument odrlDocument, final OutputStream output) {
        JSONObject unmarshalledObject = null;
        @SuppressWarnings("unchecked")
        final IOdrlJsonUnmarshaller<JSONObject> unmarshaller = (IOdrlJsonUnmarshaller<JSONObject>) newJsonUnmarshaller();
        unmarshaller.unmarshall(odrlDocument, this);
        unmarshalledObject = unmarshaller.getResult();

        final JSONSerializer serializer = JSONFactory.newFactory().newSerializer();
        try {
            serializer.write(output, unmarshalledObject);
        } catch (final JSONSerializationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlDocument, java.io.Writer)
     */
    @Override
    public void write(final IOdrlDocument odrlDocument, final Writer writer) {
        JSONObject unmarshalledObject = null;
        @SuppressWarnings("unchecked")
        final IOdrlJsonUnmarshaller<JSONObject> unmarshaller = (IOdrlJsonUnmarshaller<JSONObject>) newJsonUnmarshaller();
        unmarshaller.unmarshall(odrlDocument, this);
        unmarshalledObject = unmarshaller.getResult();

        final JSONSerializer serializer = JSONFactory.newFactory().newSerializer();
        try {
            serializer.write(writer, unmarshalledObject);
        } catch (final JSONSerializationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlElement, java.io.OutputStream)
     */
    @Override
    public void write(final IOdrlElement<?> odrlElement, final OutputStream output) {
        JSONObject unmarshalledObject = null;
        final DefaultJsonUnmarshaller unmarshaller = new DefaultJsonUnmarshaller();
        unmarshaller.unmarshall(odrlElement, this);
        unmarshalledObject = unmarshaller.getResult();

        final JSONSerializer serializer = JSONFactory.newFactory().newSerializer();
        try {
            serializer.write(output, unmarshalledObject);
        } catch (final JSONSerializationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlElement, java.io.Writer)
     */
    @Override
    public void write(final IOdrlElement<?> odrlElement, final Writer writer) {
        JSONObject unmarshalledObject = null;
        final DefaultJsonUnmarshaller unmarshaller = new DefaultJsonUnmarshaller();
        unmarshaller.unmarshall(odrlElement, this);
        unmarshalledObject = unmarshaller.getResult();

        final JSONSerializer serializer = JSONFactory.newFactory().newSerializer();
        try {
            serializer.write(writer, unmarshalledObject);
        } catch (final JSONSerializationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
