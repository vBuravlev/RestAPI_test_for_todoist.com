package api;

import api.config.Project;
import api.helpers.HelperParameters;
import api.helpers.Cleaner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.*;
import static api.listeners.CustomAllureListener.withCustomTemplates;

public class TestBase implements HelperParameters, Cleaner {

    @BeforeAll
    static void beforeAll() {
        filters(withCustomTemplates());
        baseURI = Project.config.urlRestTest();
    }

    @BeforeEach
    void beforeEach() {
        Cleaner.clearListTasksAndProjects();
    }

    @AfterEach
    void afterEach() {
        Cleaner.clearListTasksAndProjects();
    }

    @AfterAll
    static void afterAll() {
        Cleaner.clearListTasksAndProjects();
    }


}
