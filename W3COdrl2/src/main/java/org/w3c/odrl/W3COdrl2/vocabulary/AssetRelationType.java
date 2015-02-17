package org.w3c.odrl.W3COdrl2.vocabulary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;

public class AssetRelationType extends URIQNameQCode {
	
	private static Map<String, AssetRelationType> registeredItems = new HashMap<String, AssetRelationType>();
	
	public static final AssetRelationType TARGET = AssetRelationType.newAssetRelationType(Vocab.createOdrlVocabItem("target"));
	
	public static final AssetRelationType OUTPUT = AssetRelationType.newAssetRelationType(Vocab.createOdrlVocabItem("output"));
	
	static {
		registerAssetRelationType(TARGET);
		registerAssetRelationType(OUTPUT);
	}


	
	private AssetRelationType() {
		super();
	}
	
	public static AssetRelationType newAssetRelationType(final String uriQNameQCodeValue) {
		final AssetRelationType art = new AssetRelationType();
		art.setValue(uriQNameQCodeValue);
		return art;
	}
	
	public static AssetRelationType newAssetRelationType(final URIQNameQCode vocabId) {
		return newAssetRelationType(vocabId.toString());
	}
	
	public static void registerAssetRelationType(final AssetRelationType art) {
		registeredItems.put(art.toString(), art);
	}
	
	public static boolean isAssetRelationType(final String uriQNameQCode) {
		return registeredItems.containsKey(uriQNameQCode);
	}
	
	public static List<AssetRelationType> getAssetRelationTypes() {
		final List<AssetRelationType> arts = new ArrayList<AssetRelationType>();
		
		for (final Entry<String, AssetRelationType> entry : registeredItems.entrySet()) {
			arts.add(entry.getValue());
		}
		return arts;
	}

    public static AssetRelationType valueOf(final String val) {
        final AssetRelationType t = new AssetRelationType();
        t.setValue(val);
        return t;
    }
}
