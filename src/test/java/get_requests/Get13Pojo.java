package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;
import test_data.GoRestTestData;

import static io.restassured.RestAssured.given;

public class Get13Pojo extends GoRestBaseUrl {

    /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
            "meta": null,
            "data": {
                "id": 2508,
                "name": "Sharmila Deshpande VM",
                "email": "deshpande_sharmila_vm@becker.name",
                "gender": "female",
                "status": "active"
                 }
          }
    */

    @Test
    public void get13Pojo() {
        //Set the Url
        spec.pathParams("first","users","second",2508);

        //Set the Expected Data
        GoRestDataPojo goRestDataPojo =new GoRestDataPojo(2508,"Sharmila Deshpande VM","deshpande_sharmila_vm@becker.name","female","active");
        GoRestPojo expectedData = new GoRestPojo(null,goRestDataPojo);
        System.out.println("expectedData = " + expectedData);

        //Send the Request and Get the Response
        Response response =given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
       GoRestPojo actualData = response.as(GoRestPojo.class);




    }
}
