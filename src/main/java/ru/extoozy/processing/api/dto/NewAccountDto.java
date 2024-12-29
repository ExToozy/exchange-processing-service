package ru.extoozy.processing.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NewAccountDto {

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("user_id")
    private Long userId;

}
