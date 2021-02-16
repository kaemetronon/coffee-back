package ru.coffee.nostresso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "shops")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "shop", cascade=CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "shop", cascade=CascadeType.ALL)
    private List<Item> items;

    private String name;
    private String description;
    private String phone;
    private String img;
    private Double middleRate;
}
