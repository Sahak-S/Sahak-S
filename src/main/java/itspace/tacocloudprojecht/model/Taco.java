package itspace.tacocloudprojecht.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;


@Data
public class Taco {

    @NotNull
    @Size(min=5, message="Անունը պետք է լինի առնվազն 5 նիշ")
    private String name;
    @NotNull
    @Size(min=1, message="Դուք պետք է ընտրեք առնվազն 1 բաղադրիչ")
    private List<Ingredient> ingredients;
}
