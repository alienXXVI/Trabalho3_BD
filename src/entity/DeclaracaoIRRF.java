package entity;

import java.util.List;

public class DeclaracaoIRRF {
    private Contribuinte contribuinte;
    private List<Dependente> dependentes;
    private List<RendimentoTributavel> rendimentos;
    private List<Bem> bens;

    public DeclaracaoIRRF(Contribuinte contribuinte, List<Dependente> dependentes, List<RendimentoTributavel> rendimentos, List<Bem> bens) {
        this.contribuinte = contribuinte;
        this.dependentes = dependentes;
        this.rendimentos = rendimentos;
        this.bens = bens;
    }

    public Contribuinte getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public List<RendimentoTributavel> getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(List<RendimentoTributavel> rendimentos) {
        this.rendimentos = rendimentos;
    }

    public List<Bem> getBens() {
        return bens;
    }

    public void setBens(List<Bem> bens) {
        this.bens = bens;
    }
}
