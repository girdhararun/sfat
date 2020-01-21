
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
    "Address Information",
    "Lead Information",
    "Additional Information",
    "Description Information"
})
public class LeadData {

    @JsonProperty("Address Information")
    private AddressInformation addressInformation;
    @JsonProperty("Lead Information")
    private LeadInformation leadInformation;
    @JsonProperty("Additional Information")
    private AdditionalInformation additionalInformation;
    @JsonProperty("Description Information")
    private DescriptionInformation descriptionInformation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Address Information")
    public AddressInformation getAddressInformation() {
        return addressInformation;
    }

    @JsonProperty("Address Information")
    public void setAddressInformation(AddressInformation addressInformation) {
        this.addressInformation = addressInformation;
    }

    public LeadData withAddressInformation(AddressInformation addressInformation) {
        this.addressInformation = addressInformation;
        return this;
    }

    @JsonProperty("Lead Information")
    public LeadInformation getLeadInformation() {
        return leadInformation;
    }

    @JsonProperty("Lead Information")
    public void setLeadInformation(LeadInformation leadInformation) {
        this.leadInformation = leadInformation;
    }

    public LeadData withLeadInformation(LeadInformation leadInformation) {
        this.leadInformation = leadInformation;
        return this;
    }

    @JsonProperty("Additional Information")
    public AdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    @JsonProperty("Additional Information")
    public void setAdditionalInformation(AdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public LeadData withAdditionalInformation(AdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    @JsonProperty("Description Information")
    public DescriptionInformation getDescriptionInformation() {
        return descriptionInformation;
    }

    @JsonProperty("Description Information")
    public void setDescriptionInformation(DescriptionInformation descriptionInformation) {
        this.descriptionInformation = descriptionInformation;
    }

    public LeadData withDescriptionInformation(DescriptionInformation descriptionInformation) {
        this.descriptionInformation = descriptionInformation;
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

    public LeadData withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LeadData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("addressInformation");
        sb.append('=');
        sb.append(((this.addressInformation == null)?"<null>":this.addressInformation));
        sb.append(',');
        sb.append("leadInformation");
        sb.append('=');
        sb.append(((this.leadInformation == null)?"<null>":this.leadInformation));
        sb.append(',');
        sb.append("additionalInformation");
        sb.append('=');
        sb.append(((this.additionalInformation == null)?"<null>":this.additionalInformation));
        sb.append(',');
        sb.append("descriptionInformation");
        sb.append('=');
        sb.append(((this.descriptionInformation == null)?"<null>":this.descriptionInformation));
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
        result = ((result* 31)+((this.additionalInformation == null)? 0 :this.additionalInformation.hashCode()));
        result = ((result* 31)+((this.descriptionInformation == null)? 0 :this.descriptionInformation.hashCode()));
        result = ((result* 31)+((this.addressInformation == null)? 0 :this.addressInformation.hashCode()));
        result = ((result* 31)+((this.leadInformation == null)? 0 :this.leadInformation.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LeadData) == false) {
            return false;
        }
        LeadData rhs = ((LeadData) other);
        return ((((((this.additionalInformation == rhs.additionalInformation)||((this.additionalInformation!= null)&&this.additionalInformation.equals(rhs.additionalInformation)))&&((this.descriptionInformation == rhs.descriptionInformation)||((this.descriptionInformation!= null)&&this.descriptionInformation.equals(rhs.descriptionInformation))))&&((this.addressInformation == rhs.addressInformation)||((this.addressInformation!= null)&&this.addressInformation.equals(rhs.addressInformation))))&&((this.leadInformation == rhs.leadInformation)||((this.leadInformation!= null)&&this.leadInformation.equals(rhs.leadInformation))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
