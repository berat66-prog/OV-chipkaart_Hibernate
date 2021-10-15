package nl.hu.dp.OVChipkaart.dao;

import nl.hu.dp.OVChipkaart.domein.OVChipkaart;
import nl.hu.dp.OVChipkaart.domein.Product;

import java.util.List;

public interface ProductDAO {
    public void save(Product product);
    public void update(Product product);
    public void delete(Product product);
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart);
    public List<Product> findall();
    public Product findById(int id);

}
