package pam.biblioteca;

public class TestesAutomatizados {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO BATERIA DE TESTES ===\n");

        // 1. SETUP: Instanciando o sistema "limpo"
        UsuarioServicos userSvc = new UsuarioServicos();
        AcervoServicos acervoSvc = new AcervoServicos();
        EmprestimoServicos empSvc = new EmprestimoServicos(acervoSvc, userSvc);

        // Populando dados iniciais
        userSvc.cadastrarUsuario("U01", "Alice (Padrão)");
        userSvc.cadastrarUsuario("U02", "Bob (Bloqueado)");
        
        acervoSvc.cadastrarItem(new Livro("L01", "Java Book", "Deitel"));
        acervoSvc.cadastrarItem(new Filme("F01", "Matrix", 120, "Wachowski")); // Testando o Filme novo
        acervoSvc.cadastrarItem(new JogoTabuleiro("J01", "Catan", 4));        // Testando o Jogo novo

        // --- TESTE 1: Empréstimo de Livro (Caminho Feliz) ---
        System.out.print("TESTE 1 [Empréstimo Normal]: ");
        empSvc.registrarEmprestimo("U01", "L01");
        
        // Verificação: O livro L01 deve estar indisponível agora
        ItemBiblioteca livro = acervoSvc.buscarPorId("L01");
        if (!livro.isDisponivel()) {
            System.out.println("✅ SUCESSO");
        } else {
            System.out.println("❌ FALHA (O item deveria estar indisponível)");
        }

        // --- TESTE 2: Tentar pegar item já emprestado ---
        System.out.print("TESTE 2 [Item Já Emprestado]: ");
        // Tentar pegar L01 de novo (Alice já pegou)
        int qtdEmprestimosAntes = empSvc.getEmprestimosAtivos().size();
        empSvc.registrarEmprestimo("U02", "L01"); 
        int qtdEmprestimosDepois = empSvc.getEmprestimosAtivos().size();

        if (qtdEmprestimosAntes == qtdEmprestimosDepois) {
            System.out.println("✅ SUCESSO (O sistema bloqueou o segundo empréstimo)");
        } else {
            System.out.println("❌ FALHA (O sistema permitiu duplicidade)");
        }

        // --- TESTE 3: Usuário Bloqueado ---
        System.out.print("TESTE 3 [Usuário Bloqueado]: ");
        userSvc.bloquearUsuario("U02", true); // Bloqueando o Bob
        
        empSvc.registrarEmprestimo("U02", "F01"); // Bob tenta pegar o Filme Matrix
        
        ItemBiblioteca filme = acervoSvc.buscarPorId("F01");
        if (filme.isDisponivel()) {
            System.out.println("✅ SUCESSO (O filme continuou disponível, empréstimo negado)");
        } else {
            System.out.println("❌ FALHA (O sistema emprestou para usuário bloqueado)");
        }

        // --- TESTE 4: Polimorfismo (Jogo de Tabuleiro) ---
        System.out.print("TESTE 4 [Empréstimo de Novo Item - Jogo]: ");
        empSvc.registrarEmprestimo("U01", "J01"); // Alice pega Catan
        
        ItemBiblioteca jogo = acervoSvc.buscarPorId("J01");
        if (!jogo.isDisponivel()) {
            System.out.println("✅ SUCESSO (Sistema aceitou JogoTabuleiro normalmente)");
        } else {
            System.out.println("❌ FALHA (Problema com classes filhas)");
        }

        // --- TESTE 5: Item Inexistente ---
        System.out.print("TESTE 5 [Item Inexistente]: ");
        try {
            empSvc.registrarEmprestimo("U01", "ID_QUE_NAO_EXISTE");
            System.out.println("✅ SUCESSO (O sistema tratou o erro sem crashar)");
        } catch (Exception e) {
            System.out.println("❌ FALHA (O sistema crashou com exceção: " + e.getMessage() + ")");
        }

        System.out.println("\n=== FIM DOS TESTES ===");
    }
}