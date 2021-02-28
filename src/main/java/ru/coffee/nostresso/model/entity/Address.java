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
public class Address {
    private UUID id;
    private String addressText;
    private LocalDateTime dateUpdated;
    private Double x;
    private Double y;
    private UUID shopId;
}
