
package pam.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AcervoServicos {

    private List<ItemBiblioteca> inventario = new ArrayList<>();

    public void cadastrarItem(ItemBiblioteca item) {
        inventario.add(item);
        System.out.println("--> Item adicionado ao acervo: " + item.getTitulo());
    }

    public ItemBiblioteca buscarPorId(String id) {
        for (ItemBiblioteca item : inventario) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public boolean verificarDisponibilidade(String id) {
        ItemBiblioteca item = buscarPorId(id);
        return item != null && item.isDisponivel();
    }
}

