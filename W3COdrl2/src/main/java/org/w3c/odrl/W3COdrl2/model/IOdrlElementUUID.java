package org.w3c.odrl.W3COdrl2.model;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;


public interface IOdrlElementUUID<T> extends IOdrlElement<T> {

	void setUUID(URIQNameQCode uuid);
	
	URIQNameQCode getUUID();
}
