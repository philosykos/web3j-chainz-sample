package com.chainz.web3.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TransactionResponse {
    @Schema(description = "Transaction의 Hash값", example = "0x668f0a3fbd96a407f1821e7fb54346b808a3c9137b62f022a5b9061fa8732e18")
    private String transactionHash;
}
