package ovh.devnote.hello18.dto;

import java.util.List;

public class BookDTO {
    private String nazwa;

    private int id;
    private String wydawnictwo;

    private float cena;

    private int kategoriaid;
    private List<Integer> authorsid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookDTO() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getKategoriaid() {
        return kategoriaid;
    }

    public void setKategoriaid(int kategoriaid) {
        this.kategoriaid = kategoriaid;
    }

    public List<Integer> getAuthorsid() {
        return authorsid;
    }

    public void setAuthorsid(List<Integer> authorsid) {
        this.authorsid = authorsid;
    }

}