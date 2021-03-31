package ru.coffee.nostresso.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private UUID id;
    private String name;
    private String volume;
    private Long cost;
    private LocalDateTime dateUpdated;
    private UUID shopId;
}
