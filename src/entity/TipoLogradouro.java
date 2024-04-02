package entity;

public class TipoLogradouro {
    private String siglaLogradouro; // chave primária
    private String nomeLogradouro;

    public TipoLogradouro() {
        // nada vem aqui
    }

    public TipoLogradouro(String siglaLogradouro, String nomeLogradouro) {
        this.siglaLogradouro = siglaLogradouro;
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

    // Getter para nomeLogradouro
    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    // Setter para nomeLogradouro
    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }
}
