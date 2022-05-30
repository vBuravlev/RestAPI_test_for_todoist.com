package api.helpers;

import api.domain.ProjectData;
import api.domain.TaskCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public interface WriterHelper {

    public static String writerMapperTask(TaskCreator taskCreator) {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, taskCreator);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        String result = writer.toString();
        return result;
    }

    public static String writerMapperProject(ProjectData projectData) {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, projectData);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        String result = writer.toString();
        return result;
    }
}
