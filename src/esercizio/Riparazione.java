package esercizio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Riparazione extends Spesa{
    private Chiamata chiamata;
    private int id;
    private LocalDateTime dataRiparazione;
    private String nomeTecnico;
    private String descrizioneProdotto, descrizioneIntervento;
    private double costo;
    private LocalDateTime tempoImpegato;

    public Riparazione() {}

    public Riparazione(Chiamata chiamata, int id, LocalDateTime dataRiparazione, String nomeTecnico, String descrizioneProdotto, String descrizioneIntervento, double costo, LocalDateTime tempoImpegato) {
        this.chiamata = chiamata;
        this.id = id;
        this.dataRiparazione = dataRiparazione;
        this.nomeTecnico = nomeTecnico;
        this.descrizioneProdotto = descrizioneProdotto;
        this.descrizioneIntervento = descrizioneIntervento;
        this.costo = costo;
        this.tempoImpegato = tempoImpegato;
    }

    public Riparazione(Riparazione r) {
        this.chiamata = r.chiamata;
        this.id = r.id;
        this.dataRiparazione = r.dataRiparazione;
        this.nomeTecnico = r.nomeTecnico;
        this.descrizioneProdotto = r.descrizioneProdotto;
        this.descrizioneIntervento = r.descrizioneIntervento;
        this.costo = r.costo;
        this.tempoImpegato = r.tempoImpegato;
    }

    public Chiamata getChiamata() {
        return chiamata;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataRiparazione() {
        return dataRiparazione;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public String getDescrizioneProdotto() {
        return descrizioneProdotto;
    }

    public String getDescrizioneIntervento() {
        return descrizioneIntervento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDateTime getTempoImpegato() {
        return tempoImpegato;
    }

    public void setTempoImpegato(LocalDateTime tempoImpegato) {
        this.tempoImpegato = tempoImpegato;
    }

    @Override //esterno
    public double Spesa(double costoKm, double costoPerOra) {
        return 0;
    }

    @Override //in loboratorio
    public double Spesa(double costoPerOra) {
        return 0;
    }
}
