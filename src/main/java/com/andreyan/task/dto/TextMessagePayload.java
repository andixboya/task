package com.andreyan.task.dto;

import com.andreyan.task.exception.MessageException;
import com.andreyan.task.helper.Validator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import static com.andreyan.task.constant.ErrorMessages.INVALID_TEXT;
import static com.andreyan.task.model.MessageType.TEXT;

@Getter
@Setter
@RequiredArgsConstructor
public class TextMessagePayload extends MessagePayload {

    public TextMessagePayload(String payload) {
        this.payload = payload;
        this.type = TEXT;
    }

    /*@Size(min = 1, max = 160, message = INVALID_TEXT)*/
    @Override
    public String getPayload() {
        boolean isTextValid = Validator.isTextValid(".{1,160}", payload);
        if (isTextValid == false) throw new MessageException(INVALID_TEXT);
        return payload;
    }


}
