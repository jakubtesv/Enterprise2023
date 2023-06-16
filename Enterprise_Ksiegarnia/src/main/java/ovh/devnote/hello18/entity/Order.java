package ovh.devnote.hello18.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {

    public Order() {
    }
    public Order(float price, String status, Date date_time, User user, Set<Ksiazka> ksiazki) {
        this.price = price;
        this.status = status;
        this.date_time = date_time;
        this.user = user;
        this.ksiazki = ksiazki;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="price")
    private float price;

    @Column(name="status")
    private String status;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name="date_time")
    private Date date_time;

    //user moze miec wiele zamowien, zamowienie jednego usera
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="username")
    private User user;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(
            name="zamowienia_to_ksiazki",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="ksiazka_id")

    )
    private Set<Ksiazka> ksiazki;



    @Override
    public String toString() {
        return "Zamowienie{" +
                "id=" + id +
                ", cena='" + price + '\'' +
                ", status='" + status + '\'' +
                ", data=" + date_time +
                ", uzytkownik=" + user.getUsername() +
                '}';
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate_time() {
        return date_time;
    }

    public User getUser() {
        return user;
    }

    public Set<Ksiazka> getKsiazki() {
        return ksiazki;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setKsiazki(Set<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
        for(Ksiazka ksiazka : ksiazki){
            ksiazka.addOrder(this);
        }
    }
}
