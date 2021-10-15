package nl.hu.dp.OVChipkaart.dao;

import nl.hu.dp.OVChipkaart.domein.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO{
    private SessionFactory factory;

    public ReizigerDAOHibernate(SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public void save(Reiziger reiziger){
        Transaction transaction = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.save(reiziger);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }


    }

    @Override
    public void update(Reiziger reiziger){
        Transaction transaction = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.update(reiziger);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }

    }

    @Override
    public void delete(Reiziger reiziger){
        Transaction transaction = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.delete(reiziger);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }

    }

    @Override
    public Reiziger findByid(int id){
      Transaction transaction = null;
      Reiziger reiziger = null;
      try(Session session = factory.openSession()){
          transaction = session.beginTransaction();
           reiziger = (Reiziger) session.get(Reiziger.class,id);
          transaction.commit();
      }
      return reiziger;
    }

    @Override
    public List<Reiziger> findByGbdatum(String datum){
        Transaction transaction = null;
        List<Reiziger> reizigers = new ArrayList<>();
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            reizigers = session.createQuery("from Reiziger r WHERE r.geboortedatum = '" +
                    java.sql.Date.valueOf(datum) + "'",Reiziger.class).getResultList();
            transaction.commit();
        }
        return reizigers;


    }

    @Override
    public List<Reiziger> findAll(){
        Transaction transaction = null;
        List<Reiziger> reizigers = new ArrayList<>();
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            reizigers = session.createQuery("SELECT r from Reiziger r", Reiziger.class).getResultList();
            transaction.commit();
        }
        return reizigers;

    }


}
