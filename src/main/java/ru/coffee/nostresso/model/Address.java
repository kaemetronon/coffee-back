package ru.coffee.nostresso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "address")
@Data
@EqualsAndHashCode(exclude={"shop"})
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String addressText;
    private LocalDateTime dateUpdated;
    private Double x;
    private Double y;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Shop shop;
}
