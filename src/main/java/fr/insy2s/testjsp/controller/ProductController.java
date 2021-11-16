package fr.insy2s.testjsp.controller;

import fr.insy2s.testjsp.model.Product;
import fr.insy2s.testjsp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller     //spécifie que'il s'agit d'un controller qui va renvoyer du HTML, opposé à @RestController qui renvoie de la donnée pure
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    /**
     * Affiche la page All Product
     *
     * @param model le model JSP de Spring, dans lequel on va pouvoir injecter des variables
     * @return la page all_products.jsp
     */
    @GetMapping("/products")
    public String getAllProduct(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);   //ajout d'un attribut "products" étant la liste récupérer en BDD
        return "all_products"; //nom du fichier all_products.jsp à afficher
    }

    ////////////////////
    ///CREATE PRODUCT///
    ////////////////////
    /**
     * Affiche la page du formulaire add product
     * On crée un objet Product vide avant de l'envoyé dans le Formulaire
     *
     * @param model model Spring qui va récup l'attribut product
     * @return la page form_add_product.jsp
     */
    @GetMapping("/add-product")
    public String formCreateProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "form_add_product";
    }

    /**
     *
     * Requete POST /add-product permettant d'enregistrer un Product en BDD, venant du formulaire de la page form_add_product.jsp (venue de la méthode au dessus)
     *
     * @param product l'entité à enregistré en BDD (étant récupéré du formulaire)
     * @return redirrige vers GET /products
     */
    @PostMapping("/add-product")
    public String saveProduct(@ModelAttribute("product") Product product){
        productRepository.save(product);
        return "redirect:/products";
    }


}
