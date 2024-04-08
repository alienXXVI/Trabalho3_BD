package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Bem;
import entity.Contribuinte;
import entity.DeclaracaoIRRF;
import entity.Dependente;
import entity.RendimentoTributavel;

public class DeclaracaoIRRFDAO {

    public List<DeclaracaoIRRF> listarDeclaracoesIRRFCompleta() {
        List<DeclaracaoIRRF> declaracoes = new ArrayList<>();

        try {
            String sql = "SELECT c.idContribuinte, c.CPFcontribuinte, c.nomeContribuinte, c.dataNascimento, c.idEndereco, c.complemento, c.nroCasa, " +
                         "d.idDependente, d.idGrauParentesco, d.CPFdependente, d.nomeDependente, d.dataNascimento AS dataNascimentoDependente, " +
                         "r.idRendimento, r.idEmpresa, r.idContribuinte AS idContribuinteRend, r.INSS, r.IRRFpago, r.valorRecebido, r.valorDecimoTerceiro, " +
                         "b.idBemDireito, b.idTipoBem, b.descricaoBem, b.valorBem, b.dataAquisicao " +
                         "FROM contribuinte c " +
                         "LEFT JOIN dependente d ON c.idContribuinte = d.idGrauParentesco " +
                         "LEFT JOIN rendimento_tributavel r ON c.idContribuinte = r.idContribuinte " +
                         "LEFT JOIN bem b ON c.idContribuinte = b.idContribuinte ";

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Construir objeto Contribuinte
                Contribuinte contribuinte = new Contribuinte(
                    rs.getInt("idContribuinte"),
                    rs.getString("CPFcontribuinte"),
                    rs.getString("nomeContribuinte"),
                    rs.getDate("dataNascimento"),
                    rs.getInt("idEndereco"),
                    rs.getString("complemento"),
                    rs.getInt("nroCasa")
                );

                // Construir lista de dependentes
                List<Dependente> dependentes = new ArrayList<>();
                if (rs.getInt("idDependente") != 0) {
                    dependentes.add(new Dependente(
                        rs.getInt("idDependente"),
                        rs.getString("CPFdependente"),
                        rs.getString("nomeDependente"),
                        rs.getDate("dataNascimentoDependente"),
                        rs.getInt("idGrauParentesco"),
                        rs.getInt("idContribuinte")
                    ));
                }

                // Construir lista de rendimentos tributáveis
                List<RendimentoTributavel> rendimentos = new ArrayList<>();
                if (rs.getInt("idRendimento") != 0) {
                    rendimentos.add(new RendimentoTributavel(
                        rs.getInt("idRendimento"),
                        rs.getInt("idEmpresa"),
                        rs.getInt("idContribuinteRend"),
                        rs.getFloat("INSS"),
                        rs.getFloat("IRRFpago"),
                        rs.getFloat("valorRecebido"),
                        rs.getFloat("valorDecimoTerceiro")
                    ));
                }

                // Construir lista de bens e direitos
                List<Bem> bens = new ArrayList<>();
                if (rs.getInt("idBemDireito") != 0) {
                    bens.add(new Bem(
                        rs.getInt("idBemDireito"),
                        rs.getInt("idContribuinte"),
                        rs.getInt("idTipoBem"),
                        rs.getString("descricaoBem"),
                        rs.getFloat("valorBem"),
                        rs.getDate("dataAquisicao")
                    ));
                }

                // Construir declaração de IRRF
                DeclaracaoIRRF declaracaoIRRF = new DeclaracaoIRRF(contribuinte, dependentes, rendimentos, bens);
                declaracoes.add(declaracaoIRRF);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return declaracoes;
    }

    public static void exibirDetalhesDeclaracao(DeclaracaoIRRF declaracao) {
        System.out.println("Detalhes da Declaracao de IRRF:");
        System.out.println("-----------------------------------------");
        
        // Contribuinte
        System.out.println("Contribuinte:");
        System.out.println("ID: " + declaracao.getContribuinte().getIdContribuinte());
        System.out.println("Nome: " + declaracao.getContribuinte().getNomeContribuinte());
        System.out.println("CPF: " + declaracao.getContribuinte().getCPFcontribuinte());
        // Adicione outros atributos do contribuinte conforme necessário
        System.out.println("-----------------------------------------");
        
        // Dependentes
        System.out.println("Dependentes:");
        for (Dependente dependente : declaracao.getDependentes()) {
            System.out.println("ID: " + dependente.getIdDependente());
            System.out.println("Nome: " + dependente.getNomeDependente());
            System.out.println("CPF: " + dependente.getCPFdependente());
            // Adicione outros atributos do dependente conforme necessário
            System.out.println("-----------------------------------------");
        }
        
        // Rendimentos Tributáveis
        System.out.println("Rendimentos Tributaveis:");
        for (RendimentoTributavel rendimento : declaracao.getRendimentos()) {
            System.out.println("ID do Rendimento: " + rendimento.getIdRendimento());
            System.out.println("Valor Recebido: " + rendimento.getValorRecebido());
            // Adicione outros atributos do rendimento conforme necessário
            System.out.println("-----------------------------------------");
        }
        
        // Bens
        System.out.println("Bens:");
        for (Bem bem : declaracao.getBens()) {
            System.out.println("ID do Bem: " + bem.getIdBemDireito());
            System.out.println("Descricao: " + bem.getDescricaoBem());
            System.out.println("Valor: " + bem.getValorBem());
            // Adicione outros atributos do bem conforme necessário
            System.out.println("-----------------------------------------");
        }
    }
    
}