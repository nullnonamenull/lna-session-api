package com.noname.lnasessionapi.controller;

import com.noname.lnasessionapi.service.message.SessionMessageService;
import com.noname.lnasessiondto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/session/message/")
public class SessionMessageController {

    private final SessionMessageService sessionMessageService;

    @PostMapping
    public ResponseEntity<Void> addSessionsMessage(@RequestBody MessageDTO messageDTO) {
        sessionMessageService.addSessionsMessage(messageDTO);
        return ResponseEntity.ok().build();
    }
}
