package pl.chmielewski.Pokedex.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Pokemon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String imageUrl;
    private String name;

    private Type firstType;
    private Type secondType;

    private int hp;
    private int attack;
    private int defence;
    private int spAttack;
    private int spDefence;
    private int speed;

    @Column(nullable = false, updatable = false)
    private String pokemonCode;

}
