package nl.hu.dp.OVChipkaart.dao;

import nl.hu.dp.OVChipkaart.domein.Adres;
import nl.hu.dp.OVChipkaart.domein.Reiziger;

import java.util.List;

public interface AdresDAO {
    public void save(Adres adres);
    public void update(Adres adres);
    public void delete(Adres adres);
    public Adres findByReiziger(Reiziger reiziger);
    public List<Adres> findall();
}
