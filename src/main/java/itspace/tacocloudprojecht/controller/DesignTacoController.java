package itspace.tacocloudprojecht.controller;

import itspace.tacocloudprojecht.model.Ingredient;
import itspace.tacocloudprojecht.model.Taco;
import itspace.tacocloudprojecht.model.TacoOrder;
import itspace.tacocloudprojecht.model.Ingredient.Type;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Բլիթի Ալյուր", Type.WRAP),
                new Ingredient("COTO", "Եգիպտացորենի Ալյուր", Type.WRAP),
                new Ingredient("GRBF", "Տավարի աղացած միս", Type.PROTEIN),
                new Ingredient("CARN", "Կարնիտաս", Type.PROTEIN),
                new Ingredient("TMTO", "Կտրտած լոլիկ", Type.VEGGIES),
                new Ingredient("LETC", "գազար", Type.VEGGIES),
                new Ingredient("CHED", "պանիր", Type.CHEESE),
                new Ingredient("JACK", " Մոնթերեյ Ջեք պանիր", Type.CHEESE),
                new Ingredient("SLSA", "Սալսա  թանձրուկի տեսակ", Type.SAUCE),
                new Ingredient("SRCR", "Թթվասեր", Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

//    @PostMapping
//    public String processTaco(@Valid Taco taco,
//                              @ModelAttribute TacoOrder tacoOrder) {
//        tacoOrder.addTaco(taco);
//        log.info("Processing taco: {}", taco);
//        return "redirect:/orders/current";
//    }

    @PostMapping
    public String processTaco(
            @Valid Taco taco, Errors errors,
            @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
            return "design";
        }
        tacoOrder.addTaco(taco);
        log.info("Taco-ի մշակում : {}", taco);
        return "redirect:/orders/current";
    }
}
