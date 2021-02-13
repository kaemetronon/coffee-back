package ru.coffee.nostresso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shops")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private String phone;
    private String img;
}
