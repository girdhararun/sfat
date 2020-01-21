
package pojos.leaddata;

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
    "isRequired",
    "editableForUpdate",
    "editableForNew",
    "label",
    "value"
})
public class Fax {

    @JsonProperty("isRequired")
    private Boolean isRequired;
    @JsonProperty("editableForUpdate")
    private Boolean editableForUpdate;
    @JsonProperty("editableForNew")
    private Boolean editableForNew;
    @JsonProperty("label")
    private String label;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isRequired")
    public Boolean getIsRequired() {
        return isRequired;
    }

    @JsonProperty("isRequired")
    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Fax withIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
        return this;
    }

    @JsonProperty("editableForUpdate")
    public Boolean getEditableForUpdate() {
        return editableForUpdate;
    }

    @JsonProperty("editableForUpdate")
    public void setEditableForUpdate(Boolean editableForUpdate) {
        this.editableForUpdate = editableForUpdate;
    }

    public Fax withEditableForUpdate(Boolean editableForUpdate) {
        this.editableForUpdate = editableForUpdate;
        return this;
    }

    @JsonProperty("editableForNew")
    public Boolean getEditableForNew() {
        return editableForNew;
    }

    @JsonProperty("editableForNew")
    public void setEditableForNew(Boolean editableForNew) {
        this.editableForNew = editableForNew;
    }

    public Fax withEditableForNew(Boolean editableForNew) {
        this.editableForNew = editableForNew;
        return this;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    public Fax withLabel(String label) {
        this.label = label;
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

    public Fax withValue(String value) {
        this.value = value;
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

    public Fax withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Fax.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("isRequired");
        sb.append('=');
        sb.append(((this.isRequired == null)?"<null>":this.isRequired));
        sb.append(',');
        sb.append("editableForUpdate");
        sb.append('=');
        sb.append(((this.editableForUpdate == null)?"<null>":this.editableForUpdate));
        sb.append(',');
        sb.append("editableForNew");
        sb.append('=');
        sb.append(((this.editableForNew == null)?"<null>":this.editableForNew));
        sb.append(',');
        sb.append("label");
        sb.append('=');
        sb.append(((this.label == null)?"<null>":this.label));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
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
        result = ((result* 31)+((this.isRequired == null)? 0 :this.isRequired.hashCode()));
        result = ((result* 31)+((this.editableForUpdate == null)? 0 :this.editableForUpdate.hashCode()));
        result = ((result* 31)+((this.editableForNew == null)? 0 :this.editableForNew.hashCode()));
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.value == null)? 0 :this.value.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Fax) == false) {
            return false;
        }
        Fax rhs = ((Fax) other);
        return (((((((this.isRequired == rhs.isRequired)||((this.isRequired!= null)&&this.isRequired.equals(rhs.isRequired)))&&((this.editableForUpdate == rhs.editableForUpdate)||((this.editableForUpdate!= null)&&this.editableForUpdate.equals(rhs.editableForUpdate))))&&((this.editableForNew == rhs.editableForNew)||((this.editableForNew!= null)&&this.editableForNew.equals(rhs.editableForNew))))&&((this.label == rhs.label)||((this.label!= null)&&this.label.equals(rhs.label))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.value == rhs.value)||((this.value!= null)&&this.value.equals(rhs.value))));
    }

}
