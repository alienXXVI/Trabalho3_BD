package entity;

public class UnidadeFederacao {
    private String UF;
    private String nomeUF;

    public UnidadeFederacao() {
        // nada vem aqui
    }

    public UnidadeFederacao(String UF, String nomeUF) {
        this.UF = UF;
        this.nomeUF = nomeUF;
    }

    // Getter para UF
    public String getUF() {
        return UF;
    }

    // Setter para UF
    public void setUF(String UF) {
        this.UF = UF;
    }

    // Getter para nomeUF
    public String getNomeUF() {
        return nomeUF;
    }

    // Setter para nomeUF
    public void setNomeUF(String nomeUF) {
        this.nomeUF = nomeUF;
    }
}
