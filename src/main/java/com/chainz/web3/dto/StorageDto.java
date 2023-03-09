package com.chainz.web3.dto;

import lombok.Data;

@Data
public class StorageDto {
    private String providerCode;
    private String from;
    private String contractAddress;
    private Integer number;
    private String transactionHash;
}
