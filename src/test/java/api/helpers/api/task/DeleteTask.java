package api.helpers.api.task;

import api.dictonary.DictonaryApiV1;
import api.domain.TaskData;
import io.qameta.allure.Step;

import java.util.List;

import static api.specifications.Specification.requestSpec;
import static api.specifications.Specification.responseSpec204;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public interface DeleteTask {

    @Step("Отправка запроса на удаление задачи")
    public static void deleteTask(long taskId) {
        given()
                .spec(requestSpec)
                .when()
                .delete(DictonaryApiV1.TASK.getPathApi()+taskId)
                .then()
                .spec(responseSpec204);

    }

    @Step("Отправка запроса на удаление всех задач")
    public static void deleteAllTask() {
        List<TaskData> tasksData = GetActiveTasks.getTaskList();
        if (tasksData.size() > 0) {
            for (TaskData taskData : tasksData) {
                DeleteTask.deleteTask(taskData.getId());
            }
        }


    }
}
