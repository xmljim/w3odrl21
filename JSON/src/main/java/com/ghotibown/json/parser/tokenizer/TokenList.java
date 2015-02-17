package com.ghotibown.json.parser.tokenizer;

import java.util.ArrayList;

import com.ghotibown.json.NullObject;
import com.ghotibown.json.exception.JSONParserException;

class TokenList extends ArrayList<Object> {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    
    public TokenList(Tokenizer x) throws JSONParserException {
        if (x.nextClean() != '[') {
            throw x.syntaxError("A JSONArray text must start with '['");
        }
        if (x.nextClean() != ']') {
            x.back();
            for (;;) {
                if (x.nextClean() == ',') {
                    x.back();
                    this.add(new NullObject());
                } else {
                    x.back();
                    this.add(x.nextValue());
                }
                switch (x.nextClean()) {
                case ';':
                case ',':
                    if (x.nextClean() == ']') {
                        return;
                    }
                    x.back();
                    break;
                case ']':
                    return;
                default:
                    throw x.syntaxError("Expected a ',' or ']'");
                }
            }
        }
    	
    }
}
