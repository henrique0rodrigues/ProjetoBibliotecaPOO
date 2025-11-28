
package pam.biblioteca;

public class Biblioteca {

    // As camadas de serviço
    private UsuarioServicos usuarioService;
    private AcervoServicos acervoService;
    private EmprestimoServicos emprestimoService;
    private RelatorioServicos relatorioService;

    public Biblioteca() {
        System.out.println("Inicializando sistema da Biblioteca...");
        
        // 1. Instanciar os serviços básicos (que não têm dependências)
        this.usuarioService = new UsuarioServicos();
        this.acervoService = new AcervoServicos();

        // 2. Instanciar serviços complexos INJETANDO as dependências necessárias
        // O EmprestimoServicos PRECISA saber quem são os usuarios e o acervo
        this.emprestimoService = new EmprestimoServicos(acervoService, usuarioService);
        
        // O RelatorioServicos precisa dos dados de empréstimo
        this.relatorioService = new RelatorioServicos(emprestimoService);
    }

    // Getters para acesso no main (em um app real, isso seria diferente)
    public UsuarioServicos getUsuarioServicos() {
        return usuarioService;
    }
    
    public AcervoServicos getAcervoServicos() {
        return acervoService;
    }
    
    public EmprestimoServicos getEmprestimoServicos() {
        return emprestimoService;
    }
    
    public RelatorioServicos getRelatorioServicos() {
        return relatorioService;
    }


    public static void main(String[] args) {
        // --- CENÁRIO DE TESTE ---

        // 1. Inicia a biblioteca (que cria os serviços internamente)
        Biblioteca biblio = new Biblioteca();
        System.out.println("\n--- FASE 1: CADASTROS ---");

        // 2. Populando o sistema (usando os serviços)
        biblio.getUsuarioServicos().cadastrarUsuario("U01", "João da Silva");
        biblio.getUsuarioServicos().cadastrarUsuario("U02", "Maria Souza");

        // Usando polimorfismo: cadastrando um Livro como ItemBiblioteca
        biblio.getAcervoServicos().cadastrarItem(new Livro("L01", "Dom Casmurro", "Machado de Assis"));
        biblio.getAcervoServicos().cadastrarItem(new Livro("L02", "O Hobbit", "J.R.R. Tolkien"));

        System.out.println("\n--- FASE 2: OPERAÇÕES DE EMPRÉSTIMO ---");

        // 3. Teste de Empréstimo com Sucesso
        // João (U01) pega Dom Casmurro (L01)
        biblio.getEmprestimoServicos().registrarEmprestimo("U01", "L01");

        // 4. Teste de Falha: Item já emprestado
        // Maria (U02) tenta pegar o mesmo livro (L01)
        biblio.getEmprestimoServicos().registrarEmprestimo("U02", "L01");

        // 5. Teste de Falha: Usuário inexistente
        biblio.getEmprestimoServicos().registrarEmprestimo("U99", "L02");

        // 6. Teste de Falha: Usuário bloqueado
        biblio.getUsuarioServicos().bloquearUsuario("U02", true); // Bloqueia Maria
        biblio.getEmprestimoServicos().registrarEmprestimo("U02", "L02"); // Maria tenta pegar O Hobbit

        System.out.println("\n--- FASE 3: RELATÓRIOS ---");
        // 7. Verificando o estado final
        biblio.getRelatorioServicos().gerarRelatorioEmprestimosAtivos();
    }
}
