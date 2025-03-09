package com.noname.lnasessionapi.service.message;

import com.noname.lnasessionapi.data.Message;
import com.noname.lnasessionapi.repository.SessionMessageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionMessageOperationService {

    private final SessionMessageRepository sessionMessageRepository;

    @Transactional
    public Message saveSessionMessage(Message message) {
        return sessionMessageRepository.save(message);
    }

}
