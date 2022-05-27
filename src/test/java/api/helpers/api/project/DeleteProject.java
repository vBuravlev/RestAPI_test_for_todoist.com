package api.helpers.api.project;

import api.dictonary.DictonaryApiV1;
import api.domain.ProjectData;
import io.qameta.allure.Step;
import java.util.List;

import static api.specifications.Specification.*;
import static io.restassured.RestAssured.given;

public class DeleteProject {

    @Step("Отправляем запрос на удаление проекта")
    public static void deleteProject(String projectId) {
        given()
                .spec(requestSpec)
                .when()
                .delete(DictonaryApiV1.PROJECT.getPathApi() + projectId)
                .then()
                .spec(responseSpec204);

    }

    @Step("Отправка запроса на удаление всех проектов")
    public static void deleteAllProject() {
        List<ProjectData> projectsData = GetProjects.getProjectList();
        if (projectsData.size() > 1) {
            for (ProjectData projectData : projectsData) {
                DeleteProject.deleteProject(String.valueOf(projectData.getId()));
            }
        }
    }

}
