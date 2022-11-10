package com.andreyan.task.dto;

import com.andreyan.task.exception.MessageException;

import static com.andreyan.task.constant.ErrorMessages.INVALID_MESSAGE_TYPE;
import static com.andreyan.task.constant.Keywords.SEND_EMOTION;
import static com.andreyan.task.constant.Keywords.SEND_TEXT;

public class MessageFactory {

    public static MessagePayload generateMessage(String messageEndpoint, String payload) {

        MessagePayload message;
        switch (messageEndpoint) {
            case SEND_EMOTION:
                message = new EmotionMessagePayload(payload);
                break;
            case SEND_TEXT:
                message = new TextMessagePayload(payload);
                break;
            default:
                throw new MessageException(INVALID_MESSAGE_TYPE);
        }
        return message;

    }

}
