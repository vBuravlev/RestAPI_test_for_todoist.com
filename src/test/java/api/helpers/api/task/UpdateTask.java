package api.helpers.api.task;

import api.dictonary.DictonaryApiV1;
import api.domain.TaskData;

import io.qameta.allure.Step;

import static api.specifications.Specification.*;
import static io.restassured.RestAssured.given;

public interface UpdateTask {

    @Step("Обновление параметров задачи")
    public static void updateTask(TaskData taskData) {

        given()
                .spec(requestSpec)
                .body(taskData)
                .when()
                .post(DictonaryApiV1.TASK.getPathApi() + taskData.getId())
                .then()
                .spec(responseSpec204);

    }
}
