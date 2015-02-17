package org.w3c.odrl.W3COdrl2.model;

import org.w3c.odrl.W3COdrl2.datatypes.XsToken;

public interface IOdrlElementId<T> extends IOdrlElement<T> {

	void setId(XsToken id);
	
	XsToken getId();
	
	void setIdRef(XsToken idref);
	
	XsToken getIdRef();
	
	
}
