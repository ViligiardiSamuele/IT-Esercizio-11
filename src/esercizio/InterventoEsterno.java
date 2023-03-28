package esercizio;

import java.time.LocalDateTime;

public class InterventoEsterno extends Riparazione {
    private String indirizzoCliente;
    private double distanza;

    public InterventoEsterno(String indirizzoCliente, double distanza) {
        this.indirizzoCliente = indirizzoCliente;
        this.distanza = distanza;
    }

    public InterventoEsterno(Chiamata chiamata, int id, LocalDateTime dataRiparazione, String nomeTecnico, String descrizioneProdotto, String descrizioneIntervento, double costo, LocalDateTime tempoImpegato, String indirizzoCliente, double distanza) {
        super(chiamata, id, dataRiparazione, nomeTecnico, descrizioneProdotto, descrizioneIntervento, costo, tempoImpegato);
        this.indirizzoCliente = indirizzoCliente;
        this.distanza = distanza;
    }

    public InterventoEsterno(Riparazione r, String indirizzoCliente, double distanza) {
        super(r);
        this.indirizzoCliente = indirizzoCliente;
        this.distanza = distanza;
    }

    public String getIndirizzoCliente() {
        return indirizzoCliente;
    }

    public double getDistanza() {
        return distanza;
    }
    @Override public double Spesa(double costoKm, double costoPerOra){
        return QUOTA_FISSA + super.getCosto()
                + (distanza*costoKm)
                + (super.getTempoImpegato().getHour()*costoPerOra);
    }
}