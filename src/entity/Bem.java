package entity;

import java.sql.Date;

public class Bem {
    private int idBemDireito; // chave primária
    private int idContribuinte; // chave estrangeira
    private int idTipoBem; // chave estrangeira
    private String descricaoBem;
    private float valorBem;
    private Date dataAquisicao;

    public Bem() {
        // nada vem aqui
    }

    public Bem(int idBemDireito, int idContribuinte, int idTipoBem, String descricaoBem, float valorBem, Date dataAquisicao) {
        this.idBemDireito = idBemDireito;
        this.idContribuinte = idContribuinte;
        this.idTipoBem = idTipoBem;
        this.descricaoBem = descricaoBem;
        this.valorBem = valorBem;
        this.dataAquisicao = dataAquisicao;
    }

    // Getter para idBemDireito
    public int getIdBemDireito() {
        return idBemDireito;
    }

    // Setter para idBemDireito
    public void setIdBemDireito(int idBemDireito) {
        this.idBemDireito = idBemDireito;
    }

    // Getter para idContribuinte
    public int getIdContribuinte() {
        return idContribuinte;
    }

    // Setter para idContribuinte
    public void setIdContribuinte(int idContribuinte) {
        this.idContribuinte = idContribuinte;
    }

    // Getter para idTipoBem
    public int getIdTipoBem() {
        return idTipoBem;
    }

    // Setter para idTipoBem
    public void setIdTipoBem(int idTipoBem) {
        this.idTipoBem = idTipoBem;
    }

    // Getter para descricaoBem
    public String getDescricaoBem() {
        return descricaoBem;
    }

    // Setter para descricaoBem
    public void setDescricaoBem(String descricaoBem) {
        this.descricaoBem = descricaoBem;
    }

    // Getter para valorBem
    public float getValorBem() {
        return valorBem;
    }

    // Setter para valorBem
    public void setValorBem(float valorBem) {
        this.valorBem = valorBem;
    }

    // Getter para dataAquisicao
    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    // Setter para dataAquisicao
    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    } 
}
