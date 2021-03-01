package ru.coffee.nostresso.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    private UUID id;
    private UUID addressId;
    private String name;
    private String description;
    private String phone;
    private String img;
    private Double middleRate;
    private LocalDateTime dateUpdated;
}
