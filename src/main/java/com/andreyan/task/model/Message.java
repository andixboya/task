package com.andreyan.task.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

//id, type, payload, created_at.
@Getter
@Setter
@Accessors(chain = true)
@Entity
@EqualsAndHashCode(exclude = {"createdAt"})
public class Message {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "message_sequence")
    @SequenceGenerator(name = "message_sequence", allocationSize = 5)
    Long id;

    String type;

    String Payload;

    @Column(name = "created_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime createdAt;
}
