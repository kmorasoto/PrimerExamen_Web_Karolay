/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iTicket.service;


import com.iTicket.entity.Conciertos;
import com.iTicket.repository.ConciertosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */
@Service
public class ConciertosService implements IConciertosService {
    
    @Autowired
    private ConciertosRepository conciertosRepository;
    
    @Override
    public List<Conciertos> ListConciertos() {
        return (List<Conciertos>)conciertosRepository.findAll();
    }
}
