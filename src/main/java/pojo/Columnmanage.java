package pojo;

import org.springframework.stereotype.Component;

@Component
public class Columnmanage {
    private Integer id;

    private String parentColumn;

    private String sonColumn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentColumn() {
        return parentColumn;
    }

    public void setParentColumn(String parentColumn) {
        this.parentColumn = parentColumn == null ? null : parentColumn.trim();
    }

    public String getSonColumn() {
        return sonColumn;
    }

    public void setSonColumn(String sonColumn) {
        this.sonColumn = sonColumn == null ? null : sonColumn.trim();
    }
}