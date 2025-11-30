package pam.biblioteca;

import java.util.List;

public class RelatorioServicos {

    private EmprestimoServicos EmprestimoServico;
    private UsuarioServicos UsuarioServico;
    private AcervoServicos AcervoServico;

    public RelatorioServicos(EmprestimoServicos EmprestimoServico,
                             UsuarioServicos UsuarioServico,
                             AcervoServicos AcervoServico) {
        this.EmprestimoServico = EmprestimoServico;
        this.UsuarioServico = UsuarioServico;
        this.AcervoServico = AcervoServico;
    }

    public void gerarRelatorioEmprestimosAtivos() {
        System.out.println("\n--- Relatorio de Emprestimos Ativos ---");

        List<TicketEmprestimo> ativos = EmprestimoServico.getEmprestimosAtivos();

        if (ativos == null || ativos.isEmpty()) {
            System.out.println("Nenhum emprestimo ativo no momento.");
            return;
        }

        for (TicketEmprestimo e : ativos) {
            System.out.println(e);
        }
    }

    public void gerarRelatorioUsuariosCadastrados() {
        System.out.println("\n--- Relatorio de Usuarios Cadastrados ---");

        List<Usuario> usuarios = UsuarioServico.getTodosUsuarios();

        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }

        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public void gerarRelatorioItensAcervo() {
        System.out.println("\n--- Relatorio de Itens do Acervo ---");

        List<ItemBiblioteca> itens = AcervoServico.getTodosItens();

        if (itens == null || itens.isEmpty()) {
            System.out.println("Acervo vazio.");
            return;
        }

        for (ItemBiblioteca it : itens) {
            System.out.println(it);
        }
    }
}
