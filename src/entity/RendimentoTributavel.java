package entity;

public class RendimentoTributavel {
    private int idRendimento; // chave primária
    private int idEmpresa; // chave estrangeira;
    private int idContribuinte; // chave estrangeira;
    private float INSS;
    private float IRRFpago;
    private float valorRecebido;
    private float valorDecimoTerceiro;

    public RendimentoTributavel() {
        // Nada vem aqui
    }

    public RendimentoTributavel(int idRendimento, int idEmpresa, int idContribuinte, float INSS, float IRRFpago, float valorRecebido, float valorDecimoTerceiro) {
        this.idRendimento = idRendimento;
        this.idEmpresa = idEmpresa;
        this.idContribuinte = idContribuinte;
        this.INSS = INSS;
        this.IRRFpago = IRRFpago;
        this.valorRecebido = valorRecebido;
        this.valorDecimoTerceiro = valorDecimoTerceiro;
    }

    // Getter para idRendimento
    public int getIdRendimento() {
        return idRendimento;
    }

    // Setter para idRendimento
    public void setIdRendimento(int idRendimento) {
        this.idRendimento = idRendimento;
    }

    // Getter para idEmpresa
    public int getIdEmpresa() {
        return idEmpresa;
    }

    // Setter para idEmpresa
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    // Getter para idContribuinte
    public int getIdContribuinte() {
        return idContribuinte;
    }

    // Setter para idContribuinte
    public void setIdContribuinte(int idContribuinte) {
        this.idContribuinte = idContribuinte;
    }

    // Getter para INSS
    public float getINSS() {
        return INSS;
    }

    // Setter para INSS
    public void setINSS(float INSS) {
        this.INSS = INSS;
    }

    // Getter para IRRFpago
    public float getIRRFpago() {
        return IRRFpago;
    }

    // Setter para IRRFpago
    public void setIRRFpago(float IRRFpago) {
        this.IRRFpago = IRRFpago;
    }

    // Getter para valorRecebido
    public float getValorRecebido() {
        return valorRecebido;
    }

    // Setter para valorRecebido
    public void setValorRecebido(float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    // Getter para valorDecimoTerceiro
    public float getValorDecimoTerceiro() {
        return valorDecimoTerceiro;
    }

    // Setter para valorDecimoTerceiro
    public void setValorDecimoTerceiro(float valorDecimoTerceiro) {
        this.valorDecimoTerceiro = valorDecimoTerceiro;
    }
}
