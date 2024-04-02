package entity;

import javax.xml.crypto.Data;

public class Contribuinte {
    private int idContribuinte; // chave primária
    private String CPDcontribuinte;
    private String nomeContribuinte;
    private Data dataNascimento;
    private int idEndereco;
    private String complemento;
    private int nroCasa;

    public Contribuinte() {
        // nada vem aqui
    }

    public Contribuinte(int idContribuinte, String CPDcontribuinte, String nomeContribuinte, Data dataNascimento, int idEndereco, String complemento, int nroCasa) {
        this.idContribuinte = idContribuinte;
        this.CPDcontribuinte = CPDcontribuinte;
        this.nomeContribuinte = nomeContribuinte;
        this.dataNascimento = dataNascimento;
        this.idEndereco = idEndereco;
        this.complemento = complemento;
        this.nroCasa = nroCasa;
    }

    // Getter para idContribuinte
    public int getIdContribuinte() {
        return idContribuinte;
    }

    // Setter para idContribuinte
    public void setIdContribuinte(int idContribuinte) {
        this.idContribuinte = idContribuinte;
    }

    // Getter para CPDcontribuinte
    public String getCPDcontribuinte() {
        return CPDcontribuinte;
    }

    // Setter para CPDcontribuinte
    public void setCPDcontribuinte(String CPDcontribuinte) {
        this.CPDcontribuinte = CPDcontribuinte;
    }

    // Getter para nomeContribuinte
    public String getNomeContribuinte() {
        return nomeContribuinte;
    }

    // Setter para nomeContribuinte
    public void setNomeContribuinte(String nomeContribuinte) {
        this.nomeContribuinte = nomeContribuinte;
    }

    // Getter para dataNascimento
    public Data getDataNascimento() {
        return dataNascimento;
    }

    // Setter para dataNascimento
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Getter para idEndereco
    public int getIdEndereco() {
        return idEndereco;
    }

    // Setter para idEndereco
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    // Getter para complemento
    public String getComplemento() {
        return complemento;
    }

    // Setter para complemento
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    // Getter para nroCasa
    public int getNroCasa() {
        return nroCasa;
    }

    // Setter para nroCasa
    public void setNroCasa(int nroCasa) {
        this.nroCasa = nroCasa;
    }
}
