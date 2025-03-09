package com.noname.lnasessionapi.util;

import com.noname.lnasessionapi.data.Message;
import com.noname.lnasessionapi.data.Session;
import com.noname.lnasessionapi.data.enumerated.Role;
import com.noname.lnasessiondto.MessageDTO;
import com.noname.lnasessiondto.SessionMessagesResponseDTO;
import com.noname.lnasessiondto.SessionResponseDTO;
import com.noname.lnasessiondto.enumerated.MessageAuthor;
import lombok.NonNull;

import java.util.List;

public class MappingUtils {

    @NonNull
    public static SessionResponseDTO sessionToSessionResponseDTO(final Session session) {
        return SessionResponseDTO.builder()
                .sessionId(session.getId())
                .sessionName(session.getSessionName())
                .build();
    }

    @NonNull
    public static SessionMessagesResponseDTO sessionToSessionMessagesResponseDTO(final Session sessionWithMessages, List<Message> sessionMessages) {
        return SessionMessagesResponseDTO.builder()
                .sessionId(sessionWithMessages.getId())
                .sessionName(sessionWithMessages.getSessionName())
                .messages(sessionMessages
                        .stream()
                        .map(MappingUtils::messageToMessageDTO)
                        .toList())
                .build();
    }

    @NonNull
    public static MessageDTO messageToMessageDTO(final Message message) {
        return MessageDTO.builder()
                .content(message.getContent())
                .sender(MessageAuthor.valueOf(message.getRole().name()))
                .build();
    }

    @NonNull
    public static Message messageDTOToMessage(final MessageDTO messageDTO) {
        return Message.builder()
                .sessionId(messageDTO.getSessionId())
                .role(Role.valueOf(messageDTO.getSender().name()))
                .content(messageDTO.getContent())
                .build();
    }

}