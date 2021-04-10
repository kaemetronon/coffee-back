package ru.coffee.nostresso.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private UUID id;
    private UUID shopId;
    private UUID userId;
    private String description;
    private Long rate;
    private LocalDateTime dateUpdated;
}
