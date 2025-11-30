package pam.biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TicketEmprestimo {
    private Usuario usuario;
    private ItemBiblioteca item;
    private LocalDate dataEmprestimo, dataDevolucao;

    public TicketEmprestimo(Usuario usuario, ItemBiblioteca item) {
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = LocalDate.now().plusDays(7);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFmt = dataEmprestimo.format(formatter);
        String dataDevFmt = dataDevolucao.format(formatter);

        return String.format(
            "\n> REGISTRO DE EMPRESTIMO [%s]\n" +
            "    Cliente: %s\n" +
            "    Item:    %s\n" +
            "    Devolucao: [%s]",
            dataFmt,
            usuario.getNome(),
            item.getTitulo(),
            dataDevFmt
        );
    }
}