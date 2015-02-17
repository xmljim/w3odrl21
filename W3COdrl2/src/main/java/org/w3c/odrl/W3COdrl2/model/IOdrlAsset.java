package org.w3c.odrl.W3COdrl2.model;

import org.w3c.odrl.W3COdrl2.vocabulary.AssetRelationType;

public interface IOdrlAsset extends IOdrlElementUUIDAndId<IOdrlAsset> {
	
	void setRelation(AssetRelationType relation);
	
	AssetRelationType getRelation();
	
}
