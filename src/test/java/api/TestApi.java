package api;

import api.dictonary.DictonaryLanguage;
import api.dictonary.DictonaryPriority;
import api.domain.ProjectData;
import api.domain.TaskData;
import api.helpers.FakerHelper;
import api.helpers.api.project.ChekProject;
import api.helpers.api.project.CreateNewProject;
import api.helpers.api.project.UpdateProject;
import api.helpers.api.task.*;
import io.qameta.allure.Owner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestApi extends TestBase implements ChekProject, CheckTask, FakerHelper {

    @Test
    @DisplayName("Создание нового проекта")
    @Owner("buravlev")
    @Tag("API")
    public void createNewProject() {

        //Создаем новый проект
        String projectName = FakerHelper.createRandomName(5);
        CreateNewProject.createProject(projectName);

        //Проверяем, что создан проект с таким именем
        ChekProject.checkNameProjectInAccount(projectName);

    }

    @Test
    @DisplayName("Обновление проекта")
    @Owner("buravlev")
    @Tag("API")
    public void updateProject() {

        //Создаем новый проект
        String projectName = FakerHelper.createRandomName(5);
        ProjectData projectData = CreateNewProject.createProject(projectName);

        //Проверяем, что создан проект с таким именем
        ChekProject.checkNameProjectInAccount(projectName);

        //Изменяем имя проекта
        String newProjectName = FakerHelper.createRandomName(5);
        projectData.setName(newProjectName);
        UpdateProject.updateProject(projectData);

        //Проверяем, что имя обновилось
        assertThat(projectData.getName()).isNotEqualTo(projectName);

    }

    @Test
    @DisplayName("Создание новой задачи в проекте")
    @Owner("buravlev")
    @Tag("API")
    public void createNewTask() {

        //Создаем имена проекта, задачи и задаем дедлайн
        String projectName = FakerHelper.createRandomName(5);
        String taskContent = FakerHelper.createRandomName(5);
        String taskDeadLine = "tomorrow at 12:00";

        //Создаем и проверяем, что проект с заданным именем создан
        ProjectData projectData = CreateNewProject.createProject(projectName);
        ChekProject.checkNameProjectInAccount(projectName);

        //Создаем и проверяем, что задача с заданным именем создается в проекте
        TaskData taskData = CreateNewTask.createNewTaskInProject(DictonaryLanguage.EN.getPathApi(), taskContent, DictonaryPriority.FOUR.getPathApi(), taskDeadLine, projectData.getId());
        CheckTask.checkContentTask(taskData.getContent());
    }


    @Test
    @DisplayName("Закрытие задачи и ее переоткрытие")
    @Owner("buravlev")
    @Tag("API")
    public void closeAndReopenTask() {

        //Создаем задачу и проверяем,что она создалась с нужными параметрами
        String taskContent = FakerHelper.createRandomName(5);
        String taskDeadLine = "tomorrow at 12:00";
        TaskData taskData = CreateNewTask.createNewTask(DictonaryLanguage.EN.getPathApi(), taskContent, DictonaryPriority.FOUR.getPathApi(), taskDeadLine);
        assertThat(GetActiveTasks.getTask(taskData.getId()).getContent()).isEqualTo(taskContent);
        assertThat(GetActiveTasks.getTask(taskData.getId()).getDue().getString()).isEqualTo(taskDeadLine);

        //Закрываем задачу
        CloseTask.closeTask(String.valueOf(taskData.getId()));
        CheckTask.checkStatusTask(taskData.getId(), true);

        //Переоткрываем задачу
        ReopenTask.reopenTask(String.valueOf(taskData.getId()));
        CheckTask.checkStatusTask(taskData.getId(), false);
    }


    @Test
    @DisplayName("Создание большого количества задач в проекте и выборочное удаление задачи")
    @Owner("buravlev")
    @Tag("API")
    public void createPlentyTask() {

        //Задаем дедлайн для выполнения задач
        String taskDeadLine = "tomorrow at 12:00";
        //Задаем нужно количество задач
        int quantityTaskMax = 20;

        //Создаем заданное количество задач
        for (int quantityTasks = 0; quantityTasks < quantityTaskMax; quantityTasks++) {
            TaskData taskData = CreateNewTask.createNewTask(DictonaryLanguage.EN.getPathApi(), FakerHelper.createRandomName(5) + quantityTasks, DictonaryPriority.FOUR.getPathApi(), taskDeadLine);
            CheckTask.checkContentTask(taskData.getContent());
        }

        //Проверяем, что создано заданное количество задач и проверяем
        int quantityTasksList = GetActiveTasks.getTaskList().size();
        Assertions.assertThat(quantityTasksList).isEqualTo(quantityTaskMax);

        //Удаляем одну рандомную задачу из списка и проверяем, что она удалена
        DeleteTask.deleteTask(String.valueOf(GetActiveTasks.getTaskList().get(FakerHelper.createRandomInt(quantityTaskMax)).getId()));
        assertThat(GetActiveTasks.getTaskList().size()).isEqualTo(quantityTasksList - 1);

    }


}




