package nl.hu.dp.OVChipkaart.dao;

import nl.hu.dp.OVChipkaart.domein.Reiziger;

import java.util.List;

public interface ReizigerDAO {

    public void save(Reiziger reiziger);
    public void update(Reiziger reiziger);
    public void delete(Reiziger reiziger);
    public Reiziger findByid(int id);
    public List<Reiziger> findByGbdatum(String datum);
    public List<Reiziger> findAll();
}
