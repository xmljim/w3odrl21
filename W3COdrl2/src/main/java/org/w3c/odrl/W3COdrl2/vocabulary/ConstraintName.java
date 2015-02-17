package org.w3c.odrl.W3COdrl2.vocabulary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.odrl.W3COdrl2.datatypes.DataTypeException;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;

public class ConstraintName extends URIQNameQCode {
	
	public static final ConstraintName ABSOLUTE_POSITION = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("absolutePosition"));
	
	public static final ConstraintName ABSOLUTE_SIZE = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("acceptTracking"));
	
	public static final ConstraintName COUNT = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("count"));
	
	public static final ConstraintName DATE_TIME = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("dateTime"));
	
	public static final ConstraintName FILE_FORMAT = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("fileFormat"));
	
	public static final ConstraintName INDUSTRY = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("industry"));
	
	public static final ConstraintName LANGUAGE = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("language"));
	
	public static final ConstraintName DELIVERY_CHANNEL = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("deliveryChannel"));
	
	public static final ConstraintName ELAPSED_TIME = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("elapsedTime"));
	
	public static final ConstraintName EVENT = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("event"));
	
	public static final ConstraintName METERED_TIME = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("meteredTime"));
	
	public static final ConstraintName MEDIA = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("media"));
	
	public static final ConstraintName PERCENTAGE = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("percentage"));
	
	public static final ConstraintName PRODUCT = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("product"));
	
	public static final ConstraintName PROXIMITY = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("proximity"));
	
	public static final ConstraintName PURPOSE = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("purpose"));
	
	public static final ConstraintName RECIPIENT = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("recipient"));
	
	public static final ConstraintName RELATIVE_POSITION = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("relativePosition"));
	
	public static final ConstraintName RELATIVE_SIZE = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("relativeSize"));
	
	public static final ConstraintName RESOLUTION = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("resolution"));
	
	public static final ConstraintName SPATIAL = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("spatial"));
	
	public static final ConstraintName TIMED_COUNT = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("timedCount"));
	
	public static final ConstraintName TIME_INTERVAL = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("timeInterval"));
	
	public static final ConstraintName SYSTEM = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("system"));
	
	public static final ConstraintName DEVICE = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("device"));
	
	public static final ConstraintName VERSION = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("version"));
	
	public static final ConstraintName VIRTUAL_LOCATION = ConstraintName.newConstraintName(Vocab.createOdrlVocabItem("virtualLocation"));
	
	private static Map<String, ConstraintName> names = new HashMap<String, ConstraintName>();
	
	static {
		registerConstraintName(ABSOLUTE_POSITION);
		registerConstraintName(ABSOLUTE_SIZE);
		registerConstraintName(COUNT);
		registerConstraintName(DATE_TIME);
		registerConstraintName(FILE_FORMAT);
		registerConstraintName(INDUSTRY);
		registerConstraintName(LANGUAGE);
		registerConstraintName(DELIVERY_CHANNEL);
		registerConstraintName(DEVICE);
		registerConstraintName(ELAPSED_TIME);
		registerConstraintName(EVENT);
		registerConstraintName(MEDIA);
		registerConstraintName(METERED_TIME);
		registerConstraintName(PERCENTAGE);
		registerConstraintName(PRODUCT);
		registerConstraintName(PROXIMITY);
		registerConstraintName(PURPOSE);
		registerConstraintName(RECIPIENT);
		registerConstraintName(RELATIVE_POSITION);
		registerConstraintName(RELATIVE_SIZE);
		registerConstraintName(RESOLUTION);
		registerConstraintName(SPATIAL);
		registerConstraintName(SYSTEM);
		registerConstraintName(TIMED_COUNT);
		registerConstraintName(TIME_INTERVAL);
		registerConstraintName(VERSION);
		registerConstraintName(VIRTUAL_LOCATION);
	}
	
	private ConstraintName() {
		super();
	}

	public ConstraintName(final String val) throws DataTypeException {
	    super(val);
	    // TODO Auto-generated constructor stub
    }
	
	public static ConstraintName newConstraintName(final String uriQnameQcodeValue) {
		final ConstraintName cn = new ConstraintName();
		cn.setValue(uriQnameQcodeValue);
		return cn;
	}
	
	public static ConstraintName newConstraintName(final URIQNameQCode vocabId) {
		return newConstraintName(vocabId.toString());
	}
	
	public static boolean isConstraintName(final String uriQNameQcode) {
		return names.containsKey(uriQNameQcode);
	}
	
	public static void registerConstraintName(final ConstraintName constraintName) {
		names.put(constraintName.toString(), constraintName);
	}
	
	public static List<ConstraintName> getConstraintNames () {
		final List<ConstraintName> constraints = new ArrayList<ConstraintName>();
		
		for (final Entry<String, ConstraintName> c : names.entrySet()) {
			constraints.add(c.getValue());
		}
		
		return constraints;
	}
	
    public static ConstraintName valueOf(final String val) {
        final ConstraintName t = new ConstraintName();
        t.setValue(val);
        return t;
    }
}
