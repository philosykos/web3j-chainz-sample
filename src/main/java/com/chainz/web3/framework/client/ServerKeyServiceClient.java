package com.chainz.web3.framework.client;

import com.chainz.web3.framework.dto.CreateAccountDto;
import com.chainz.web3.framework.dto.CreateAccountDto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="sksClient", url = "http://localhost:8100")
public interface ServerKeyServiceClient {

    @PostMapping(value="/accounts")
    Response createAccount(@RequestHeader("x-service-provider") String providerCode, @RequestBody CreateAccountDto.Request request);
}
