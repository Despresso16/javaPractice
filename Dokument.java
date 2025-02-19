import java.math.BigInteger;

public abstract class Dokument implements Przeszukiwalne{
    public Osoba wlasciciel;
    public String dataWaznosciDokumentu;

    public Dokument(Osoba wlasciciel, String dataWaznosciDokumentu) {
        this.wlasciciel = wlasciciel;
        this.dataWaznosciDokumentu = dataWaznosciDokumentu;
    }
    public abstract String toString();
}
