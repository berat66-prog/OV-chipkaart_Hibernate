package nl.hu.dp.OVChipkaart.dao;


import nl.hu.dp.OVChipkaart.domein.OVChipkaart;
import nl.hu.dp.OVChipkaart.domein.Product;
import nl.hu.dp.OVChipkaart.domein.Reiziger;

import java.util.List;

public interface OVChipkaartDAO {

    public void save(OVChipkaart ovChipkaart);
    public void update(OVChipkaart ovChipkaart);
    public void delete(OVChipkaart ovChipkaart);
    public List<OVChipkaart> findByReiziger(Reiziger reiziger);
    public List<OVChipkaart> findall();
    public OVChipkaart findByid(int id);
    public List<OVChipkaart> findByProduct(Product product);
}
