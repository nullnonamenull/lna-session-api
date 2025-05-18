package com.noname.lnasessionapi.data;

import com.noname.lnasessiondto.enumerated.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private OffsetDateTime sentAt;

    @Column(nullable = false)
    private UUID sessionId;

    @PrePersist
    private void onCreate() {
        if (sentAt == null) {
            sentAt = OffsetDateTime.now();
        }
    }
}