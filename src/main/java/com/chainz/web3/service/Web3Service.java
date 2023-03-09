package com.chainz.web3.service;

import com.chainz.web3.dto.AccountDto;
import com.chainz.web3.dto.ContractDto;
import com.chainz.web3.dto.StorageDto;
import com.chainz.web3.framework.dto.TransactionResult;

public interface Web3Service {

    AccountDto createAccount(AccountDto accountDto);
    ContractDto deployContract(ContractDto contractDto);
    TransactionResult.Message getTransactionResult(String providerCode, String transactionHash);
    StorageDto store(StorageDto storageDto);

    StorageDto retrieve(StorageDto storageDto);
}
