package com.andreyan.task.rest;

import com.andreyan.task.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/messages")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;


    @PostMapping(value = "/{type}")
    public ResponseEntity<Object> sendText(@PathVariable String type, @RequestParam String payload) {
        messageService.createMessage(type, payload);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}






