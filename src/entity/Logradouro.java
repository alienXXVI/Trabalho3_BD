package entity;

public class Logradouro {
    private int idLogradouro; // chave primária
    private String nomeLogradouro;
    private String siglaLogradouro; // chave estrangeira

    public Logradouro() {
        // nada vem aqui
    }

    public Logradouro(int idLogradouro, String nomeLogradouro, String siglaLogradouro) {
        this.idLogradouro = idLogradouro;
        this.nomeLogradouro = nomeLogradouro;
        this.siglaLogradouro = siglaLogradouro;
    }

    // Getter para idLogradouro
    public int getIdLogradouro() {
        return idLogradouro;
    }

    // Setter para idLogradouro
    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    // Getter para nomeLogradouro
    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    // Setter para nomeLogradouro
    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    // Getter para siglaLogradouro
    public String getSiglaLogradouro() {
        return siglaLogradouro;
    }

    // Setter para siglaLogradouro
    public void setSiglaLogradouro(String siglaLogradouro) {
        this.siglaLogradouro = siglaLogradouro;
    }
}
