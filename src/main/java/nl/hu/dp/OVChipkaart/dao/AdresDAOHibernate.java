package nl.hu.dp.OVChipkaart.dao;

import nl.hu.dp.OVChipkaart.domein.Adres;
import nl.hu.dp.OVChipkaart.domein.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdresDAOHibernate implements AdresDAO {
    private SessionFactory factory;

    public AdresDAOHibernate(SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public void save(Adres adres){
        Transaction transaction = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.save(adres);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(Adres adres){
        Transaction transaction = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.update(adres);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }

    }

    @Override
    public void delete(Adres adres){
        Transaction transaction = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.delete(adres);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    @Override
    public Adres findByReiziger(Reiziger reiziger){
        Transaction transaction = null;
        Adres adres = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            adres = session.get(Adres.class, reiziger.getId());
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return adres;

    }

    @Override
    public List<Adres> findall(){
        Transaction transaction = null;
        List<Adres> adressen = new ArrayList<>();
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            adressen = session.createQuery("SELECT a from Adres a", Adres.class).getResultList();
            transaction.commit();
        }
        return adressen;

    }

}
