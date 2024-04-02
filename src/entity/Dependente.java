package entity;

import javax.xml.crypto.Data;

public class Dependente {
    private int idDependente; // chave primária
    private int idGrauParentesco; // chave estrangeira
    private String CPFdependente;
    private String nomeDependente;
    private Data dataNascimento;

    public Dependente() {
        // Nada vem aqui
    }

    public Dependente(int idDependente, int idGrauParentesco, String CPFdependente, String nomeDependente, Data dataNascimento) {
        this.idDependente = idDependente;
        this.idGrauParentesco = idGrauParentesco;
        this.CPFdependente = CPFdependente;
        this.nomeDependente = nomeDependente;
        this.dataNascimento = dataNascimento;
    }

    // Getter para idDependente
    public int getIdDependente() {
        return idDependente;
    }

    // Setter para idDependente
    public void setIdDependente(int idDependente) {
        this.idDependente = idDependente;
    }

    // Getter para idGrauParentesco
    public int getIdGrauParentesco() {
        return idGrauParentesco;
    }

    // Setter para idGrauParentesco
    public void setIdGrauParentesco(int idGrauParentesco) {
        this.idGrauParentesco = idGrauParentesco;
    }

    // Getter para CPFdependente
    public String getCPFdependente() {
        return CPFdependente;
    }

    // Setter para CPFdependente
    public void setCPFdependente(String CPFdependente) {
        this.CPFdependente = CPFdependente;
    }

    // Getter para nomeDependente
    public String getNomeDependente() {
        return nomeDependente;
    }

    // Setter para nomeDependente
    public void setNomeDependente(String nomeDependente) {
        this.nomeDependente = nomeDependente;
    }

    // Getter para dataNascimento
    public Data getDataNascimento() {
        return dataNascimento;
    }

    // Setter para dataNascimento
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
