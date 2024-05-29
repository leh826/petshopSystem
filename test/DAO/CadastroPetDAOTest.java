/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Model.ModeloTabelaPets;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CadastroPetDAOTest {

    private CadastroPetDAO petDao;

    public CadastroPetDAOTest() {
    }

    @Before
    public void setUp() throws SQLException {
        petDao = new CadastroPetDAO();
    }

    /**
     * Test of insetCadastrosPet method, of class CadastroPetDAO.
     */

    @Test
    public void testInsetCadastrosPet() {
        ModeloTabelaPets pet = new ModeloTabelaPets();
        pet.setNomePet("teste-pet");
        pet.setEspecie("teste-");
        pet.setRaca("teste-pet");
        pet.setSexo("femea");
        pet.setIdade("pet24");
        pet.setCor("teste-pet");
        pet.setPeso("15");
        pet.setCaracteristicas("teste-pet");
        pet.setNomeTutor("teste-pet");
        pet.setContato("teste-pet");
        pet.setNum_cpf("teste-pet");
        pet.setEndereco("teste-pet");
        pet.setHistorico_vacinacao("teste");
        pet.setMedicamentos_uso("teste");
        pet.setAlergias("teste");
        pet.setHist_doencas_cond_medicas("teste"); 
       petDao.insetCadastrosPet(pet.getNomePet(), pet.getEspecie(), pet.getRaca(), pet.getSexo(), pet.getIdade(), pet.getCor(), pet.getPeso(), pet.getCaracteristicas(), pet.getNomeTutor(), pet.getContato(), pet.getNum_cpf(), pet.getEndereco(), pet.getHistorico_vacinacao(), pet.getMedicamentos_uso(), pet.getAlergias(), pet.getHist_doencas_cond_medicas());
       
       assert (pet.equals(pet));

    }

    /**
     * Test of alterCadastros method, of class CadastroPetDAO.
     */
    
    @Test
    public void testAlterCadastros() {
        ModeloTabelaPets pet = new ModeloTabelaPets();
        pet.setNomePet("BACKEND");
        petDao.alterCadastros(pet.getNomePet(), pet.getNomePet(), 1);
        assert (pet.equals(pet)); //Se for true que dizer que o objeto foi alterado no banco de acordo com os sets acima
    }

    /**
     * Test of deleteCadastros method, of class CadastroPetDAO.
     */
    
    @Test
    public void testDeleteCadastros() {
        int idParaDeletar = 1009;
        System.out.println("Deletando registro de numero " + idParaDeletar);
        petDao.deleteCadastros(idParaDeletar);
        assert (petDao.existsById(idParaDeletar) == false);
    }

}
