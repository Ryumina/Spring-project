package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	@GetMapping
	public String showDesignForm(Model model) {
		
		// 타코 식사재를 나타내는 ingredient 객체를 저장하는 List 생성하여 뷰에 전달
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO", "Flour Tortilla", 	Type.WRAP),
				new Ingredient("COTO", "Corn Tortilla", 	Type.WRAP),
				new Ingredient("GRBF", "Ground Beef", 		Type.PROTEIN),
				new Ingredient("CARN", "Carnitas", 			Type.PROTEIN),
				new Ingredient("TMTO", "Diced Tomatoes", 	Type.VEGGIES),
				new Ingredient("LETC", "Lettuce", 			Type.VEGGIES),
				new Ingredient("CHED", "Cheddar", 			Type.CHEESE),
				new Ingredient("JACK", "Monterrey Jack", 	Type.CHEESE),
				new Ingredient("SLSA", "Salsa", 			Type.SAUCE),
				new Ingredient("SRCR", "Sour Cream", 		Type.SAUCE)
		);
		
		log.info("####### ingredients: {}", ingredients);
		
		// WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
		Type[] types = Ingredient.Type.values();
		
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), fillterByType(ingredients, type));
		}
		
		model.addAttribute("taco", new Taco());
		
		log.info("####### model: {}", model);
		
		return "design";
	}

	private List<Ingredient> fillterByType(List<Ingredient> ingredients, Type type) {
		return ingredients
				.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public String processDesign(@Valid Taco design, Errors errors) {
		
		if(errors.hasErrors()) return "design";
		
		// 해당 메서드에서는 타코 디자인 (브라우저에서 선택한 식자재 내역) 을 저장한다.
		log.info("Processing design: {}", design);
		
		return "redirect:/orders/current";
	}
}
