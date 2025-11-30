package pam.biblioteca;

import java.util.Scanner;

public class Biblioteca {

    private UsuarioServicos usuarios;
    private AcervoServicos acervo;
    private EmprestimoServicos emprestimos;
    private RelatorioServicos relatorios;

    public Biblioteca() {

        this.usuarios = new UsuarioServicos();
        this.acervo = new AcervoServicos();
        this.emprestimos = new EmprestimoServicos(acervo, usuarios);

        this.relatorios = new RelatorioServicos(emprestimos, usuarios, acervo);
    }

    public UsuarioServicos getUsuarios() {
        return usuarios;
    }
    
    public AcervoServicos getAcervo() {
        return acervo;
    }
    
    public EmprestimoServicos getEmprestimos() {
        return emprestimos;
    }
    
    public RelatorioServicos getRelatorios() {
        return relatorios;
    }
    

    // ================= SUBMENU DE RELATORIOS =================
    public void menuRelatorios(Scanner scanner) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n--- MENU DE RELATORIOS ---");
            System.out.println("1. Relatorio de Emprestimos Ativos");
            System.out.println("2. Relatorio de Usuarios Cadastrados");
            System.out.println("3. Relatorio de Itens no Acervo");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");

            int opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    relatorios.gerarRelatorioEmprestimosAtivos();
                    break;
                case 2:
                    relatorios.gerarRelatorioUsuariosCadastrados();
                    break;
                case 3:
                    relatorios.gerarRelatorioItensAcervo();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        Biblioteca biblio = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        

        System.out.println("Sistema da Biblioteca Iniciado!");
        System.out.println("--- Carregando dados iniciais... ---");

        // Cadastro inicial de usuarios
        biblio.getUsuarios().cadastrarUsuario("U01", "Joao da Silva");
        biblio.getUsuarios().cadastrarUsuario("U02", "Maria Oliveira");
        biblio.getUsuarios().cadastrarUsuario("U03", "Pedro Santos");

        // Cadastro inicial do acervo
        biblio.getAcervo().cadastrarItem(new Livro("L01", "Dom Casmurro", "Machado de Assis"));
        biblio.getAcervo().cadastrarItem(new Livro("L02", "Clean Code", "Robert C. Martin"));

        biblio.getAcervo().cadastrarItem(new Filme("F01", "O Poderoso Chefao", 175, "Coppola"));
        biblio.getAcervo().cadastrarItem(new Filme("F02", "Interestelar", 169, "Nolan"));

        biblio.getAcervo().cadastrarItem(new JogoTabuleiro("J01", "Banco Imobiliario", 6));
        biblio.getAcervo().cadastrarItem(new JogoTabuleiro("J02", "Catan", 4));

        System.out.println("--- Dados carregados! Menu liberado. ---");

        while (rodando) {

            System.out.println("\n========= MENU =========");
            System.out.println("1. Cadastrar Usuario");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Cadastrar Filme");
            System.out.println("4. Cadastrar Jogo de Tabuleiro");
            System.out.println("5. Cadastrar Equipamento");
            System.out.println("6. Realizar Emprestimo");
            System.out.println("7. Relatorios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {

                case 1:
                    System.out.print("ID do Usuario: ");
                    String idU = scanner.nextLine().toUpperCase();
                    System.out.print("Nome do Usuario: ");
                    String nomeU = scanner.nextLine();
                    biblio.getUsuarios().cadastrarUsuario(idU, nomeU);
                    break;

                case 2:
                    System.out.print("ID do Livro: ");
                    String idLivro = scanner.nextLine().toUpperCase();
                    System.out.print("Titulo: ");
                    String titLivro = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    biblio.getAcervo().cadastrarItem(new Livro(idLivro, titLivro, autor));
                    break;

                case 3:
                    System.out.print("ID do Filme: ");
                    String idFilme = scanner.nextLine().toUpperCase();
                    System.out.print("Titulo: ");
                    String titFilme = scanner.nextLine();
                    System.out.print("Diretor: ");
                    String diretor = scanner.nextLine();
                    System.out.print("Duracao (minutos): ");
                    int duracao = Integer.parseInt(scanner.nextLine());
                    biblio.getAcervo().cadastrarItem(new Filme(idFilme, titFilme, duracao, diretor));
                    break;

                case 4:
                    System.out.print("ID do Jogo: ");
                    String idJogo = scanner.nextLine().toUpperCase();
                    System.out.print("Titulo: ");
                    String titJogo = scanner.nextLine();
                    System.out.print("Numero max de jogadores: ");
                    int numJog = Integer.parseInt(scanner.nextLine());
                    biblio.getAcervo().cadastrarItem(new JogoTabuleiro(idJogo, titJogo, numJog));
                    break;

                case 5:
                    System.out.print("ID do Equipamento: ");
                    String idEquip = scanner.nextLine().toUpperCase();
                    System.out.print("Nome/Tipo: ");
                    String tipoEquip = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    biblio.getAcervo().cadastrarItem(new Equipamento(idEquip, tipoEquip, marca));
                    break;

                case 6:
                    biblio.relatorios.gerarRelatorioUsuariosCadastrados();
                    System.out.print("\nID do Usuario: ");
                    String usrId = scanner.nextLine().toUpperCase();
                    
                    biblio.relatorios.gerarRelatorioItensAcervo();
                    System.out.print("\nID do Item: ");
                    String itemId = scanner.nextLine().toUpperCase();
                    biblio.getEmprestimos().registrarEmprestimo(usrId, itemId);
                    break;

                case 7:
                    biblio.menuRelatorios(scanner);
                    break;

                case 0:
                    rodando = false;
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }
        }

        scanner.close();
    }
}
