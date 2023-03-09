package com.chainz.web3.service;

import com.chainz.web3.dto.AccountDto;
import com.chainz.web3.dto.ContractDto;
import com.chainz.web3.dto.StorageDto;
import com.chainz.web3.framework.dto.CreateAccountDto;
import com.chainz.web3.framework.dto.TransactionResult;
import com.chainz.web3.framework.service.ChainzFrameworkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class Web3ServiceImpl implements Web3Service{
    private final ChainzFrameworkService chainzFrameworkService;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        CreateAccountDto.Response response = chainzFrameworkService.createAccount(accountDto.getProviderCode(), accountDto.getUserId());
        accountDto.setAddress(response.getAddress());
        return accountDto;
    }
    @Override
    public ContractDto deployContract(ContractDto contractDto) {
        contractDto.setTransactionHash(chainzFrameworkService.deployContract(contractDto.getProviderCode(), contractDto.getFrom()));
        return contractDto;
    }

    @Override
    public TransactionResult.Message getTransactionResult(String providerCode, String transactionHash) {
        return chainzFrameworkService.getTransactionResult(providerCode, transactionHash);
    }

    @Override
    public StorageDto store(StorageDto storageDto) {
        Function function = new Function(
            "store",
            Arrays.asList(new Uint256(storageDto.getNumber())),
            new ArrayList()
        );
        String data = FunctionEncoder.encode(function);

        storageDto.setTransactionHash(
            chainzFrameworkService.sendTransaction(storageDto.getProviderCode(),
                storageDto.getFrom(),
                storageDto.getContractAddress(),
                data
            )
        );
        return storageDto;
    }

    @Override
    public StorageDto retrieve(StorageDto storageDto) {
        Function function = new Function(
            "retrieve",
            new ArrayList(),
            Arrays.asList(new TypeReference<Uint256>() {})
        );
        String data = FunctionEncoder.encode(function);

        String response = chainzFrameworkService.callFunction(storageDto.getProviderCode(),
            storageDto.getFrom(),
            storageDto.getContractAddress(),
            data
        );

        List<Type> decode = FunctionReturnDecoder.decode(response, function.getOutputParameters());
        storageDto.setNumber( (Integer) decode.get(0).getValue() );

        return storageDto;
    }
}
