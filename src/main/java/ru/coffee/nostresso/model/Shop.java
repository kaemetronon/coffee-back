package ru.coffee.nostresso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "shops")
@Data
@EqualsAndHashCode(exclude={"address","items","reviews"})
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @JsonIgnore
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Item> items;
    @JsonIgnore
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Review> reviews;

    private String name;
    private String description;
    private String phone;
    private String img;
    private Double middleRate;
    private LocalDateTime dateUpdated;


    public void setItems(List<Item> items) {
        if (items != null) {
            items.forEach(a -> a.setShop(this));
        }
        this.items = items;
    }

    public void setReviews(List<Review> reviews) {
        if (reviews != null) {
            reviews.forEach(a -> a.setShop(this));
        }
        this.reviews = reviews;
    }
}
