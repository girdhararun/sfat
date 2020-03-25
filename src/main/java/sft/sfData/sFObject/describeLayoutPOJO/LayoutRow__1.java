
package sft.sfData.sFObject.describeLayoutPOJO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "layoutItems",
    "numItems"
})
public class LayoutRow__1 {

    @JsonProperty("layoutItems")
    private List<LayoutItem__1> layoutItems = new ArrayList<LayoutItem__1>();
    @JsonProperty("numItems")
    private Integer numItems;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("layoutItems")
    public List<LayoutItem__1> getLayoutItems() {
        return layoutItems;
    }

    @JsonProperty("layoutItems")
    public void setLayoutItems(List<LayoutItem__1> layoutItems) {
        this.layoutItems = layoutItems;
    }

    public LayoutRow__1 withLayoutItems(List<LayoutItem__1> layoutItems) {
        this.layoutItems = layoutItems;
        return this;
    }

    @JsonProperty("numItems")
    public Integer getNumItems() {
        return numItems;
    }

    @JsonProperty("numItems")
    public void setNumItems(Integer numItems) {
        this.numItems = numItems;
    }

    public LayoutRow__1 withNumItems(Integer numItems) {
        this.numItems = numItems;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public LayoutRow__1 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LayoutRow__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("layoutItems");
        sb.append('=');
        sb.append(((this.layoutItems == null)?"<null>":this.layoutItems));
        sb.append(',');
        sb.append("numItems");
        sb.append('=');
        sb.append(((this.numItems == null)?"<null>":this.numItems));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.layoutItems == null)? 0 :this.layoutItems.hashCode()));
        result = ((result* 31)+((this.numItems == null)? 0 :this.numItems.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LayoutRow__1) == false) {
            return false;
        }
        LayoutRow__1 rhs = ((LayoutRow__1) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.layoutItems == rhs.layoutItems)||((this.layoutItems!= null)&&this.layoutItems.equals(rhs.layoutItems))))&&((this.numItems == rhs.numItems)||((this.numItems!= null)&&this.numItems.equals(rhs.numItems))));
    }

}
