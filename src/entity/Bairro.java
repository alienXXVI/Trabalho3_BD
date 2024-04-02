package entity;

public class Bairro {
    private int idBairro; // chave primária
    private String nomeBairro;

    public Bairro() {
        System.err.println();
        // nada vem aqui 
    }

    public Bairro(int idBairro, String nomeBairro) {
        this.idBairro = idBairro;
        this.nomeBairro = nomeBairro;
    }

    // Getter para idBairro
    public int getIdBairro() {
        return idBairro;
    }

    // Setter para idBairro
    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    // Getter para nomeBairro
    public String getNomeBairro() {
        return nomeBairro;
    }

    // Setter para nomeBairro
    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }
}
