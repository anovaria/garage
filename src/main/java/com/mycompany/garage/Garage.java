package com.mycompany.garage;
import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;
/**
 *
 * @author alex
 */
public class Garage {

    private static Auto elencoAuto[];
    private static Furgone elencoFurgoni[];
    private static Moto elencoMoto[];
    private final int maxPosti = 3;

    public static void main(String[] args) {
        Garage G = new Garage();
    }
    public void rimuoviA(Auto A){
        elencoAuto=(Auto[]) ArrayUtils.remove(elencoAuto, 0);
        System.out.println("Rimosso: "+A.toString());
    }
    public void rimuoviM(Moto M){
        elencoMoto=(Moto[]) ArrayUtils.remove(elencoMoto, 0);
        System.out.println("Rimosso: "+M.toString());
    }
    public void rimuoviF(Furgone F){
        
    }
    
    public void inserisci(Auto A) {
        int posto=0;
        if (controlla(posto)) {
            elencoAuto[posto] = A;
            
            System.out.println("Inserito: "+A.toString());
        } else {

            System.out.println("posi pieni");
        }
    }

    public void inserisci(Moto M) {
        int posto=0;
        if (controlla(posto)) {
            elencoMoto[posto] = M;
            System.out.println("Inserito: "+M.toString());
        } else {

            System.out.println("posi pieni");
        }
    }

    public void inserisci(Furgone F) {
        int posto=0;
        if (controlla(posto)) {
            elencoFurgoni[posto] = F;
            System.out.println("Inserito: "+F.toString());
        } else {
            System.out.println("posi pieni");
        }
    }
/**
 * controllo disponibilita posti
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
            elencoAuto[i] = new Auto(i,0, "", "", 0, 0);
        }
        elencoFurgoni = new Furgone[maxPosti];
        for (int i = 0; i < elencoFurgoni.length; i++) {
            elencoFurgoni[i] = new Furgone(i,0, "", 0, 0);
        }
        elencoMoto = new Moto[maxPosti];
        for (int i = 0; i < elencoMoto.length; i++) {
            elencoMoto[i] = new Moto(i,0, "", 0, 0);
        }
        
        //inserisco veicoli
        Auto A = new Auto(0, 4, "benz",  "fiat", 2000, 1200);
        inserisci(A);
        Moto M = new Moto(1, 1, "aprilia", 2000, 600);
        inserisci(M);
        Furgone F = new Furgone(2,300, "Ducato", 1995,2500);
        inserisci(F);
        rimuoviA(elencoAuto[0]);
        rimuoviM(elencoMoto[0]);
        rimuoviF(elencoFurgoni[0]);
    }
}

class Veicolo {

    int posto;
    String marca;
    int anno;
    int cilindrata;

    public Veicolo(int posto,String marca, int anno, int cilindrata) {
        this.posto= posto;
        this.marca = marca;
        this.anno = anno;
        this.cilindrata = cilindrata;
    }
}

class Auto extends Veicolo {

    public int porte;
    public String alim;

    public Auto(int posto,int porte, String alim, String marca, int anno, int cilindrata) {
        super(posto,marca, anno, cilindrata);
        this.porte = porte;
        this.alim = alim;
    }

    @Override
    public String toString() {
        return "posto: "+posto+") Auto: " + marca + ", porte=" + porte + ", alim=" + alim + ", anno=" + anno + ", "
                + "cil.=" + cilindrata;
    }

}

class Moto extends Veicolo {

    int tempi;

    public Moto(int posto,int tempi, String marca, int anno, int cilindrata) {
        super(posto,marca, anno, cilindrata);
        this.tempi = tempi;
    }

    @Override
    public String toString() {
        return "posto: "+posto+") Moto " + marca + " cil.=" + cilindrata + " anno=" + anno + " tempi=" + tempi + '}';
    }

}

class Furgone extends Veicolo {

    int cpacita;

    public Furgone(int posto,int cpacita, String marca, int anno, int cilindrata) {
        super(posto,marca, anno, cilindrata);
        this.cpacita = cpacita;
    }

    @Override
    public String toString() {
        return "posto: "+posto+") Furgone" + " marca=" + marca + " cpacita=" + cpacita + " anno=" + anno
                + " cilind.=" + cilindrata;
    }

}
