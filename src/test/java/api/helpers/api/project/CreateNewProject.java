package api.helpers.api.project;

import api.dictonary.DictonaryApiV1;
import api.domain.ProjectData;
import api.helpers.WriterHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;

import static api.helpers.WriterHelper.writerMapperProject;
import static api.helpers.WriterHelper.writerMapperTask;
import static api.specifications.Specification.requestSpec;
import static api.specifications.Specification.responseSpec200;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public interface CreateNewProject {

    @Step("Отправляем запрос на создание проекта")
    public static ProjectData createProject (String projectName) {

        ProjectData projectDataCreate = new ProjectData();
        projectDataCreate.setName(projectName);

        ProjectData projectData = given()
                .spec(requestSpec)
                .body(writerMapperProject(projectDataCreate))
                .when()
                .post(DictonaryApiV1.PROJECTS.getPathApi())
                .then()
                .spec(responseSpec200)
                .extract().as(ProjectData.class);

        assertThat(projectData.getName()).isEqualTo(projectDataCreate.getName());

        return projectData;

    }
}
