package entity;

public class TipoBem {
    private int idTipoBem; // chave primária
    private String nomeTipoBem;

    public TipoBem() {
        // Nada vem aqui
    }

    public TipoBem(int idTipoBem, String nomeTipoBem) {
        this.idTipoBem = idTipoBem;
        this.nomeTipoBem = nomeTipoBem;
    }

    // Getter para idTipoBem
    public int getIdTipoBem() {
        return idTipoBem;
    }

    // Setter para idTipoBem
    public void setIdTipoBem(int idTipoBem) {
        this.idTipoBem = idTipoBem;
    }

    // Getter para nomeTipoBem
    public String getNomeTipoBem() {
        return nomeTipoBem;
    }

    // Setter para nomeTipoBem
    public void setNomeTipoBem(String nomeTipoBem) {
        this.nomeTipoBem = nomeTipoBem;
    }
}
