
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
    "SIC Code",
    "Primary",
    "Number of Locations",
    "Current Generator(s)",
    "Product Interest"
})
public class AdditionalInformation {

    @JsonProperty("SIC Code")
    private SICCode sICCode;
    @JsonProperty("Primary")
    private Primary primary;
    @JsonProperty("Number of Locations")
    private NumberOfLocations numberOfLocations;
    @JsonProperty("Current Generator(s)")
    private CurrentGeneratorS currentGeneratorS;
    @JsonProperty("Product Interest")
    private ProductInterest productInterest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("SIC Code")
    public SICCode getSICCode() {
        return sICCode;
    }

    @JsonProperty("SIC Code")
    public void setSICCode(SICCode sICCode) {
        this.sICCode = sICCode;
    }

    public AdditionalInformation withSICCode(SICCode sICCode) {
        this.sICCode = sICCode;
        return this;
    }

    @JsonProperty("Primary")
    public Primary getPrimary() {
        return primary;
    }

    @JsonProperty("Primary")
    public void setPrimary(Primary primary) {
        this.primary = primary;
    }

    public AdditionalInformation withPrimary(Primary primary) {
        this.primary = primary;
        return this;
    }

    @JsonProperty("Number of Locations")
    public NumberOfLocations getNumberOfLocations() {
        return numberOfLocations;
    }

    @JsonProperty("Number of Locations")
    public void setNumberOfLocations(NumberOfLocations numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    public AdditionalInformation withNumberOfLocations(NumberOfLocations numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
        return this;
    }

    @JsonProperty("Current Generator(s)")
    public CurrentGeneratorS getCurrentGeneratorS() {
        return currentGeneratorS;
    }

    @JsonProperty("Current Generator(s)")
    public void setCurrentGeneratorS(CurrentGeneratorS currentGeneratorS) {
        this.currentGeneratorS = currentGeneratorS;
    }

    public AdditionalInformation withCurrentGeneratorS(CurrentGeneratorS currentGeneratorS) {
        this.currentGeneratorS = currentGeneratorS;
        return this;
    }

    @JsonProperty("Product Interest")
    public ProductInterest getProductInterest() {
        return productInterest;
    }

    @JsonProperty("Product Interest")
    public void setProductInterest(ProductInterest productInterest) {
        this.productInterest = productInterest;
    }

    public AdditionalInformation withProductInterest(ProductInterest productInterest) {
        this.productInterest = productInterest;
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

    public AdditionalInformation withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AdditionalInformation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sICCode");
        sb.append('=');
        sb.append(((this.sICCode == null)?"<null>":this.sICCode));
        sb.append(',');
        sb.append("primary");
        sb.append('=');
        sb.append(((this.primary == null)?"<null>":this.primary));
        sb.append(',');
        sb.append("numberOfLocations");
        sb.append('=');
        sb.append(((this.numberOfLocations == null)?"<null>":this.numberOfLocations));
        sb.append(',');
        sb.append("currentGeneratorS");
        sb.append('=');
        sb.append(((this.currentGeneratorS == null)?"<null>":this.currentGeneratorS));
        sb.append(',');
        sb.append("productInterest");
        sb.append('=');
        sb.append(((this.productInterest == null)?"<null>":this.productInterest));
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
        result = ((result* 31)+((this.sICCode == null)? 0 :this.sICCode.hashCode()));
        result = ((result* 31)+((this.productInterest == null)? 0 :this.productInterest.hashCode()));
        result = ((result* 31)+((this.numberOfLocations == null)? 0 :this.numberOfLocations.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.primary == null)? 0 :this.primary.hashCode()));
        result = ((result* 31)+((this.currentGeneratorS == null)? 0 :this.currentGeneratorS.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdditionalInformation) == false) {
            return false;
        }
        AdditionalInformation rhs = ((AdditionalInformation) other);
        return (((((((this.sICCode == rhs.sICCode)||((this.sICCode!= null)&&this.sICCode.equals(rhs.sICCode)))&&((this.productInterest == rhs.productInterest)||((this.productInterest!= null)&&this.productInterest.equals(rhs.productInterest))))&&((this.numberOfLocations == rhs.numberOfLocations)||((this.numberOfLocations!= null)&&this.numberOfLocations.equals(rhs.numberOfLocations))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.primary == rhs.primary)||((this.primary!= null)&&this.primary.equals(rhs.primary))))&&((this.currentGeneratorS == rhs.currentGeneratorS)||((this.currentGeneratorS!= null)&&this.currentGeneratorS.equals(rhs.currentGeneratorS))));
    }

}
