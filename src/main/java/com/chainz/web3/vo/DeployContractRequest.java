package com.chainz.web3.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class DeployContractRequest {
    @Schema(description = "사업자 구분코드(min: 1, MAX: 50)", example = "TEST1234")
    @NotNull(message= "providerCode cannot be null")
    @Size(min = 1, max = 50, message= "providerCode must be equal or greater than 1 characters and less than 50 characters")
    private String providerCode;

    @Schema(description = "Transaction에 서명할 계정 주소", example = "0xd9892f1023ca38e8d46921c1e0813a922bf485f1")
    @NotNull(message= "from cannot be null")
    @Size(min = 42, max = 42, message= "from must be equal 42 characters")
    private String from;
}
