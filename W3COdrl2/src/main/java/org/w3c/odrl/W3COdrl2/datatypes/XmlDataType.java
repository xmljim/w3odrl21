/**
 * 
 */
package org.w3c.odrl.W3COdrl2.datatypes;

import org.w3c.odrl.W3COdrl2.vocabulary.Vocab;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 8, 2014
 * 
 *         Enumeration of XML primitive and built-in datatype URI References. Does not include list types or signed values. For more
 *         information see <a href="http://www.w3.org/TR/xmlschema-2">http://www.w3.org/TR/xmlschema-2</a>
 *         <p>
 *         <strong>Note: </strong> Not all types are enabled specifically. For more information about XML datatype to Java bindings, see <a
 *         href
 *         ="http://docs.oracle.com/cd/E17802_01/webservices/webservices/docs/2.0/tutorial/doc/JAXBWorks4.html">http://docs.oracle.com/cd
 *         /E17802_01/webservices/webservices/docs/2.0/tutorial/doc/JAXBWorks4.html</a>
 *         </p>
 *
 */
public enum XmlDataType  {
    /** A Base-64 Binary value (http://http://www.w3.org/2001/XMLSchema#) **/
    BASE_64_BINARY(Vocab.XML_SCHEMA_NS + "#base64Binary", "NUMBER"),

    /** A boolean datatype (http://http://www.w3.org/2001/XMLSchema#boolean) **/
    BOOLEAN(Vocab.XML_SCHEMA_NS + "#boolean", "BOOLEAN"),

    /** A date (http://www.w3.org/2001/XMLSchema#date) **/
    DATE(Vocab.XML_SCHEMA_NS + "#date", "CALENDAR"),

    /** A dateTime (http://www.w3.org/2001/XMLSchema#dateTime) **/
    DATE_TIME(Vocab.XML_SCHEMA_NS + "#dateTime", "CALENDAR"),

    /** A decimal (http://www.w3.org/2001/XMLSchema#decimal) **/
    DECIMAL(Vocab.XML_SCHEMA_NS + "#decimal", "NUMBER"),

    /** An integer value (http://http://www.w3.org/2001/XMLSchema#integer) **/
    INTEGER(Vocab.XML_SCHEMA_NS + "#integer", "NUMBER"),

    LONG(Vocab.XML_SCHEMA_NS + "#long", "NUMBER"),

    INT(Vocab.XML_SCHEMA_NS + "#int", "NUMBER"),

    SHORT(Vocab.XML_SCHEMA_NS + "#short", "NUMBER"),

    BYTE(Vocab.XML_SCHEMA_NS + "#byte", "NUMBER"),

    /** A double (http://www.w3.org/2001/XMLSchema#double) **/
    DOUBLE(Vocab.XML_SCHEMA_NS + "#double", "NUMBER"),

    /** A duration (http://www.w3.org/2001/XMLSchema#duration) **/
    DURATION(Vocab.XML_SCHEMA_NS + "#duration", "DURATION"),

    /** a dayTimeDuration (http://www.w3.org/2001/XMLSchema#dayTimeDuration **/
    DAY_TIME_DURATION(Vocab.XML_SCHEMA_NS + "#dayTimeDuration", "CALENDAR"),

    /** a yearMonthDuration (http://www.w3.org/2001/XMLSchema#yearMonthDuration) **/
    YEAR_MONTH_DURATION(Vocab.XML_SCHEMA_NS + "#yearMonthDuration", "CALENDAR"),

    /** a float (http://www.w3.org/2001/XMLSchema#float) **/
    FLOAT(Vocab.XML_SCHEMA_NS + "#float", "NUMBER"),

    /** a Gregorian Day value (http://www.w3.org/2001/XMLSchema#gDay) **/
    G_DAY(Vocab.XML_SCHEMA_NS + "#gDay", "CALENDAR"),

    /** a Gregorian Month value (http://www.w3.org/2001/XMLSchema#gMonth) **/
    G_MONTH(Vocab.XML_SCHEMA_NS + "#gMonth", "CALENDAR"),

    /** a Gregorian Month-Day value (http://www.w3.org/2001/XMLSchema#gMonthDay **/
    G_MONTH_DAY(Vocab.XML_SCHEMA_NS + "#gMonthDay", "CALENDAR"),

    /** a Gregorian Year value (http://www.w3.org/2001/XMLSchema#year) **/
    G_YEAR(Vocab.XML_SCHEMA_NS + "#year", "CALENDAR"),

    /** A Gregorian Year-Month value (http://www.w3.org/2001/XMLSchema#gYearMonth) **/
    G_YEAR_MONTH(Vocab.XML_SCHEMA_NS + "#gYearMonth", "CALENDAR"),

    /** A HEX/Binary value (http://www.w3.org/2001/XMLSchema#hexBinary) **/
    HEX_BINARY(Vocab.XML_SCHEMA_NS + "#hexBinary", "NUMBER"),

    /** A NOTATION value (http://http://www.w3.org/2001/XMLSchema#NOTATION) **/
    NOTATION(Vocab.XML_SCHEMA_NS + "#NOTATION", "STRING"),

    /** A QName value (http://http://www.w3.org/2001/XMLSchema#QName) **/
    QNAME(Vocab.XML_SCHEMA_NS + "#QName", "STRING"),

    /** A String value (http://http://www.w3.org/2001/XMLSchema#string) **/
    STRING(Vocab.XML_SCHEMA_NS + "#string", "STRING"),

    /** A Time value (http://http://www.w3.org/2001/XMLSchema#time) **/
    TIME(Vocab.XML_SCHEMA_NS + "#time", "CALENDAR");

    XmlDataType(final String val, final String dataClass) {
        this.value = new URIQNameQCode(val);
        this.dataClass = dataClass;
    }

    private String dataClass;
    private URIQNameQCode value;

    public String getDataClass() {
        return this.dataClass;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public static XmlDataType find(final String xmlSchemaUri) {
        XmlDataType dt = null;
        for (final XmlDataType t : XmlDataType.values()) {
            if (t.value.toString().equals(xmlSchemaUri)) {
                dt = t;
                break;
            }
        }

        return dt;
    }

    public static boolean hasValue(final String value) {
        boolean result = false;
        for (final XmlDataType dt : XmlDataType.values()) {
            dt.toString().equals(value);
            result = true;
            break;
        }

        return result;
    }
}
