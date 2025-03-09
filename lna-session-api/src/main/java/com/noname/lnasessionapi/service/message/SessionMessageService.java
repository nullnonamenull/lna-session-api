package com.noname.lnasessionapi.service.message;

import com.noname.lnasessionapi.util.MappingUtils;
import com.noname.lnasessiondto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionMessageService {

    private final SessionMessageOperationService sessionMessageOperationService;


    public void addSessionsMessage(final MessageDTO messageDTO) {
        sessionMessageOperationService.saveSessionMessage(MappingUtils.messageDTOToMessage(messageDTO));
    }
}