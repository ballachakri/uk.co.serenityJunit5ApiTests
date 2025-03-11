package api.model.auth;

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
"username",
"password"
})

public class AuthToken {

@JsonProperty("username")
public String username;
@JsonProperty("password")
public String password;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<>();

}