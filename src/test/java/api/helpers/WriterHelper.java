package api.helpers;

import api.domain.TaskCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public interface WriterHelper {

    public static String writerMapper(TaskCreator taskCreator) {
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
}
