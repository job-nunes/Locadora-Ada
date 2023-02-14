import business.*;
import model.Cliente;
import model.Locacao;
import model.Veiculo;
import persistence.Repository;
import persistence.arquivo.*;
import persistence.memoria.RepositorioEmMemoriaGenerico;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //Repositórios em Arquivos com base nas aulas.

        //Cria Repositório Cliente
        ManipuladorDeArquivo manipuladorDeArquivoCliente = new ManipuladorDeArquivoComObjectIOStream("arquivo-cliente.txt");
        Repository<Cliente> repositorioEmMemoriaGenericoCliente = new RepositorioEmMemoriaGenerico<>();
        Repository<Cliente> repositorioDeCliente = new ClienteEmArquivoRepository(manipuladorDeArquivoCliente,repositorioEmMemoriaGenericoCliente);
        GerenciadorDeCliente gerenciadorDeClientePF = new GerenciadorDeClientePF(repositorioDeCliente);
        GerenciadorDeCliente gerenciadorDeClientePJ = new GerenciadorDeClientePJ(repositorioDeCliente);

        //Cria Clientes - Identificador único: documento
        Cliente clientePF1 = gerenciadorDeClientePF.adicionarCliente("João","81751088197","998444984");
        Cliente clientePF2 = gerenciadorDeClientePF.adicionarCliente("Job","93121891588","998444984");
        Cliente clientePJ = gerenciadorDeClientePJ.adicionarCliente("Job's Enterprise","75472949000193","998444984");
        System.out.println(gerenciadorDeClientePF.listarTodos());
        System.out.println(gerenciadorDeClientePF.listarTodosPorTipoPessoa());

        //Cria Repositório Veiculo
        ManipuladorDeArquivo manipuladorDeArquivoVeiculo = new ManipuladorDeArquivoComObjectIOStream("arquivo-veiculo.txt");
        Repository<Veiculo> repositorioEmMemoriaGenericoVeiculo = new RepositorioEmMemoriaGenerico<>();
        Repository<Veiculo> repositorioDeVeiculo = new VeiculoEmArquivoRepository(manipuladorDeArquivoVeiculo,repositorioEmMemoriaGenericoVeiculo);
        GerenciadorDeVeiculo gerenciadorDeVeiculoPequeno = new GerenciadorDeVeiculoPequeno(repositorioDeVeiculo);
        GerenciadorDeVeiculo gerenciadorDeVeiculoMedio = new GerenciadorDeVeiculoMedio(repositorioDeVeiculo);
        GerenciadorDeVeiculo gerenciadorDeVeiculoSUV = new GerenciadorDeVeiculoSUV(repositorioDeVeiculo);

        //Cria Veiculos - Identificador único: placa
        Veiculo veiculoMedia = gerenciadorDeVeiculoMedio.adicionarVeiculo("253-94as", "Corsa");
        Veiculo veiculoPequeno1 = gerenciadorDeVeiculoPequeno.adicionarVeiculo("946-7841", "Celta");
        Veiculo veiculoPequeno2 = gerenciadorDeVeiculoPequeno.adicionarVeiculo("JOB-12sa", "Fusca");
        Veiculo veiculoSUV = gerenciadorDeVeiculoSUV.adicionarVeiculo("dsa-94as", "Camionete");
        System.out.println(gerenciadorDeVeiculoPequeno.listarTodos());

        //Cria Repositório Locação
        ManipuladorDeArquivo manipuladorDeArquivoLocacao = new ManipuladorDeArquivoComObjectIOStream("arquivo-locacao.txt");
        Repository<Locacao> repositorioEmMemoriaGenericoLocacao = new RepositorioEmMemoriaGenerico<>();
        Repository<Locacao> repositorioDeLocacao = new LocacaoEmArquivoRepository(manipuladorDeArquivoLocacao,repositorioEmMemoriaGenericoLocacao);
        GerenciadorDeLocacaoPF gerenciadorDeLocacaoPF = new GerenciadorDeLocacaoPF(repositorioDeLocacao);
        GerenciadorDeLocacaoPJ gerenciadorDeLocacaoPJ = new GerenciadorDeLocacaoPJ(repositorioDeLocacao);

        //Cria Locaçoes - Locacoes de mesmo carro não podem possuir interseção de datas
        //Podemos listar as locações por carros ou por clientes.
        //Gerenciador de PJ adiciona somente PJ e gerenciado de PF somente PF
        gerenciadorDeLocacaoPF.adicionarLocacao(veiculoMedia,clientePF1, LocalDateTime.parse("2023-02-15T10:11:30"),LocalDateTime.parse("2023-02-16T10:11:30"));
        gerenciadorDeLocacaoPF.adicionarLocacao(veiculoPequeno1,clientePF2, LocalDateTime.parse("2023-02-16T15:11:30"),LocalDateTime.parse("2023-02-23T11:12:30"));
        gerenciadorDeLocacaoPJ.adicionarLocacao(veiculoPequeno2,clientePJ, LocalDateTime.parse("2023-02-15T10:11:30"),LocalDateTime.parse("2023-02-15T22:11:30"));
        gerenciadorDeLocacaoPJ.adicionarLocacao(veiculoSUV,clientePJ, LocalDateTime.parse("2023-02-17T10:11:30"),LocalDateTime.parse("2023-02-22T10:11:30"));
        System.out.println(gerenciadorDeLocacaoPJ.listarTodos());
        System.out.println(gerenciadorDeLocacaoPF.consultarAlocacaoPorCliente(clientePF2));
        System.out.println(gerenciadorDeLocacaoPF.consultarAlocacaoPorCliente(clientePJ));

        /**Erros:*/
        //gerenciadorDeClientePF.adicionarCliente("Job","81751088197","998444984");
        //gerenciadorDeClientePF.adicionarCliente("Job","75472949000193","998444984");

        //gerenciadorDeVeiculoPequeno.adicionarVeiculo("946-7841", "OUTRO QUALQUER");


        //gerenciadorDeLocacaoPF.adicionarLocacao(veiculoPequeno1,clientePF2, LocalDateTime.parse("2023-02-17T15:11:30"),LocalDateTime.parse("2023-02-18T11:12:30"));


    }
}