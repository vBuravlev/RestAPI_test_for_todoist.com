package api.helpers.api.project;

import api.dictonary.DictonaryApiV1;
import api.domain.ProjectData;
import api.helpers.FakerHelper;
import io.qameta.allure.Step;

import static api.specifications.Specification.*;
import static io.restassured.RestAssured.given;

public class UpdateProject {

    @Step("Отправляем запрос на обновление проекта")
    public static void updateProject(ProjectData projectData) {

                given()
                .spec(requestSpec)
                .body(projectData)
                .when()
                .post(DictonaryApiV1.PROJECT.getPathApi() + projectData.getId())
                .then()
                .spec(responseSpec204);
    }
}
