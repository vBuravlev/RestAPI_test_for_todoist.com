package api.helpers.api.task;

import api.dictonary.DictonaryApiV1;
import api.domain.TaskData;
import io.qameta.allure.Step;
import java.util.List;

import static api.specifications.Specification.*;
import static io.restassured.RestAssured.given;

public interface GetActiveTasks {

    @Step("Отправляем запрос на получение списка проектов в виде массива")
    public static TaskData[] getTaskArray() {
        return given()
                .spec(requestSpec)
                .when()
                .get(DictonaryApiV1.TASKS.getPathApi())
                .then()
                .spec(responseSpec200)
                .extract().as(TaskData[].class);
    }

    @Step("Отправляем запрос на получение списка проектов в ввиде коллекции")
    public static List<TaskData> getTaskList() {
        return given()
                .spec(requestSpec)
                .when()
                .get(DictonaryApiV1.TASKS.getPathApi())
                .then()
                .spec(responseSpec200)
                .extract().response().jsonPath().getList(".", TaskData.class);
    }

    @Step("Отправляем запрос на получение последней задачи в списке")
    public static TaskData getLastTask() {
        TaskData lastTask = getTaskList().get(getTaskList().size()-1);
        return lastTask;
    }

    @Step("Отправляем запрос на получение задачи")
    public static TaskData getTask(long taskID) {

        TaskData taskData = given()
                .spec(requestSpec)
                .when()
                .get(DictonaryApiV1.TASK.getPathApi()+taskID)
                .then()
                .spec(responseSpec200)
                .extract().response().as(TaskData.class);

        return taskData;
    }

    @Step("Отправляем запрос на получение задачи")
    public static TaskData getTask404(String taskID) {

        TaskData taskData = given()
                .spec(requestSpec)
                .when()
                .get(DictonaryApiV1.TASK.getPathApi()+taskID)
                .then()
                .spec(responseSpec204)
                .extract().response().as(TaskData.class);

        return taskData;
    }

}
