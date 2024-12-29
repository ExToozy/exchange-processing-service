package ru.extoozy.processing.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddAccountMoneyDto {

    private String uuid;

    @JsonProperty("account_id")
    private Long accountId;

    private BigDecimal amount;

}
