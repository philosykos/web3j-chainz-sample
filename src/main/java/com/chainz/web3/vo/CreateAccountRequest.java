package com.chainz.web3.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAccountRequest {
    @Schema(description = "사업자 구분코드(min: 1, MAX: 50)", example = "TEST1234")
    @NotNull(message= "providerCode cannot be null")
    @Size(min = 1, max = 50, message= "providerCode must be equal or greater than 1 characters and less than 50 characters")
    private String providerCode;

    @Schema(description = "EOA 계정에 매핑된 사용자 ID(min: 1, MAX: 50)", example = "user01")
    @NotNull(message= "userId cannot be null")
    @Size(min = 1, max = 50, message= "userId must be equal or greater than 1 characters and less than 50 characters")
    private String userId;
}