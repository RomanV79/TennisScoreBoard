package dao;

import Utils.SessionFactoryUtil;
import entity.Player;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Optional;

public class PlayerDao implements Dao<Player> {

    @Override
    public void add(Player player) {
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(player);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Player> getById(int id) {
        Player player = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            player = session.get(Player.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(player);
    }

    @Override
    public List<Player> getAll() {
        List<Player> players = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            players = session.createQuery("FROM Player", Player.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public void update(Player player) {

    }
}
