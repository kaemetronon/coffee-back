package ru.coffee.nostresso.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    private Integer id;
    private String comment;
    private LocalDateTime dateUpload;
    private LocalDateTime timeToDo;
    private String transactionId;
    private Integer userId;
}
