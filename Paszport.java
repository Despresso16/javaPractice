import java.math.BigInteger;
import java.util.Objects;

public class Paszport extends Dokument{
    public Paszport(Osoba wlasciciel, String dataWaznosciDokumentu) {
        super(wlasciciel, dataWaznosciDokumentu);
    }

    public boolean czyPasuje(String wzorzec)
    {
        wzorzec = wzorzec.toLowerCase();
        return Objects.equals(wzorzec, this.wlasciciel.imie.toLowerCase()) || Objects.equals(wzorzec, this.wlasciciel.nazwisko.toLowerCase()) || Objects.equals(wzorzec, this.wlasciciel.dataUrodzenia.toLowerCase()) || Objects.equals(wzorzec, this.wlasciciel.pesel.toLowerCase()) || Objects.equals(wzorzec, this.dataWaznosciDokumentu.toLowerCase());
    }

    public String toString()
    {
        return "---Paszport---\nWlaściciel: "+this.wlasciciel.imie+" "+this.wlasciciel.nazwisko+"\nData urodzenia: "+this.wlasciciel.dataUrodzenia+"\nPESEL: "+this.wlasciciel.pesel+"\nData ważności dokumentu: "+this.dataWaznosciDokumentu;
    }
}
