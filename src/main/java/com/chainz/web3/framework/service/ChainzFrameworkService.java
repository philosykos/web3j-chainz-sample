package com.chainz.web3.framework.service;

import com.chainz.web3.framework.dto.CreateAccountDto;
import com.chainz.web3.framework.dto.TransactionResult;

public interface ChainzFrameworkService {

    String deployContract(String provicerCode, String from);

    CreateAccountDto.Response createAccount(String providerCode, String userId);

    TransactionResult.Message getTransactionResult(String providerCode, String userId);

    String sendTransaction(String providerCode, String from, String to, String data);

    String callFunction(String providerCode, String from, String to, String data);
}
