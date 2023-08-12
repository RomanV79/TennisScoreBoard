package dao;

import Utils.SessionFactoryUtil;
import entity.Match;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class MatchesDao implements Dao<Match> {
    @Override
    public Match create(Match match) {
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            session.persist(match);
            transaction.commit();
        } catch (Exception e) {
            if (transaction == null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return match;
    }

    @Override
    public Optional<Match> getById(int id) {
        Match match = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            match = session.get(Match.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(match);
    }

    @Override
    public List<Match> getAll() {
        List<Match> matches = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            matches = session.createQuery("from Match order by id DESC", Match.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matches;
    }

    public List<Match> getByPlayer(int id) {
        List<Match> matches = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Match where Match.player1 = :id or Match.player2 = :id", Match.class);
            query.setParameter("id", id);
            matches = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matches;
    }

    public List<Match> getAllPagination(int limit, int offset) {
        List<Match> matches = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Match ORDER BY id DESC", Match.class);
            matches = query.setMaxResults(limit).setFirstResult(offset).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matches;
    }

    public List<Match> getByPlayerNamePagination(String name, int limit, int offset) {
        List<Match> matches = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Match where player1.name like:name or player2.name like:name ORDER BY id DESC", Match.class);
            query.setParameter("name", "%" + name.toUpperCase().trim() + "%");
            matches = query.setMaxResults(limit).setFirstResult(offset).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matches;
    }

    public int getByPlayerNameUnique(String name) {
        int uniqueResults = 0;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT count(*) from Match where player1.name like:name or player2.name like:name", Match.class);
            query.setParameter("name", "%" + name.toUpperCase().trim() + "%");
            uniqueResults = (int) query.getSingleResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uniqueResults;
    }

    public long getAllUnique() {
        long uniqueResults = 0;
        try (Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT count(*) from Match", Match.class);
            uniqueResults = (long) query.getSingleResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uniqueResults;
    }
}
