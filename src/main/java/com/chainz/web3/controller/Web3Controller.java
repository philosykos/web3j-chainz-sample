package com.chainz.web3.controller;

import com.chainz.web3.dto.AccountDto;
import com.chainz.web3.dto.ContractDto;
import com.chainz.web3.dto.StorageDto;
import com.chainz.web3.framework.dto.TransactionResult;
import com.chainz.web3.service.Web3Service;
import com.chainz.web3.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
@Slf4j
public class Web3Controller {
    private final Web3Service web3Service;

    @Operation(summary = "SKS의 Ethereum 계정 생성", description = "Service Key Service를 통해 Ethereum 계정 생성")
    @PostMapping(value="/createAccount")
    public ResponseEntity<CreateAccountResponse> createAccount(@RequestBody CreateAccountRequest request) {
        ModelMapper mapper = new ModelMapper();

        AccountDto accountDto = mapper.map(request, AccountDto.class);
        web3Service.createAccount(accountDto);

        CreateAccountResponse response = mapper.map(accountDto, CreateAccountResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Smart Contract 배포", description = "Transaction Manager를 통해 Store Contract 배포")
    @PostMapping(value="/deployContract")
    public ResponseEntity<TransactionResponse> deployContract(@RequestBody DeployContractRequest request) {
        ModelMapper mapper = new ModelMapper();

        ContractDto contractDto = mapper.map(request, ContractDto.class);
        web3Service.deployContract(contractDto);

        TransactionResponse response = mapper.map(contractDto, TransactionResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Transaction 처리 결과 조회", description = "Transaction Manager를 통해 Transaction 처리 결과 조회")
    @GetMapping(value="/getTransactionResult")
    public ResponseEntity<TransactionResult.Message> getTransactionResult(
            @RequestParam(value= "providerCode")
            String providerCode,
            @RequestParam(value= "transactionHash")
            String transactionHash
    ) {
        TransactionResult.Message response = web3Service.getTransactionResult(providerCode, transactionHash);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Store Transaction 요청", description = "Transaction Manager를 통해 Store Transaction 요청")
    @PostMapping(value="/store")
    public ResponseEntity<TransactionResponse> store(@RequestBody StoreRequest request) {
        ModelMapper mapper = new ModelMapper();

        StorageDto storageDto = mapper.map(request, StorageDto.class);
        web3Service.store(storageDto);

        TransactionResponse response = mapper.map(storageDto, TransactionResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Retrieve 함수 호출", description = "Transaction Manager를 통해 Retrieve 함수 호출")
    @GetMapping(value="/retrieve")
    public ResponseEntity<RetrieveResponse> retrieve(
        @RequestParam(value= "providerCode")
        String providerCode,
        @RequestParam(value= "from")
        String from,
        @RequestParam(value= "contractAddress")
        String contractAddress
    ) {
        ModelMapper mapper = new ModelMapper();

        StorageDto storageDto = new StorageDto();
        storageDto.setProviderCode(providerCode);
        storageDto.setFrom(from);
        storageDto.setContractAddress(contractAddress);

        web3Service.retrieve(storageDto);

        RetrieveResponse response = mapper.map(storageDto, RetrieveResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
