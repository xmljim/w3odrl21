package org.w3c.odrl.W3COdrl2.datatypes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import javax.xml.namespace.QName;

public class URIQNameQCode {

	private String value;
	private boolean isUri;
	private boolean isQName;
	private boolean isQCode;
	
	protected URIQNameQCode() {
		
	}
	
	protected void setValue(final String val) {
		this.value  = val;
	}
	
	public static URIQNameQCode newURIQNameQCode(final String val) {
		final URIQNameQCode uqq = new URIQNameQCode();
		uqq.setValue(val);
		return uqq;
	}
	
    public static final URIQNameQCode generateRandom() {
        return newURIQNameQCode(UUID.randomUUID().toString());
    }

    public URIQNameQCode(final String val) {
		
		try {
			new URI(val);
			this.isUri = true;
		} catch (final URISyntaxException e) {
			this.isUri = false;
		}
		
		if (!this.isUri) {
			//try value as QName
			try {
				QName.valueOf(val);
			} catch (final IllegalArgumentException e) {
				this.isQName = false;
			}
			
			if (!this.isQName) {
				try {
					new QCode(val);
					
				} catch (final DataTypeException e) {
					throw new DataTypeException("Invalid value.  Value format must conform to either a URI, QName or QCode");
				}
			}
		}
		
		this.value = val;
		

	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	public boolean isURI() {
		return this.isUri;
	}
	
	public URI toURI() throws DataTypeException {

		try {
	        return new URI(this.value);
        } catch (final URISyntaxException e) {
        	throw new DataTypeException("Value is not a valid URI");
        }
	}
	
	public boolean isQName() {
		return this.isQName;
	}
	
	public QName toQName() throws DataTypeException {
		try {
			return QName.valueOf(this.value);
		} catch(final IllegalArgumentException e) {
			throw new DataTypeException("Value is not a valid QName");
		}
	}
	
	public boolean isQCode() {
		return this.isQCode;
	}
	
	public QCode toQCode() throws DataTypeException {
		return new QCode(this.value);
	}
	
    @Override
    public boolean equals(final Object o) {
        return this.value.equals(o.toString());
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return this.value.hashCode();
    }
	

}
