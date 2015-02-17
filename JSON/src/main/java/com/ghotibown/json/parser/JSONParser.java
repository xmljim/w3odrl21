package com.ghotibown.json.parser;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

import com.ghotibown.json.JSONObject;
import com.ghotibown.json.exception.JSONParserException;

public interface JSONParser {
	
	JSONObject parse(InputStream inputStream) throws JSONParserException;
	
	JSONObject parse(URL url) throws JSONParserException;
	
	JSONObject parse(String data) throws JSONParserException;
	
	JSONObject parse(Reader reader) throws JSONParserException;
	
	JSONObject parse(File file) throws JSONParserException;
	
	JSONObject newJSONObject();

}
