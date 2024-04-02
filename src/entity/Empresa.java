package entity;

public class Empresa {
    private int idEmpresa; // chave primária
    private String CNPJempresa;
    private String razaoSocial;
    private String nomeFantasia;

    public Empresa() {
        // nada vem aqui
    }

    public Empresa(int idEmpresa, String CNPJempresa, String razaoSocial, String nomeFantasia) {
        this.idEmpresa = idEmpresa;
        this.CNPJempresa = CNPJempresa;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    // Getter para idEmpresa
    public int getIdEmpresa() {
        return idEmpresa;
    }

    // Setter para idEmpresa
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    // Getter para CNPJempresa
    public String getCNPJempresa() {
        return CNPJempresa;
    }

    // Setter para CNPJempresa
    public void setCNPJempresa(String CNPJempresa) {
        this.CNPJempresa = CNPJempresa;
    }

    // Getter para razaoSocial
    public String getRazaoSocial() {
        return razaoSocial;
    }

    // Setter para razaoSocial
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    // Getter para nomeFantasia
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    // Setter para nomeFantasia
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    } 
}
