
package sft.sfData.quickActions.describeQuickActionsPOJO;

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
import sft.forceObject.objField;
import sft.sfData.objectDescribe.describeLayoutPOJO.PicklistValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aggregatable",
    "aiPredictionField",
    "autoNumber",
    "byteLength",
    "calculated",
    "calculatedFormula",
    "cascadeDelete",
    "caseSensitive",
    "compoundFieldName",
    "controllerName",
    "createable",
    "custom",
    "defaultValue",
    "defaultValueFormula",
    "defaultedOnCreate",
    "dependentPicklist",
    "deprecatedAndHidden",
    "digits",
    "displayLocationInDecimal",
    "encrypted",
    "externalId",
    "extraTypeInfo",
    "filterable",
    "filteredLookupInfo",
    "formulaTreatNullNumberAsZero",
    "groupable",
    "highScaleNumber",
    "htmlFormatted",
    "idLookup",
    "inlineHelpText",
    "label",
    "length",
    "mask",
    "maskType",
    "name",
    "nameField",
    "namePointing",
    "nillable",
    "permissionable",
    "picklistValues",
    "polymorphicForeignKey",
    "precision",
    "queryByDistance",
    "referenceTargetField",
    "referenceTo",
    "relationshipName",
    "relationshipOrder",
    "restrictedDelete",
    "restrictedPicklist",
    "scale",
    "searchPrefilterable",
    "soapType",
    "sortable",
    "type",
    "unique",
    "updateable",
    "writeRequiresMasterRead"
})
public class Details extends objField {

    @JsonProperty("aggregatable")
    private Boolean aggregatable;
    @JsonProperty("aiPredictionField")
    private Boolean aiPredictionField;
    @JsonProperty("autoNumber")
    private Boolean autoNumber;
    @JsonProperty("byteLength")
    private Integer byteLength;
    @JsonProperty("calculated")
    private Boolean calculated;
    @JsonProperty("calculatedFormula")
    private Object calculatedFormula;
    @JsonProperty("cascadeDelete")
    private Boolean cascadeDelete;
    @JsonProperty("caseSensitive")
    private Boolean caseSensitive;
    @JsonProperty("compoundFieldName")
    private Object compoundFieldName;
    @JsonProperty("controllerName")
    private Object controllerName;
    @JsonProperty("createable")
    private Boolean createable;
    @JsonProperty("custom")
    private Boolean custom;
    @JsonProperty("defaultValue")
    private Object defaultValue;
    @JsonProperty("defaultValueFormula")
    private Object defaultValueFormula;
    @JsonProperty("defaultedOnCreate")
    private Boolean defaultedOnCreate;
    @JsonProperty("dependentPicklist")
    private Boolean dependentPicklist;
    @JsonProperty("deprecatedAndHidden")
    private Boolean deprecatedAndHidden;
    @JsonProperty("digits")
    private Integer digits;
    @JsonProperty("displayLocationInDecimal")
    private Boolean displayLocationInDecimal;
    @JsonProperty("encrypted")
    private Boolean encrypted;
    @JsonProperty("externalId")
    private Boolean externalId;
    @JsonProperty("extraTypeInfo")
    private String extraTypeInfo;
    @JsonProperty("filterable")
    private Boolean filterable;
    @JsonProperty("filteredLookupInfo")
    private Object filteredLookupInfo;
    @JsonProperty("formulaTreatNullNumberAsZero")
    private Boolean formulaTreatNullNumberAsZero;
    @JsonProperty("groupable")
    private Boolean groupable;
    @JsonProperty("highScaleNumber")
    private Boolean highScaleNumber;
    @JsonProperty("htmlFormatted")
    private Boolean htmlFormatted;
    @JsonProperty("idLookup")
    private Boolean idLookup;
    @JsonProperty("inlineHelpText")
    private Object inlineHelpText;
    @JsonProperty("label")
    private String label;
    @JsonProperty("length")
    private Integer length;
    @JsonProperty("mask")
    private Object mask;
    @JsonProperty("maskType")
    private Object maskType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameField")
    private Boolean nameField;
    @JsonProperty("namePointing")
    private Boolean namePointing;
    @JsonProperty("nillable")
    private Boolean nillable;
    @JsonProperty("permissionable")
    private Boolean permissionable;
    @JsonProperty("picklistValues")
    private List<sft.sfData.objectDescribe.describeLayoutPOJO.PicklistValue> picklistValues = new ArrayList<PicklistValue>();
    @JsonProperty("polymorphicForeignKey")
    private Boolean polymorphicForeignKey;
    @JsonProperty("precision")
    private Integer precision;
    @JsonProperty("queryByDistance")
    private Boolean queryByDistance;
    @JsonProperty("referenceTargetField")
    private Object referenceTargetField;
    @JsonProperty("referenceTo")
    private List<String> referenceTo = null;
    @JsonProperty("relationshipName")
    private String relationshipName;
    @JsonProperty("relationshipOrder")
    private Object relationshipOrder;
    @JsonProperty("restrictedDelete")
    private Boolean restrictedDelete;
    @JsonProperty("restrictedPicklist")
    private Boolean restrictedPicklist;
    @JsonProperty("scale")
    private Integer scale;
    @JsonProperty("searchPrefilterable")
    private Boolean searchPrefilterable;
    @JsonProperty("soapType")
    private String soapType;
    @JsonProperty("sortable")
    private Boolean sortable;
    @JsonProperty("type")
    private String type;
    @JsonProperty("unique")
    private Boolean unique;
    @JsonProperty("updateable")
    private Boolean updateable;
    @JsonProperty("writeRequiresMasterRead")
    private Boolean writeRequiresMasterRead;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("aggregatable")
    public Boolean getAggregatable() {
        return aggregatable;
    }

    @JsonProperty("aggregatable")
    public void setAggregatable(Boolean aggregatable) {
        this.aggregatable = aggregatable;
    }

    @JsonProperty("aiPredictionField")
    public Boolean getAiPredictionField() {
        return aiPredictionField;
    }

    @JsonProperty("aiPredictionField")
    public void setAiPredictionField(Boolean aiPredictionField) {
        this.aiPredictionField = aiPredictionField;
    }

    @JsonProperty("autoNumber")
    public Boolean getAutoNumber() {
        return autoNumber;
    }

    @JsonProperty("autoNumber")
    public void setAutoNumber(Boolean autoNumber) {
        this.autoNumber = autoNumber;
    }

    @JsonProperty("byteLength")
    public Integer getByteLength() {
        return byteLength;
    }

    @JsonProperty("byteLength")
    public void setByteLength(Integer byteLength) {
        this.byteLength = byteLength;
    }

    @JsonProperty("calculated")
    public Boolean getCalculated() {
        return calculated;
    }

    @JsonProperty("calculated")
    public void setCalculated(Boolean calculated) {
        this.calculated = calculated;
    }

    @JsonProperty("calculatedFormula")
    public Object getCalculatedFormula() {
        return calculatedFormula;
    }

    @JsonProperty("calculatedFormula")
    public void setCalculatedFormula(Object calculatedFormula) {
        this.calculatedFormula = calculatedFormula;
    }

    @JsonProperty("cascadeDelete")
    public Boolean getCascadeDelete() {
        return cascadeDelete;
    }

    @JsonProperty("cascadeDelete")
    public void setCascadeDelete(Boolean cascadeDelete) {
        this.cascadeDelete = cascadeDelete;
    }

    @JsonProperty("caseSensitive")
    public Boolean getCaseSensitive() {
        return caseSensitive;
    }

    @JsonProperty("caseSensitive")
    public void setCaseSensitive(Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    @JsonProperty("compoundFieldName")
    public Object getCompoundFieldName() {
        return compoundFieldName;
    }

    @JsonProperty("compoundFieldName")
    public void setCompoundFieldName(Object compoundFieldName) {
        this.compoundFieldName = compoundFieldName;
    }

    @JsonProperty("controllerName")
    public Object getControllerName() {
        return controllerName;
    }

    @JsonProperty("controllerName")
    public void setControllerName(Object controllerName) {
        this.controllerName = controllerName;
    }

    @JsonProperty("createable")
    public Boolean getCreateable() {
        return createable;
    }

    @JsonProperty("createable")
    public void setCreateable(Boolean createable) {
        this.createable = createable;
    }

    @JsonProperty("custom")
    public Boolean getCustom() {
        return custom;
    }

    @JsonProperty("custom")
    public void setCustom(Boolean custom) {
        this.custom = custom;
    }

    @JsonProperty("defaultValue")
    public Object getDefaultValue() {
        return defaultValue;
    }

    @JsonProperty("defaultValue")
    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    @JsonProperty("defaultValueFormula")
    public Object getDefaultValueFormula() {
        return defaultValueFormula;
    }

    @JsonProperty("defaultValueFormula")
    public void setDefaultValueFormula(Object defaultValueFormula) {
        this.defaultValueFormula = defaultValueFormula;
    }

    @JsonProperty("defaultedOnCreate")
    public Boolean getDefaultedOnCreate() {
        return defaultedOnCreate;
    }

    @JsonProperty("defaultedOnCreate")
    public void setDefaultedOnCreate(Boolean defaultedOnCreate) {
        this.defaultedOnCreate = defaultedOnCreate;
    }

    @JsonProperty("dependentPicklist")
    public Boolean getDependentPicklist() {
        return dependentPicklist;
    }

    @JsonProperty("dependentPicklist")
    public void setDependentPicklist(Boolean dependentPicklist) {
        this.dependentPicklist = dependentPicklist;
    }

    @JsonProperty("deprecatedAndHidden")
    public Boolean getDeprecatedAndHidden() {
        return deprecatedAndHidden;
    }

    @JsonProperty("deprecatedAndHidden")
    public void setDeprecatedAndHidden(Boolean deprecatedAndHidden) {
        this.deprecatedAndHidden = deprecatedAndHidden;
    }

    @JsonProperty("digits")
    public Integer getDigits() {
        return digits;
    }

    @JsonProperty("digits")
    public void setDigits(Integer digits) {
        this.digits = digits;
    }

    @JsonProperty("displayLocationInDecimal")
    public Boolean getDisplayLocationInDecimal() {
        return displayLocationInDecimal;
    }

    @JsonProperty("displayLocationInDecimal")
    public void setDisplayLocationInDecimal(Boolean displayLocationInDecimal) {
        this.displayLocationInDecimal = displayLocationInDecimal;
    }

    @JsonProperty("encrypted")
    public Boolean getEncrypted() {
        return encrypted;
    }

    @JsonProperty("encrypted")
    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    @JsonProperty("externalId")
    public Boolean getExternalId() {
        return externalId;
    }

    @JsonProperty("externalId")
    public void setExternalId(Boolean externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("extraTypeInfo")
    public String getExtraTypeInfo() {
        return extraTypeInfo;
    }

    @JsonProperty("extraTypeInfo")
    public void setExtraTypeInfo(String extraTypeInfo) {
        this.extraTypeInfo = extraTypeInfo;
    }

    @JsonProperty("filterable")
    public Boolean getFilterable() {
        return filterable;
    }

    @JsonProperty("filterable")
    public void setFilterable(Boolean filterable) {
        this.filterable = filterable;
    }

    @JsonProperty("filteredLookupInfo")
    public Object getFilteredLookupInfo() {
        return filteredLookupInfo;
    }

    @JsonProperty("filteredLookupInfo")
    public void setFilteredLookupInfo(Object filteredLookupInfo) {
        this.filteredLookupInfo = filteredLookupInfo;
    }

    @JsonProperty("formulaTreatNullNumberAsZero")
    public Boolean getFormulaTreatNullNumberAsZero() {
        return formulaTreatNullNumberAsZero;
    }

    @JsonProperty("formulaTreatNullNumberAsZero")
    public void setFormulaTreatNullNumberAsZero(Boolean formulaTreatNullNumberAsZero) {
        this.formulaTreatNullNumberAsZero = formulaTreatNullNumberAsZero;
    }

    @JsonProperty("groupable")
    public Boolean getGroupable() {
        return groupable;
    }

    @JsonProperty("groupable")
    public void setGroupable(Boolean groupable) {
        this.groupable = groupable;
    }

    @JsonProperty("highScaleNumber")
    public Boolean getHighScaleNumber() {
        return highScaleNumber;
    }

    @JsonProperty("highScaleNumber")
    public void setHighScaleNumber(Boolean highScaleNumber) {
        this.highScaleNumber = highScaleNumber;
    }

    @JsonProperty("htmlFormatted")
    public Boolean getHtmlFormatted() {
        return htmlFormatted;
    }

    @JsonProperty("htmlFormatted")
    public void setHtmlFormatted(Boolean htmlFormatted) {
        this.htmlFormatted = htmlFormatted;
    }

    @JsonProperty("idLookup")
    public Boolean getIdLookup() {
        return idLookup;
    }

    @JsonProperty("idLookup")
    public void setIdLookup(Boolean idLookup) {
        this.idLookup = idLookup;
    }

    @JsonProperty("inlineHelpText")
    public Object getInlineHelpText() {
        return inlineHelpText;
    }

    @JsonProperty("inlineHelpText")
    public void setInlineHelpText(Object inlineHelpText) {
        this.inlineHelpText = inlineHelpText;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("length")
    public Integer getLength() {
        return length;
    }

    @JsonProperty("length")
    public void setLength(Integer length) {
        this.length = length;
    }

    @JsonProperty("mask")
    public Object getMask() {
        return mask;
    }

    @JsonProperty("mask")
    public void setMask(Object mask) {
        this.mask = mask;
    }

    @JsonProperty("maskType")
    public Object getMaskType() {
        return maskType;
    }

    @JsonProperty("maskType")
    public void setMaskType(Object maskType) {
        this.maskType = maskType;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nameField")
    public Boolean getNameField() {
        return nameField;
    }

    @JsonProperty("nameField")
    public void setNameField(Boolean nameField) {
        this.nameField = nameField;
    }

    @JsonProperty("namePointing")
    public Boolean getNamePointing() {
        return namePointing;
    }

    @JsonProperty("namePointing")
    public void setNamePointing(Boolean namePointing) {
        this.namePointing = namePointing;
    }

    @JsonProperty("nillable")
    public Boolean getNillable() {
        return nillable;
    }

    @JsonProperty("nillable")
    public void setNillable(Boolean nillable) {
        this.nillable = nillable;
    }

    @JsonProperty("permissionable")
    public Boolean getPermissionable() {
        return permissionable;
    }

    @JsonProperty("permissionable")
    public void setPermissionable(Boolean permissionable) {
        this.permissionable = permissionable;
    }

//    @JsonProperty("picklistValues")
//    public List<PicklistValue> getPicklistValues() {
//        return picklistValues;
//    }
//
//    @JsonProperty("picklistValues")
//    public void setPicklistValues(List<PicklistValue> picklistValues) {
//        this.picklistValues = picklistValues;
//    }


    @JsonProperty("picklistValues")
    public List<sft.sfData.objectDescribe.describeLayoutPOJO.PicklistValue> getPicklistValues() {
        return picklistValues;
    }

    @JsonProperty("picklistValues")
    public void setPicklistValues(List<sft.sfData.objectDescribe.describeLayoutPOJO.PicklistValue> picklistValues) {
        this.picklistValues = picklistValues;
    }

    @JsonProperty("polymorphicForeignKey")
    public Boolean getPolymorphicForeignKey() {
        return polymorphicForeignKey;
    }

    @JsonProperty("polymorphicForeignKey")
    public void setPolymorphicForeignKey(Boolean polymorphicForeignKey) {
        this.polymorphicForeignKey = polymorphicForeignKey;
    }

    @JsonProperty("precision")
    public Integer getPrecision() {
        return precision;
    }

    @JsonProperty("precision")
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    @JsonProperty("queryByDistance")
    public Boolean getQueryByDistance() {
        return queryByDistance;
    }

    @JsonProperty("queryByDistance")
    public void setQueryByDistance(Boolean queryByDistance) {
        this.queryByDistance = queryByDistance;
    }

    @JsonProperty("referenceTargetField")
    public Object getReferenceTargetField() {
        return referenceTargetField;
    }

    @JsonProperty("referenceTargetField")
    public void setReferenceTargetField(Object referenceTargetField) {
        this.referenceTargetField = referenceTargetField;
    }

    @JsonProperty("referenceTo")
    public List<String> getReferenceTo() {
        return referenceTo;
    }

    @JsonProperty("referenceTo")
    public void setReferenceTo(List<String> referenceTo) {
        this.referenceTo = referenceTo;
    }

    @JsonProperty("relationshipName")
    public String getRelationshipName() {
        return relationshipName;
    }

    @JsonProperty("relationshipName")
    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }

    @JsonProperty("relationshipOrder")
    public Object getRelationshipOrder() {
        return relationshipOrder;
    }

    @JsonProperty("relationshipOrder")
    public void setRelationshipOrder(Object relationshipOrder) {
        this.relationshipOrder = relationshipOrder;
    }

    @JsonProperty("restrictedDelete")
    public Boolean getRestrictedDelete() {
        return restrictedDelete;
    }

    @JsonProperty("restrictedDelete")
    public void setRestrictedDelete(Boolean restrictedDelete) {
        this.restrictedDelete = restrictedDelete;
    }

    @JsonProperty("restrictedPicklist")
    public Boolean getRestrictedPicklist() {
        return restrictedPicklist;
    }

    @JsonProperty("restrictedPicklist")
    public void setRestrictedPicklist(Boolean restrictedPicklist) {
        this.restrictedPicklist = restrictedPicklist;
    }

    @JsonProperty("scale")
    public Integer getScale() {
        return scale;
    }

    @JsonProperty("scale")
    public void setScale(Integer scale) {
        this.scale = scale;
    }

    @JsonProperty("searchPrefilterable")
    public Boolean getSearchPrefilterable() {
        return searchPrefilterable;
    }

    @JsonProperty("searchPrefilterable")
    public void setSearchPrefilterable(Boolean searchPrefilterable) {
        this.searchPrefilterable = searchPrefilterable;
    }

    @JsonProperty("soapType")
    public String getSoapType() {
        return soapType;
    }

    @JsonProperty("soapType")
    public void setSoapType(String soapType) {
        this.soapType = soapType;
    }

    @JsonProperty("sortable")
    public Boolean getSortable() {
        return sortable;
    }

    @JsonProperty("sortable")
    public void setSortable(Boolean sortable) {
        this.sortable = sortable;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("unique")
    public Boolean getUnique() {
        return unique;
    }

    @JsonProperty("unique")
    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    @JsonProperty("updateable")
    public Boolean getUpdateable() {
        return updateable;
    }

    @JsonProperty("updateable")
    public void setUpdateable(Boolean updateable) {
        this.updateable = updateable;
    }

    @JsonProperty("writeRequiresMasterRead")
    public Boolean getWriteRequiresMasterRead() {
        return writeRequiresMasterRead;
    }

    @JsonProperty("writeRequiresMasterRead")
    public void setWriteRequiresMasterRead(Boolean writeRequiresMasterRead) {
        this.writeRequiresMasterRead = writeRequiresMasterRead;
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
