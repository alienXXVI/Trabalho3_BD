package entity;

public class EmailContribuinte {
    private String emailContribuinte; // chave primária
    private int idContribuinte; // chave primária

    public EmailContribuinte() {
        // Nada vem aqui
    }

    public EmailContribuinte(String emailContribuinte, int idContribuinte) {
        this.emailContribuinte = emailContribuinte;
        this.idContribuinte = idContribuinte;
    }

    // Getter para emailContribuinte
    public String getEmailContribuinte() {
        return emailContribuinte;
    }

    // Setter para emailContribuinte
    public void setEmailContribuinte(String emailContribuinte) {
        this.emailContribuinte = emailContribuinte;
    }

    // Getter para idContribuinte
    public int getIdContribuinte() {
        return idContribuinte;
    }

    // Setter para idContribuinte
    public void setIdContribuinte(int idContribuinte) {
        this.idContribuinte = idContribuinte;
    }
}
