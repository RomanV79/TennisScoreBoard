import Utils.SessionFactoryUtil;
import dao.PlayerDao;
import entity.Player;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class Main {

    private static SessionFactoryUtil sessionFactoryUtil;
    private final static PlayerDao playerDao = new PlayerDao();


    public static void main(String[] args) {
        System.out.println("123");
        try {
            Player player1 = new Player("Roman");
            playerDao.add(player1);
            Player player2 = new Player("Katya");
            playerDao.add(player2);
            Optional optional;
            optional = playerDao.getById(1);
            if (optional.isPresent()) {
                System.out.println("getById = " + optional.get());
            }
            System.out.println("--------------- getAll ----------------");
            System.out.println(playerDao.getAll());


        } catch (Exception e) {
            System.out.println("something wrong");
        }
    }
}
