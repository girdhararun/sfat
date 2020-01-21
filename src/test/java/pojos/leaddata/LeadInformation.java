
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
    "Lead Source",
    "No. of Employees",
    "Company",
    "Email",
    "Rating",
    "First Name",
    "Title",
    "Website",
    "Lead Status",
    "Mobile",
    "Salutation",
    "Annual Revenue",
    "Industry",
    "Phone",
    "Last Name",
    "Fax"
})
public class LeadInformation {

    @JsonProperty("Lead Source")
    private LeadSource leadSource;
    @JsonProperty("No. of Employees")
    private NoOfEmployees noOfEmployees;
    @JsonProperty("Company")
    private Company company;
    @JsonProperty("Email")
    private Email email;
    @JsonProperty("Rating")
    private Rating rating;
    @JsonProperty("First Name")
    private FirstName firstName;
    @JsonProperty("Title")
    private Title title;
    @JsonProperty("Website")
    private Website website;
    @JsonProperty("Lead Status")
    private LeadStatus leadStatus;
    @JsonProperty("Mobile")
    private Mobile mobile;
    @JsonProperty("Salutation")
    private Salutation salutation;
    @JsonProperty("Annual Revenue")
    private AnnualRevenue annualRevenue;
    @JsonProperty("Industry")
    private Industry industry;
    @JsonProperty("Phone")
    private Phone phone;
    @JsonProperty("Last Name")
    private LastName lastName;
    @JsonProperty("Fax")
    private Fax fax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Lead Source")
    public LeadSource getLeadSource() {
        return leadSource;
    }

    @JsonProperty("Lead Source")
    public void setLeadSource(LeadSource leadSource) {
        this.leadSource = leadSource;
    }

    public LeadInformation withLeadSource(LeadSource leadSource) {
        this.leadSource = leadSource;
        return this;
    }

    @JsonProperty("No. of Employees")
    public NoOfEmployees getNoOfEmployees() {
        return noOfEmployees;
    }

    @JsonProperty("No. of Employees")
    public void setNoOfEmployees(NoOfEmployees noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    public LeadInformation withNoOfEmployees(NoOfEmployees noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
        return this;
    }

    @JsonProperty("Company")
    public Company getCompany() {
        return company;
    }

    @JsonProperty("Company")
    public void setCompany(Company company) {
        this.company = company;
    }

    public LeadInformation withCompany(Company company) {
        this.company = company;
        return this;
    }

    @JsonProperty("Email")
    public Email getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(Email email) {
        this.email = email;
    }

    public LeadInformation withEmail(Email email) {
        this.email = email;
        return this;
    }

    @JsonProperty("Rating")
    public Rating getRating() {
        return rating;
    }

    @JsonProperty("Rating")
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public LeadInformation withRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    @JsonProperty("First Name")
    public FirstName getFirstName() {
        return firstName;
    }

    @JsonProperty("First Name")
    public void setFirstName(FirstName firstName) {
        this.firstName = firstName;
    }

    public LeadInformation withFirstName(FirstName firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("Title")
    public Title getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(Title title) {
        this.title = title;
    }

    public LeadInformation withTitle(Title title) {
        this.title = title;
        return this;
    }

    @JsonProperty("Website")
    public Website getWebsite() {
        return website;
    }

    @JsonProperty("Website")
    public void setWebsite(Website website) {
        this.website = website;
    }

    public LeadInformation withWebsite(Website website) {
        this.website = website;
        return this;
    }

    @JsonProperty("Lead Status")
    public LeadStatus getLeadStatus() {
        return leadStatus;
    }

    @JsonProperty("Lead Status")
    public void setLeadStatus(LeadStatus leadStatus) {
        this.leadStatus = leadStatus;
    }

    public LeadInformation withLeadStatus(LeadStatus leadStatus) {
        this.leadStatus = leadStatus;
        return this;
    }

    @JsonProperty("Mobile")
    public Mobile getMobile() {
        return mobile;
    }

    @JsonProperty("Mobile")
    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public LeadInformation withMobile(Mobile mobile) {
        this.mobile = mobile;
        return this;
    }

    @JsonProperty("Salutation")
    public Salutation getSalutation() {
        return salutation;
    }

    @JsonProperty("Salutation")
    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
    }

    public LeadInformation withSalutation(Salutation salutation) {
        this.salutation = salutation;
        return this;
    }

    @JsonProperty("Annual Revenue")
    public AnnualRevenue getAnnualRevenue() {
        return annualRevenue;
    }

    @JsonProperty("Annual Revenue")
    public void setAnnualRevenue(AnnualRevenue annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public LeadInformation withAnnualRevenue(AnnualRevenue annualRevenue) {
        this.annualRevenue = annualRevenue;
        return this;
    }

    @JsonProperty("Industry")
    public Industry getIndustry() {
        return industry;
    }

    @JsonProperty("Industry")
    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public LeadInformation withIndustry(Industry industry) {
        this.industry = industry;
        return this;
    }

    @JsonProperty("Phone")
    public Phone getPhone() {
        return phone;
    }

    @JsonProperty("Phone")
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public LeadInformation withPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    @JsonProperty("Last Name")
    public LastName getLastName() {
        return lastName;
    }

    @JsonProperty("Last Name")
    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }

    public LeadInformation withLastName(LastName lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("Fax")
    public Fax getFax() {
        return fax;
    }

    @JsonProperty("Fax")
    public void setFax(Fax fax) {
        this.fax = fax;
    }

    public LeadInformation withFax(Fax fax) {
        this.fax = fax;
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

    public LeadInformation withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LeadInformation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("leadSource");
        sb.append('=');
        sb.append(((this.leadSource == null)?"<null>":this.leadSource));
        sb.append(',');
        sb.append("noOfEmployees");
        sb.append('=');
        sb.append(((this.noOfEmployees == null)?"<null>":this.noOfEmployees));
        sb.append(',');
        sb.append("company");
        sb.append('=');
        sb.append(((this.company == null)?"<null>":this.company));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("rating");
        sb.append('=');
        sb.append(((this.rating == null)?"<null>":this.rating));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("website");
        sb.append('=');
        sb.append(((this.website == null)?"<null>":this.website));
        sb.append(',');
        sb.append("leadStatus");
        sb.append('=');
        sb.append(((this.leadStatus == null)?"<null>":this.leadStatus));
        sb.append(',');
        sb.append("mobile");
        sb.append('=');
        sb.append(((this.mobile == null)?"<null>":this.mobile));
        sb.append(',');
        sb.append("salutation");
        sb.append('=');
        sb.append(((this.salutation == null)?"<null>":this.salutation));
        sb.append(',');
        sb.append("annualRevenue");
        sb.append('=');
        sb.append(((this.annualRevenue == null)?"<null>":this.annualRevenue));
        sb.append(',');
        sb.append("industry");
        sb.append('=');
        sb.append(((this.industry == null)?"<null>":this.industry));
        sb.append(',');
        sb.append("phone");
        sb.append('=');
        sb.append(((this.phone == null)?"<null>":this.phone));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("fax");
        sb.append('=');
        sb.append(((this.fax == null)?"<null>":this.fax));
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
        result = ((result* 31)+((this.leadStatus == null)? 0 :this.leadStatus.hashCode()));
        result = ((result* 31)+((this.lastName == null)? 0 :this.lastName.hashCode()));
        result = ((result* 31)+((this.website == null)? 0 :this.website.hashCode()));
        result = ((result* 31)+((this.leadSource == null)? 0 :this.leadSource.hashCode()));
        result = ((result* 31)+((this.rating == null)? 0 :this.rating.hashCode()));
        result = ((result* 31)+((this.mobile == null)? 0 :this.mobile.hashCode()));
        result = ((result* 31)+((this.industry == null)? 0 :this.industry.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.firstName == null)? 0 :this.firstName.hashCode()));
        result = ((result* 31)+((this.phone == null)? 0 :this.phone.hashCode()));
        result = ((result* 31)+((this.noOfEmployees == null)? 0 :this.noOfEmployees.hashCode()));
        result = ((result* 31)+((this.company == null)? 0 :this.company.hashCode()));
        result = ((result* 31)+((this.salutation == null)? 0 :this.salutation.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.fax == null)? 0 :this.fax.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.annualRevenue == null)? 0 :this.annualRevenue.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LeadInformation) == false) {
            return false;
        }
        LeadInformation rhs = ((LeadInformation) other);
        return ((((((((((((((((((this.leadStatus == rhs.leadStatus)||((this.leadStatus!= null)&&this.leadStatus.equals(rhs.leadStatus)))&&((this.lastName == rhs.lastName)||((this.lastName!= null)&&this.lastName.equals(rhs.lastName))))&&((this.website == rhs.website)||((this.website!= null)&&this.website.equals(rhs.website))))&&((this.leadSource == rhs.leadSource)||((this.leadSource!= null)&&this.leadSource.equals(rhs.leadSource))))&&((this.rating == rhs.rating)||((this.rating!= null)&&this.rating.equals(rhs.rating))))&&((this.mobile == rhs.mobile)||((this.mobile!= null)&&this.mobile.equals(rhs.mobile))))&&((this.industry == rhs.industry)||((this.industry!= null)&&this.industry.equals(rhs.industry))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.firstName == rhs.firstName)||((this.firstName!= null)&&this.firstName.equals(rhs.firstName))))&&((this.phone == rhs.phone)||((this.phone!= null)&&this.phone.equals(rhs.phone))))&&((this.noOfEmployees == rhs.noOfEmployees)||((this.noOfEmployees!= null)&&this.noOfEmployees.equals(rhs.noOfEmployees))))&&((this.company == rhs.company)||((this.company!= null)&&this.company.equals(rhs.company))))&&((this.salutation == rhs.salutation)||((this.salutation!= null)&&this.salutation.equals(rhs.salutation))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.fax == rhs.fax)||((this.fax!= null)&&this.fax.equals(rhs.fax))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.annualRevenue == rhs.annualRevenue)||((this.annualRevenue!= null)&&this.annualRevenue.equals(rhs.annualRevenue))));
    }

}
