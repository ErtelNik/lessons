import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("Postman Echo API Tests")
@Feature("HTTP Methods")

public class PostmanEchoTests {

    private final String BASE_URL = "https://postman-echo.com/";

    @Test
    @DisplayName("GET Request Test")
    @Description("Verify that GET request to postman-echo returns expected results")
    public void getRequestTest() {
        given()
                .spec(PostmanEchoSpec.requestSpecification())
                .when()
                .get("get?foo1=bar1&foo2=bar2")
                .then()
                .body("args.foo1", is("bar1"))
                .body("args.foo2", is("bar2"))
                .statusCode(200)
                .log().all();
    }

    @Test
    @DisplayName("POST Form Data Test")
    @Description("Verify that POST request with form data returns expected results")
    public void postRequestFromData() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post(BASE_URL + "post")
                .then()
                .statusCode(200)
                .body("form.foo1", is("bar1"))
                .body("form.foo2", is("bar2"))
                .log().all();
    }

    @Test
    @DisplayName("POST Raw Text Test")
    @Description("Verify that POST request with raw text returns expected results")
    public void postRequestRawText() {
        given()
                .when()
                .body("This is expected to be sent back as part of response body.")
                .post(BASE_URL + "post")
                .then()
                .statusCode(200)
                .body("data", containsString("This is expected to be sent back as part of response body."))
                .log().all();
    }

    @Test
    @DisplayName("PUT Request Test")
    @Description("Verify that PUT request returns expected results")
    public void putRequestTest() {
        given()
                .spec(PostmanEchoSpec.requestSpecification())
                .when()
                .body("This is expected to be sent back as part of response body.")
                .put("put")
                .then()
                .spec(PostmanEchoSpec.responseSpecification())
                .log().all();
    }

    @Test
    @DisplayName("PATCH Request Test")
    @Description("Verify that PATCH request returns expected results")
    public void patchRequestTest() {
        given()
                .spec(PostmanEchoSpec.requestSpecification())
                .when()
                .body("This is expected to be sent back as part of response body.")
                .patch("patch")
                .then()
                .spec(PostmanEchoSpec.responseSpecification())
                .log().all();
    }

    @Test
    @DisplayName("DELETE Request Test")
    @Description("Verify that DELETE request returns expected results")
    public void deleteRequestTest() {
        given()
                .spec(PostmanEchoSpec.requestSpecification())
                .when()
                .body("This is expected to be sent back as part of response body.")
                .delete("delete")
                .then()
                .spec(PostmanEchoSpec.responseSpecification())
                .log().all();
    }
}
