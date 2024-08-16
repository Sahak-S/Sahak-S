package itspace.tacocloudprojecht.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {


    @NotBlank(message="Մուտքագրեք առաքման տեղը")
    private String deliveryName;
    @NotBlank(message="Փողոցը պարտադիր է")
    private String deliveryStreet;
    @NotBlank(message="Քաղաքը պարտադիր է")
    private String deliveryCity;
    @NotBlank(message="Պետություն պարտադիր է")
    private String deliveryState;
    @NotBlank(message="Փոստային ինդեքսն պարտադիր է")
    private String deliveryZip;
    @CreditCardNumber(message="Վարկային քարտի համարը վավեր չէ")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Պետք է ձևաչափված լինի MM/YY")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Անվավեր CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
