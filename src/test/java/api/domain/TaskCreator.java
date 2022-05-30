package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskCreator {
    public String content;
    @JsonProperty("due_string")
    public String dueString;
    @JsonProperty("due_lang")
    public String dueLang;
    public int priority;


}
