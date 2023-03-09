package com.chainz.web3.dto;

import lombok.Data;

@Data
public class ContractDto {
    private String providerCode;
    private String from;
    private String transactionHash;
}
