package com.sheamunion.spring_integration_oreilly_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Override
    public String toString() {
        return String.format("Person [id=%s, name=%s, ]", id, name);
    }
}
