package api.helpers.api.task;

import api.domain.TaskData;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public interface CheckTask {

    @Step("Отправляем запрос проверку что существует задача с заданным именем")
    public static void checkContentTask(String content) {

        List<TaskData> tasks = GetActiveTasks.getTaskList().stream().filter(taskData -> taskData.getContent().equals(content)).collect(Collectors.toList());
        assertThat(tasks.toArray()).isNotEmpty();
    }

    @Step("Отправляем запрос на проверку, что задача не существует (удалена)")
    public static void checkDeleteTask(String taskId) {
        GetActiveTasks.getTask404(taskId);
    }


    @Step("Отправляем запрос на проверку статуса задачи")
    public static void checkStatusTask(long taskId, boolean bool) {
        assertThat(GetActiveTasks.getTask(taskId).isCompleted()).isEqualTo(bool);
    }

    @Step("Отправляем запрос на проверку контента задачи")
    public static void checkContentTask(long taskId, String content) {
        assertThat(GetActiveTasks.getTask(taskId).getContent()).isEqualTo(content);
    }

}
