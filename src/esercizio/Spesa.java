package esercizio;

public abstract class Spesa {
    protected final double QUOTA_FISSA = 100;

    public abstract double Spesa(double costoKm, double costoPerOra);
    public abstract double Spesa(double costoPerOra);
}
