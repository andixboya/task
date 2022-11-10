package com.andreyan.task;

import com.andreyan.task.exception.MessageException;
import com.andreyan.task.model.Message;
import com.andreyan.task.repository.MessageRepository;
import com.andreyan.task.service.MessageService;
import com.andreyan.task.service.MessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static com.andreyan.task.constant.Keywords.SEND_EMOTION;
import static com.andreyan.task.constant.Keywords.SEND_TEXT;
import static com.andreyan.task.model.MessageType.EMOTION;
import static com.andreyan.task.model.MessageType.TEXT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
class MessageServiceTests {
    public MessageService messageService;

    @MockBean
    public MessageRepository messageRepository;


    @BeforeEach
    public void setUp() {
        messageService = new MessageServiceImpl(messageRepository);
    }

    @Test
    void createValidTextMessage() {
        String expectedPayload = "valid text";
        String expectedType = TEXT;
        String pathVariable = SEND_TEXT;
        Message expected = createMessage(expectedType, expectedPayload);
        Mockito.when(messageRepository.save(expected)).thenReturn(expected);
        Message actual = messageService.createMessage(pathVariable, expectedPayload);
        assertEquals(expected, actual);
    }

    @Test
    void createValidEmotionMessage() {
        String expectedPayload = "emojiii";
        String expectedType = EMOTION;
        String pathVariable = SEND_EMOTION;
        Message expected = createMessage(expectedType, expectedPayload);
        Mockito.when(messageRepository.save(expected)).thenReturn(expected);
        Message actual = messageService.createMessage(pathVariable, expectedPayload);
        assertEquals(expected, actual);
    }

    @Test
    void createInvalidEmotionMessage() {
        String invalidNumbers = "1325";
        assertThrows(MessageException.class, () -> messageService.createMessage(SEND_EMOTION, invalidNumbers));

        String insufficientSymbols = "a";
        assertThrows(MessageException.class, () -> messageService.createMessage(SEND_EMOTION, insufficientSymbols));
    }

    @Test
    void createInvalidTextMessage() {
        String invalidNumbers = "";
        assertThrows(MessageException.class, () -> messageService.createMessage(SEND_TEXT, invalidNumbers));
    }


    public Message createMessage(String type, String payload) {
        return new Message()
                .setType(type)
                .setPayload(payload)
                .setCreatedAt(LocalDateTime.now())
                .setId(null);
    }

}
