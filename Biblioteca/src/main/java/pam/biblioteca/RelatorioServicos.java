package pam.biblioteca;

import java.util.List;

public class RelatorioServicos {
    private EmprestimoServicos emprestimoService;
    private UsuarioServicos usuarioService;
    private AcervoServicos acervoService;

    public RelatorioServicos(EmprestimoServicos emprestimoService,
                             UsuarioServicos usuarioService,
                             AcervoServicos acervoService) {
        this.emprestimoService = emprestimoService;
        this.usuarioService = usuarioService;
        this.acervoService = acervoService;
    }

    // Já existente (presumo). Mantive e chamei internamente.
    public void gerarRelatorioEmprestimosAtivos() {
        System.out.println("\n--- Relatorio de Emprestimos Ativos ---");
        // Presumo que EmprestimoServicos tenha método que retorna List<Emprestimo>
        List<TicketEmprestimo> ativos = emprestimoService.getEmprestimosAtivos(); // ajuste se nome diferente
        if (ativos == null || ativos.isEmpty()) {
            System.out.println("Nenhum emprestimo ativo no momento.");
            return;
        }
        for (TicketEmprestimo e : ativos) {
            System.out.println(e); // depende do toString de Emprestimo (ideal)
        }
    }

    // Novo: lista todos os usuários cadastrados
    public void gerarRelatorioUsuariosCadastrados() {
        System.out.println("\n--- Relatorio de Usuarios Cadastrados ---");
        // Presumo que UsuarioServicos tenha método getTodosUsuarios() retornando List<Usuario>
        List<Usuario> usuarios = usuarioService.getTodosUsuarios(); // ajuste se nome diferente
        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }
        for (Usuario u : usuarios) {
            System.out.println(u); // depende de toString em Usuario ou use getters
        }
    }

    // Novo: lista todos os itens do acervo
    public void gerarRelatorioItensAcervo() {
        System.out.println("\n--- Relatorio de Itens do Acervo ---");
        // Presumo que AcervoServicos tenha getTodosItens() retornando List<ItemBiblioteca>
        List<ItemBiblioteca> itens = acervoService.getTodosItens(); // ajuste se nome diferente
        if (itens == null || itens.isEmpty()) {
            System.out.println("Acervo vazio.");
            return;
        }
        for (ItemBiblioteca it : itens) {
            System.out.println(it); // toString de cada item já descreve
        }
    }
}
