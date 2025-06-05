package kr.ac.hansung.cse.homework2.controller;

import jakarta.validation.Valid;
import kr.ac.hansung.cse.homework2.entity.Product;
import kr.ac.hansung.cse.homework2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping({"", "/"}) // products 또는 /products/ 둘 다 매핑
    public String viewHomePage(Model model) {

        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "index";
    }

    @GetMapping("/new")
    public String showNewProductPage(Model model) {

        Product product = new Product(); // 비어있는 객체
        model.addAttribute("product", product);

        return "new_product";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable(name = "id") Long id, Model model) {

        Product product = service.get(id); // 조회해서 모델에 집어넣음
        model.addAttribute("product", product);

        return "edit_product";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("검증 오류 발생:");
            bindingResult.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
            return "new_product";
        }

        service.save(product);

        return "redirect:/products";
    }

    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("검증 오류 발생:");
            bindingResult.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
            return "edit_product";
        }

        service.save(product);

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {

        service.delete(id);
        return "redirect:/products";
    }
}
