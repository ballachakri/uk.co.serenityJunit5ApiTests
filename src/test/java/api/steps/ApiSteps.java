package api.steps;

import api.helpers.Helpers;
import api.model.bookingIdsList.BookingIdsList;
import api.model.createBooking.CreateBooking;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;

import net.serenitybdd.core.steps.UIInteractions;

import net.serenitybdd.rest.SerenityRest;
import org.assertj.core.api.Assertions;


public class ApiSteps extends UIInteractions {

    final static String BASE_URL = "https://restful-booker.herokuapp.com";

    @Step("Get response")
    public Response getResponse(String basePath) {

        return SerenityRest.given()
                .baseUri(BASE_URL)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .thenReturn();
    }

    @Step("Create booking")
    public Response createBooking(String basePath, String firstName, String lastName) {

        String body = Helpers.getCreateBookingRequestBody(firstName, lastName);

        return SerenityRest.given()
                .filter(new RequestLoggingFilter()).filter(new ResponseLoggingFilter())
                .baseUri(BASE_URL)
                .basePath(basePath)
                .accept("*/*")
                .contentType("application/json")
                .when()
                .body(body)
                .post()
                .thenReturn();

    }

    @Step("Verify response code '{1}'")
    public void verifyResponseCode(Response response, int statusCode) {
        Assertions.assertThat(response.statusCode()).isEqualTo(statusCode);

    }

    @Step("Verify booking details list is returned")
    public void verifyBookingDetailsListIsReturned(Response response) {
        BookingIdsList[] bookingIdsList = response.getBody().as(BookingIdsList[].class);
        Assertions.assertThat(bookingIdsList.length).isGreaterThan(1);
    }

    @Step("Verify booking is created")
    public void verifyBookingIsCreated(Response response, String firstName, String lastName) {
        CreateBooking createBooking = response.getBody().as(CreateBooking.class);


        Assertions.assertThat(createBooking.booking.firstname).isEqualToIgnoringCase(firstName);
        Assertions.assertThat(createBooking.booking.lastname).isEqualToIgnoringCase(lastName);
    }
}
