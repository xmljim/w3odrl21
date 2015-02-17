package org.w3c.odrl.W3COdrl2.datatypes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Represents a tokenized list of values <div> <h3>Notes about datatypes</h3>
 * <p>
 * Internally, the tokenized list uses a List<T> to hold the values. All of the <code>new*</code> initializers use the {@link XmlDataType}
 * Enum to determine the underlying data type for the list values. The {{@link #newListOfValues(String)} method will attempt to guess the
 * datatype for the string data, gracefully degrading to <code>ListOfValues&lt;String&gt;</code> if the value cannot be determined.
 * </p>
 * <p>
 * Specific XML Data Types will be cast to the following types. Some datatypes may not be supported, and others may be supported in context
 * of another type (e.g., xs:gDay)
 * </p>
 * <table border="1" style="border-collapse: collapse">
 * <tr>
 * <th>XML Datatype</th>
 * <th>Java Class</th>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#BASE_64_BINARY}</td>
 * <td><strong>Not Supported: throws a {@linkplain DataTypeException}</strong></td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#BOOLEAN}</td>
 * <td>{@link Boolean}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#BYTE}</td>
 * <td><strong>Not Supported: throws a {@linkplain DataTypeException}</strong></td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#DATE}</td>
 * <td>{@link XMLGregorianCalendar}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#DATE_TIME}</td>
 * <td>{@link XMLGregorianCalendar}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#DAY_TIME_DURATION}</td>
 * <td>{@link Duration}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#DECIMAL}</td>
 * <td>{@link Number} - Internally the underlying concrete class is {@link BigDecimal}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#DOUBLE}</td>
 * <td>{@link Number} - The underlying concrete class is {@link Double}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#DURATION}</td>
 * <td>{@link Duration}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#FLOAT}</td>
 * <td>{@link Number} - The underlying concrete class is {@link Float}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#G_DAY}</td>
 * <td>{@link XMLGregorianCalendar} - value must be part of {@link XmlDataType#DATE} or {@link XmlDataType#DATE_TIME}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#G_MONTH}</td>
 * <td>{@link XMLGregorianCalendar} - value must be part of {@link XmlDataType#DATE} or {@link XmlDataType#DATE_TIME}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#G_MONTH_DAY}</td>
 * <td>{@link XMLGregorianCalendar} - value must be part of {@link XmlDataType#DATE} or {@link XmlDataType#DATE_TIME}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#G_YEAR}</td>
 * <td>{@link XMLGregorianCalendar} - value must be part of {@link XmlDataType#DATE} or {@link XmlDataType#DATE_TIME}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#G_YEAR_MONTH}</td>
 * <td>{@link XMLGregorianCalendar} - value must be part of {@link XmlDataType#DATE} or {@link XmlDataType#DATE_TIME}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#HEX_BINARY}</td>
 * <td><strong>Not Supported: throws a {@linkplain DataTypeException}</strong></td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#INT}</td>
 * <td>{@link Number} - Concrete class is {@link Integer}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#INTEGER}</td>
 * <td>{@link Number} - Concrete class is {@link BigInteger}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#LONG}</td>
 * <td>{@link Number} - Concrete class is {@link Long}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#NOTATION}</td>
 * <td>{@link String}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#QNAME}</td>
 * <td>{@link String}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#SHORT}</td>
 * <td>{@link Number}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#STRING}</td>
 * <td>{@link String}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#TIME}</td>
 * <td>{@link XMLGregorianCalendar}</td>
 * </tr>
 * <tr>
 * <td>{@link XmlDataType#YEAR_MONTH_DURATION}</td>
 * <td>{@link Duration}</td>
 * </tr>
 * </table>
 * </div>
 * 
 * @author Jim Earley <xml.jim@gmail.com> Sep 7, 2014
 *
 * @param <T>
 *            the value datatype
 */
public class ListOfValues<T> implements Iterable<T> {
	private final List<T> _values = new ArrayList<T>();
    private XmlDataType dataType;
	
    private ListOfValues() {

    }

    private ListOfValues(final XmlDataType dataType) {
        this.dataType = dataType;
    }

	@SuppressWarnings("unchecked")
    private ListOfValues(final String valueString) {
        this.dataType = guessDataType(valueString);
		final String[] tokens = valueString.split(" ");
		for (final String s : tokens) {
			addValue((T) s.trim());
		}
	}
	
    /**
     * Returns the datatype
     * 
     * @return
     */
    public XmlDataType getDataType() {
        return this.dataType;
    }

    /**
     * Returns the values
     * 
     * @return
     */
	public List<T> getValues() {
		return this._values;
	}
	
    /**
     * Adds a value to the list
     * 
     * @param value
     */
	public void addValue(final T value) {
		this._values.add(value);
	}
	
	@Override
    public String toString() {
		final StringBuilder builder = new StringBuilder();
		
		for (final T v : this._values) {
            if (v instanceof XMLGregorianCalendar) {
                builder.append(((XMLGregorianCalendar) v).toXMLFormat()).append(" ");
            } else {
                builder.append(v).append(" ");
            }

		}
		
		return builder.toString().trim();
	}

    /**
     * Returns a new boolean list of values
     * 
     * @param value
     *            a space separated list of boolean values (<code>true</code> or <code>false</code>). Can be null, which returns an empty
     *            boolean list
     * @return a new Boolean list.
     * @throws DataTypeException
     *             thrown if a value in the list cannot be parsed to a boolean value
     */
    public static ListOfValues<Boolean> newBooleanListOfValues(final String value) {
        final ListOfValues<Boolean> listOfValues = new ListOfValues<Boolean>(XmlDataType.BOOLEAN);

        if (value != null) {
            final StringTokenizer tokenizer = new StringTokenizer(value);
            while (tokenizer.hasMoreElements()) {
                final String token = tokenizer.nextToken();

                listOfValues.addValue(Boolean.valueOf(token));
            }
        }

        return listOfValues;
    }

    /**
     * Returns a new list of numbers. The underlying value type the values will be "guessed" based on the number format (either
     * {@link Integer} or {@link Float}).
     * 
     * @param value
     *            a list of number values. Can be null, which returns an empty number list.
     * @return a new Number list
     * @throws DataTypeException
     *             thrown if a value cannot be parsed to a particular number type.
     */
    public static ListOfValues<Number> newNumberListOfValues(final String value) {
        final XmlDataType dt = guessNumberType(value);
        return newNumberListOfValues(value, dt);
    }

    /**
     * Return a new list of numbers. The underlying values will be based on the XML data type
     * 
     * @param valueSet
     *            a space separated list of number values. Can be null which will return an empty list
     * @param dataType
     *            the XML datatype
     * @return a new number list
     * @throws DataTypeException
     *             thrown if a value cannot be parsed to a particular number type
     */
    public static ListOfValues<Number> newNumberListOfValues(final String valueSet, final XmlDataType dataType) {
        final ListOfValues<Number> listOfValues = new ListOfValues<Number>(dataType);

        if (valueSet != null) {
            if (dataType.getDataClass().equals("NUMBER")) {
                final StringTokenizer tokenizer = new StringTokenizer(valueSet);
                while (tokenizer.hasMoreElements()) {
                    final String token = tokenizer.nextToken();
                    listOfValues.addValue(newNumber(dataType, token));
                }
            }
        }


        return listOfValues;
    }

    /**
     * Return a list of XML Date/Time values.
     * 
     * @param valueSet
     *            A space separated list of xs:date/xs:time/xs:dateTime values. Can be null which will return an empty list
     * @param dataType
     *            the date datatype
     * @return a list of XML Date/Time values
     * @throws DataTypeException
     *             thrown if any of values cannot be parsed to a XML date time value. Will also be thrown if the underlying
     *             {@link DatatypeFactory} could not be configured or instantiated to create the {@link XMLGregorianCalendar} type
     */
    public static ListOfValues<XMLGregorianCalendar> newXmlDateTimeListOfValues(final String valueSet, final XmlDataType dataType) {
        final ListOfValues<XMLGregorianCalendar> listOfValues = new ListOfValues<XMLGregorianCalendar>(dataType);
        
        if (null != valueSet) {
            final StringTokenizer tokenizer = new StringTokenizer(valueSet);
            while (tokenizer.hasMoreElements()) {
                final String token = tokenizer.nextToken();
                listOfValues.addValue(newXmlDateTimeValue(token));
            }
        }
        return listOfValues;
    }

    /**
     * Returns a list of string values
     * 
     * @param valueSet
     *            a space-separated list of values. Can be null, which returns an empty list
     * @param dataType
     *            the underlying datatype
     * @return a list of string values
     */
    public static ListOfValues<String> newStringListOfValues(final String valueSet, final XmlDataType dataType) {
        final ListOfValues<String> listOfValues = new ListOfValues<String>(dataType);
        if (null != valueSet) {
            final StringTokenizer tokenizer = new StringTokenizer(valueSet);
            while (tokenizer.hasMoreElements()) {
                final String token = tokenizer.nextToken();
                listOfValues.addValue(token);
            }
        }
        return listOfValues;
    }

    /**
     * Returns a list of XML Duration values (e.g., "P30D")
     * 
     * @param valueSet
     *            a space-separated list of values. Can be null, which returns an empty list
     * @param dataType
     *            the underlying datatype
     * @return a list of XML Duration values
     */
    public static ListOfValues<Duration> newXmlDurationListOfValues(final String valueSet, final XmlDataType dataType) {
        final ListOfValues<Duration> listOfValues = new ListOfValues<Duration>(dataType);

        if (null != valueSet) {
            final StringTokenizer tokenizer = new StringTokenizer(valueSet);
            while (tokenizer.hasMoreElements()) {
                final String token = tokenizer.nextToken();
                listOfValues.addValue(newDuration(token));
            }
        }

        return listOfValues;
    }

    /**
     * Returns a list of values
     * 
     * @param valueSet
     *            a space-separated list of values. Can be null, which returns an empty list
     * @param dataType
     *            the underlying datatype, which determines the Java type to assign to the list values
     * @return a list of values
     */
    public static ListOfValues<?> newListOfValues(final String valueSet, final XmlDataType dataType) {
        if (dataType != null) {
            if (dataType.getDataClass().equals("NUMBER")) {
                return newNumberListOfValues(valueSet, dataType);
            } else if (dataType.getDataClass().equals("BOOLEAN")) {
                return newBooleanListOfValues(valueSet);
            } else if (dataType.getDataClass().equals("CALENDAR")) {
                return newXmlDateTimeListOfValues(valueSet, dataType);
            } else if (dataType.getDataClass().equals("STRING")) {
                return newStringListOfValues(valueSet, dataType);
            } else if (dataType.getDataClass().equals("DURATION")) {
                return newXmlDurationListOfValues(valueSet, dataType);
            }
        } else {
            return newListOfValues(valueSet);
        }

        return null;
    }

    /**
     * Returns a list of values. It attempts to guess the datatype for the values and assign the appropriate Java type to the value list <h3>
     * Data Type Precision</h3>
     * <p>
     * Without providing any hint about the formatting or type of data in the value set, this method attempts to "guess" the datatype. This
     * guess is an <em>approximation</em> of the real datatype in some cases. For example, <code>3.14</code> could be assigned as a Decimal,
     * Double, or Float. However without any hint, it will assume that the value is a Float. Likewise non-floating point numbers such as
     * int, short, and long will also be interpreted as Float values, and correspondingly, will be stored a ListOfValues&lt;Number&gt;
     * instance
     * </p>
     * <p>
     * Similarly, there are numerous derivative types of String, such as QName or a URI. These will be cast to String values.
     * </p>
     * <p>
     * Boolean values must be assigned the values 'true' or 'false' in order to be interpreted as a Boolean list. For XML Date Time values,
     * the method interrogates the format to determine if it's either a date, time or dateTime. Likewise, it does the same for Duration
     * values, provided that the format matches the Duration pattern.
     * </p>
     * <p>
     * The bottom line is that you should only use this method when you have no explicit or implied knowledge of the values' underlying
     * datatypes.
     * </p>
     * <h3>Examples</h3>
     * <p>
     * Returns a List of Boolean values:
     * </p>
     * 
     * <pre>
     * final ListOfValues&lt;?&gt; booleanList = ListOfValues.newListOfValues(&quot;true false true true&quot;);
     * System.out.println(booleanList.getDataType().toString()); // prints http://http://www.w3.org/2001/XMLSchema#boolean
     * </pre>
     * <p>
     * Returns a List of XMLGregorianCalendar values, with a datatype of http://http://www.w3.org/2001/XMLSchema#date
     * 
     * <pre>
     * final ListOfValues&lt;?&gt; dateList = ListOfValues.newListOfValues(&quot;2014-09-09&quot;);
     * System.out.println(dateList.getDataType().toString()); // prints http://http://www.w3.org/2001/XMLSchema#date
     * </pre>
     * <p>
     * Returns a List of Number values, regardless of the "true" type. The underlying datatype for each value will be a Float
     * </p>
     * 
     * <pre>
     * final ListOfValues&lt;?&gt; integerValues = ListOfValues.newListOfValues(&quot;1 3 5 7 11 13 17 19 23 29&quot;);
     * System.out.println(integerValues.getDataType().toString()); // prints http://http://www.w3.org/2001/XMLSchema#float
     * </pre>
     * 
     * @param valueSet
     *            a space-separated list of values. If null, it will assign an empty String list
     * @return a list of values
     */
    public static ListOfValues<?> newListOfValues(final String valueSet) {
        final XmlDataType dataType = guessDataType(valueSet);
        return newListOfValues(valueSet, dataType);
    }


    /**
     * Guesses the datatype for a value. Internally, it uses regular expressions to evaluate the value type
     * 
     * @param value
     *            the string value to evaluate. If the type cannot be determined it will return {@link XmlDataType#STRING}
     * @return an XML Data Type
     */
    public static XmlDataType guessDataType(final String valueSet) {
        final List<String> values = getValueList(valueSet);
        final String value = values.isEmpty() ? "" : values.get(0);
        XmlDataType dataType = XmlDataType.STRING;

        if (DatatypeUtils.isBoolean(value)) {
            dataType = XmlDataType.BOOLEAN;
        } else if (DatatypeUtils.isNumber(value)) {
            dataType = guessNumberType(value);
        } else if (DatatypeUtils.isDuration(value)) {
            dataType = XmlDataType.DURATION;
        } else if (DatatypeUtils.isXmlGregorianCalendarValue(value)) {
            dataType = guessXmlDateType(value);
        } else {
            // already set to string
        }


        return dataType;
    }

    /**
     * Guesses the number type.
     * 
     * @param numberValue
     * @return Returns either {@link XmlDataType#FLOAT}, or null, if the value is not a number value
     */
    public static XmlDataType guessNumberType(final String numberValue) {
        XmlDataType dataType = null;
        final List<String> values = getValueList(numberValue);
        if (!values.isEmpty() && DatatypeUtils.isNumber(values.get(0))) {
            dataType = XmlDataType.FLOAT;
        } else {
            dataType = XmlDataType.FLOAT;
        }
        
        return dataType;
    }

    /**
     * Guesses the XML Date type
     * 
     * @param value
     *            the xml date-time value
     * @return returns either {@link XmlDataType#DATE}, {@link XmlDataType#DATE_TIME}, {@link XmlDataType#TIME}, or null if the value is
     *         not an XML date-time value
     */
    public static XmlDataType guessXmlDateType(final String value) {
        XmlDataType dataType = null;

        if (DatatypeUtils.isXmlGregorianCalendarValue(value)) {
            dataType = XmlDataType.DATE_TIME;

            if (DatatypeUtils.isXmlDate(value)) {
                dataType = XmlDataType.DATE;
            } else if (DatatypeUtils.isXmlTime(value)) {
                dataType = XmlDataType.TIME;
            }
        }

        return dataType;
    }


    private static Number newNumber(final XmlDataType dataType, final String value) {

        Number returnValue = null;
        switch (dataType) {
            case DOUBLE:
                returnValue = Double.valueOf(value);
                break;
            case DECIMAL:
                returnValue = new BigDecimal(value);
                break;
            case INT:
                returnValue = Integer.valueOf(value);
                break;
            case INTEGER:
                returnValue = new BigInteger(value);
                break;
            case LONG:
                returnValue = Long.valueOf(value);
                break;
            case FLOAT:
                returnValue = Float.valueOf(value);
                break;
            case SHORT:
                returnValue = Short.valueOf(value);
                break;
            default:
                return Float.valueOf(value);
        }

        return returnValue;
    }

    private static Duration newDuration(final String value) {
        Duration d = null;
        try {
            d = DatatypeUtils.newDuration(value);
        } catch (final DatatypeConfigurationException e) {
            throw new DataTypeException(e);
        }
        return d;
    }

    private static XMLGregorianCalendar newXmlDateTimeValue(final String value) {
        XMLGregorianCalendar cal = null;

        try {
            cal = DatatypeUtils.newXmlGregorianCalendar(value);
        } catch (final DatatypeConfigurationException e) {
            throw new DataTypeException(e);
        }

        return cal;
    }

    private static List<String> getValueList(final String valueSet) {
        final List<String> valueList = new ArrayList<String>();
        if (valueSet != null) {
            final StringTokenizer tokenizer = new StringTokenizer(valueSet);
            while (tokenizer.hasMoreElements()) {
                valueList.add(tokenizer.nextToken());
            }
        }
        return valueList;
    }


    
    public T item(final int index) {
        return this._values.get(index);
    }

    
	public Iterator<T> iterator() {
		return this._values.iterator();
	}

}
