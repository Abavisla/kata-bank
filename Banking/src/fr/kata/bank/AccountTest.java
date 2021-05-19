package fr.kata.bank;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountTest {

	private Account account;
	
    @BeforeEach                                         
    public void setUp() throws Exception {
    	account = new Account();
    }

    @Test                                               
    @DisplayName("Simple deposit should work")   
    public void testDeposit() {
    	account.deposit(new BigDecimal(50));
        assertEquals(new BigDecimal(50), account.getBalance());          
    }
    
    @Test                                               
    @DisplayName("Multiple deposits should work")   
    public void testDeposits() {
    	account.deposit(new BigDecimal(50));
    	account.deposit(new BigDecimal(50));
    	account.deposit(new BigDecimal(50));
    	account.deposit(new BigDecimal(50));
        assertEquals(new BigDecimal(200), account.getBalance());          
    }
    
    
    @Test                                               
    @DisplayName("Simple withdrawal should work")   
    public void testWithdrawal() {
    	account.deposit(new BigDecimal(100));
    	account.withdraw(new BigDecimal(100));
        assertEquals(new BigDecimal(0), account.getBalance());          
    }
    @Test                                               
    @DisplayName("Multiple withdrawal should work")   
    public void testWithdrawals() {
    	account.deposit(new BigDecimal(100));
    	account.withdraw(new BigDecimal(10));
    	account.withdraw(new BigDecimal(10));
    	account.withdraw(new BigDecimal(10));
    	account.withdraw(new BigDecimal(10));
    	account.withdraw(new BigDecimal(10));
        assertEquals(new BigDecimal(50), account.getBalance());          
    }
    
    @Test
    @DisplayName("withdrawal with amount more than balance should not work")   
    public void testWithdrawalMoreThanBalance() {
    	account.deposit(new BigDecimal(50));
    	account.withdraw(new BigDecimal(100));
        assertEquals(new BigDecimal(50), account.getBalance());          
    }
        
    
    

}
