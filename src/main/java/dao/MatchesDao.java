package dao;

import Utils.SessionFactoryUtil;
import entity.Matches;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class MatchesDao implements Dao<Matches> {
    @Override
    public void add(Matches matches) {
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(matches);
            transaction.commit();
        } catch (Exception e) {
            if (transaction == null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Matches> getById(int id) {
        Matches matches = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            matches = session.get(Matches.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(matches);
    }

    @Override
    public List<Matches> getAll() {
        List<Matches> matches = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            matches = session.createQuery("from Matches", Matches.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matches;
    }
    public List<Matches> getByPlayer(int id) {
        List<Matches> matches = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
             session.beginTransaction();
             Query query = session.createQuery("from Matches where Matches.player1 = :id or Matches.player2 = :id", Matches.class);
             query.setParameter("id", id);
             matches = query.getResultList();
             session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matches;
    }
}
