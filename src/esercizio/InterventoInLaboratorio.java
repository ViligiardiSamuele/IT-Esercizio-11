package esercizio;

import java.time.LocalDateTime;

public class InterventoInLaboratorio extends Riparazione {
    private LocalDateTime dataRitiro;

    public InterventoInLaboratorio(LocalDateTime dataRitiro) {
        this.dataRitiro = dataRitiro;
    }

    public InterventoInLaboratorio(Chiamata chiamata, int id, LocalDateTime dataRiparazione, String nomeTecnico, String descrizioneProdotto, String descrizioneIntervento, double costo, LocalDateTime tempoImpegato, LocalDateTime dataRitiro) {
        super(chiamata, id, dataRiparazione, nomeTecnico, descrizioneProdotto, descrizioneIntervento, costo, tempoImpegato);
        this.dataRitiro = dataRitiro;
    }

    public InterventoInLaboratorio(Riparazione r, LocalDateTime dataRitiro) {
        super(r);
        this.dataRitiro = dataRitiro;
    }

    @Override public double Spesa(double costoPerOra){
        return QUOTA_FISSA + super.getCosto() + (super.getTempoImpegato().getHour()*costoPerOra);
    }
}
