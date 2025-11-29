package pam.biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        // Formata a data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFmt = dataEmprestimo.format(formatter);

        // Formatação limpa usando apenas indentação e quebra de linha
        return String.format(
            "\n> REGISTRO DE EMPRÉSTIMO [%s]\n" +
            "    Cliente: %s\n" +
            "    Item:    %s",
            dataFmt,
            usuario.getNome(),
            item.getTitulo()
        );
    }
}