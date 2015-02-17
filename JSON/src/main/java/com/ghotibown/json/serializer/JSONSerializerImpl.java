package com.ghotibown.json.serializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.ghotibown.json.JSONNode;
import com.ghotibown.json.exception.JSONSerializationException;

public class JSONSerializerImpl implements JSONSerializer {

	
	public void write(File outputFile, JSONNode json) throws JSONSerializationException {
		try {
	        FileWriter fileWriter = new FileWriter(outputFile);
	        write(fileWriter, json);
        } catch (IOException e) {
	        throw new JSONSerializationException(e);
        }

	}

	
	public void write(OutputStream stream, JSONNode json) throws JSONSerializationException {
		 OutputStreamWriter writer = new OutputStreamWriter(stream);
		 write(writer, json);
	}

	
	public void write(Writer writer, JSONNode json) throws JSONSerializationException {
		String jsonString = json.toJSONString();
		
		try {
	        writer.write(jsonString);
	        writer.flush();
	        writer.close();
        } catch (IOException e) {
	        // TODO Auto-generated catch block
	        throw new JSONSerializationException(e);
        }
	}

}
