package esercizio;

import java.time.LocalDateTime;

public class Chiamata {
    private LocalDateTime arrivoRichiesta;

    private String nome, cognome, cf;
    private int telefono;

    public Chiamata(LocalDateTime arrivoRichiesta, String nome, String cognome, String cf, int telefono) {
        this.arrivoRichiesta = arrivoRichiesta;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.telefono = telefono;
    }

    public LocalDateTime getArrivoRichiesta() {
        return arrivoRichiesta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCf() {
        return cf;
    }

    public int getTelefono() {
        return telefono;
    }
}