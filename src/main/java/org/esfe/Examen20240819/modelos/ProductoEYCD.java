package org.esfe.Examen20240819.modelos;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "productos")
public class ProductoEYCD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El campo es requerido")
    private String nameEYCD;

    @NotBlank(message = "El campo es requerido")
    private String descriptionEYCD;

    @NotBlank(message = "El campo es requerido")
    private double priceEYCD;

    @NotBlank(message = "El campo es requerido")
    private Date expireEYCD;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEYCD() {
        return nameEYCD;
    }

    public void setNameEYCD(String nameEYCD) {
        this.nameEYCD = nameEYCD;
    }

    public String getDescriptionEYCD() {
        return descriptionEYCD;
    }

    public void setDescriptionEYCD(String descriptionEYCD) {
        this.descriptionEYCD = descriptionEYCD;
    }

    public double getPriceEYCD() {
        return priceEYCD;
    }

    public void setPriceEYCD(double priceEYCD) {
        this.priceEYCD = priceEYCD;
    }

    public Date getExpireEYCD() {
        return expireEYCD;
    }

    public void setExpireEYCD(Date expireEYCD) {
        this.expireEYCD = expireEYCD;
    }

    

}
