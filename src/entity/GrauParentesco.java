package entity;

public class GrauParentesco {
    private int idGrauParentesco; // chave primária
    private String grauParentesco;

    public GrauParentesco() {
        // nada vem aqui
    }

    public GrauParentesco(int idGrauParentesco, String grauParentesco) {
        this.idGrauParentesco = idGrauParentesco;
        this.grauParentesco = grauParentesco;
    }

    // Getter para idGrauParentesco
    public int getIdGrauParentesco() {
        return idGrauParentesco;
    }

    // Setter para idGrauParentesco
    public void setIdGrauParentesco(int idGrauParentesco) {
        this.idGrauParentesco = idGrauParentesco;
    }

    // Getter para grauParentesco
    public String getGrauParentesco() {
        return grauParentesco;
    }

    // Setter para grauParentesco
    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }
}
