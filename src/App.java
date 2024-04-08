import java.sql.Date;
import java.util.List;

import DAO.BairroDAO;
import DAO.BemDAO;
import DAO.CidadeDAO;
import DAO.ContribuinteDAO;
import DAO.DDDDAO;
import DAO.DeclaracaoIRRFDAO;
import DAO.DependenteDAO;
import DAO.EmailContribuinteDAO;
import DAO.EnderecoDAO;
import DAO.FoneContribuinteDAO;
import DAO.GrauParentescoDAO;
import DAO.LogradouroDAO;
import DAO.RendimentoTributavelDAO;
import DAO.TipoBemDAO;
import DAO.TipoLogradouroDAO;
import DAO.UnidadeFederacaoDAO;
import entity.Bairro;
import entity.Bem;
import entity.Cidade;
import entity.Contribuinte;
import entity.DDD;
import entity.DeclaracaoIRRF;
import entity.Dependente;
import entity.EmailContribuinte;
import entity.Endereco;
import entity.FoneContribuinte;
import entity.GrauParentesco;
import entity.Logradouro;
import entity.RendimentoTributavel;
import entity.TipoBem;
import entity.TipoLogradouro;
import entity.UnidadeFederacao;

public class App {
    public static void main(String[] args) throws Exception {
        // BAIRRO
        // Bairro b1 = new Bairro(2, "bairro3");
        // new BairroDAO().InserirBairro(b1);
        // BairroDAO.imprimirBairros(new BairroDAO().listarBairrosComCidades());
 
        // BEM
        // Bem be1 = new Bem(2, 2, 2, "descricao2", 12.00f, Date.valueOf("2024-05-02"));
        // new BemDAO().InserirBem(be1);
        // BemDAO.imprimirBens(new BemDAO().listarBens());

        // CIDADE
        // Cidade c1 = new Cidade(1, "cidade1", "UF1");
        // new CidadeDAO().InserirCidade(c1);
        // CidadeDAO.imprimirCidades(new CidadeDAO().listarCidades());

        // CONTRIBUINTE
        // Contribuinte ct1 = new Contribuinte(1, "111.111.111-11", "contribuinte1", Date.valueOf("2021-01-01"), 1, "complemento1", 111);
        // new ContribuinteDAO().InserirContribuinte(ct1);
        // CONTRIBUINTES POR CIDADE
        // ContribuinteDAO.imprimirContribuintes(new ContribuinteDAO().listarContribuintesPorCidade("São Paulo"));

        // DDD
        // DDD d1 = new DDD("11");
        // new DDDDAO().InserirDDD(d1);
        // DDDDAO.imprimirDDDs(new DDDDAO().listarDDDs());

        // DEPENDENTE
        // Dependente de1 = new Dependente(1, "111.111.111-11", "dependente1", Date.valueOf("2024-04-05"), 1);
        // new DependenteDAO().InserirDependente(de1);
        // DependenteDAO.imprimirDependentes(new DependenteDAO().listarDependentesComParentesco());

        // EMAIL CONTRIBUINTE
        // EmailContribuinte e1 = new EmailContribuinte("email1@gmail.com", 1);
        // new EmailContribuinteDAO().InserirEmailContribuinte(e1);
        // EmailContribuinteDAO.imprimirEmailContribuintes(new EmailContribuinteDAO().listarEmailContribuintes());
    
        // ENDERECO
        // Endereco ed1 = new Endereco(1, "11111-11", 1, 1, 1);
        // new EnderecoDAO().InserirEndereco(ed1);
        // EnderecoDAO.imprimirEnderecos(new EnderecoDAO().listarEnderecos());

        // FONE CONTRIBUINTE
        // FoneContribuinte f1 = new FoneContribuinte("11111-1111", 1, "11");
        // new FoneContribuinteDAO().InserirFoneContribuinte(f1);
        // FoneContribuinteDAO.imprimirFoneContribuintes(new FoneContribuinteDAO().listarFoneContribuintes());

        // GRAU PARENTESCO
        // GrauParentesco g1 = new GrauParentesco(1, "grau1");
        // new GrauParentescoDAO().InserirGrauParentesco(g1);
        // GrauParentescoDAO.imprimirGrauParentescos(new GrauParentescoDAO().listarGrauParentescos());

        // LOGRADOURO
        // Logradouro l1 = new Logradouro(1, "logradouro1", "log1");
        // new LogradouroDAO().InserirLogradouro(l1);
        // LogradouroDAO.imprimirLogradouros(new LogradouroDAO().listarLogradouros());

        // RENDIMENTO TRIBUTAVEL
        // RendimentoTributavel r1 = new RendimentoTributavel(1, 1, 1, "1000,00", 10.00f, 10.00f, 10.00f);
        // new RendimentoTributavelDAO().InserirRendimentoTributavel(r1);
        // RendimentoTributavelDAO.imprimirRendimentoTributavels(new RendimentoTributavelDAO().listarRendimentoTributavels());

        // TIPO BEM
        // TipoBem r1 = new TipoBem(1, "tipo1");
        // new TipoBemDAO().InserirTipoBem(r1);
        // TipoBemDAO.imprimirTipoBems(new TipoBemDAO().listarTipoBems());

        // TIPO LOGRADOURO
        // TipoLogradouro l1 = new TipoLogradouro("sigla1", "logradouro1");
        // new TipoLogradouroDAO().InserirTipoLogradouro(l1);
        // TipoLogradouroDAO.imprimirTipoLogradouros(new TipoLogradouroDAO().listarTipoLogradouros());

        // UNIDADE FEDERECAO
        // UnidadeFederacao u1 = new UnidadeFederacao("sigla1", "UF1");
        // new UnidadeFederacaoDAO().InserirUnidadeFederacao(u1);
        // UnidadeFederacaoDAO.imprimirUnidadeFederacaos(new UnidadeFederacaoDAO().listarUnidadeFederacaos());

        // IRRF COMPLETA
        ContribuinteDAO contribuinteDAO = new ContribuinteDAO();
        DependenteDAO dependenteDAO = new DependenteDAO();
        RendimentoTributavelDAO rendimentoDAO = new RendimentoTributavelDAO();
        BemDAO bemDAO = new BemDAO();

        int idContribuinte1 = 2;
        int idContribuinte2 = 3;

        Contribuinte contribuinte1 = contribuinteDAO.buscarPorId(idContribuinte1);
        List<Dependente> dependentes1 = dependenteDAO.listarPorContribuinte(idContribuinte1);
        List<RendimentoTributavel> rendimentos1 = rendimentoDAO.listarPorContribuinte(idContribuinte1);
        List<Bem> bens1 = bemDAO.listarPorContribuinte(idContribuinte1);

        Contribuinte contribuinte2 = contribuinteDAO.buscarPorId(idContribuinte2);
        List<Dependente> dependentes2 = dependenteDAO.listarPorContribuinte(idContribuinte2);
        List<RendimentoTributavel> rendimentos2 = rendimentoDAO.listarPorContribuinte(idContribuinte2);
        List<Bem> bens2 = bemDAO.listarPorContribuinte(idContribuinte2);

        DeclaracaoIRRF declaracao1 = new DeclaracaoIRRF(contribuinte1, dependentes1, rendimentos1, bens1);
        DeclaracaoIRRF declaracao2 = new DeclaracaoIRRF(contribuinte2, dependentes2, rendimentos2, bens2);

        System.out.println("Declaracao de IRRF para o Contribuinte 2:");
        DeclaracaoIRRFDAO.exibirDetalhesDeclaracao(declaracao1);

        System.out.println("\nDeclaracao de IRRF para o Contribuinte 3:");
        DeclaracaoIRRFDAO.exibirDetalhesDeclaracao(declaracao2);
    }
}
