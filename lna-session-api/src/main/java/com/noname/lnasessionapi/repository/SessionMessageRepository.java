package com.noname.lnasessionapi.repository;

import com.noname.lnasessionapi.data.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SessionMessageRepository extends JpaRepository<Message, Long> {

    List<Message> getMessageBySessionId(UUID sessionId);

}