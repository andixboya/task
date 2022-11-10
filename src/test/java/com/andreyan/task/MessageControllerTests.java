package com.andreyan.task;

import com.andreyan.task.model.Message;
import com.andreyan.task.rest.MessageController;
import com.andreyan.task.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static com.andreyan.task.constant.Keywords.SEND_TEXT;
import static com.andreyan.task.model.MessageType.TEXT;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class MessageControllerTests {

    @MockBean
    public MessageService messageService;

    public MessageController messageController;

    @BeforeEach
    public void setUp() {
        messageController = new MessageController(messageService);
    }

    @Test
    void createValidResponse() {
        String anyText = "hahahaha";
        var expected = ResponseEntity.status(HttpStatus.CREATED).build();
        var returnMessage = new Message()
                .setType(TEXT)
                .setPayload(anyText)
                .setCreatedAt(LocalDateTime.now())
                .setId(null);
        Mockito.when(messageService.createMessage(SEND_TEXT, anyText)).thenReturn(returnMessage);
        var actual = messageController.sendText(SEND_TEXT, anyText);
        assertEquals(expected.getBody(), actual.getBody());
        assertEquals(expected.getStatusCode(), actual.getStatusCode());
    }


}
