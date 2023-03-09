package com.chainz.web3.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateAccountResponse {
    @Schema(description = "EOA 계정에 매핑된 사용자 ID(min: 1, MAX: 50)", example = "user01")
    private String userId;
    @Schema(description = "EOA 계정 주소", example = "0xd9892f1023ca38e8d46921c1e0813a922bf485f1")
    private String address;
}