package api.helpers.api.project;

import api.dictonary.DictonaryApiV1;
import api.domain.ProjectData;
import io.qameta.allure.Step;

import static api.specifications.Specification.requestSpec;
import static api.specifications.Specification.responseSpec200;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateNewProject {

    @Step("Отправляем запрос на создание проекта")
    public static ProjectData createProject (String projectName) {

        ProjectData projectDataCreate = new ProjectData();
        projectDataCreate.setName(projectName);

        ProjectData projectData = given()
                .spec(requestSpec)
                .body(projectDataCreate)
                .when()
                .post(DictonaryApiV1.PROJECTS.getPathApi())
                .then()
                .spec(responseSpec200)
                .extract().as(ProjectData.class);

        assertThat(projectData.getName()).isEqualTo(projectDataCreate.getName());

        return projectData;

    }


}
