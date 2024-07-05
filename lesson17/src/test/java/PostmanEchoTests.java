import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static jdk.javadoc.doclet.DocletEnvironment.ModuleMode.API;
import static org.hamcrest.Matchers.*;


public class PostmanEchoTests {

    private final String BASE_URL = "https://postman-echo.com/";

    @Test
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
    public void postRequestFromData() {
        given().
                contentType("application/x-www-form-urlencoded").
                formParam("foo1", "bar1").
                formParam("foo2", "bar2").
                when().
                post(BASE_URL+"post").
                then().
                statusCode(200).
                body("form.foo1", is("bar1")).
                body("form.foo2", is("bar2")).
                log().all();
    }

    @Test
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
    public void  deleteRequestTest() {

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
