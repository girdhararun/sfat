
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
    "collapsed",
    "columns",
    "heading",
    "layoutRows",
    "layoutSectionId",
    "parentLayoutId",
    "rows",
    "tabOrder",
    "useCollapsibleSection",
    "useHeading"
})
public class Layout {

    @JsonProperty("collapsed")
    private Boolean collapsed;
    @JsonProperty("columns")
    private Integer columns;
    @JsonProperty("heading")
    private Object heading;
    @JsonProperty("layoutRows")
    private List<LayoutRow> layoutRows = null;
    @JsonProperty("layoutSectionId")
    private Object layoutSectionId;
    @JsonProperty("parentLayoutId")
    private String parentLayoutId;
    @JsonProperty("rows")
    private Integer rows;
    @JsonProperty("tabOrder")
    private String tabOrder;
    @JsonProperty("useCollapsibleSection")
    private Boolean useCollapsibleSection;
    @JsonProperty("useHeading")
    private Boolean useHeading;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("collapsed")
    public Boolean getCollapsed() {
        return collapsed;
    }

    @JsonProperty("collapsed")
    public void setCollapsed(Boolean collapsed) {
        this.collapsed = collapsed;
    }

    @JsonProperty("columns")
    public Integer getColumns() {
        return columns;
    }

    @JsonProperty("columns")
    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    @JsonProperty("heading")
    public Object getHeading() {
        return heading;
    }

    @JsonProperty("heading")
    public void setHeading(Object heading) {
        this.heading = heading;
    }

    @JsonProperty("layoutRows")
    public List<LayoutRow> getLayoutRows() {
        return layoutRows;
    }

    @JsonProperty("layoutRows")
    public void setLayoutRows(List<LayoutRow> layoutRows) {
        this.layoutRows = layoutRows;
    }

    @JsonProperty("layoutSectionId")
    public Object getLayoutSectionId() {
        return layoutSectionId;
    }

    @JsonProperty("layoutSectionId")
    public void setLayoutSectionId(Object layoutSectionId) {
        this.layoutSectionId = layoutSectionId;
    }

    @JsonProperty("parentLayoutId")
    public String getParentLayoutId() {
        return parentLayoutId;
    }

    @JsonProperty("parentLayoutId")
    public void setParentLayoutId(String parentLayoutId) {
        this.parentLayoutId = parentLayoutId;
    }

    @JsonProperty("rows")
    public Integer getRows() {
        return rows;
    }

    @JsonProperty("rows")
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @JsonProperty("tabOrder")
    public String getTabOrder() {
        return tabOrder;
    }

    @JsonProperty("tabOrder")
    public void setTabOrder(String tabOrder) {
        this.tabOrder = tabOrder;
    }

    @JsonProperty("useCollapsibleSection")
    public Boolean getUseCollapsibleSection() {
        return useCollapsibleSection;
    }

    @JsonProperty("useCollapsibleSection")
    public void setUseCollapsibleSection(Boolean useCollapsibleSection) {
        this.useCollapsibleSection = useCollapsibleSection;
    }

    @JsonProperty("useHeading")
    public Boolean getUseHeading() {
        return useHeading;
    }

    @JsonProperty("useHeading")
    public void setUseHeading(Boolean useHeading) {
        this.useHeading = useHeading;
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
