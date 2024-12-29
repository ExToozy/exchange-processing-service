package ru.extoozy.processing.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeMoneyDto {

    @JsonProperty("exchange_id")
    private String exchangeUuid;

    @JsonProperty("from_id")
    private Long fromAccountId;

    @JsonProperty("to_id")
    private Long toAccountId;

    private BigDecimal amount;
}
