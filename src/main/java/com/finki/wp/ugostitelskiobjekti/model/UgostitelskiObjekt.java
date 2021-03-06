package com.finki.wp.ugostitelskiobjekti.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class UgostitelskiObjekt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String imeNaObjekt;
    private Integer vkupnoMasi;
    private String adresa;
    private String opis;

    @Lob
    @Column(nullable = true)
    private String urlImg;


    @OneToMany
    private List<Rezervacija> rezervacijaList;

    @ManyToOne
    private Grad grad;

    @ManyToOne//(cascade = CascadeType.ALL)
    private Shef shef;

    @OneToMany
    private List<Vraboten> vrabotenList;


    public UgostitelskiObjekt() {
    }



    public UgostitelskiObjekt(String imeNaObjekt, String adresa, String opis, Integer vkupnoMasi, Grad grad, Shef shef) {
        this.imeNaObjekt = imeNaObjekt;
        this.vkupnoMasi = vkupnoMasi;
        this.adresa = adresa;
        this.opis = opis;

        this.rezervacijaList = new ArrayList<>();
        this.grad = grad;
        this.shef = shef;
        this.vrabotenList = new ArrayList<>();
    }
}
