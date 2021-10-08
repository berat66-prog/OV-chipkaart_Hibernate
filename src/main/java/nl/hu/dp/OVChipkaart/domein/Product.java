package nl.hu.dp.OVChipkaart.domein;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Product {
    @Id
    private int product_nummer;
    private String naam;
    private String beschrijving;
    private double prijs;
    @ManyToMany(mappedBy = "producten", targetEntity = OVChipkaart.class)
    private List<OVChipkaart> ovChipkaarten = new ArrayList<>();

    public Product(){

    }

    public void voegOVChipkaartToe(OVChipkaart ovChipkaart){
        if(!ovChipkaarten.contains(ovChipkaart)){
            ovChipkaarten.add(ovChipkaart);
        }
    }

    public void verwijderOVChipkaart(OVChipkaart ovChipkaart){
        ovChipkaarten.remove(ovChipkaart);
    }

    public List<OVChipkaart> getOvChipkaarten() {
        return ovChipkaarten;
    }

    public void setOvChipkaarten(List<OVChipkaart> ovChipkaarten) {
        this.ovChipkaarten = ovChipkaarten;
    }

    public int getProduct_nummer() {
        return product_nummer;
    }

    public void setProduct_nummer(int product_nummer) {
        this.product_nummer = product_nummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String toString(){
        String s = " Product{#" + product_nummer + " NAAM: " + naam + " BESCHRIJVING: " + beschrijving + " PRIJS: " + prijs + "}";

        return s;
    }
}
