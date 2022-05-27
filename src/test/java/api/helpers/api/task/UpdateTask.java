package api.helpers.api.task;

import api.dictonary.DictonaryApiV1;
import api.domain.TaskData;
import api.helpers.FakerHelper;
import io.qameta.allure.Step;

import static api.specifications.Specification.*;
import static io.restassured.RestAssured.given;

public class UpdateTask implements FakerHelper {


    @Step("Обновление параметров задачи")

    public void updateTask(TaskData taskData) {

        given()
                .spec(requestSpec)
                .body(taskData)
                .when()
                .post(DictonaryApiV1.TASK.getPathApi() + taskData.getId())
                .then()
                .spec(responseSpec204);

    }


}
