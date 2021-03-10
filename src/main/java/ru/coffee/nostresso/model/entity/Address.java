package ru.coffee.nostresso.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Long id;
    private String addressText;
    private LocalDateTime dateUpdated;
    private Double x;
    private Double y;
    private Long shopId;
}
