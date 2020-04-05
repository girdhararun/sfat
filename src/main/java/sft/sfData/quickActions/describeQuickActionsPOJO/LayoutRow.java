
package sft.sfData.quickActions.describeQuickActionsPOJO;

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
public class LayoutRow {

    @JsonProperty("layoutItems")
    private List<LayoutItem> layoutItems = null;
    @JsonProperty("numItems")
    private Integer numItems;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("layoutItems")
    public List<LayoutItem> getLayoutItems() {
        return layoutItems;
    }

    @JsonProperty("layoutItems")
    public void setLayoutItems(List<LayoutItem> layoutItems) {
        this.layoutItems = layoutItems;
    }

    @JsonProperty("numItems")
    public Integer getNumItems() {
        return numItems;
    }

    @JsonProperty("numItems")
    public void setNumItems(Integer numItems) {
        this.numItems = numItems;
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
