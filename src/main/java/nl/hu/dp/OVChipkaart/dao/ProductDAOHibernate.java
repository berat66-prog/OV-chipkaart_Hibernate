package nl.hu.dp.OVChipkaart.dao;

import nl.hu.dp.OVChipkaart.domein.OVChipkaart;
import nl.hu.dp.OVChipkaart.domein.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOHibernate implements ProductDAO{
    private SessionFactory factory;

    public ProductDAOHibernate(SessionFactory factory){
        this.factory = factory;
    }

    public void save(Product product){
        Transaction transaction = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }

    }
    public void update(Product product){
        Transaction transaction = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }

    }
    public void delete(Product product){
        Transaction transaction = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }

    }
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart){
        Transaction transaction = null;
        List<Product> producten = ovChipkaart.getProducten();
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            producten = session.createQuery("FROM Product p WHERE ov_chipkaart.kaart_nummer = '" +
                    ovChipkaart.getKaart_nummer() + "'",Product.class).getResultList();
            transaction.commit();
        }
        return producten;

    }
    public List<Product> findall(){
        Transaction transaction = null;
        List<Product> producten = new ArrayList<>();
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            producten = session.createQuery("SELECT p from Product p", Product.class).getResultList();
            transaction.commit();
        }
        return producten;

    }
    public Product findById(int id){
        Transaction transaction = null;
        Product product = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            product = (Product) session.get(Product.class,id);
            transaction.commit();
        }
        return product;

    }


}
