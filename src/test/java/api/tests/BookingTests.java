package api.tests;

import api.steps.ApiSteps;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class BookingTests {

    String firstName = RandomStringUtils.randomAlphanumeric(7);

    String lastName = RandomStringUtils.randomAlphanumeric(7);
    @Steps
    ApiSteps apiSteps;

    @Test
    @DisplayName("Get all bookings")
    public void getAllBookings() {

        Response response = apiSteps.getResponse("/booking");
        apiSteps.verifyResponseCode(response, 200);
        apiSteps.verifyBookingDetailsListIsReturned(response);
    }

    @Test
    @DisplayName("Create booking")
    public void createBookings() {

        Response response = apiSteps.createBooking("/booking", firstName, lastName);

        apiSteps.verifyResponseCode(response, 200);
        apiSteps.verifyBookingIsCreated(response, firstName,lastName);
    }
}
