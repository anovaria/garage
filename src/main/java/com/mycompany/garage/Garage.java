package com.mycompany.garage;

import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.java_cup.internal.runtime.Symbol;

/**
 *
 * @author alex
 */
public class Garage {

    static Auto elencoAuto[];
    private static Furgone elencoFurgoni[];
    private static Moto elencoMoto[];
    private final int maxPosti = 4;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Garage G = new Garage();
        
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("dimmi alimentazione?");
        Auto.Alimentazione alimentazione=null;
        boolean invalid;
        do{
            invalid=false;
            try{
                alimentazione=Auto.Alimentazione.valueOf(sc.nextLine().toUpperCase());
            }catch(IllegalArgumentException ex){
                System.out.println("Alim non valida riprova");
                invalid=true;
            }
        
    } while(invalid);
        
        
    }

    public void rimuoviA(Auto A) {

        elencoAuto[A.posto] = new Auto(A.posto, 0, Auto.Alimentazione.BENZINA, "", 0, 0);
        System.out.println("Rimosso: " + A.toString());
        stampaSituazione();
    }

    public void rimuoviM(Moto M) {
        elencoMoto[M.posto] = new Moto(M.posto, 0, "", 0, 0);
        System.out.println("Rimosso: " + M.toString());
        stampaSituazione();
    }

    public void rimuoviF(Furgone F) {
        elencoFurgoni[F.posto] = new Furgone(F.posto, 0, "", 0, 0);
        System.out.println("Rimosso: " + F.toString());
        stampaSituazione();
    }

    public void stampaSituazione() {
        String res = "Situazione Auto in garage:";
        for (Auto elencoAuto1 : elencoAuto) {
            res += "\n" + elencoAuto1.toString();
        }
        res += "\nSituazione Moto in garage:";
        for (Moto elencoMoto1 : elencoMoto) {
            res += "\n" + elencoMoto1.toString();
        }
        res += "\nSituazione Furgoni in garage:";
        for (Furgone elencoFurgoni1 : elencoFurgoni) {
            res += "\n" + elencoFurgoni1.toString();
        }
        System.out.println(res);
    }

    public void inserisci(Auto A) {
        int posto = 0;
        if (controlla(A.posto)) {
            elencoAuto[A.posto] = A;

            System.out.println("Inserito: " + A.toString());
            stampaSituazione();
        } else {

            System.out.println("posi pieni");
            stampaSituazione();
        }
    }

    public void inserisci(Moto M) {
        int posto = 0;
        if (controlla(M.posto)) {
            elencoMoto[M.posto] = M;
            System.out.println("Inserito: " + M.toString());
            stampaSituazione();
        } else {

            System.out.println("posi pieni");
            stampaSituazione();
        }
    }

    public void inserisci(Furgone F) {
        int posto = 0;
        if (controlla(F.posto)) {
            elencoFurgoni[F.posto] = F;
            System.out.println("Inserito: " + F.toString());
            stampaSituazione();
        } else {
            System.out.println("posi pieni");
            stampaSituazione();
        }
    }

    /**
     * controllo disponibilita posti
     *
     * @param posto
     * @return
     */
    public boolean controlla(int posto) {
        int cont = 0;

        for (Auto elencoAuto1 : elencoAuto) {
            if (!"".equals(elencoAuto1.marca)) {
                cont = cont + 1;
            }
        }
        for (Moto elencoMoto1 : elencoMoto) {
            if (!"".equals(elencoMoto1.marca)) {
                cont = cont + 1;
            }
        }
        for (Furgone elencoFurgoni1 : elencoFurgoni) {
            if (!"".equals(elencoFurgoni1.marca)) {
                cont = cont + 1;
            }
        }
        //System.out.println(Integer.toString(cont));
        if (cont < maxPosti) {
            posto = cont;
            return true;
        } else {
            return false;
        }
    }

    public Garage() {
        // preparo gli array
        elencoAuto = new Auto[maxPosti];
        for (int i = 0; i < elencoAuto.length; i++) {
            elencoAuto[i] = new Auto(i, 0, Auto.Alimentazione.BENZINA, "", 0, 0);
        }
        elencoFurgoni = new Furgone[maxPosti];
        for (int i = 0; i < elencoFurgoni.length; i++) {
            elencoFurgoni[i] = new Furgone(i, 0, "", 0, 0);
        }
        elencoMoto = new Moto[maxPosti];
        for (int i = 0; i < elencoMoto.length; i++) {
            elencoMoto[i] = new Moto(i, 0, "", 0, 0);
        }

        //inserisco veicoli 
        //throw new IllegalArgumentException("errore");
        Auto A = new Auto(3, 4, Auto.Alimentazione.BENZINA, "fiat", 2000, 1200);
        inserisci(A);
        Moto M = new Moto(2, 4, "aprilia", 2000, 600);
        inserisci(M);
        Furgone F = new Furgone(2, 300, "Ducato", 1995, 2500);
        inserisci(F);
        rimuoviA(elencoAuto[3]);
        rimuoviM(elencoMoto[2]);
        rimuoviF(elencoFurgoni[2]);
    }
}

class Veicolo {

    int posto;
    String marca;
    int anno;
    int cilindrata;

    public Veicolo(int posto, String marca, int anno, int cilindrata) {
        this.posto = posto;
        this.marca = marca;
        this.anno = anno;
        this.cilindrata = cilindrata;
    }

    @Override
    public String toString() {
        return String.format(" marca %s, anno %s, cil. %s ", marca, anno, cilindrata);
    }

}

class Auto extends Veicolo {

    public static enum Alimentazione {
        BENZINA, DIESEL
    }
    public static enum Porte {
        
    }
    public int porte;
    //public String alim;
    Alimentazione alim;

    public Auto(int posto, int porte, Alimentazione alim, String marca, int anno, int cilindrata) {
        super(posto, marca, anno, cilindrata);
        this.porte = porte;
        this.alim = alim;
    }

    @Override
    public String toString() {
        //return "posto: " + posto + ") Auto: " + marca + ", porte=" + porte + ", alim=" + alim + ", anno=" + anno + ", "
        //      + "cil.=" + cilindrata;
        return super.toString() + String.format(" porte %s, alim. %s ", porte, alim);
    }

}

class Moto extends Veicolo {

    int tempi;

    public Moto(int posto, int tempi, String marca, int anno, int cilindrata) {
        super(posto, marca, anno, cilindrata);
        this.tempi = tempi;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" tempi %s ", tempi);
        //return "posto: " + posto + ") Moto " + marca + " cil.=" + cilindrata + " anno=" + anno + " tempi=" + tempi + '}';
    }

}

class Furgone extends Veicolo {

    int cpacita;

    public Furgone(int posto, int cpacita, String marca, int anno, int cilindrata) {
        super(posto, marca, anno, cilindrata);
        this.cpacita = cpacita;
    }

    @Override
    public String toString() {

        return "posto: " + posto + ") Furgone" + " marca=" + marca + " cpacita=" + cpacita + " anno=" + anno
                + " cilind.=" + cilindrata;
    }

}
