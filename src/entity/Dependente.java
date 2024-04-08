package entity;

import java.sql.Date;

public class Dependente {
    private int idDependente; // chave primária
    private int idGrauParentesco; // chave estrangeira
    private String CPFdependente;
    private String nomeDependente;
    private Date dataNascimento;
    private int idContribuinte;

    private GrauParentesco grauParentesco;

    public Dependente() {
        // Nada vem aqui
    }

    public Dependente(int idDependente, String CPFdependente, String nomeDependente, Date dataNascimento, int idGrauParentesco, int idContribuinte) {
        this.idDependente = idDependente;
        this.idGrauParentesco = idGrauParentesco;
        this.CPFdependente = CPFdependente;
        this.nomeDependente = nomeDependente;
        this.dataNascimento = dataNascimento;
        this.idContribuinte = idContribuinte;
    }

    // Método para associar um GrauParentesco a um dependente
    public void setGrauParentesco(GrauParentesco grauParentesco) {
        this.grauParentesco = grauParentesco;
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
    public Date getDataNascimento() {
        return dataNascimento;
    }

    // Setter para dataNascimento
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdContribuinte() {
        return idContribuinte;
    }

    public void setIdContribuinte(int idContribuinte) {
        this.idContribuinte = idContribuinte;
    }
}
