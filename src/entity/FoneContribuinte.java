package entity;

public class FoneContribuinte {
    private String foneContribuinte; // chave primária
    private int idContribuinte; // chave primária
    private String DDD; // chave estrangeira

    public FoneContribuinte() {
        // nada vem aqui
    }

    public FoneContribuinte(String foneContribuinte, int idContribuinte, String DDD) {
        this.foneContribuinte = foneContribuinte;
        this.idContribuinte = idContribuinte;
        this.DDD = DDD;
    }

    // Getter para foneContribuinte
    public String getFoneContribuinte() {
        return foneContribuinte;
    }

    // Setter para foneContribuinte
    public void setFoneContribuinte(String foneContribuinte) {
        this.foneContribuinte = foneContribuinte;
    }

    // Getter para idContribuinte
    public int getIdContribuinte() {
        return idContribuinte;
    }

    // Setter para idContribuinte
    public void setIdContribuinte(int idContribuinte) {
        this.idContribuinte = idContribuinte;
    }

    // Getter para DDD
    public String getDDD() {
        return DDD;
    }

    // Setter para DDD
    public void setDDD(String DDD) {
        this.DDD = DDD;
    }
}
