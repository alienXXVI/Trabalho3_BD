package entity;

import java.sql.Date;

public class Contribuinte {
    private int idContribuinte; // chave primária
    private String CPFcontribuinte;
    private String nomeContribuinte;
    private Date dataNascimento;
    private int idEndereco;
    private String complemento;
    private int nroCasa;

    public Contribuinte() {
        // nada vem aqui
    }

    public Contribuinte(int idContribuinte, String CPFcontribuinte, String nomeContribuinte, Date dataNascimento, int idEndereco, String complemento, int nroCasa) {
        this.idContribuinte = idContribuinte;
        this.CPFcontribuinte = CPFcontribuinte;
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

    // Getter para CPFcontribuinte
    public String getCPFcontribuinte() {
        return CPFcontribuinte;
    }

    // Setter para CPFcontribuinte
    public void setCPFcontribuinte(String CPFcontribuinte) {
        this.CPFcontribuinte = CPFcontribuinte;
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
    public Date getDataNascimento() {
        return dataNascimento;
    }

    // Setter para dataNascimento
    public void setDataNascimento(Date dataNascimento) {
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

    public void imprimirDetalhes() {
        System.out.println("ID Contribuinte: " + idContribuinte);
        System.out.println("CPF: " + CPFcontribuinte);
        System.out.println("Nome: " + nomeContribuinte);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("ID Endereço: " + idEndereco);
        System.out.println("Complemento: " + complemento);
        System.out.println("Número da Casa: " + nroCasa);
        System.err.println();
    }
}
