package com.ghotibown.json.factory;

import com.ghotibown.json.JSONFactory;
import com.ghotibown.json.parser.JSONParser;
import com.ghotibown.json.parser.tokenizer.TokenParser;
import com.ghotibown.json.serializer.JSONSerializer;
import com.ghotibown.json.serializer.JSONSerializerImpl;

public class JSONFactoryImpl extends JSONFactory {

	@Override
	public JSONParser newParser() {
		return new TokenParser();
	}

	@Override
    public JSONSerializer newSerializer() {
	    return new JSONSerializerImpl();
    }

}
