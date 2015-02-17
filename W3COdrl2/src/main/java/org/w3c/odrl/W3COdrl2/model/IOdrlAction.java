package org.w3c.odrl.W3COdrl2.model;

import org.w3c.odrl.W3COdrl2.vocabulary.ActionName;

public interface IOdrlAction extends IOdrlElementId<IOdrlAction> {

	void setActionName(ActionName name);
	
	ActionName getActionName();
}
