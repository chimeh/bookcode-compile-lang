package com.TacoCloud.TacoCloud.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.TacoCloud.TacoCloud.Domain.Entities.Ingredient;
import com.TacoCloud.TacoCloud.Domain.Entities.Ingredient.Type;
import com.TacoCloud.TacoCloud.Domain.Entities.Order;
import com.TacoCloud.TacoCloud.Domain.Entities.Taco;
import com.TacoCloud.TacoCloud.Repositories.IngredientRepository;
import com.TacoCloud.TacoCloud.Repositories.TacoRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Slf4j annotation generates a logger as if you had used the logger factory
 * for this class.
 *
 * private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignController.class);
 *
 * The RequestMapping prefix is then used to handle all requests beginning with "/design"
 */
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private TacoRepository tacoRepository;

    /**
     * This is picked as it is mapped to the GET verb.
     *
     * @param model This is a Model object. We add attributes to the model object
     *              which can then be retrieved by the Thymeleaf template in order
     *              to populate the view template.
     *
     * @return
     */
    @GetMapping
    public String showDesignForm(Model model) {

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());

        return "design";
    }

    /**
     * This is picked as it is mapped to the POST verb
     *
     * This is fed back the design attribute populated above. It is populated using
     * Thymeleaf and the form, then submitted to this function using the button.
     *
     * @param design
     * @return
     */
    @PostMapping
    public String processDesign(
            Taco design,
            @ModelAttribute Order order
    ) {

        log.info("Processing design: " + design);

        Taco saved = tacoRepository.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }


    /*
     * Utilities
     */

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(ing -> ing.getType().equals(type)).collect(Collectors.toList());
    }

}
