package mx.utng.lmtc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.lmtc.model.entity.ListaDeseosMascota;
import mx.utng.lmtc.model.service.IListaDeseosMascotaService;

@Controller
@SessionAttributes("listaDeseosMascota")
public class ListaDeseosMascotaController {
    
    @Autowired
    private IListaDeseosMascotaService service;

    @GetMapping({"/listaDeseosMascota", "/listaDeseosMascota/", "/listaDeseosMascota/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Lista Deseos Mascotas");
        model.addAttribute("listaDeseosMascotas", service.list());
        return "listaDeseosMascota-list";
    }

    @GetMapping("/listaDeseosMascota/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Lista Deseos Mascotas");
        model.addAttribute("listaDeseosMascota", new ListaDeseosMascota());
        return "listaDeseosMascota-form";
    }

    @PostMapping("/listaDeseosMascota/form")
    public String save(@Valid ListaDeseosMascota listaDeseosMascota, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de lista deseos mascotas");
            return "listaDeseosMascota-form";
        }
        service.save(listaDeseosMascota);
        return "redirect:/listaDeseosMascota/list";
    }

    @GetMapping("/listaDeseosMascota/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ListaDeseosMascota listaDeseosMascota = null;
        if(id>0){
            listaDeseosMascota = service.getById(id);
        }else{
            return "redirect:/listaDeseosMascota/list";
        }
        model.addAttribute("title", "Editar Lista");
        model.addAttribute("listaDeseosMascota", listaDeseosMascota);
        return "listaDeseosMascota-form";
    }

    @GetMapping("/listaDeseosMascota/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/listaDeseosMascota/list";
    }



}
