package api.helpers.api.project;

import api.dictonary.DictonaryApiV1;
import api.domain.ProjectData;
import io.qameta.allure.Step;
import java.util.List;

import static api.specifications.Specification.*;
import static io.restassured.RestAssured.given;

public class GetProjects {

    @Step("Отправляем запрос на получение массива проектов")
    public static ProjectData[] getProjectArray() {
        return given()
                .spec(requestSpec)
                .when()
                .get(DictonaryApiV1.PROJECTS.getPathApi())
                .then()
                .spec(responseSpec200)
                .extract().as(ProjectData[].class);
    }

    @Step("Отправляем запрос на получение списка проектов")
    public static List<ProjectData> getProjectList() {
        return given()
                .spec(requestSpec)
                .when()
                .get(DictonaryApiV1.PROJECTS.getPathApi())
                .then()
                .spec(responseSpec200)
                .extract().response().jsonPath().getList(".", ProjectData.class);
    }

    @Step("Отправляем запрос на информацию по проект")
    public static ProjectData getProject(long projectId) {
        return given()
                .spec(requestSpec)
                .when()
                .get(DictonaryApiV1.PROJECT.getPathApi() + projectId)
                .then()
                .spec(responseSpec200)
                .extract().as(ProjectData.class);
    }

    @Step("Отправляем запрос на информацию по проект")
    public static ProjectData getProject404(long projectId) {
        return given()
                .spec(requestSpec)
                .when()
                .get(DictonaryApiV1.PROJECT.getPathApi() + projectId)
                .then()
                .spec(responseSpec404)
                .extract().as(ProjectData.class);
    }


}
