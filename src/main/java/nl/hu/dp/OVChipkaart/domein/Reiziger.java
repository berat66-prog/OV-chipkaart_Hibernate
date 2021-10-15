package nl.hu.dp.OVChipkaart.domein;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Reiziger {
    @Id
    private int reiziger_id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;
    @OneToOne
    @JoinColumn(name = "reiziger_id")
    private Adres adres;
    @OneToMany
    @JoinColumn(name = "reiziger_id")
    private List<OVChipkaart> OVChipkaarten = new ArrayList<>();

    public Reiziger(){


    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public List<OVChipkaart> getOVChipkaarten() {
        return OVChipkaarten;
    }

    public void setOVChipkaarten(ArrayList<OVChipkaart> OVChipkaarten) {
        this.OVChipkaarten = OVChipkaarten;
    }


    public int getId() {
        return reiziger_id;
    }

    public void setId(int id) {
        this.reiziger_id = id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String toString(){
        String s = "";
        if(tussenvoegsel == null){
            s = s + "Reiziger {#" + reiziger_id + ": " + voorletters + ". "  + achternaam + " " + "(" + geboortedatum + ")} ";
        }else if(tussenvoegsel != null){
            s = s + "Reiziger {#" + reiziger_id + ": " + voorletters + ". " + tussenvoegsel + " " + achternaam + " " + "(" + geboortedatum + ")} ";
        }


        return s;
    }
}
