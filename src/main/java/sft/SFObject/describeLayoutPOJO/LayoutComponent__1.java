
package sft.SFObject.describeLayoutPOJO;

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
    "details",
    "displayLines",
    "tabOrder",
    "type",
    "value",
    "components",
    "fieldType"
})
public class LayoutComponent__1 {

    @JsonProperty("details")
    private Details__2 details;
    @JsonProperty("displayLines")
    private Integer displayLines;
    @JsonProperty("tabOrder")
    private Integer tabOrder;
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private String value;
    @JsonProperty("components")
    private List<Component__1> components = new ArrayList<Component__1>();
    @JsonProperty("fieldType")
    private String fieldType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("details")
    public Details__2 getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details__2 details) {
        this.details = details;
    }

    public LayoutComponent__1 withDetails(Details__2 details) {
        this.details = details;
        return this;
    }

    @JsonProperty("displayLines")
    public Integer getDisplayLines() {
        return displayLines;
    }

    @JsonProperty("displayLines")
    public void setDisplayLines(Integer displayLines) {
        this.displayLines = displayLines;
    }

    public LayoutComponent__1 withDisplayLines(Integer displayLines) {
        this.displayLines = displayLines;
        return this;
    }

    @JsonProperty("tabOrder")
    public Integer getTabOrder() {
        return tabOrder;
    }

    @JsonProperty("tabOrder")
    public void setTabOrder(Integer tabOrder) {
        this.tabOrder = tabOrder;
    }

    public LayoutComponent__1 withTabOrder(Integer tabOrder) {
        this.tabOrder = tabOrder;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public LayoutComponent__1 withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public LayoutComponent__1 withValue(String value) {
        this.value = value;
        return this;
    }

    @JsonProperty("components")
    public List<Component__1> getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(List<Component__1> components) {
        this.components = components;
    }

    public LayoutComponent__1 withComponents(List<Component__1> components) {
        this.components = components;
        return this;
    }

    @JsonProperty("fieldType")
    public String getFieldType() {
        return fieldType;
    }

    @JsonProperty("fieldType")
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public LayoutComponent__1 withFieldType(String fieldType) {
        this.fieldType = fieldType;
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

    public LayoutComponent__1 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LayoutComponent__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("details");
        sb.append('=');
        sb.append(((this.details == null)?"<null>":this.details));
        sb.append(',');
        sb.append("displayLines");
        sb.append('=');
        sb.append(((this.displayLines == null)?"<null>":this.displayLines));
        sb.append(',');
        sb.append("tabOrder");
        sb.append('=');
        sb.append(((this.tabOrder == null)?"<null>":this.tabOrder));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
        sb.append(',');
        sb.append("components");
        sb.append('=');
        sb.append(((this.components == null)?"<null>":this.components));
        sb.append(',');
        sb.append("fieldType");
        sb.append('=');
        sb.append(((this.fieldType == null)?"<null>":this.fieldType));
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
        result = ((result* 31)+((this.components == null)? 0 :this.components.hashCode()));
        result = ((result* 31)+((this.tabOrder == null)? 0 :this.tabOrder.hashCode()));
        result = ((result* 31)+((this.details == null)? 0 :this.details.hashCode()));
        result = ((result* 31)+((this.displayLines == null)? 0 :this.displayLines.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.value == null)? 0 :this.value.hashCode()));
        result = ((result* 31)+((this.fieldType == null)? 0 :this.fieldType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LayoutComponent__1) == false) {
            return false;
        }
        LayoutComponent__1 rhs = ((LayoutComponent__1) other);
        return (((((((((this.components == rhs.components)||((this.components!= null)&&this.components.equals(rhs.components)))&&((this.tabOrder == rhs.tabOrder)||((this.tabOrder!= null)&&this.tabOrder.equals(rhs.tabOrder))))&&((this.details == rhs.details)||((this.details!= null)&&this.details.equals(rhs.details))))&&((this.displayLines == rhs.displayLines)||((this.displayLines!= null)&&this.displayLines.equals(rhs.displayLines))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.value == rhs.value)||((this.value!= null)&&this.value.equals(rhs.value))))&&((this.fieldType == rhs.fieldType)||((this.fieldType!= null)&&this.fieldType.equals(rhs.fieldType))));
    }

}
