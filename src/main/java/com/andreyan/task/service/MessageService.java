package com.andreyan.task.service;


import com.andreyan.task.model.Message;


public interface MessageService {
    Message createMessage(String type, String messagePayload);
}
