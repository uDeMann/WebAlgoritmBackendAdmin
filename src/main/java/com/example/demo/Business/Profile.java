package com.example.demo.Business;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, name = "profileID")
    public int id;

    @Column(columnDefinition = "varchar(500)")
    public String name;

    @Column(columnDefinition = "varchar(500)")
    public String password;

    @ManyToMany
    @JoinTable(
            name = "profileAlgoritm",
            joinColumns = @JoinColumn(name = "profileID"),
            inverseJoinColumns = @JoinColumn(name = "algoritmID")
    )
    public Set<Algoritm> Algoritms = new HashSet<>();

    public int[] GetAlgoritmIDs(){
        int[] alIDs = new int[Algoritms.size()];
        int counter = 0;
        for (Algoritm al: Algoritms){
            alIDs[counter] = al.id;
            counter++;
        }
        return alIDs;
    }
}
