package api.helpers;

import api.helpers.api.project.DeleteProject;
import api.helpers.api.project.GetProjects;
import api.helpers.api.task.DeleteTask;
import api.helpers.api.task.GetActiveTasks;
import io.qameta.allure.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public interface Cleaner {

    @Step("Очищаем список проектов и задач")
    public static void clearListTasksAndProjects() {
        //Очищаем все проекты и задачи перед тестом
        DeleteProject.deleteAllProject();
        DeleteTask.deleteAllTask();

        //Проверяем, что очистка прошла успешно
        assertThat(GetProjects.getProjectList().size()).isEqualTo(1);
        assertThat(GetActiveTasks.getTaskList().size()).isEqualTo(0);
    }
}
