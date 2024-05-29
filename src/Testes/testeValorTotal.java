/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testes;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class testeValorTotal {


	@Test
	public void deveSomarDoisValores() {
		int valorA = 1;
		int valorB = 2;
		
		testeValorTotal calc = new testeValorTotal();
		int soma = calc.somar(valorA, valorB);
		
		assertEquals(3, soma);
	}
	
	@Test
	public void deveSomarTresValores() {
		int valorA = 1;
		int valorB = 2; 
		int valorC = 3;
		
		testeValorTotal calc = new testeValorTotal();
		int soma = calc.somar(valorA, valorB, valorC);
		
		assertEquals(6, soma);
	}


}
