package com.noname.lnasessionapi.service.message;

import com.noname.lnasessionapi.data.Message;
import com.noname.lnasessionapi.repository.SessionMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionMessageRetrievalService {

    private final SessionMessageRepository sessionMessageRepository;

    public List<Message> retrieveAllSessionMessages(final UUID sessionId) {
        return sessionMessageRepository.getMessageBySessionId(sessionId);
    }

}