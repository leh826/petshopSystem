/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iumy P.F
 */
public class ModeloTabelaPets {
    
    private static DefaultTableModel modeloTabela;
    
    public static List<ModeloTabelaPets> listaCadastros;  

    static {
        listaCadastros = new ArrayList<>();
    }
    
    private String id;
    private String nomePet;
    private String especie;
    private String raca;
    private String sexo;
    private String idade;
    private String cor;
    private String peso;
    private String caracteristicas;
    
    private String historico_vacinacao;
    private String medicamentos_uso;
    private String alergias;
    private String hist_doencas_cond_medicas;
    
    private String nomeTutor;
    private String contato;
    private String num_cpf;
    private String endereco;

    public ModeloTabelaPets(String id, String nomePet, String especie, String raca, String sexo, String idade, String cor, String peso, String caracteristicas, String historico_vacinacao, String medicamentos_uso, String alergias, String hist_doencas_cond_medicas, String nomeTutor, String contato, String num_cpf, String endereco) {
        this.id = id;
        this.nomePet = nomePet;
        this.especie = especie;
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.cor = cor;
        this.peso = peso;
        this.caracteristicas = caracteristicas;
        this.historico_vacinacao = historico_vacinacao;
        this.medicamentos_uso = medicamentos_uso;
        this.alergias = alergias;
        this.hist_doencas_cond_medicas = hist_doencas_cond_medicas;
        this.nomeTutor = nomeTutor;
        this.contato = contato;
        this.num_cpf = num_cpf;
        this.endereco = endereco;
        
        listaCadastros.add(this);
    }

    public ModeloTabelaPets() {
        
    }
    
    public String getId() {
        return id;
    }

    public String getNomePet() {
        return nomePet;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public String getSexo() {
        return sexo;
    }

    public String getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public String getPeso() {
        return peso;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public String getHistorico_vacinacao() {
        return historico_vacinacao;
    }

    public String getMedicamentos_uso() {
        return medicamentos_uso;
    }

    public String getAlergias() {
        return alergias;
    }

    public String getHist_doencas_cond_medicas() {
        return hist_doencas_cond_medicas;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public String getContato() {
        return contato;
    }

    public String getNum_cpf() {
        return num_cpf;
    }

    public String getEndereco() {
        return endereco;
    }
    
    public void setModeloTabela(DefaultTableModel modeloTabela) {
        
        ModeloTabelaPets.modeloTabela = modeloTabela;
        
    }
    
     public void adicionarCads(ModeloTabelaPets cad) {

        // Adicione os dados do produto ao modelo da tabela
        modeloTabela.addRow(new Object[]{
            cad.getId(),
            cad.getNomePet(), 
            cad.getEspecie(),
            cad.getRaca(),
            cad.getSexo(),
            cad.getIdade(),
            cad.getCor(),
            cad.getPeso(),
            cad.getCaracteristicas(),
            
            cad.getNomeTutor(),
            cad.getContato(),
            cad.getNum_cpf(),
            cad.getEndereco(),
            
            cad.getHistorico_vacinacao(),
            cad.getMedicamentos_uso(),
            cad.getAlergias(),
            cad.getHist_doencas_cond_medicas()
        });      
    }
    
    
}

