package nl.hu.dp.OVChipkaart.domein;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "ov_chipkaart")
public class OVChipkaart {
    @Id
    private int kaart_nummer;
    private Date geldig_tot;
    private int klasse;
    private double saldo;
    @ManyToOne
    @JoinColumn(name = "reiziger_id")
    private Reiziger reiziger;

    @JoinTable(name = "ov_chipkaart_product", joinColumns = {@JoinColumn(name = "kaart_nummer")}, inverseJoinColumns = {@JoinColumn(name = "product_nummer")})
    @ManyToMany
    private List<Product> producten = new ArrayList<>();

    public OVChipkaart(){

    }



    public List<Product> getProducten() {
        return producten;
    }

    public void setProducten(List<Product> producten) {
        this.producten= producten;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public int getKaart_nummer() {
        return kaart_nummer;
    }

    public void setKaart_nummer(int kaart_nummer) {
        this.kaart_nummer = kaart_nummer;
    }

    public Date getGeldig_tot() {
        return geldig_tot;
    }

    public void setGeldig_tot(Date geldig_tot) {
        this.geldig_tot = geldig_tot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        String s = reiziger.toString() + " OVChipkaart{#" + kaart_nummer + " geldig_tot: " + geldig_tot + " klasse: " + klasse + " saldo " + saldo;
            for(Product products : producten){
                s = s + products.toString();
            }
            return s;

        }


}
