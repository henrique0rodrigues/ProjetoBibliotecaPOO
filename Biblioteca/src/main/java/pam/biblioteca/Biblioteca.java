package pam.biblioteca;

import java.util.Scanner;

public class Biblioteca {

    private UsuarioServicos usuarioService;
    private AcervoServicos acervoService;
    private EmprestimoServicos emprestimoService;
    private RelatorioServicos relatorioService;

    public Biblioteca() {
        
        this.usuarioService = new UsuarioServicos();
        this.acervoService = new AcervoServicos();
        this.emprestimoService = new EmprestimoServicos(acervoService, usuarioService);
        this.relatorioService = new RelatorioServicos(emprestimoService);
    }

    public UsuarioServicos getUsuarioServicos() { return usuarioService; }
    public AcervoServicos getAcervoServicos() { return acervoService; }
    public EmprestimoServicos getEmprestimoServicos() { return emprestimoService; }
    public RelatorioServicos getRelatorioServicos() { return relatorioService; }

    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        System.out.println("Sistema da Biblioteca Iniciado!");
           
        System.out.println("--- Carregando dados iniciais... ---");

        biblio.getUsuarioServicos().cadastrarUsuario("U01", "Joao da Silva");
        biblio.getUsuarioServicos().cadastrarUsuario("U02", "Maria Oliveira");
        biblio.getUsuarioServicos().cadastrarUsuario("U03", "Pedro Santos");

        biblio.getAcervoServicos().cadastrarItem(new Livro("L01", "Dom Casmurro", "Machado de Assis"));
        biblio.getAcervoServicos().cadastrarItem(new Livro("L02", "Clean Code", "Robert C. Martin"));

        biblio.getAcervoServicos().cadastrarItem(new Filme("F01", "O Poderoso Chefao", 175, "Coppola"));
        biblio.getAcervoServicos().cadastrarItem(new Filme("F02", "Interestelar", 169, "Nolan"));

        biblio.getAcervoServicos().cadastrarItem(new JogoTabuleiro("J01", "Banco Imobiliario", 6));
        biblio.getAcervoServicos().cadastrarItem(new JogoTabuleiro("J02", "Catan", 4));

        System.out.println("--- Dados carregados! Menu liberado. ---\n");

        while (rodando) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Cadastrar Usuario");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Cadastrar Filme");
            System.out.println("4. Cadastrar Jogo de Tabuleiro");
            System.out.println("5. Cadastrar Equipamento");
            System.out.println("6. Realizar Emprestimo");
            System.out.println("7. Relatorio de Emprestimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": 
                    System.out.print("ID do Usuario: ");
                    String idUser = scanner.nextLine();
                    System.out.print("Nome do Usuario: ");
                    String nomeUser = scanner.nextLine();
                    biblio.getUsuarioServicos().cadastrarUsuario(idUser, nomeUser);
                    break;

                case "2":
                    System.out.print("ID do Livro: ");
                    String idLivro = scanner.nextLine();
                    System.out.print("Titulo: ");
                    String titLivro = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    biblio.getAcervoServicos().cadastrarItem(new Livro(idLivro, titLivro, autor));
                    break;

                case "3": 
                    System.out.print("ID do Filme: ");
                    String idFilme = scanner.nextLine();
                    System.out.print("Titulo: ");
                    String titFilme = scanner.nextLine();
                    System.out.print("Diretor: ");
                    String diretor = scanner.nextLine();
                    System.out.print("Duracao (minutos): ");
                    int duracao = Integer.parseInt(scanner.nextLine());
                    biblio.getAcervoServicos().cadastrarItem(new Filme(idFilme, titFilme, duracao, diretor));
                    break;

                case "4": 
                    System.out.print("ID do Jogo: ");
                    String idJogo = scanner.nextLine();
                    System.out.print("Titulo: ");
                    String titJogo = scanner.nextLine();
                    System.out.print("Numero max de jogadores: ");
                    int numJog = Integer.parseInt(scanner.nextLine());
                    biblio.getAcervoServicos().cadastrarItem(new JogoTabuleiro(idJogo, titJogo, numJog));
                    break;

                case "5": 
                    System.out.print("ID do Equipamento: ");
                    String idEquip = scanner.nextLine();
                    System.out.print("Nome/Tipo: ");
                    String tipoEquip = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    biblio.getAcervoServicos().cadastrarItem(new Equipamento(idEquip, tipoEquip, marca));
                    break;

                case "6":
                    System.out.print("Digite o ID do Usuario: ");
                    String uId = scanner.nextLine();
                    System.out.print("Digite o ID do Item: ");
                    String iId = scanner.nextLine();
                    biblio.getEmprestimoServicos().registrarEmprestimo(uId, iId);
                    break;

                case "7": 
                    biblio.getRelatorioServicos().gerarRelatorioEmprestimosAtivos();
                    break;

                case "0":
                    rodando = false;
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        }
        scanner.close();
    }
}