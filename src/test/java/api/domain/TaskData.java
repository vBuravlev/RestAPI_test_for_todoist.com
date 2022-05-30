package api.domain;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskData {
    public long id;
    public int assigner;
    @JsonProperty("project_id")
    public long projectId;
    @JsonProperty("section_id")
    public int sectionId;
    @JsonProperty("parent_id")
    public int parentId;
    public int order;
    public String content;
    public String description;
    public boolean completed;
    @JsonProperty("label_ids")
    public ArrayList<Object> labelIds;
    public int priority;
    public int comment_count;
    public int creator;
    public Date created;
    public Due due;
    public String url;

}
