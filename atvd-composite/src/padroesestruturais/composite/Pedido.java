package padroesestruturais.composite;

public class Pedido {
    private ItemCardapio cardapio;

    public void setCardapio(ItemCardapio cardapio) {
        this.cardapio = cardapio;
    }

    public String getCardapio() {
        if (this.cardapio == null) {
            throw new NullPointerException("Pedido sem cardapio");
        }
        return this.cardapio.getDetalhes();
    }
}