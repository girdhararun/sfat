
package sft.sfData.quickActions.describeQuickActionsPOJO;

import java.util.HashMap;
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
    "value"
})
public class LayoutComponent {

    @JsonProperty("details")
    private Details details;
    @JsonProperty("displayLines")
    private Integer displayLines;
    @JsonProperty("tabOrder")
    private Integer tabOrder;
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("details")
    public Details getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details details) {
        this.details = details;
    }

    @JsonProperty("displayLines")
    public Integer getDisplayLines() {
        return displayLines;
    }

    @JsonProperty("displayLines")
    public void setDisplayLines(Integer displayLines) {
        this.displayLines = displayLines;
    }

    @JsonProperty("tabOrder")
    public Integer getTabOrder() {
        return tabOrder;
    }

    @JsonProperty("tabOrder")
    public void setTabOrder(Integer tabOrder) {
        this.tabOrder = tabOrder;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
