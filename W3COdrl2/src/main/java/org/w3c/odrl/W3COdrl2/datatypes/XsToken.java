package org.w3c.odrl.W3COdrl2.datatypes;

import java.util.List;

public class XsToken {
	
    private String value;

	private XsToken() {
	    
	}
	
	public XsToken(final String val) throws DataTypeException {
		//FIXME need a regex to better match this pattern
		if (val.startsWith(" ") 
				|| val.endsWith(" ") 
				|| val.indexOf("  ") != -1 
				|| val.indexOf("\n") != -1
				|| val.indexOf("\r") != -1
				|| val.indexOf("\t") != -1) {
			throw new DataTypeException("Invalid Token: " + val);
		}
		
		this.value = val;
		
	} 
	
	public XsToken(final List<String> values) {
		final StringBuilder builder = new StringBuilder();
		for (final String s : values) {
			builder.append(s).append(" ");
		}
		
		this.value = builder.toString().trim();
	}
	

	
	@Override
	public String toString() {
		return this.value;
	}
	
    public static XsToken valueOf(final String token) {
        final XsToken t = new XsToken();
        t.value = token;
        return t;
    }
}
