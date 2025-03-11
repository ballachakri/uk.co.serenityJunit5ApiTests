package api.model.bookingIdsList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookingid"
})
public class BookingIdsList {

    @JsonProperty("bookingid")
    public Integer bookingid;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

}