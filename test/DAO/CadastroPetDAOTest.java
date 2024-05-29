/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Model.ModeloTabelaPets;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CadastroPetDAOTest {
    private  static  CadastroPetDAO petDao = null;
    public CadastroPetDAOTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of insetCadastrosPet method, of class CadastroPetDAO.
     */
    @Test
    public void testInsetCadastrosPet() {
        ModeloTabelaPets pet = new ModeloTabelaPets();
        pet.setNomePet("teste-pet");
        pet.setEspecie("teste-pet");
        pet.setRaca("teste-pet");
        pet.setSexo("teste-pet");
        pet.setIdade("teste-pet");
        pet.setCor("teste-pet");
        pet.setPeso("teste-pet");
        pet.setCaracteristicas ("teste-pet");
        pet.setNomeTutor("teste-pet");
        pet.setContato("teste-pet");
        pet.setNum_cpf("teste-pet");
        pet.setEndereco("teste-pet");
        pet.setHistorico_vacinacao("teste");
        pet.setMedicamentos_uso("teste");
        pet.setAlergias("teste");
        pet.setHist_doencas_cond_medicas("teste");
        petDao.insetCadastrosPet(nomePet, especie, raca, sexo, idade, cor, peso, caracteristicas, nomeTutor, contato, num_cpf, endereco, historico_vacinacao, medicamentos_uso, alergias, hist_doencas_cond_medicas);
        assert (pet.getId()) != null);
    }

    /**
     * Test of alterCadastros method, of class CadastroPetDAO.
     */
    @Test
    public void testAlterCadastros() {
    }

    /**
     * Test of deleteCadastros method, of class CadastroPetDAO.
     */
    @Test
    public void testDeleteCadastros() {
    }

    /**
     * Test of selectCadastros method, of class CadastroPetDAO.
     */
    @Test
    public void testSelectCadastros() {
    }
    
}
