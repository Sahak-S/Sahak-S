package itspace.tacocloudprojecht.component;

import itspace.tacocloudprojecht.model.Ingredient;
import org.springframework.stereotype.Component;
import itspace.tacocloudprojecht.model.Ingredient.Type;

import java.util.HashMap;
import java.util.Map;


import org.springframework.core.convert.converter.Converter;


@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO", new Ingredient("FLTO", "Բլիթի Ալյուր",Type.WRAP));
        ingredientMap.put("COTO",
                new Ingredient("COTO", "Եգիպտացորենի Ալյուր", Type.WRAP));
        ingredientMap.put("GRBF",
                new Ingredient("GRBF", "Տավարի աղացած միս", Type.PROTEIN));
        ingredientMap.put("CARN",
                new Ingredient("CARN", "Կարնիտաս", Type.PROTEIN));
        ingredientMap.put("TMTO",
                new Ingredient("TMTO", "Կտրտած լոլիկ", Type.VEGGIES));
        ingredientMap.put("LETC",
                new Ingredient("LETC", "գազար", Type.VEGGIES));
        ingredientMap.put("CHED",
                new Ingredient("CHED", "պանիր", Type.CHEESE));
        ingredientMap.put("JACK",
                new Ingredient("JACK", "Մոնթերեյ Ջեք պանիր", Type.CHEESE));
        ingredientMap.put("SLSA",
                new Ingredient("SLSA", "Սալսա  թանձրուկի տեսակ", Type.SAUCE));
        ingredientMap.put("SRCR",
                new Ingredient("SRCR", "Թթվասեր", Type.SAUCE));
    }


    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
