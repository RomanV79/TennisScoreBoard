package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Players", indexes = {@Index(name = "nameIndex", columnList = "Name")})
@Data
@NoArgsConstructor
@ToString
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    public Player(String name) {
        this.name = name;
    }
}
