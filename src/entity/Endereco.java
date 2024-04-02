package entity;

public class Endereco {
    private int idEndereco; // chave primária
    private String CEP;
    private int idCidade; // chave estrangeira
    private int idLogradouro; // chave estrangeira
    private int idBairro; // chave estrangeira

    public Endereco() {
        // nada vem aqui
    }

    public Endereco(int idEndereco, String CEP, int idCidade, int idLogradouro, int idBairro) {
        this.idEndereco = idEndereco;
        this.CEP = CEP;
        this.idCidade = idCidade;
        this.idLogradouro = idLogradouro;
        this.idBairro = idBairro;
    }

    // Getter para idEndereco
    public int getIdEndereco() {
        return idEndereco;
    }

    // Setter para idEndereco
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    // Getter para CEP
    public String getCEP() {
        return CEP;
    }

    // Setter para CEP
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    // Getter para idCidade
    public int getIdCidade() {
        return idCidade;
    }

    // Setter para idCidade
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    // Getter para idLogradouro
    public int getIdLogradouro() {
        return idLogradouro;
    }

    // Setter para idLogradouro
    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    // Getter para idBairro
    public int getIdBairro() {
        return idBairro;
    }

    // Setter para idBairro
    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }
}
