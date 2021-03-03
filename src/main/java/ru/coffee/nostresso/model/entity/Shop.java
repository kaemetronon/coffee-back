package ru.coffee.nostresso.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    private Integer id;
    private String name;
    private String description;
    private String phone;
    private String img;
    private Double middleRate;
    private LocalDateTime dateUpdated;
}
