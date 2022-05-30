package api.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectData {
    public long id;
    public int color;
    public String name;
    @JsonProperty("comment_count")
    public int commentCount;
    public boolean shared;
    public boolean favorite;
    @JsonProperty("sync_id")
    public int syncId;
    @JsonProperty("inbox_project")
    public boolean inboxProject;
    public String url;
    public int order;

}
