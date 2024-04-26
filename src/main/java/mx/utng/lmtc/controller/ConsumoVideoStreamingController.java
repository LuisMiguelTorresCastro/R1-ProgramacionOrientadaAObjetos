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
import mx.utng.lmtc.model.entity.ConsumoVideoStreaming;
import mx.utng.lmtc.model.service.IConsumoVideoStreamingService;

@Controller
@SessionAttributes("consumoVideoStreaming")
public class ConsumoVideoStreamingController {
    
    @Autowired
    private IConsumoVideoStreamingService service;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Consumo Video Streaming");
        model.addAttribute("consumoVideoStreamings", service.list());
        return "list";
    }

    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Consumo Video Streaming");
        model.addAttribute("consumoVideoStreaming", new ConsumoVideoStreaming());
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid ConsumoVideoStreaming consumoVideoStreaming, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de consumo video streaming");
            return "form";
        }
        service.save(consumoVideoStreaming);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ConsumoVideoStreaming consumoVideoStreaming = null;
        if(id>0){
            consumoVideoStreaming = service.getById(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar Consumo");
        model.addAttribute("consumoVideoStreaming", consumoVideoStreaming);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/list";
    }



}
