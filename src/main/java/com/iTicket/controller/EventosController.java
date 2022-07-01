/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iTicket.controller;

import com.iTicket.entity.Conciertos;
import com.iTicket.entity.Eventos;
import com.iTicket.service.IConciertosService;
import com.iTicket.service.IEventosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventosController {
    @Autowired
    private IEventosService eventosService;
    
    @Autowired
    private IConciertosService conciertosService;
    
    @GetMapping("/eventos") //cuando reciba esto (localhost/persona) en el navegador va a reconocer que tiene que realizar toda esta accion
    public String index (Model model){
        List<Eventos> listaEventos = eventosService.getAllEventos();
        model.addAttribute("titulo","Tabla Eventos");
        model.addAttribute("eventos",listaEventos);
        return "eventos";
    }

    @GetMapping("/eventosN")
    public String crearEventos (Model model){
        List<Conciertos> listaConciertos = conciertosService.ListConciertos();
        model.addAttribute("eventos",new Eventos());
        model.addAttribute("conciertos",listaConciertos);
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarEventos (@ModelAttribute Eventos eventos){
        eventosService.saveEventos(eventos); //con esto lo guardo en mi base de datos
        return "redirect:/eventos";
    }
    
     @GetMapping("/editEventos/{id}")
    public String editarEventos (@PathVariable("id") Long idEventos, Model model){
        Eventos eventos = eventosService.getEventosById(idEventos);
        List<Conciertos> listaConciertos = conciertosService.ListConciertos();
        model.addAttribute("eventos",eventos);
        model.addAttribute("conciertos",listaConciertos);
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarEventos (@PathVariable("id") Long idEventos){
        eventosService.delete(idEventos);
        return "redirect:/eventos";
    }
}
