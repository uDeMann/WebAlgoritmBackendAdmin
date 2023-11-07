package com.example.demo.Business;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name= "Algoritm")
public class Algoritm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, name = "algoritmID")
    public int id;
    @Column(columnDefinition = "varchar(50)")
    public String name;
    @Column(columnDefinition = "varchar(500)")
    public String description;
    @Column(columnDefinition = "int")
    public int timesUsed;

    @OneToMany(
            mappedBy= "algoritm",
            cascade=CascadeType.ALL,
            orphanRemoval=true
    )
    public Set<Result> Results;

    public Algoritm(int id, String name, String description, int timesUsed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timesUsed = timesUsed;
    }

    public Algoritm() {
    }
}
