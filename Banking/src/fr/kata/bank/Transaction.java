package fr.kata.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

	 BigDecimal amount;
	 LocalDateTime date;
	 BigDecimal balance;
	 String type;
	
	public Transaction(String type, BigDecimal amount, LocalDateTime date, BigDecimal balance) {
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.balance = balance;
	}

	public BigDecimal execute() {
		BigDecimal result = balance.add(amount);
		if(result.compareTo(BigDecimal.ZERO) >= 0) {
			balance = result;
			return result; 
		}
		return  balance;
	}
}
