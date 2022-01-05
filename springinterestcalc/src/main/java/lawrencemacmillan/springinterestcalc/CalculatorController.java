package lawrencemacmillan.springinterestcalc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ControllerAdvice
public class CalculatorController {
	
	@RequestMapping("/")
	public String calculator() {
		return "calculator";
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String userInput(BigDecimal lumpsum, BigDecimal interestrate, int inputYears, Model model) {
		
		BigDecimal initialinvestment = lumpsum;
	    
	    List<calculationObject> calculationObjectList = new ArrayList<calculationObject>();

	    calculationObject calculationObject = new calculationObject();
	    calculationObject.setBdcInterest(new BigDecimal(0));
	    calculationObject.setBdAmount(initialinvestment);
	    calculationObject.setInitialInvestment(initialinvestment);
	    calculationObject.setCurrentYearInterest(new BigDecimal(0));
	    calculationObject.setYears(0);
	    calculationObjectList.add(calculationObject);
	    
	    int increment = 1; // Declare increment counter variable
	    inputYears++;

		while(increment < inputYears) { // While the increment counter is less than the years input from the user, iterate the loop

			BigDecimal amount = lumpsum
					.multiply(BigDecimal
							.valueOf(1)
							.add(interestrate
									.divide(BigDecimal
											.valueOf(100)))); // Calculate the total yearly amount - 1.X times the interest rate from user
			
			BigDecimal currentYearInterest = lumpsum
					.multiply(BigDecimal
							.valueOf(0)
							.add(interestrate
									.divide(BigDecimal
											.valueOf(100)))); // Calculate the interest earned in the current year only - 0.X times the interest rate from user
			
			BigDecimal cInterest = amount.subtract(initialinvestment); // Calculate only the interest earned 
			
			calculationObject = new calculationObject();
			calculationObject.setBdAmount(amount);
			calculationObject.setBdcInterest(cInterest);
			calculationObject.setInitialInvestment(initialinvestment);
			calculationObject.setYears(increment);
			calculationObject.setCurrentYearInterest(currentYearInterest);
			calculationObjectList.add(calculationObject);
	        
			lumpsum = amount; // The lump sum variable is assigned the previous loops total to provide the compounding effect

	        increment++; // Increase increment counter by 1

		}
		
		model.addAttribute("calculationObjects", calculationObjectList);

		return "userinput";

	}
	
}