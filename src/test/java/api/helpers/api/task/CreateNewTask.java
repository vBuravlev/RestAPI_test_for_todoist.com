package api.helpers.api.task;

import api.dictonary.DictonaryApiV1;
import api.domain.Due;
import api.domain.TaskCreator;
import api.domain.TaskData;
import api.helpers.FakerHelper;
import api.helpers.WriterHelper;
import io.qameta.allure.Step;

import static api.helpers.WriterHelper.writerMapper;
import static api.specifications.Specification.requestSpec;
import static api.specifications.Specification.responseSpec200;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateNewTask implements FakerHelper, WriterHelper {

    @Step("Создаем новую задачу в проекте")
    public static TaskData createNewTaskInProject(String lang, String content, int priority, String deadLine, long projectId) {

        Due dueEx = new Due();
        dueEx.setString(deadLine);
        dueEx.setLang(lang);

        TaskData taskDataEx = new TaskData();
        taskDataEx.setContent(content);
        taskDataEx.setPriority(priority);
        taskDataEx.setProject_id(projectId);
        taskDataEx.setDue(dueEx);

        TaskCreator taskCreatorEx = new TaskCreator();
        taskCreatorEx.setContent(taskDataEx.getContent());
        taskCreatorEx.setDue_string(dueEx.getString());
        taskCreatorEx.setDue_lang(dueEx.getLang());
        taskCreatorEx.setPriority(taskDataEx.getPriority());

        TaskData taskData = given()
                .spec(requestSpec)
                .body(writerMapper(taskCreatorEx))
                .when()
                .post(DictonaryApiV1.TASKS.getPathApi())
                .then()
                .spec(responseSpec200)
                .extract().as(TaskData.class);

        assertThat(taskData.getContent()).isEqualTo(content);
        assertThat(taskData.getPriority()).isEqualTo(priority);
        assertThat(taskData.due.getLang()).isEqualTo(lang);
        assertThat(taskData.due.getString()).isEqualTo(deadLine);
        assertThat(taskData.getId()).isNotNull();
        assertThat(taskData.getUrl()).contains(String.valueOf(taskData.getId()));

        return taskData;
    }

    @Step("Создаем новую задачу в проекте")
    public static TaskData createNewTask(String lang, String taskName, int priority, String description) {

        Due dueEx = new Due();
        dueEx.setString(description);
        dueEx.setLang(lang);

        TaskData taskDataEx = new TaskData();
        taskDataEx.setContent(taskName);
        taskDataEx.setPriority(priority);
        taskDataEx.setDue(dueEx);

        TaskCreator taskCreatorEx = new TaskCreator();
        taskCreatorEx.setContent(taskDataEx.getContent());
        taskCreatorEx.setDue_string(dueEx.getString());
        taskCreatorEx.setDue_lang(dueEx.getLang());
        taskCreatorEx.setPriority(taskDataEx.getPriority());

        TaskData taskData = given()
                .spec(requestSpec)
//                .body(writerMapper(taskCreatorEx))
                .body(taskCreatorEx)
                .when()
                .post(DictonaryApiV1.TASKS.getPathApi())
                .then()
                .spec(responseSpec200)
                .extract().as(TaskData.class);

        assertThat(taskData.getContent()).isEqualTo(taskName);
        assertThat(taskData.getPriority()).isEqualTo(priority);
        assertThat(taskData.due.getLang()).isEqualTo(lang);
        assertThat(taskData.due.getString()).isEqualTo(description);
        assertThat(taskData.getId()).isNotNull();
        assertThat(taskData.getUrl()).contains(String.valueOf(taskData.getId()));

        return taskData;
    }



}
