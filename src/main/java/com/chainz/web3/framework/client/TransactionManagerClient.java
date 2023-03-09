package com.chainz.web3.framework.client;

import com.chainz.web3.framework.dto.CallFunctionDto;
import com.chainz.web3.framework.dto.SendTransactionDto;
import com.chainz.web3.framework.dto.TransactionResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="transactionManagerClient", url="https://dev-utility.chainz.biz/tx-manager")
public interface TransactionManagerClient {

    @PostMapping(value="/transactions")
    SendTransactionDto.Response sendTransaction(@RequestHeader("x-service-provider") String providerCode, @RequestBody SendTransactionDto.Request request);

    @GetMapping(value="/transactions/{id}")
    TransactionResult.Message getTransactionResult(@RequestHeader("x-service-provider") String providerCode, @PathVariable String id);

    @PostMapping(value="/extension/web3-api/call")
    CallFunctionDto.Response callFunction(@RequestHeader("x-service-provider") String providerCode, @RequestBody CallFunctionDto.Request request);
}
