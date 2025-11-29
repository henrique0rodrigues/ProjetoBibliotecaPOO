
package pam.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class UsuarioServicos {

    private Map<String, Usuario> bancoDeUsuarios = new HashMap<>();

    public void cadastrarUsuario(String id, String nome) {
        if (bancoDeUsuarios.containsKey(id)) {
            System.out.println("Erro: Usuario com ID " + id + " ja existe.");
        } else {
            Usuario novoUser = new Usuario(id, nome);
            bancoDeUsuarios.put(id, novoUser);
            System.out.println("--> Usuario cadastrado: " + novoUser);
        }
    }

    public Usuario buscarUsuario(String id) {
        return bancoDeUsuarios.get(id);
    }

    public boolean verificarStatusParaEmprestimo(String id) {
        Usuario u = bancoDeUsuarios.get(id);
        // Verifica se existe e se NÃO está bloqueado
        return u != null && !u.isBloqueado();
    }
    
    public void bloquearUsuario(String id, boolean status) {
        Usuario u = bancoDeUsuarios.get(id);
        if(u != null) {
             u.setBloqueado(status);
             System.out.println("Status de bloqueio do usuario " + u.getNome() + " alterado para: " + status);
        }
    }
}
