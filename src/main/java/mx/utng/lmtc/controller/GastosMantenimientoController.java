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
import mx.utng.lmtc.model.entity.GastosMantenimiento;
import mx.utng.lmtc.model.service.IGastosMantenimientoService;

@Controller
@SessionAttributes("gastosMantenimiento")
public class GastosMantenimientoController {
    
    @Autowired
    private IGastosMantenimientoService service;

    @GetMapping({"/gastosMantenimiento", "/gastosMantenimiento/", "/gastosMantenimiento/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Gastos Mantenimientos");
        model.addAttribute("gastosMantenimientos", service.list()); 
        return "gastosMantenimiento-list";
    }

    @GetMapping("/gastosMantenimiento/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Gastos Mantenimientos");
        model.addAttribute("gastosMantenimiento", new GastosMantenimiento());
        return "gastosMantenimiento-form";
    }

    @PostMapping("/gastosMantenimiento/form")
    public String save(@Valid GastosMantenimiento gastosMantenimiento, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de gastos mantenimientos");
            return "gastosMantenimiento-form";
        }
        service.save(gastosMantenimiento);
        return "redirect:/gastosMantenimiento/list";
    }

    @GetMapping("/gastosMantenimiento/form/{id}")
    public String update(@PathVariable Long id, Model model){
        GastosMantenimiento gastosMantenimiento = null;
        if(id>0){
            gastosMantenimiento = service.getById(id);
        }else{
            return "redirect:/gastosMantenimiento/list";
        }
        model.addAttribute("title", "Editar Gastos");
        model.addAttribute("gastosMantenimiento", gastosMantenimiento);
        return "gastosMantenimiento-form";
    }

    @GetMapping("/gastosMantenimiento/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/gastosMantenimiento/list";
    }



}