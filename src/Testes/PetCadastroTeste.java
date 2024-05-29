/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testes;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PetCadastroTeste {
 
    
    @Before
    static void setup(){
        departamentoDao = DaoFactory.criaDepartamentoDao();
    }

    @Test
    void findById(){
        Departamento d =  departamentoDao.findById(4);
        System.out.println("Departamento: " + d.toString());
        assert (d != null);
    }
    @Test
    void getAll(){
        List<Departamento> d = departamentoDao.getAll();
        System.out.println(d.toString());
        assert(d.size() > 0);
    }
    @Test
    public void inserir(){
        Departamento d = new Departamento();
        d.setNome("DEV");
        departamentoDao.insert(d);
        System.out.println(d);
        assert (departamentoDao.findById(d.getId()) != null);
    }
    @Test
    void update(){
            Departamento d= departamentoDao.findById(3);
            d.setNome("backend");
            departamentoDao.update(d);
            Departamento d2 = departamentoDao.findById(3);
            System.out.println(d2.toString());
            assert (d.equals(d2)); //Se for true que dizer que o objeto foi alterado no banco de acordo com os sets acima
        }
    @Test
    void delete(){
        int idParaDeletar = 4;
        System.out.println("Deletando registro de numero " + idParaDeletar);
        departamentoDao.delete(idParaDeletar);
        assert (departamentoDao.findById(idParaDeletar) == null);
    }
    }