package padroesestruturais.composite;

import java.util.ArrayList;
import java.util.List;

public class Combo extends ItemCardapio {
    private List<ItemCardapio> itens;

    public Combo(String descricao) {
        super(descricao);
        this.itens = new ArrayList<ItemCardapio>();
    }

    public void addItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public String getDetalhes() {
        String saida = "";
        saida = "Combo: " + this.getDescricao() + "\n";
        for (ItemCardapio item : itens) {
            saida += item.getDetalhes();
        }
        return saida;
    }
}