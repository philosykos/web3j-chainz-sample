package com.chainz.web3.vo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class DeployContractRequest {
    @NotNull(message= "providerCode cannot be null")
    @Size(min = 1, max = 50, message= "providerCode must be equal or greater than 1 characters and less than 50 characters")
    private String providerCode;

    @NotNull(message= "from cannot be null")
    @Size(min = 42, max = 42, message= "from must be equal 42 characters")
    private String from;
}
