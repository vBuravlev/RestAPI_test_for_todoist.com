package api.helpers.api.task;

import api.dictonary.DictonaryApiV1;
import io.qameta.allure.Step;

import static api.specifications.Specification.*;
import static io.restassured.RestAssured.given;

public class CloseTask {

    @Step("Отправляем запрос на закрытие задачи")
    public static void closeTask(long taskId) {

        given()
                .spec(requestSpec)
                .when()
                .post(DictonaryApiV1.TASK.getPathApi() + taskId + DictonaryApiV1.CLOSE.getPathApi())
                .then()
                .spec(responseSpec204);

    }
}
