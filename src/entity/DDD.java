package entity;

public class DDD {
    private String DDD; // chave primária

    public DDD() {
        // nada vem aqui
    }

    public DDD(String ddd) {
        this.DDD = ddd;
    }

    // Getter para ddd
    public String getDdd() {
        return DDD;
    }

    // Setter para ddd
    public void setDdd(String ddd) {
        this.DDD = ddd;
    }
}
