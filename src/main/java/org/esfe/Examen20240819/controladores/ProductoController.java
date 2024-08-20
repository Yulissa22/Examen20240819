package org.esfe.Examen20240819.controladores;

import org.esfe.Examen20240819.modelos.ProductoEYCD;
import org.esfe.Examen20240819.servicios.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<ProductoEYCD> productos = productoService.buscarTodosPaginados(pageable);
        model.addAttribute("productos", productos);

        int totalPages = productos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "producto/index";
    }

    @GetMapping("/create")
    public String create(ProductoEYCD productoEYCD){
        return "producto/create";
    }

    @PostMapping("/save")
    public String save(ProductoEYCD productoEYCD, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            model.addAttribute(productoEYCD);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "producto/create";
        }

        productoService.crearOEditar(productoEYCD);
        attributes.addFlashAttribute("msg", "Produco creado correctamente");
        return "redirect:/productos";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        ProductoEYCD productoEYCD = productoService.buscarPorId(id).get();
        model.addAttribute("producto", productoEYCD);
        return "producto/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        ProductoEYCD productoEYCD = productoService.buscarPorId(id).get();
        model.addAttribute("producto", productoEYCD);
        return "producto/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        ProductoEYCD productoEYCD = productoService.buscarPorId(id).get();
        model.addAttribute("producto", productoEYCD);
        return "producto/delete";
    }

    @PostMapping("/delete")
    public String delete(ProductoEYCD productoEYCD, RedirectAttributes attributes){
        productoService.eliminarPorId(productoEYCD.getId());
        attributes.addFlashAttribute("msg", "producto eliminado correctamente");
        return "redirect:/productos";
    }
    
}
