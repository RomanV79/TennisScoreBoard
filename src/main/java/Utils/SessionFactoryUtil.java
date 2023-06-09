package Utils;

import dao.MatchesDao;
import dao.PlayerDao;
import entity.Match;
import entity.Player;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private static final MatchesDao matchesDao = new MatchesDao();
    private static final PlayerDao playerDao = new PlayerDao();
    //demo
    static {
        Player player1 = new Player("К. Алькарас");
        Player player2 = new Player("Ф. Коболли");
        playerDao.create(player1);
        playerDao.create(player2);
        matchesDao.create(new Match(player1, player2, player1));

        Player player3 = new Player("Д. Медведев");
        Player player4 = new Player("Т. Уайлд");
        playerDao.create(player3);
        playerDao.create(player4);
        matchesDao.create(new Match(player3, player4, player4));

        Player player5 = new Player("Н. Джокович");
        Player player6 = new Player("М. Фучович");
        playerDao.create(player5);
        playerDao.create(player6);
        matchesDao.create(new Match(player5, player6, player5));

        Player player7 = new Player("К. Хачанов");
        playerDao.create(player7);
        matchesDao.create(new Match(player5, player7, player5));

        Player player8 = new Player("К. Рууд");
        Player player9 = new Player("А. Зверев");
        playerDao.create(player8);
        playerDao.create(player9);
        matchesDao.create(new Match(player8, player9, player9));

        Player player10 = new Player("Ф. Тиафо");
        playerDao.create(player10);
        matchesDao.create(new Match(player3, player10, player3));
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Match.class);
                configuration.addAnnotatedClass(Player.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}



