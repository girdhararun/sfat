
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
    "editableForNew",
    "editableForUpdate",
    "label",
    "layoutComponents",
    "placeholder",
    "required"
})
public class LayoutItem {

    @JsonProperty("editableForNew")
    private Boolean editableForNew;
    @JsonProperty("editableForUpdate")
    private Boolean editableForUpdate;
    @JsonProperty("label")
    private String label;
    @JsonProperty("layoutComponents")
    private List<LayoutComponent> layoutComponents = null;
    @JsonProperty("placeholder")
    private Boolean placeholder;
    @JsonProperty("required")
    private Boolean required;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("editableForNew")
    public Boolean getEditableForNew() {
        return editableForNew;
    }

    @JsonProperty("editableForNew")
    public void setEditableForNew(Boolean editableForNew) {
        this.editableForNew = editableForNew;
    }

    @JsonProperty("editableForUpdate")
    public Boolean getEditableForUpdate() {
        return editableForUpdate;
    }

    @JsonProperty("editableForUpdate")
    public void setEditableForUpdate(Boolean editableForUpdate) {
        this.editableForUpdate = editableForUpdate;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("layoutComponents")
    public List<LayoutComponent> getLayoutComponents() {
        return layoutComponents;
    }

    @JsonProperty("layoutComponents")
    public void setLayoutComponents(List<LayoutComponent> layoutComponents) {
        this.layoutComponents = layoutComponents;
    }

    @JsonProperty("placeholder")
    public Boolean getPlaceholder() {
        return placeholder;
    }

    @JsonProperty("placeholder")
    public void setPlaceholder(Boolean placeholder) {
        this.placeholder = placeholder;
    }

    @JsonProperty("required")
    public Boolean getRequired() {
        return required;
    }

    @JsonProperty("required")
    public void setRequired(Boolean required) {
        this.required = required;
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
