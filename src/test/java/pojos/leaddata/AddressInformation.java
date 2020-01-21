
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
    "Zip/Postal Code",
    "Street",
    "Country",
    "City",
    "State/Province"
})
public class AddressInformation {

    @JsonProperty("Zip/Postal Code")
    private ZipPostalCode zipPostalCode;
    @JsonProperty("Street")
    private Street street;
    @JsonProperty("Country")
    private Country country;
    @JsonProperty("City")
    private City city;
    @JsonProperty("State/Province")
    private StateProvince stateProvince;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Zip/Postal Code")
    public ZipPostalCode getZipPostalCode() {
        return zipPostalCode;
    }

    @JsonProperty("Zip/Postal Code")
    public void setZipPostalCode(ZipPostalCode zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }

    public AddressInformation withZipPostalCode(ZipPostalCode zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
        return this;
    }

    @JsonProperty("Street")
    public Street getStreet() {
        return street;
    }

    @JsonProperty("Street")
    public void setStreet(Street street) {
        this.street = street;
    }

    public AddressInformation withStreet(Street street) {
        this.street = street;
        return this;
    }

    @JsonProperty("Country")
    public Country getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(Country country) {
        this.country = country;
    }

    public AddressInformation withCountry(Country country) {
        this.country = country;
        return this;
    }

    @JsonProperty("City")
    public City getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(City city) {
        this.city = city;
    }

    public AddressInformation withCity(City city) {
        this.city = city;
        return this;
    }

    @JsonProperty("State/Province")
    public StateProvince getStateProvince() {
        return stateProvince;
    }

    @JsonProperty("State/Province")
    public void setStateProvince(StateProvince stateProvince) {
        this.stateProvince = stateProvince;
    }

    public AddressInformation withStateProvince(StateProvince stateProvince) {
        this.stateProvince = stateProvince;
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

    public AddressInformation withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddressInformation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("zipPostalCode");
        sb.append('=');
        sb.append(((this.zipPostalCode == null)?"<null>":this.zipPostalCode));
        sb.append(',');
        sb.append("street");
        sb.append('=');
        sb.append(((this.street == null)?"<null>":this.street));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null)?"<null>":this.city));
        sb.append(',');
        sb.append("stateProvince");
        sb.append('=');
        sb.append(((this.stateProvince == null)?"<null>":this.stateProvince));
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
        result = ((result* 31)+((this.country == null)? 0 :this.country.hashCode()));
        result = ((result* 31)+((this.zipPostalCode == null)? 0 :this.zipPostalCode.hashCode()));
        result = ((result* 31)+((this.city == null)? 0 :this.city.hashCode()));
        result = ((result* 31)+((this.street == null)? 0 :this.street.hashCode()));
        result = ((result* 31)+((this.stateProvince == null)? 0 :this.stateProvince.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddressInformation) == false) {
            return false;
        }
        AddressInformation rhs = ((AddressInformation) other);
        return (((((((this.country == rhs.country)||((this.country!= null)&&this.country.equals(rhs.country)))&&((this.zipPostalCode == rhs.zipPostalCode)||((this.zipPostalCode!= null)&&this.zipPostalCode.equals(rhs.zipPostalCode))))&&((this.city == rhs.city)||((this.city!= null)&&this.city.equals(rhs.city))))&&((this.street == rhs.street)||((this.street!= null)&&this.street.equals(rhs.street))))&&((this.stateProvince == rhs.stateProvince)||((this.stateProvince!= null)&&this.stateProvince.equals(rhs.stateProvince))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
