package com.chainz.web3.vo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GetTransactionResultRequest {
    @NotNull(message= "providerCode cannot be null")
    @Size(min = 1, max = 50, message= "providerCode must be equal or greater than 1 characters and less than 50 characters")
    private String providerCode;

    @NotNull(message= "transactionHash cannot be null")
    @Size(min = 66, max = 66, message= "from must be equal 66 characters")
    private String transactionHash;
}
