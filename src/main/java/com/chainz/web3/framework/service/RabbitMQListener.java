package com.chainz.web3.framework.service;

import com.chainz.web3.framework.dto.TransactionResult;
import com.chainz.web3.framework.dto.TransactionResult.Message;
import com.chainz.web3.framework.dto.TransactionStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQListener {

//    private final ObjectMapper objectMapper;
//
//    @RabbitListener(queues = {})
//    public void receiveMessage(final String message) throws Exception {
//        try {
//            log.debug("Receive Queue Message. Message = {}", message);
//            TransactionResult.Message txMessage = objectMapper.readValue(message, Message.class);
//
//            if(txMessage.getTransactionStatus().equals(TransactionStatus.SUCCESS)) {
//                // 성공 처리
//                log.debug("txMessage = {}", txMessage);
//            } else {
//                // 실패 처리
//            }
//        } catch (Exception e) {
//            // 에러 처리
//            throw new Exception(e);
//        }
//    }
}
