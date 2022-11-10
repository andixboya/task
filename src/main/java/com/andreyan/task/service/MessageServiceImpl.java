package com.andreyan.task.service;

import com.andreyan.task.dto.MessageFactory;
import com.andreyan.task.dto.MessagePayload;
import com.andreyan.task.model.Message;
import com.andreyan.task.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public Message createMessage(String type, String messagePayload) {
        MessagePayload payload = MessageFactory.generateMessage(type, messagePayload);
        Message newMsg = new Message()
                .setCreatedAt(LocalDateTime.now())
                .setPayload(payload.getPayload())
                .setType(payload.getType());
        return messageRepository.save(newMsg);
    }
}
