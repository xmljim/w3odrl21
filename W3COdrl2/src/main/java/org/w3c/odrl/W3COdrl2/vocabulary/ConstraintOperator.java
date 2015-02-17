package org.w3c.odrl.W3COdrl2.vocabulary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.odrl.W3COdrl2.datatypes.DataTypeException;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;

public class ConstraintOperator extends URIQNameQCode {
	
	public static final ConstraintOperator EQUALS = ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("eq")); 
	
	public static final ConstraintOperator GREATER_THAN = ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("gt"));
	
	public static final ConstraintOperator GREATER_THAN_EQUALS = ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("gteq"));
	
	public static final ConstraintOperator HAS_PART =  ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("hasPart"));

	public static final ConstraintOperator IS_A = ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("isA"));
	
	public static final ConstraintOperator IS_ALL_OF = ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("isAllOf"));
	
	public static final ConstraintOperator IS_ANY_OF = ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("isAnyOf"));
	
	public static final ConstraintOperator IS_NONE_OF =  ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("isNoneOf"));
	
	public static final ConstraintOperator IS_PART_OF =  ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("isPartOf"));
	
	public static final ConstraintOperator LESS_THAN = ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("lt"));
	
	public static final ConstraintOperator LESS_THAN_EQUALS = ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("lteq"));
	
	public static final ConstraintOperator NOT_EQUALS = ConstraintOperator.newConstraintOperator(Vocab.createOdrlVocabItem("neq"));
	
	private static Map<String, ConstraintOperator> operators = new HashMap<String, ConstraintOperator>();
	
	//register our static constants as operators
	static {
		registerOperator(EQUALS);
		registerOperator(GREATER_THAN);
		registerOperator(GREATER_THAN_EQUALS);
		registerOperator(HAS_PART);
		registerOperator(IS_A);
		registerOperator(IS_ALL_OF);
		registerOperator(IS_ANY_OF);
		registerOperator(IS_NONE_OF);
		registerOperator(IS_PART_OF);
		registerOperator(LESS_THAN);
		registerOperator(LESS_THAN_EQUALS);
		registerOperator(NOT_EQUALS);
		
	}
	
	/**
	 * Register an operator
	 * @param operator the URI, QName or QCode value of the operator
	 */
	public static void registerOperator(final ConstraintOperator operator) {
		operators.put(operator.toString(), operator);
	}
	
	/**
	 * Returns true if the specified URI, QName or QCode is registered as an operator
	 * @param operatorEval the {@link URIQNameQCode} value
	 * @return true if the value is registered as an operator; false otherwise
	 */
	public static boolean isOperator(final URIQNameQCode operatorEval) {
		return operators.containsKey(operatorEval.toString());
	}
	
	/**
	 * return a list of registered operators
	 * @return a list of registered operators;
	 */
	public static List<ConstraintOperator> getOperators() {
		final List<ConstraintOperator> operatorList = new ArrayList<ConstraintOperator>();
		
		for (final Entry<String, ConstraintOperator> entry : operators.entrySet()) {
			operatorList.add(entry.getValue());
		}
		
		return operatorList;
	}
	
	private ConstraintOperator() {
		super();
	}

	public ConstraintOperator(final String val) throws DataTypeException {
	    super(val);
	    // TODO Auto-generated constructor stub
    }
	
	public static ConstraintOperator newConstraintOperator(final String uriQnameQcodeValue) {
		final ConstraintOperator co = new ConstraintOperator();
		co.setValue(uriQnameQcodeValue);
		return co;
	}
	
	public static ConstraintOperator newConstraintOperator(final URIQNameQCode vocabId) {
		return newConstraintOperator(vocabId.toString());
	}

    public static ConstraintOperator valueOf(final String val) {
        final ConstraintOperator t = new ConstraintOperator();
        t.setValue(val);
        return t;
    }
}
