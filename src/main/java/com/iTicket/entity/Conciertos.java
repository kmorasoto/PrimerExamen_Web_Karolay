/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iTicket.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="conciertos")
public class Conciertos implements Serializable {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String conciertos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConciertos() {
        return conciertos;
    }

    public void setConciertos(String conciertos) {
        this.conciertos = conciertos;
    }

    
}
