package org.example;

import java.time.LocalDate;

public class Angajat {
    String nume;
    String post;
    LocalDate dataAngaj;
    float salariu;
    public Angajat(){}
    public Angajat(String nume,String post,LocalDate dataAngaj,float salariu){
        this.nume=nume;
        this.post=post;
        this.dataAngaj=dataAngaj;
        this.salariu=salariu;
    }

    public String getNume() {return nume;}

    public void setNume(String nume) {this.nume = nume;}

    public String getPost() {return post;}

    public void setPost(String post) {this.post = post;}

    public LocalDate getDataAngaj() {return dataAngaj;}

    public void setDataAngaj(LocalDate dataAngaj) {this.dataAngaj = dataAngaj;}

    public float getSalariu() {return salariu;}

    public void setSalariu(float salariu) {this.salariu = salariu;}

    @Override
    public String toString() {
        return "Angajat{" + "nume='" + nume + ", post='" + post  + ", dataAngaj=" + dataAngaj + ", salariu=" + salariu + '}';
    }
}
