package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskCreator {
    public String content;
    public String due_string;
    public String due_lang;
    public int priority;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDue_string() {
        return due_string;
    }

    public void setDue_string(String due_string) {
        this.due_string = due_string;
    }

    public String getDue_lang() {
        return due_lang;
    }

    public void setDue_lang(String due_lang) {
        this.due_lang = due_lang;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
