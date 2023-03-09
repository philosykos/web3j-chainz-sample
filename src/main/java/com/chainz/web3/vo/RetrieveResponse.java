package com.chainz.web3.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RetrieveResponse {
    @Schema(description = "Smart Contract에 저장된 숫자", type = "Integer", example = "1")
    private Integer number;
}
