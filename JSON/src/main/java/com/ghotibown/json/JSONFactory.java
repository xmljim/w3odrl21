package com.ghotibown.json;

import com.ghotibown.json.exception.JSONFactoryException;
import com.ghotibown.json.factory.JSONFactoryImpl;
import com.ghotibown.json.parser.JSONParser;
import com.ghotibown.json.serializer.JSONSerializer;

/**
 * Factory class used to instantiate a new {@link JSONParser}. For anyone familiar with 
 * <a href="http://docs.oracle.com/javaee/1.4/tutorial/doc/JAXPIntro.html>JAXP</a>, this API uses the same type of pattern.
 * <p><b>Example</b></p>
 * <pre>
 * JSONFactory factory = JSONFactory.newFactory();
 * <span>//</span>Use the factory to create a new Parser
 * JSONParser parser = factory.newParser();
 * <span>//</span>Now use the parser to create a new JSONObject, using one of its methods - we'll create an empty one here...
 * JSONObject json = parser.newJSONObject();
 * </pre>
 * @author jearley
 *
 */
public abstract class JSONFactory {
	
	/**
	 * Create a new factory implementation.  The factory will instantiate a new {@link JSONParser}
	 * @return a new factory
	 * @throws JSONFactoryException thrown if the factory could not be instantiated
	 */
	public static JSONFactory newFactory() throws JSONFactoryException {
		return new JSONFactoryImpl();
	}
	
	/**
	 * Instantiate the underlying {@link JSONParser} implementation for this factory
	 * @return the {@link JSONParser}
	 */
	public abstract JSONParser newParser();
	
	/**
	 * Instantiate the underlying {@link JSONSerializer} implementation for this factory
	 * @return the {@link JSONSerializer}
	 */
	public abstract JSONSerializer newSerializer();

}
