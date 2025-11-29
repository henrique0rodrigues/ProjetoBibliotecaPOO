package pam.biblioteca;

import java.util.List;

public class RelatorioServicos {

    private EmprestimoServicos fonteDeDados;

    public RelatorioServicos(EmprestimoServicos fonteDeDados) {
        this.fonteDeDados = fonteDeDados;
    }

    public void gerarRelatorioEmprestimosAtivos() {
        System.out.println("\n--- RELATORIO: ITENS EMPRESTADOS ---");
        List<TicketEmprestimo> lista = fonteDeDados.getEmprestimosAtivos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum emprestimo ativo no momento.");
        } else {
            for (TicketEmprestimo t : lista) {
                System.out.println(t);
            }
        }
        System.out.println("------------------------------------");
    }
}
