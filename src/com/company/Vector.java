package com.company;

import java.util.Scanner;
import java.io.*;
public class Vector {
    private int dim;
    private Natural v[];

    public Vector(){
        this.dim=0;
        this.v=new Natural[dim];
    }

    public int getDim() {
        return dim;
    }

    public Natural[] getV() {
        return v;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public void setV(Natural[] v) {
        this.v = v;
    }
    public void citirefisier()throws Exception{
        File file=new File("/Users/mariangeorge/IdeaProjects/TADNatural/src/com/company/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        st=br.readLine();
        this.dim=Integer.parseInt(st);
        this.v=new Natural[dim];
        for(int i=0;i<this.dim;i++){
            st=br.readLine();
            v[i]=new Natural(st);
        }
        System.out.println("Citirea din fisier efectuata cu succes");
    }
    public void citiretast(){
        System.out.print("Dati dimensiunea vectorului: ");
        Scanner scr=new Scanner(System.in);
        dim=scr.nextInt();
        v=new Natural[dim];
        for(int i=0;i<dim;i++){
            v[i]=new Natural();
            System.out.print("Dati elementul de pe poz "+i+": ");
            v[i].citire();
        }
    }
    public void afisaresir(){
        for(int i=0;i<this.dim;i++)
            v[i].afisare();
    }
    public void ordonare(){
        for(int i=0;i<this.dim-1;i++)
            for(int j=i+1;j<this.dim;j++)
                if(v[i].isLower(v[j]))
                {
                    Natural Aux=new Natural(v[i]);
                    v[i]=v[j];
                    v[j]=Aux;
                }
    }
    public Natural produs(){
        Natural Rez=new Natural("1");
        for(int i=0;i<this.dim;i++)
            Rez=Rez.produs(v[i]);
        return Rez;
    }

}
