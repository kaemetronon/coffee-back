package ru.coffee.nostresso.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private UUID id;
    private String description;
    private Integer rate;
    private LocalDateTime dateUpdated;
    private UUID shopId;
    private UUID userId;

}
