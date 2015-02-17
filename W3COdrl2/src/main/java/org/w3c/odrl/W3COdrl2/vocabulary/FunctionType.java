package org.w3c.odrl.W3COdrl2.vocabulary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;

public class FunctionType extends URIQNameQCode {
    private static Map<String, FunctionType> registeredTypes = new HashMap<String, FunctionType>();

    public static List<FunctionType> getFunctionTypes() {
        final List<FunctionType> types = new ArrayList<FunctionType>();

        for (final Entry<String, FunctionType> entry : registeredTypes.entrySet()) {
            types.add(entry.getValue());
        }

        return types;
    }

    public static boolean isFunctionType(final String uriQNameQCode) {
        return registeredTypes.containsKey(uriQNameQCode);
    }

    public static FunctionType newFunctionType(final String uriQNameQCodeValue) {
        final FunctionType part = new FunctionType();
        part.setValue(uriQNameQCodeValue);
        return part;
    }

    public static FunctionType newFunctionType(final URIQNameQCode vocabId) {
        return newFunctionType(vocabId.toString());
    }

    public static void registerFunctionType(final FunctionType part) {
        registeredTypes.put(part.toString(), part);
    }

    public static final FunctionType ASSIGNER = FunctionType.newFunctionType(Vocab.createOdrlVocabItem("assigner"));

    public static final FunctionType ASSIGNEE = FunctionType.newFunctionType(Vocab.createOdrlVocabItem("assignee"));

    public static final FunctionType ATTRIBUTED_PARTY = FunctionType.newFunctionType(Vocab.createOdrlVocabItem("attributedParty"));

    public static final FunctionType CONSENTING_PARTY = FunctionType.newFunctionType(Vocab.createOdrlVocabItem("consentingParty"));

    public static final FunctionType INFORMED_PARTY = FunctionType.newFunctionType(Vocab.createOdrlVocabItem("informedParty"));

    public static final FunctionType PAYEE_PARTY = FunctionType.newFunctionType(Vocab.createOdrlVocabItem("payeeParty"));

    public static final FunctionType TRACKING_PARTY = FunctionType.newFunctionType(Vocab.createOdrlVocabItem("trackingParty"));

    static {
        registerFunctionType(ASSIGNER);
        registerFunctionType(ASSIGNEE);
        registerFunctionType(ATTRIBUTED_PARTY);
        registerFunctionType(CONSENTING_PARTY);
        registerFunctionType(INFORMED_PARTY);
        registerFunctionType(PAYEE_PARTY);
        registerFunctionType(TRACKING_PARTY);
    }



    private FunctionType() {
        super();
    }

    public static FunctionType valueOf(final String val) {
        final FunctionType t = new FunctionType();
        t.setValue(val);
        return t;
    }
}
