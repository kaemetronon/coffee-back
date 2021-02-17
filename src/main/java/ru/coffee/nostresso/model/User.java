package ru.coffee.nostresso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(exclude={"histories","reviews"})
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderHistory> histories;

    private String name;
    private LocalDateTime dateUpdated;

    public void setReviews(List<Review> reviews) {
        if (reviews != null) {
            reviews.forEach(a -> a.setUser(this));
        }
        this.reviews = reviews;
    }

    public void setHistories(List<OrderHistory> histories) {
        if (histories != null) {
            histories.forEach(a -> a.setUser(this));
        }
        this.histories = histories;
    }
}