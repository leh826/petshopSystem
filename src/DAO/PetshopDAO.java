/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class PetshopDAO {
    PreparedStatement pstm;
    ResultSet rs; // Resultset é a biblioteca que trás dados do sql
    ArrayList<UEPA_dadosDTO> list = new ArrayList<>();
    //metodo para encontrar usuario no banco (login)
    public ResultSet autenticacaoUsuario(UEPA_LoginDTO objUsuariodto) { //cria obj p/recebe os atributos da classe DTO
        Connection conn = new ConnectionDAO().connectionBD();

        try {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ? "; //query para consultar no banco

            pstm = conn.prepareStatement(sql); //objeto criado p/ conectar dados java e instruções sql
            pstm.setString(1, objUsuariodto.getUsuario());
            pstm.setString(2, objUsuariodto.getSenha());

            rs = pstm.executeQuery(); // Trazer dados dados do BD

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erro no UsuarioDAO");
        }
        return null;
    }
    //metodo para cadastrar informações do aluno
    public void cadastrarAluno(UEPA_dadosDTO objUsuariodto) {
        String sql = "INSERT INTO aluno (nome,cpf,curso,telefone,turma,endereco,matricula) values (?,?,?,?,?,?,?)"; // cada ? é substituido por uma variável na hora da consulta do BD
        Connection conn = new ConnectionDAO().connectionBD();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsuariodto.getNome()); //variáveis que subistituem "?"
            pstm.setString(2, objUsuariodto.getCpf());
            pstm.setString(3, objUsuariodto.getCurso());
            pstm.setString(4, objUsuariodto.getTelefone());
            pstm.setString(5, objUsuariodto.getTurma());
            pstm.setString(6, objUsuariodto.getEndereco());
            pstm.setString(7, objUsuariodto.getMatricula());

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Cadastro" + erro);
        }

    }
    //metodo para mostrar alunos cadastrados no banco e seus dados
    public ArrayList<UEPA_dadosDTO> listarAluno() { //é criado lista para que possa ser guardado cada dado agrupado e mostrado sequencialmente 
        String sql = "SELECT * FROM aluno ";
        Connection conn = new ConnectionDAO().connectionBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                UEPA_dadosDTO objUsuariodto = new UEPA_dadosDTO();
                objUsuariodto.setId(rs.getInt("id"));  // o rs é o objeto que trás o dado que vem do banco
                objUsuariodto.setNome(rs.getString("Nome"));
                objUsuariodto.setCpf(rs.getString("CPF"));
                objUsuariodto.setCurso(rs.getString("Curso"));
                objUsuariodto.setTelefone(rs.getString("Telefone"));
                objUsuariodto.setTurma(rs.getString("Turma"));
                objUsuariodto.setEndereco(rs.getString("Endereco"));
                objUsuariodto.setMatricula(rs.getString("Matricula"));
                list.add(objUsuariodto);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Lista de alunos" + erro);
        }
        return list;
    }
    //metodo para alterar um dado do aluno
    public void alterarAluno(UEPA_dadosDTO objUsuariodto) {
        String sql = "UPDATE aluno set nome = ?, cpf = ?, curso=?,telefone= ?,turma= ?,endereco=?, matricula=? where id = ?";
        Connection conn = new ConnectionDAO().connectionBD();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsuariodto.getNome());  
            pstm.setString(2, objUsuariodto.getCpf());
            pstm.setString(3, objUsuariodto.getCurso());
            pstm.setString(4, objUsuariodto.getTelefone());
            pstm.setString(5, objUsuariodto.getTurma());
            pstm.setString(6, objUsuariodto.getEndereco());
            pstm.setString(7, objUsuariodto.getMatricula());
            pstm.setInt(8, objUsuariodto.getId());

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Alterar" + erro);
        }
    }
    //metodo para deletar o aluno da base de dados
    public void deletarAluno(UEPA_dadosDTO objUsuariodto) {
        String sql = "DELETE from aluno where id = ?";
        Connection conn = new ConnectionDAO().connectionBD();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objUsuariodto.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Deletar" + erro);
        }
    }
    //metodo para usar uma combobox
    public ResultSet listarSemestre() {
        String sql = "SELECT * FROM semestre;";
        Connection conn = new ConnectionDAO().connectionBD();
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Listar Semestres" + erro);
        return null;
        }
    }
}
