package padroesestruturais.composite;

public class PratoSimples extends ItemCardapio {
    private float preco;

    public PratoSimples(String descricao, float preco) {
        super(descricao);
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDetalhes() {
        return "Prato: " + this.getDescricao() + " - preco: R$ " + this.preco + "\n";
    }
}