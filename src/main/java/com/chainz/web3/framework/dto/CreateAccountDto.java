package com.chainz.web3.framework.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateAccountDto {

    @ToString
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request {
        private String userId;

        @Builder
        public Request(String userId) {
            this.userId = userId;
        }
    }
    @ToString
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private String userId;
        private String address;
    }
}
