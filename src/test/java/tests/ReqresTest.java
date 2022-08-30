package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class ReqresTest {

    private static final RequestSpecification spec =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in")
                    .setBasePath("/api/users/")
                    .setContentType(ContentType.JSON)
                    .build();

    @Test(description = "Проверка статус-кода и имени пользователя при отправке get-запроса")
    public void userTest (){
        String userId = "2";
        String expectedName = "Janet";
        Response response = given()
                .spec(spec)
                .get(userId);
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        assertEquals(response.jsonPath().get("data.first_name"),  expectedName);
    }
}
