/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.json;


/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 * @param <T>
 *
 */
public class JsonProperty {
    private final String key;
    private final Object value;
    private String parentKey;
    

    /**
     * @param <T>
     * 
     */
    public <T> JsonProperty(final String key, final T value) {
        this.key = key;
        this.value = value;
    }

    public <T> JsonProperty(final String key, final T value, final String parentKey) {
        this(key, value);
        this.parentKey = parentKey;
    }

    public String getKey() {
        return this.key;
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue() {
        return (T) this.value;
    }
    
    public void setParentKey(final String parentKey) {
        this.parentKey = parentKey;
    }
    
    public String getParentKey() {
        return this.parentKey;
    }


}
