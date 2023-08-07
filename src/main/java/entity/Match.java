package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Match")
@Data
@NoArgsConstructor
@ToString
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "player_1", nullable = false)
    private Player player1;

    @ManyToOne()
    @JoinColumn(name = "player_2", nullable = false)
    private Player player2;

    @ManyToOne()
    @JoinColumn(name = "winner", nullable = false)
    private Player winner;

    public Match(Player player1, Player player2, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }
}
