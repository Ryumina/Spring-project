package tacos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {
	
	private Long id;
	
	@NotNull
	@Size(min=5, message="타코 이름은 5글자 이상이어야 합니다.")
	private String name;
	
	@Size(min=1, message="최소 1개 이상의 재료를 선택하여 주십시오.")
	private List<Ingredient> ingredients;
	
	private Date createdAt;

}
