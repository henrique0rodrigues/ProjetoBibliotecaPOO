package pam.biblioteca;

import java.util.List;
import java.util.ArrayList;

public class EmprestimoServicos {

    private List<TicketEmprestimo> emprestimosAtivos = new ArrayList<>();

    private AcervoServicos acervoServicos;
    private UsuarioServicos usuarioServicos;

    public EmprestimoServicos(AcervoServicos acervoServicos, UsuarioServicos usuarioServicos) {
        this.acervoServicos = acervoServicos;
        this.usuarioServicos = usuarioServicos;
    }

    public void registrarEmprestimo(String idUsuario, String idItem) {
        System.out.println("\nTentando registrar emprestimo...");

        boolean usuarioOk = usuarioServicos.verificarStatusParaEmprestimo(idUsuario);
        boolean itemOk = acervoServicos.verificarDisponibilidade(idItem);

        if (!usuarioOk) {
            System.out.println("FALHA: Usuario invalido ou bloqueado.");
            return;
        }

        if (!itemOk) {
            System.out.println("FALHA: Item nao existe ou ja esta emprestado.");
            return;
        }

        Usuario u = usuarioServicos.buscarUsuario(idUsuario);
        ItemBiblioteca item = acervoServicos.buscarPorId(idItem);

        TicketEmprestimo ticket = new TicketEmprestimo(u, item);
        emprestimosAtivos.add(ticket);

        item.setDisponivel(false);

        System.out.println("SUCESSO: Emprestimo realizado. " + ticket);
    }

    public List<TicketEmprestimo> getEmprestimosAtivos() {
        return new ArrayList<>(emprestimosAtivos);
    }
}


