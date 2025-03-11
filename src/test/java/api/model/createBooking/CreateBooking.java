package api.model.createBooking;

import api.model.bookingdetails.BookingDetails;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;


import java.util.LinkedHashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookingid",
        "booking"
})
public class CreateBooking {

    @JsonProperty("bookingid")
    public Integer bookingid;
    @JsonProperty("booking")
    public BookingDetails booking;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}