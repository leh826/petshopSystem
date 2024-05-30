/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import DAO.CadastroPetDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Iumy P.F
 */
public class ControlerCadPet {
    
    private String nomePet;
    private String especie;
    private String raca;
    private String sexo;
    private String idade;
    private String cor;
    private String peso;
    private String caracteristicas;
    
    private String historico_vacinacao;
    private String medicametos_uso;
    private String alergias;
    private String hist_doencas_cond_medicas;
    
    private String nomeTutor;
    private String contato;
    private String num_cpf;
    private String endereco;

    public ControlerCadPet(String nomePet, String especie, String raca, String sexo, String idade, String cor, String peso, String caracteristicas, String historico_vacinacao, String medicametos_uso, String alergias, String hist_doencas_cond_medicas, String nomeTutor, String contato, String num_cpf, String endereco) {
        this.nomePet = nomePet;
        this.especie = especie;
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.cor = cor;
        this.peso = peso;
        this.caracteristicas = caracteristicas;
        this.historico_vacinacao = historico_vacinacao;
        this.medicametos_uso = medicametos_uso;
        this.alergias = alergias;
        this.hist_doencas_cond_medicas = hist_doencas_cond_medicas;
        this.nomeTutor = nomeTutor;
        this.contato = contato;
        this.num_cpf = num_cpf;
        this.endereco = endereco;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getHistorico_vacinacao() {
        return historico_vacinacao;
    }

    public void setHistorico_vacinacao(String historico_vacinacao) {
        this.historico_vacinacao = historico_vacinacao;
    }

    public String getMedicametos_uso() {
        return medicametos_uso;
    }

    public void setMedicametos_uso(String medicametos_uso) {
        this.medicametos_uso = medicametos_uso;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getHist_doencas_cond_medicas() {
        return hist_doencas_cond_medicas;
    }

    public void setHist_doencas_cond_medicas(String hist_doencas_cond_medicas) {
        this.hist_doencas_cond_medicas = hist_doencas_cond_medicas;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNum_cpf() {
        return num_cpf;
    }

    public void setNum_cpf(String num_cpf) {
        this.num_cpf = num_cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    public boolean validaDadosCorretos(){
        
        if(getNomePet() == null || getEspecie() == null || getSexo() == null || getCaracteristicas() == null || getNomeTutor() == null){
            
            
            return true;
            
            
        }else{
                        
            return false;
        }
        
        
    }
    
    
    
}
