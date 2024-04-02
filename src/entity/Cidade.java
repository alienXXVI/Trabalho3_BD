package entity;

public class Cidade {
    private int idCidade; // chave primária
    private String nomeCidade;
    private String siglaUF; // chave estrangeira

    public Cidade() {
        // nada vem aqui
    }

    public Cidade(int idCidade, String nomeCidade, String siglaUF) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.siglaUF = siglaUF;
    }

    // Getter para idCidade
    public int getIdCidade() {
        return idCidade;
    }

    // Setter para idCidade
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    // Getter para nomeCidade
    public String getNomeCidade() {
        return nomeCidade;
    }

    // Setter para nomeCidade
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    // Getter para siglaUF
    public String getSiglaUF() {
        return siglaUF;
    }

    // Setter para siglaUF
    public void setSiglaUF(String siglaUF) {
        this.siglaUF = siglaUF;
    }
}
