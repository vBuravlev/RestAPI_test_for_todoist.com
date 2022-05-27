package api.specifications;

import api.config.Project;
import api.helpers.HelperParameters;
import api.listeners.CustomAllureListener;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;


import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.with;

public class Specification implements HelperParameters {

    static final String BASE_URL = Project.config.urlRestTest();

    public static RequestSpecification requestSpec = with()
            .filters(CustomAllureListener.withCustomTemplates())
            .baseUri(BASE_URL)
            .header("Authorization", "Bearer " + Project.config.token())
            .contentType(ContentType.JSON)
            .log().body();

    public static ResponseSpecification responseSpec200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(Matchers.lessThan(MAX_TIMEOUT_RESPONSE), TimeUnit.MILLISECONDS)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification responseSpec204 = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .expectResponseTime(Matchers.lessThan(MAX_TIMEOUT_RESPONSE), TimeUnit.MILLISECONDS)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification responseSpec400 = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .expectResponseTime(Matchers.lessThan(MAX_TIMEOUT_RESPONSE), TimeUnit.MILLISECONDS)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification responseSpec404 = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .expectResponseTime(Matchers.lessThan(MAX_TIMEOUT_RESPONSE), TimeUnit.MILLISECONDS)
            .log(LogDetail.BODY)
            .build();

}