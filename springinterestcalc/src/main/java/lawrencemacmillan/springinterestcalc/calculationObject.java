package lawrencemacmillan.springinterestcalc;

import java.math.BigDecimal;

public final class calculationObject {
		
		  private BigDecimal amount;
		  private BigDecimal bdcInterest;
		  private BigDecimal initialInvestment;
		  private BigDecimal currentYearInterest;
		  private int year;
		  
		  // Getter
		  public BigDecimal getBdAmount() {
		    return amount;
		  }
		  
		  // Setter
		  public void setBdAmount(BigDecimal c) {
		    this.amount = c;
		  }
		  
		  // Getter
		  public BigDecimal getBdcInterest() {
		    return bdcInterest;
		  }
		  
		  // Setter
		  public void setBdcInterest(BigDecimal c) {
		    this.bdcInterest = c;
		  }

		  // Getter
		  public BigDecimal getInitialInvestment() {
		    return initialInvestment;
		  }
		  
		  // Setter
		  public void setInitialInvestment(BigDecimal c) {
		    this.initialInvestment = c;
		  }
		  
	      // Getter
		  public Integer getYears() {
		    return year;
		  }
		  
		  // Setter
		  public void setYears(Integer c) {
		    this.year = c;
		  }		  
		  
	      // Getter
		  public BigDecimal getCurrentYearInterest() {
		    return currentYearInterest;
		  }
		  
		  // Setter
		  public void setCurrentYearInterest(BigDecimal c) {
		    this.currentYearInterest = c;
		  }
}