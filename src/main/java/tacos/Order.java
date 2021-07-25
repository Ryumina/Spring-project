package tacos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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
	
	private Date placedAt;
	
	@ManyToMany(targetEntity = Taco.class)
	private List<Taco> tacos = new ArrayList<>();
	
	public void addDesign(Taco design) {
		this.tacos.add(design);
	}
	
	@PrePersist
	void placesAt() {
		this.placedAt = new Date();
	}
}
