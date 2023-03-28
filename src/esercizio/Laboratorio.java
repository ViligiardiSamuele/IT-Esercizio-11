package esercizio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Laboratorio {
    private List<Riparazione> riparazioni;
    private String nome, indirizzo;

    public Laboratorio(String nome, String indirizzo) {
        this.riparazioni = new ArrayList<Riparazione>();
        this.nome = nome;
        this.indirizzo = indirizzo;
    }
    public Laboratorio(Laboratorio l) {
        this.riparazioni = l.riparazioni;
        this.nome = l.nome;
        this.indirizzo = l.indirizzo;
    }

    public boolean addRiparazione(Riparazione r){
        return riparazioni.add(r);
    }

    public Riparazione searchCF(String CF){
        Iterator<Riparazione> i = riparazioni.iterator();
        Riparazione old = riparazioni.get(0);
        while(i.hasNext()){
            if(old.getChiamata().getCf().equalsIgnoreCase(CF))
                return old;
            old = i.next();
        }
        return new Riparazione();
    }

    public boolean modificaTempoPerNomeCliente(String name, double costo){
        Iterator<Riparazione> i = riparazioni.iterator();
        Riparazione old = riparazioni.get(0);
        while(i.hasNext()){
            if(old.getChiamata().getNome().equalsIgnoreCase(name))
                old.setCosto(costo);
            old = i.next();
        }
        return false;
    }

    public boolean modificaTempoPerNomeCliente(String name, LocalDateTime tempo){
        Iterator<Riparazione> i = riparazioni.iterator();
        Riparazione old = riparazioni.get(0);
        while(i.hasNext()){
            if(old.getChiamata().getNome().equalsIgnoreCase(name))
                old.setTempoImpegato(tempo);
            old = i.next();
        }
        return false;
    }

    public double totaleSpesa(double costoKm, double costoPerOra){
        double tot = 0;
        Iterator<Riparazione> i = riparazioni.iterator();
        Riparazione old = riparazioni.get(0);
        while(i.hasNext()){
            if(old instanceof InterventoEsterno)
                tot += i.next().Spesa(costoKm, costoPerOra);
            else if (old instanceof InterventoInLaboratorio)
                tot += i.next().Spesa(costoKm);
            old = i.next();
        }
        return tot;
    }

    public double totaleSpesaPerGiorno(LocalDate giorno, double costoKm, double costoPerOra){
        double tot = 0;
        Iterator<Riparazione> i = riparazioni.iterator();
        Riparazione old = riparazioni.get(0);
        while(i.hasNext()){
            if(old.getDataRiparazione().getDayOfYear() == giorno.getDayOfYear())
            if(old instanceof InterventoEsterno)
                tot += i.next().Spesa(costoKm, costoPerOra);
            else if (old instanceof InterventoInLaboratorio)
                tot += i.next().Spesa(costoKm);
            old = i.next();
        }
        return tot;
    }

    public ArrayList<Riparazione> elencoPerCostoMateriale(){
        ArrayList<Riparazione> ordinati = new ArrayList<>(riparazioni);
        Riparazione temp;
        for(int i = 1; i < ordinati.size(); i++){
            if(ordinati.get(i-1).getCosto() > ordinati.get(1).getCosto()){
                temp = ordinati.get(i-1);
                ordinati.set(i-1,ordinati.get(i));
                ordinati.set(i,ordinati.set(i,temp));
            }
            i = 1;
        }
        return ordinati;
    }

    public ArrayList<InterventoEsterno> elencoPerDistanzaMaggioreDi(double d){
        ArrayList<InterventoEsterno> ordinati = new ArrayList<>();
        Iterator<Riparazione> r = riparazioni.iterator();
        Riparazione old = riparazioni.get(0);

        //filto ed aggiunta istanze
        while(r.hasNext()) {
            if (old instanceof InterventoEsterno && ((InterventoEsterno) old).getDistanza() > d)
                ordinati.add((InterventoEsterno) old);
            old = r.next();
        }

        //ordinamento crescente
        InterventoEsterno temp;
        for(int i = 1; i < ordinati.size(); i++){
            if(ordinati.get(i-1).getDistanza() > ordinati.get(1).getDistanza()){
                temp = ordinati.get(i-1);
                ordinati.set(i-1,ordinati.get(i));
                ordinati.set(i,ordinati.set(i,temp));
            }
            i = 1;
        }
        return ordinati;
    }

    public ArrayList<InterventoEsterno> elencoPerDistanzaMinore(){
        ArrayList<InterventoEsterno> ordinati = new ArrayList<>();
        Iterator<Riparazione> r = riparazioni.iterator();
        Riparazione old = riparazioni.get(0);

        //filto ed aggiunta istanze
        while(r.hasNext()) {
            if (old instanceof InterventoEsterno)
                ordinati.add((InterventoEsterno) old);
            old = r.next();
        }

        //ordinamento crescente
        InterventoEsterno temp;
        for(int i = 1; i < ordinati.size(); i++){
            if(ordinati.get(i-1).getDistanza() > ordinati.get(1).getDistanza()){
                temp = ordinati.get(i-1);
                ordinati.set(i-1,ordinati.get(i));
                ordinati.set(i,ordinati.set(i,temp));
            }
            i = 1;
        }
        return ordinati;
    }
}
