/**
 * 
 */
package org.w3c.odrl.W3COdrl2.datatypes;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 7, 2014
 *
 */
public class DatatypeUtils {
    
    private static final String SIGN_REGEX = "[\\-|\\+]";

    private static final String NUMBER_REGEX = "^" + SIGN_REGEX + "?([1-9]\\d*(\\.\\d+)?|[0]?\\.\\d+)([\\-|\\+]?[Ee]\\d+)?$";
    
    private static final String INTEGER_REGEX = "^" + SIGN_REGEX + "?\\d+$";
    
    private static final String DURATION_REGEX = "^" + SIGN_REGEX + "?P(\\d+Y)?(\\d+M)?(\\d+D)?(T((\\d+H)?(\\d+M)?(\\d*(\\.\\d+)?S)?))?$";
    
    private static final String DOUBLE_REGEX = "^" + SIGN_REGEX + "?([1-9]\\d*(\\.\\d+)?|[0]?\\.\\d+)$";
    
    private static final String FLOAT_REGEX = NUMBER_REGEX;
    
    private static final String DECIMAL_REGEX = DOUBLE_REGEX;
    
    
    private static final String BOOLEAN_REGEX = "^([T][R][U][E])|([t][r][u][e])|([F][A][L][S][E])|([f][a][l][s][e])$";
    
    private static final String DASH = "\\-";

    
    private static final String YEAR_REGEX = "[1-9]\\d{3}";
    
    private static final String MONTH_REGEX = "1[0-2]|0[1-9]";
    
    private static final String DAY_REGEX = "3[01]|0[1-9]|[12][0-9]";
    
    private static final String HOUR_REGEX = "2[0-3]|[01][0-9]";
    
    private static final String MINUTE_REGEX = "[0-5][0-9]";
    
    private static final String CLOCK_REGEX = "(" + HOUR_REGEX + ":" + MINUTE_REGEX + ")";
    
    private static final String MS_REGEX = "(\\.[0-9]+)?";
    
    private static final String SECOND_REGEX = MINUTE_REGEX + MS_REGEX ;
    
    private static final String TZ_REGEX = "(Z|(" + SIGN_REGEX + "(" + CLOCK_REGEX + ")))?";
    
    private static final String SIMPLE_DATE_REGEX = "((" + YEAR_REGEX + ")" + DASH + "(" + MONTH_REGEX + ")" + DASH + "(" + DAY_REGEX + "))";
    
    private static final String XS_DATE_REGEX = SIMPLE_DATE_REGEX  + TZ_REGEX ;
    
    private static final String SIMPLE_TIME_REGEX = "((" + HOUR_REGEX + "):(" + MINUTE_REGEX + "):(" + SECOND_REGEX + "))";

    private static final String XS_TIME_REGEX = "(" + SIMPLE_TIME_REGEX + TZ_REGEX + ")";
    
    private static final String XS_DATE_TIME_REGEX = "(" + SIMPLE_DATE_REGEX + "T" + XS_TIME_REGEX + ")";
    
    private static final String XS_G_YEAR_REGEX = "(" + YEAR_REGEX + ")";
    
    private static final String XS_G_YEAR_MONTH_REGEX = "((" + YEAR_REGEX + ")" + DASH + "(" + MONTH_REGEX + "))";
    
    private static final String XML_GREGORIAN_CALENDAR_REGEX = XS_DATE_TIME_REGEX + "|" + XS_DATE_REGEX + "|" + XS_TIME_REGEX + "|"
                    + XS_G_YEAR_REGEX + "|" + XS_G_YEAR_MONTH_REGEX;
    /**
     * 
     */
    private DatatypeUtils() {

    }

    /**
     * Evaluates a string to determine if the value is numeric. It will not determine underlying number type (e.g., integer, double, etc.)
     * <p>
     * Other numeric tests in this class can be used to provide additional determination of number type as an approximation
     * </p>
     * 
     * @param numberTest
     *            the string containing the value to test
     * @return returns true if the value can be represented as a number, false otherwise
     */
    public static boolean isNumber(final String numberTest) {
        final String regex = NUMBER_REGEX;
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(numberTest);
        return m.matches();
    }
    
    public static boolean isInteger(final String integerTest) {
        if (!isNumber(integerTest)) {
            return false;
        }
        
        final String regex = INTEGER_REGEX;
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(integerTest);
        return m.matches();
    }

    public static boolean isDuration(final String durationTest) {
        final String regex = DURATION_REGEX;
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(durationTest);

        return m.matches();
    }
    
    public static boolean isDouble(final String doubleTest) {
        if (!isNumber(doubleTest)) {
            return false;
        }
        final String regex = DOUBLE_REGEX;
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(doubleTest);

        return m.matches();
    }
    
    public static boolean isFloat(final String floatTest) {
        if (!isNumber(floatTest)) {
            return false;
        }
        final String regex = FLOAT_REGEX;
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(floatTest);

        return m.matches();
    }

    public static boolean isDecimal(final String decimalTest) {
        if (!isNumber(decimalTest)) {
            return false;
        }
        final String regex = DECIMAL_REGEX;
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(decimalTest);

        return m.matches();
    }

    public static boolean isBoolean(final String booleanTest) {
        final String regex = BOOLEAN_REGEX;
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(booleanTest);

        return m.matches();
    }


    /**
     * Matches against xs:date, xs:time, xs:dateTime, xs:gYear, xs:gYearMonth
     * 
     * @param xmlDateTimeTest
     * @return
     */
    public static boolean isXmlGregorianCalendarValue(final String xmlDateTimeTest) {
        final String regex = "^" + XML_GREGORIAN_CALENDAR_REGEX + "$";
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(xmlDateTimeTest);

        return m.matches();
    }

    public static boolean isXmlDate(final String dateValue) {
        final String regex = "^" + XS_DATE_REGEX + "$";
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(dateValue);

        return m.matches();
    }

    public static boolean isXmlTime(final String dateValue) {
        final String regex = "^" + XS_TIME_REGEX + "$";
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(dateValue);

        return m.matches();
    }

    public static boolean isXmlDateTime(final String dateValue) {
        final String regex = "^" + XS_DATE_TIME_REGEX + "$";
        final Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher m = p.matcher(dateValue);

        return m.matches();
    }

    
    public static XMLGregorianCalendar newXmlGregorianCalendar(final String xmlDateTime) throws DatatypeConfigurationException {
        XMLGregorianCalendar calendar = null;
        final DatatypeFactory factory = DatatypeFactory.newInstance();

        calendar = factory.newXMLGregorianCalendar(xmlDateTime);

        return calendar;
    }
    
    public static Duration newDuration(final String duration) throws DatatypeConfigurationException {
        final DatatypeFactory dtFactory = DatatypeFactory.newInstance();
        return dtFactory.newDuration(duration);
    }


    public static XMLGregorianCalendar newXmlGregorianCalendar(final Date date) throws DatatypeConfigurationException {
        final GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);

        final DatatypeFactory factory = DatatypeFactory.newInstance();
        return factory.newXMLGregorianCalendar(gc);
    }

    public static XMLGregorianCalendar newXmlGregorianCalendar(final Calendar cal) throws DatatypeConfigurationException {
        return newXmlGregorianCalendar(cal.getTime());
    }

}
