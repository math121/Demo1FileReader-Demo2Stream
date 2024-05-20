package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Person(
        int id,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        String email,
        String gender,
        @JsonProperty("catch_phrase")
        String catchPhrase,
        String color
) {
}
