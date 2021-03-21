package tacos;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class Order {
	
	@NotBlank(message="필수 입력값입니다.")
	private String deliveryName;
	
	@NotBlank(message="필수 입력값입니다.")
	private String deliveryStreet;
	
	@NotBlank(message="필수 입력값입니다.")
	private String deliveryCity;
	
	@NotBlank(message="필수 입력값입니다.")
	private String deliveryState;
	
	@NotBlank(message="필수 입력값입니다.")
	private String deliveryZip;
	
	@CreditCardNumber(message="유효하지 않은 카드 번호입니다.")
	private String ccNumber;
	
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="MM/YY 형식이어야 합니다.")
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message="CVV 값이 유효하지 않습니다.")
	private String ccCVV;
}
