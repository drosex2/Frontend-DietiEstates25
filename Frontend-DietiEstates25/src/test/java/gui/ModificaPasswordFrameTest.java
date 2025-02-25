package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dto.Agenzia;
import dto.Amministratore;
import exceptions.PasswordNonValidaException;
import starter.Starter;

class ModificaPasswordFrameTest {
		Agenzia agenzia=new Agenzia("Agency SRL","Roma","Via Napoli");
		Amministratore amministratore=new Amministratore("amministratoreCapo","NuovaPassword2@",agenzia);
		ModificaPasswordFrame frame=new ModificaPasswordFrame(new Starter(),amministratore,"token");
	
		
	
		
	@Test
	void testIllegalNuovaPassword() {
		String vecchiaPassword="prova";
		String nuovaPassword="";
		assertThrows(IllegalArgumentException.class,()->{
			frame.checkModifyPassword(nuovaPassword, vecchiaPassword);
			});
		
	}
	
	
	
	
	
	@Test
	void testIllegalVecchiaPassword() {
		String vecchiaPassword="";
		String nuovaPassword="prova";
		assertThrows(IllegalArgumentException.class,()->{
			frame.checkModifyPassword(nuovaPassword, vecchiaPassword);
			});
		
	}
	
	
	
	
	
	@Test
	void testNewPasswordNotValid() {
		String vecchiaPassword="NuovaPassword2@";
		String nuovaPassword="passwordnonvalida";
		assertThrows(PasswordNonValidaException.class,()->{
			frame.checkModifyPassword(nuovaPassword, vecchiaPassword);
			});
	}
	
	
	
	
	
	
	
	@Test
	void testEqualPassword() throws PasswordNonValidaException {
		String vecchiaPassword="NuovaPassword2@";
		String nuovaPassword="NuovaPassword2@";
		boolean result;
		result=frame.checkModifyPassword(nuovaPassword, vecchiaPassword);
		assertFalse(result);
	}
	
	
	
	
	
	
	
	
	@Test
	void testResultTrue()throws PasswordNonValidaException {
		String vecchiaPassword="NuovaPassword2@";
		String nuovaPassword="NuovaPassword3@";
		boolean result;
		result=frame.checkModifyPassword(nuovaPassword, vecchiaPassword);
		assertTrue(result);
	}
	
	
	
	
}
