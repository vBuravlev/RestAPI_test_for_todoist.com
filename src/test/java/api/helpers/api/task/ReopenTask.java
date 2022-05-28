package api.helpers.api.task;

import api.dictonary.DictonaryApiV1;
import io.qameta.allure.Step;

import static api.specifications.Specification.requestSpec;
import static api.specifications.Specification.responseSpec204;
import static io.restassured.RestAssured.given;

public class ReopenTask {

    @Step("Отправляем запрос на переоткрытие задачи")
    public static void reopenTask(long taskId) {

        given()
                .spec(requestSpec)
                .when()
                .post(DictonaryApiV1.TASK.getPathApi()+taskId+ DictonaryApiV1.REOPEN.getPathApi())
                .then()
                .spec(responseSpec204);

    }

}
