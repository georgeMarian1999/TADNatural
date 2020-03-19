package com.company;

public class CTRL {
    private Vector Numere;


    public CTRL(){
        this.Numere=new Vector();
    }
    public void Initializare(){
        this.Numere.citiretast();
    }
    public void citirefisier() throws Exception {
        this.Numere.citirefisier();
    }
    public Vector getNumere() {
        return Numere;
    }

    public void setNumere(Vector numere) {
        Numere = numere;
    }
    public void afisarenumere(){
        this.Numere.afisaresir();
    }
    public void AfisareProdus(){
        Natural Rez;
        Rez=this.Numere.produs();
        Rez.afisare();
    }
    public void Ordonare(){
        this.Numere.ordonare();
    }
}
