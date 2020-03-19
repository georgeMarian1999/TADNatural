package com.company;

import java.util.Scanner;

public class UI {
    private CTRL C;
    public UI(){
        C=new CTRL();
    }

    public CTRL getC() {
        return C;
    }

    public void setC(CTRL c) {
        C = c;
    }
    public void afisaremeniup() {
        System.out.println("Bine ati venit!");
        System.out.println("Va rog sa alegeti o optiune:");
        System.out.println("1.Citeste numarul n si sirul de numere naturale:");
        System.out.println("2.Citeste date din fisier");
        System.out.println("3.Iesire");
    }

    public void afisaremenius1() {
        System.out.println("Va rog sa alegeti o optiune:");
        System.out.println("1.Ordoneaza sirul descrescator si afiseaza sirul de numere ");
        System.out.println("2.Determina produsul numerelor citite si afiseaza l");
        System.out.println("3.Afiseaza sirul");
        System.out.println("4.Revenire");
    }
    public int citireint() {
        try {
            Scanner scr = new Scanner(System.in);
            int l = scr.nextInt();
            return l;
        } catch (Exception e) {
            System.out.println("Nu este numar intreg");
            return citireint();
        }
    }
    public void Run()throws Exception{
        afisaremeniup();
        System.out.println("Dati optiunea:");
        int op1;
        op1=citireint();
        if(op1==2){
            System.out.println("La revedere!");
        }
        while(op1==1||op1==2){
            if(op1==1)
                C.Initializare();
            if(op1==2)
                C.citirefisier();
            afisaremenius1();
            int op2;
            System.out.println("Dati optiunea:");
            op2=citireint();
            while(op2>0&&op2<4) {
                if (op2 == 1) {
                    C.Ordonare();
                    C.afisarenumere();
                }
                if (op2 == 2) {
                    C.AfisareProdus();
                }
                if(op2==3){
                    C.afisarenumere();
                }
                afisaremenius1();
                System.out.println("Dati o alta optiune:");
                op2=citireint();
            }
            afisaremeniup();
            System.out.println("Dati optiunea:");
            op1=citireint();
            if(op1==3){
                System.out.println("La revedere!");
            }
        }
    }
}
