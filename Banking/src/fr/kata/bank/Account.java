package fr.kata.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account{
	private BigDecimal balance;
	private List<Transaction> transactions;
	
	public Account() {
		this.balance = BigDecimal.ZERO;
		this.transactions = new ArrayList<>();
	}
	
	public void deposit(BigDecimal amount){
		Transaction t = new Transaction("CREDIT",amount, LocalDateTime.now(),balance);
		balance = t.execute();
		this.transactions.add(t);
	}
	
	public void withdraw(BigDecimal amount){
		Transaction t = new Transaction("DEBIT",amount.negate(), LocalDateTime.now(), balance);
		balance = t.execute();
		this.transactions.add(t);
		
	}
	
	public BigDecimal getBalance(){
		return  balance;
	}
	
	public String printStatement(){
		StringBuilder sb = new StringBuilder();
		sb.append("TYPE AMOUNT BALANCE DATE");
		for (Transaction transaction : transactions) {
			sb.append("\n");
			sb.append(transaction.type + " ");
			sb.append(transaction.amount + " ");
			sb.append(transaction.balance + " ");
			sb.append(transaction.date.format(
					DateTimeFormatter.ofPattern("dd/MM/yyyy -- HH:mm:ss")));
		}
		return sb.toString();

		}
		
}
