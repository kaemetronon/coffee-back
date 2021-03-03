package ru.coffee.nostresso.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private Integer id;
    private String description;
    private Integer rate;
    private LocalDateTime dateUpdated;
    private Integer shopId;
    private Integer userId;
}
