package com.chainz.web3.vo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RetrieveRequest {
    @NotNull(message= "providerCode cannot be null")
    @Size(min = 1, max = 50, message= "providerCode must be equal or greater than 1 characters and less than 50 characters")
    private String providerCode;

    @NotNull(message= "serviceName cannot be null")
    @Size(min = 64, max = 64, message= "serviceName must be equal or greater than 1 characters and less than 50 characters")
    private String from;

    @Size(min = 64, max = 64)
    private String contractAddress;
}
