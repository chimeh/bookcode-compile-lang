package com.TacoCloud.TacoCloud.Domain.Entities;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Contains validation rules as part of the Java Bean validation API
 */
@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String       name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "TACO_INGREDIENT",
            joinColumns = @JoinColumn(name = "TACO_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "ID")
    )
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

}
