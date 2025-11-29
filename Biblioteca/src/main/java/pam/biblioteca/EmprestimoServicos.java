package pam.biblioteca;

import java.util.List;
import java.util.ArrayList;

public class EmprestimoServicos {

    private List<TicketEmprestimo> emprestimosAtivos = new ArrayList<>();
    
    // Dependências necessárias para trabalhar
    private AcervoServicos acervoServicos;
    private UsuarioServicos usuarioServicos;

    // CONSTRUTOR CRÍTICO: Recebe as dependências já instanciadas
    public EmprestimoServicos(AcervoServicos acervoServicos, UsuarioServicos usuarioServicos) {
        this.acervoServicos = acervoServicos;
        this.usuarioServicos = usuarioServicos;
    }

    public void registrarEmprestimo(String idUsuario, String idItem) {
        System.out.println("\nTentando registrar emprestimo...");

        // 1. Validações usando os outros serviços
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

        // 2. Se passou, realiza a operação
        Usuario u = usuarioServicos.buscarUsuario(idUsuario);
        ItemBiblioteca item = acervoServicos.buscarPorId(idItem);

        // Cria o ticket
        TicketEmprestimo ticket = new TicketEmprestimo(u, item);
        emprestimosAtivos.add(ticket);

        // Atualiza o status do item no acervo (Importante!)
        item.setDisponivel(false);

        System.out.println("SUCESSO: Emprestimo realizado. " + ticket);
    }

    // Método auxiliar para o relatório
    public List<TicketEmprestimo> getEmprestimosAtivos() {
        return emprestimosAtivos;
    }
} 

