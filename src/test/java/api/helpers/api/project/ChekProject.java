package api.helpers.api.project;

import api.domain.ProjectData;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public interface ChekProject {

    @Step("Отправляем запрос проверку что существует проект с заданным именем")
    public static void checkNameProjectInAccount(String projectName) {

        List<ProjectData> projects = GetProjects.getProjectList().stream().filter(projectData -> projectData.getName().equals(projectName)).collect(Collectors.toList());
        assertThat(projects.toArray()).isNotEmpty();

    }

    @Step("Отправляем запрос на проверку, что проект не существует (удален)")
    public static void checkDeleteProject(long projectId) {
        GetProjects.getProject404(projectId);
    }
}
