
package pam.biblioteca;

import java.time.LocalDate;

public class TicketEmprestimo {
    private Usuario usuario;
    private ItemBiblioteca item;
    private LocalDate dataEmprestimo;

    public TicketEmprestimo(Usuario usuario, ItemBiblioteca item) {
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = LocalDate.now();
    }
    @Override
    public String toString() {
        return "Ticket [User: " + usuario.getNome() + ", Item: " + item.getTitulo() + ", Data: " + dataEmprestimo + "]";
    }
}
