package com.andreyan.task.dto;

import com.andreyan.task.exception.MessageException;
import com.andreyan.task.helper.Validator;

import lombok.Getter;
import lombok.Setter;

import static com.andreyan.task.constant.ErrorMessages.INVALID_EMOTION;
import static com.andreyan.task.model.MessageType.EMOTION;

@Getter
@Setter
public class EmotionMessagePayload extends MessagePayload {

    public EmotionMessagePayload(String payload) {
        this.payload = payload;
        this.type = EMOTION;
    }


    /*@Pattern(regexp = "[a-zA-Z]{2,10}", message = "Invalid error")*/

    @Override
    public String getPayload() {
        boolean isEmotionValid = Validator.isTextValid("[a-zA-Z]{2,10}", payload);
        if (isEmotionValid == false) throw new MessageException(INVALID_EMOTION);
        return payload;
    }
}
