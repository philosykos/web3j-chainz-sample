package com.chainz.web3.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GetTransactionResultRequest {
    @Schema(description = "사업자 구분코드(min: 1, MAX: 50)", example = "TEST1234")
    @NotNull(message= "providerCode cannot be null")
    @Size(min = 1, max = 50, message= "providerCode must be equal or greater than 1 characters and less than 50 characters")
    private String providerCode;

    @Schema(description = "Transaction의 Hash값", example = "0x668f0a3fbd96a407f1821e7fb54346b808a3c9137b62f022a5b9061fa8732e18")
    @NotNull(message= "transactionHash cannot be null")
    @Size(min = 66, max = 66, message= "from must be equal 66 characters")
    private String transactionHash;
}
