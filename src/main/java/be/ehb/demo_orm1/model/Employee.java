package be.ehb.demo_orm1.model;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String naam;
    private String email;
    private int telefoonNr;

    public Employee() {
        this.id = id;
        this.naam = naam;
        this.email = email;
        this.telefoonNr = telefoonNr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefoonNr() {
        return telefoonNr;
    }

    public void setTelefoonNr(int telefoonNr) {
        this.telefoonNr = telefoonNr;
    }
}
