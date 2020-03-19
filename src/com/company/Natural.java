package com.company;
import com.sun.source.tree.NewArrayTree;

import java.lang.String;
import java.util.Scanner;

public class Natural {
    static int DIM=10000;
    int lung;
    int cif[];
    public Natural(){
        lung=0;
        cif=new int[DIM];
    }
    public Natural(Natural N){
        if(this!=N){
            this.lung=N.lung;
            this.cif=N.cif;
        }
    }
    public Natural(String sir){
        int j=0;

        while(sir.charAt(j)=='0')
            j++;
        this.lung=sir.length()-j;
        cif=new int[DIM];
        for(int i=0;i<this.lung;i++){
            this.cif[i]=sir.charAt(j)-'0';
            j++;
        }

    }

    public void setCif(int pos,int val){
        this.cif[pos]=val;
    }

    public void afisare(){
        for(int i=0;i<this.lung;i++)
            System.out.print(this.cif[i]);
        System.out.println(" ");
    }

    public void citire(){
        String s=new String();
        Scanner scr=new Scanner(System.in);
        s=scr.next();
        Natural Aux=new Natural(s);
        this.lung=Aux.lung;
        this.cif=Aux.cif;
    }
    public int carryprod(int x ,int y){
        if(x*y<10)
            return 0;
        else return (x*y)/10;
    }

    public void inversare(){
        Natural Aux=new Natural();
        Aux.setLung(this.lung);
        for(int i=this.lung-1;i>=0;i--)
        {
            Aux.setCif(this.lung-i-1,this.cif[i]);
        }
        this.cif=Aux.cif;
    }
    public int getLung() {
        return lung;
    }
    public boolean iszero(){
        if(this.lung==1&&this.cif[0]==0)
            return true;
        else return false;
    }

    public void setLung(int lung) {
        this.lung = lung;
    }

    public void setcifpos(int i,int val){
        this.cif[i]=val;
    }

    public int[] getCif() {
        return cif;
    }
    public void setCif(int[] cif) {
        this.cif = cif;
    }
    public Natural Aduna(Natural N){
        Natural aux1=new Natural(this);
        aux1.inversare();
        Natural aux2=new Natural(N);
        aux2.inversare();
        Natural Rez=new Natural();
        aux1.afisare();
        aux2.afisare();
        int CF=0,aux;
        int lungmax;
        if(aux1.getLung()>aux2.getLung())
        {
            lungmax=aux1.getLung();
            aux=aux2.getLung();
            aux2.setLung(lungmax);
            for(int i=aux;i<aux1.getLung();i++)
                aux2.setcifpos(i,0);
        }
        else {
            lungmax=aux2.getLung();
            aux=aux1.getLung();
            aux1.setLung(lungmax);
            for(int i=aux;i<aux2.getLung();i++)
                aux1.setcifpos(i,0);
        }
        Rez.setLung(lungmax);
        for(int i=0;i<lungmax;i++){
            aux=(aux1.getCif()[i]+aux2.getCif()[i]+CF);
            Rez.setCif(i,aux%10);
            CF=aux/10;
        }
        aux1.afisare();
        aux2.afisare();
        Rez.inversare();
        return Rez;
    }
    public Natural produs(Natural N){
        int aux;
        Natural Rez=new Natural();
           /* if(this.iszero()||N.iszero())
            {
                Rez.setLung(1);
                Rez.setCif(0,0);
                return Rez;
            }*/
        Natural Aux1=new Natural(this);
        Aux1.inversare();
        Natural Aux2=new Natural(N);
        Aux2.inversare();
        int CF=0;
        Rez.setLung(Aux1.getLung()+Aux2.getLung()+1);
        for(int i=0;i<Rez.getLung();i++)
            Rez.setCif(i,0);
        for(int i=0;i<Aux1.getLung();i++)
            for(int j=0;j<Aux2.getLung();j++)
            {
                aux=Rez.getCif()[i+j]+Aux1.getCif()[i]*Aux2.getCif()[j];
                Rez.setCif(i+j,aux);
                CF=Rez.getCif()[i+j]/10;
                Rez.setCif(i+j,aux%10);
                Rez.setCif(i+j+1,Rez.getCif()[i+j+1]+CF);
            }
        int i=Rez.getLung()-1;
            while(Rez.getCif()[i]==0)
            {
                i--;
                Rez.setLung(Rez.getLung()-1);
            }
        Rez.inversare();
        return Rez;
    }
    public boolean isLower(Natural N){
        int j=0;
        if(this.lung<N.lung)
            return true;
        else if(this.lung>N.lung)
                return false;
             else {
                while(this.cif[j]==N.cif[j])
                    j++;
                if(this.cif[j]<N.cif[j])
                    return true;
                else return false;
                }
    }


}
