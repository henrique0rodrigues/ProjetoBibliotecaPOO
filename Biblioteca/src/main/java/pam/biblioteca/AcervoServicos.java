
package pam.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AcervoServicos {

    private List<ItemBiblioteca> inventario = new ArrayList<>();

    public boolean cadastrarItem(ItemBiblioteca item) {
        if (buscarPorId(item.getId()) != null) {
            System.out.println("Erro: item com ID " + item.getId() + " ja existe.");
            return false;
        }
        inventario.add(item);
        System.out.println("--> Item adicionado ao acervo: " + item.getTitulo());
        return true;
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
    
    public List<ItemBiblioteca> getTodosItens() {
        return new ArrayList<>(this.inventario); // coleção interna do acervo
}

}

