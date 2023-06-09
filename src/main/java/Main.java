import Utils.SessionFactoryUtil;
import dao.MatchesDao;
import dao.PlayerDao;
import entity.Match;
import entity.Player;
import java.util.Optional;

public class Main {
    private final static PlayerDao playerDao = new PlayerDao();
    private final static MatchesDao matchesDao = new MatchesDao();


    public static void main(String[] args) {
//        System.out.println("123");
        try {
            System.out.println("----------player 1--------------");
            Player player1 = new Player("Roman");
            System.out.println("Player1 = " + player1);
            System.out.println("Player1_dao = " + playerDao.create(player1));

            System.out.println("----------player 2--------------");
            Player player2 = new Player("Lena");
            System.out.println("Player2 = " + player2);
            System.out.println("Player2_dao = " + playerDao.create(player2));

            System.out.println("----------match--------------");
            Match match = new Match(player1, player2, player1);
            System.out.println("match = " + match);
            System.out.println("match_dao = " + matchesDao.create(match));

            System.out.println(playerDao.getByName("Roman"));
            System.out.println(playerDao.getByName("Lena"));


//            Player player2 = new Player("Katya");
//            playerDao.add(player2);
//            Optional optional;
//            optional = playerDao.getById(1);
//            if (optional.isPresent()) {
//                System.out.println("getById = " + optional.get());
//            }
//            System.out.println("--------------- getAll ----------------");
//            System.out.println(playerDao.getAll());
//            System.out.println(playerDao.getAll().size());

//            Optional optional2 = playerDao.getAll();
//            if (optional2.isPresent()) {
//                System.out.println(playerDao.getAll());
//            } else {
//                System.out.println("List is empty");
//            }


        } catch (Exception e) {
            System.out.println("something wrong");
        }
    }
}
