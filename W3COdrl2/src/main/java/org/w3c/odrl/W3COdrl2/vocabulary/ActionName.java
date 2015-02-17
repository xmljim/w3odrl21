package org.w3c.odrl.W3COdrl2.vocabulary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;

/**
 * Contains a list of defined action names in the ODRL specification. Additional action names can be added using
 * {@link #newActionName(String)} or {@link #newActionName(URIQNameQCode)}
 * 
 * @author Jim Earley <xml.jim@gmail.com> Feb 14, 2015
 *
 */
public class ActionName extends URIQNameQCode {
    private static Map<String, ActionName> actionTypes = new HashMap<String, ActionName>();

    public static final ActionName USE = ActionName.newActionName(Vocab.createOdrlVocabItem("use"));

    public static final ActionName AGGREGATE = ActionName.newActionName(Vocab.createOdrlVocabItem("aggregate"), USE);

    public static final ActionName ANNOTATE = ActionName.newActionName(Vocab.createOdrlVocabItem("annotate"), USE);

    public static final ActionName ANONYMIZE = ActionName.newActionName(Vocab.createOdrlVocabItem("anonymize"), USE);

    public static final ActionName ARCHIVE = ActionName.newActionName(Vocab.createOdrlVocabItem("archive"), USE);

    public static final ActionName CONCURRENT_USE = ActionName.newActionName(Vocab.createOdrlVocabItem("concurrentUse"), USE);

    public static final ActionName DERIVE = ActionName.newActionName(Vocab.createOdrlVocabItem("derive"), USE);

    public static final ActionName DIGITIZE = ActionName.newActionName(Vocab.createOdrlVocabItem("digitize"), USE);

    public static final ActionName DISTRIBUTE = ActionName.newActionName(Vocab.createOdrlVocabItem("distribute"), USE);

    public static final ActionName EXECUTE = ActionName.newActionName(Vocab.createOdrlVocabItem("execute"), USE);

    public static final ActionName INDEX = ActionName.newActionName(Vocab.createOdrlVocabItem("index"), USE);

    public static final ActionName INSTALL = ActionName.newActionName(Vocab.createOdrlVocabItem("install"), USE);

    public static final ActionName MODIFY = ActionName.newActionName(Vocab.createOdrlVocabItem("modify"), DERIVE);

    public static final ActionName APPEND = ActionName.newActionName(Vocab.createOdrlVocabItem("append"), MODIFY);

    public static final ActionName MOVE = ActionName.newActionName(Vocab.createOdrlVocabItem("move"), USE);

    // PRESENT AND SUBITEMS
    public static final ActionName PRESENT = ActionName.newActionName(Vocab.createOdrlVocabItem("present"), USE);

    public static final ActionName DISPLAY = ActionName.newActionName(Vocab.createOdrlVocabItem("display"), PRESENT);

    public static final ActionName PLAY = ActionName.newActionName(Vocab.createOdrlVocabItem("play"), PRESENT);

    public static final ActionName PRINT = ActionName.newActionName(Vocab.createOdrlVocabItem("print"), PRESENT);

    public static final ActionName PREVIEW = ActionName.newActionName(Vocab.createOdrlVocabItem("preview"), PRESENT);

    public static final ActionName READ = ActionName.newActionName(Vocab.createOdrlVocabItem("read"), USE);

    // REPRODUCT & SUBITEMS
    public static final ActionName REPRODUCE = ActionName.newActionName(Vocab.createOdrlVocabItem("reproduce"), USE);

    public static final ActionName COPY = ActionName.newActionName(Vocab.createOdrlVocabItem("copy"), REPRODUCE);

    public static final ActionName EXTRACT = ActionName.newActionName(Vocab.createOdrlVocabItem("extract"), REPRODUCE);

    public static final ActionName EXTRACT_CHAR = ActionName.newActionName(Vocab.createOdrlVocabItem("extractChar"), EXTRACT);

    public static final ActionName EXTRACT_WORD = ActionName.newActionName(Vocab.createOdrlVocabItem("extractWord"), EXTRACT);

    public static final ActionName EXTRACT_PAGE = ActionName.newActionName(Vocab.createOdrlVocabItem("extractPage"), EXTRACT);


    public static final ActionName TEXT_TO_SPEECH = ActionName.newActionName(Vocab.createOdrlVocabItem("textToSpeech"), USE);

    public static final ActionName TRANSLATE = ActionName.newActionName(Vocab.createOdrlVocabItem("translate"), DERIVE);

    public static final ActionName TRANSFORM = ActionName.newActionName(Vocab.createOdrlVocabItem("transform"), DERIVE);

    public static final ActionName TRANSFER = ActionName.newActionName(Vocab.createOdrlVocabItem("transfer"), USE);

    public static final ActionName GIVE = ActionName.newActionName(Vocab.createOdrlVocabItem("give"), TRANSFER);

    public static final ActionName SELL = ActionName.newActionName(Vocab.createOdrlVocabItem("sell"), TRANSFER);

    public static final ActionName EXPORT = ActionName.newActionName(Vocab.createOdrlVocabItem("export"), TRANSFER);

    public static final ActionName LEASE = ActionName.newActionName(Vocab.createOdrlVocabItem("lease"), TRANSFER);

    public static final ActionName LEND = ActionName.newActionName(Vocab.createOdrlVocabItem("lend"), TRANSFER);

    public static final ActionName SHARE = ActionName.newActionName(Vocab.createOdrlVocabItem("share"), TRANSFER);

    public static final ActionName GRANT_USE = ActionName.newActionName(Vocab.createOdrlVocabItem("grantUse"), USE);

    // FOR USE WITH DUTIES
	public static final ActionName ACCEPT_TRACKING = ActionName.newActionName(Vocab.createOdrlVocabItem("acceptTracking"));
	
	public static final ActionName ATTRIBUTE = ActionName.newActionName(Vocab.createOdrlVocabItem("attribute"));
	
    public static final ActionName COMPENSATE = ActionName.newActionName(Vocab.createOdrlVocabItem("compensate"));
	
	public static final ActionName DELETE = ActionName.newActionName(Vocab.createOdrlVocabItem("delete"));

	public static final ActionName ENSURE_EXLUSIVITY = ActionName.newActionName(Vocab.createOdrlVocabItem("ensureExlusivity"));

	public static final ActionName INCLUDE = ActionName.newActionName(Vocab.createOdrlVocabItem("include"));
	
	public static final ActionName INFORM = ActionName.newActionName(Vocab.createOdrlVocabItem("inform"));
	
	public static final ActionName NEXT_POLICY = ActionName.newActionName(Vocab.createOdrlVocabItem("nextPolicy"));
	
	public static final ActionName OBTAIN_CONSENT = ActionName.newActionName(Vocab.createOdrlVocabItem("obtainConsent"));
	
	public static final ActionName PAY = ActionName.newActionName(Vocab.createOdrlVocabItem("pay"));
	
	public static final ActionName REVIEW_POLICY = ActionName.newActionName(Vocab.createOdrlVocabItem("reviewPolicy"));

	public static final ActionName UNINSTALL = ActionName.newActionName(Vocab.createOdrlVocabItem("uninstall"));
	
	public static final ActionName WATERMARK = ActionName.newActionName(Vocab.createOdrlVocabItem("watermark"));
	
	public static final ActionName WRITE = ActionName.newActionName(Vocab.createOdrlVocabItem("write"));
	
	static {
		registerActionName(ACCEPT_TRACKING);
		registerActionName(AGGREGATE);
		registerActionName(ANNOTATE);
		registerActionName(ANONYMIZE);
		registerActionName(APPEND);
		registerActionName(ARCHIVE);
		registerActionName(ATTRIBUTE);
		registerActionName(CONCURRENT_USE);
		registerActionName(COPY);
		registerActionName(DELETE);
		registerActionName(DERIVE);
		registerActionName(DIGITIZE);
		registerActionName(DISPLAY);
		registerActionName(DISTRIBUTE);
		registerActionName(ENSURE_EXLUSIVITY);
		registerActionName(EXECUTE);
		registerActionName(EXPORT);
		registerActionName(EXTRACT);
		registerActionName(EXTRACT_CHAR);
		registerActionName(EXTRACT_PAGE);
		registerActionName(EXTRACT_WORD);
		registerActionName(GIVE);
		registerActionName(INCLUDE);
		registerActionName(INDEX);
		registerActionName(INFORM);
		registerActionName(INSTALL);
		registerActionName(LEASE);
		registerActionName(LEND);
		registerActionName(MODIFY);
		registerActionName(MOVE);
		registerActionName(NEXT_POLICY);
		registerActionName(OBTAIN_CONSENT);
		registerActionName(PAY);
		registerActionName(PLAY);
		registerActionName(PRESENT);
		registerActionName(PREVIEW);
		registerActionName(PRINT);
		registerActionName(READ);
		registerActionName(REPRODUCE);
		registerActionName(REVIEW_POLICY);
		registerActionName(SELL);
		registerActionName(SHARE);
		registerActionName(TEXT_TO_SPEECH);
		registerActionName(TRANSFORM);
		registerActionName(TRANSLATE);
		registerActionName(UNINSTALL);
		registerActionName(WATERMARK);
		registerActionName(WRITE);
	}
	
    private ActionName parentTerm;
    private final List<ActionName> childTerms = new ArrayList<ActionName>();

	private ActionName() {
		super();
	}
	
    public ActionName getParentTerm() {
        return this.parentTerm;
    }

    public List<ActionName> getAncestorTerms() {
        final List<ActionName> ancestors = new ArrayList<ActionName>();
        addAncestorTerm(this, ancestors);
        return ancestors;

    }

    /**
     * Returns the root Action for the current action name
     * 
     * @return returns the ancestor root term, or itself, if no ancestor terms are found
     */
    public ActionName getRootTerm() {
        final List<ActionName> ancestors = getAncestorTerms();
        if (!ancestors.isEmpty()) {
            return ancestors.get(0);
        } else {
            return this;
        }
    }

    public List<ActionName> getChildTerms() {
        return this.childTerms;
    }

    public List<ActionName> getDescendantTerms() {
        final List<ActionName> descendants = new ArrayList<ActionName>();
        addDescendantTerm(this, descendants);
        return descendants;
    }

    private void addDescendantTerm(final ActionName current, final List<ActionName> list) {
        for (final ActionName an : current.getChildTerms()) {
            list.add(an);
            addDescendantTerm(an, list);
        }
    }

    private void addAncestorTerm(final ActionName current, final List<ActionName> list) {
        if (current.getParentTerm() != null) {
            list.add(0, current.getParentTerm());
            addAncestorTerm(current.getParentTerm(), list);
        }
    }

    private void setParentTerm(final ActionName parentTerm) {
        this.parentTerm = parentTerm;
        this.parentTerm.addChildTerm(this);

    }

    private void addChildTerm(final ActionName childTerm) {
        this.childTerms.add(childTerm);
    }

    public static ActionName newActionName(final String uriQNameQCodeValue, final ActionName parentTerm) {
        final ActionName currentTerm = new ActionName();
        currentTerm.setValue(uriQNameQCodeValue);

        if (isActionName(parentTerm.toString())) {
            currentTerm.setParentTerm(actionTypes.get(parentTerm.toString()));
        } else {
            registerActionName(parentTerm);
            currentTerm.setParentTerm(parentTerm);
        }

        if (!isActionName(uriQNameQCodeValue)) {
            registerActionName(currentTerm);
        }

        return currentTerm;
    }

	public static ActionName newActionName(final String uriQNameQCodeValue) {
		final ActionName at = new ActionName();
		at.setValue(uriQNameQCodeValue);
        if (!isActionName(uriQNameQCodeValue)) {
            registerActionName(at);
        }
		return at;
	}
	
	public static ActionName newActionName(final URIQNameQCode vocabId) {
		return newActionName(vocabId.toString());
	}
	
    public static ActionName newActionName(final URIQNameQCode vocabId, final ActionName parent) {
        return newActionName(vocabId.toString(), parent);
    }

	public static void registerActionName(final ActionName at) {
		actionTypes.put(at.toString(), at);
	}
	
	public static boolean isActionName(final String uriQNameQCode) {
		return actionTypes.containsKey(uriQNameQCode);
	}
	
	public static List<ActionName> getActionNames() {
		final List<ActionName> ats = new ArrayList<ActionName>();
		
		for (final Entry<String, ActionName> entry : actionTypes.entrySet()) {
			ats.add(entry.getValue());
		}
		
		return ats;
	}

    public static ActionName valueOf(final String val) {
        final ActionName t = new ActionName();
        t.setValue(val);
        return t;
    }
}
