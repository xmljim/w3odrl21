package com.ghotibown.json.parser.tokenizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;

import com.ghotibown.json.JSONObject;
import com.ghotibown.json.exception.JSONParserException;
import com.ghotibown.json.factory.NodeFactory;
import com.ghotibown.json.parser.JSONParser;

public class TokenParser implements JSONParser {

	
	public JSONObject parse(InputStream inputStream) throws JSONParserException {
		InputStreamReader reader = new InputStreamReader(inputStream);
		return parse(reader);
	}

	
	public JSONObject parse(URL url) throws JSONParserException {
		try {
			InputStream stream = url.openStream();
	        JSONObject o = parse(stream);
	        stream.close();
	        return o;
        } catch (IOException e) {
	        throw new JSONParserException(e.getMessage(), e);
        }
	}

	
	public JSONObject parse(String data) throws JSONParserException {
		StringReader reader = new StringReader(data);
		return parse(reader);
	}

	
	public JSONObject parse(Reader reader) throws JSONParserException {
		Tokenizer t = new Tokenizer(reader);
		TokenMap map = new TokenMap(t);
		JSONObject o = NodeFactory.newJSONObject(map);
		return o;
	}
	
	public JSONObject parse(File file) throws JSONParserException {
		try {
	        FileInputStream stream = new FileInputStream(file);
	        JSONObject o = parse(stream);
	        stream.close();
	        return o;
        } catch (FileNotFoundException e) {
        	throw new JSONParserException(e.getMessage(), e);
	        
        } catch (IOException e) {
        	throw new JSONParserException(e.getMessage(), e);
        }
		
	}
	
	public JSONObject newJSONObject() {
		return NodeFactory.newJSONObject();
	}

}
