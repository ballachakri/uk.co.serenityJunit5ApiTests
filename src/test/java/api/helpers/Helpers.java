package api.helpers;

import api.model.bookingdetails.BookingDetails;
import api.model.bookingdetails.Bookingdates;
import api.model.createBooking.CreateBooking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helpers {

    public static String getCreateBookingRequestBody(String firstName, String lastName) {

        ObjectMapper objectMapper = new ObjectMapper();

        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setFirstname(firstName);
        bookingDetails.setLastname(lastName);
        bookingDetails.setDepositpaid(true);
        bookingDetails.setTotalprice(200);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-01-01");
        bookingdates.setCheckout("2024-01-04");
        bookingDetails.setAdditionalneeds("Breakfast");
        bookingDetails.setBookingdates(bookingdates);

        try {
            return objectMapper.writeValueAsString(bookingDetails);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
