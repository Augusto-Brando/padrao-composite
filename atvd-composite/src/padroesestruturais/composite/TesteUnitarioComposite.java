package padroesestruturais.composite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteUnitarioComposite {

    @Test
    public void testPratoSimples() {
        PratoSimples prato = new PratoSimples("X-Bacon", 18.0f);
        assertEquals("Prato: X-Bacon - preco: R$ 18.0\n", prato.getDetalhes());
    }

    @Test
    public void testComboComDoisItens() {
        Combo combo = new Combo("Combo Familia");
        combo.addItem(new PratoSimples("X-Tudo", 25.0f));
        combo.addItem(new PratoSimples("Refrigerante", 5.0f));
        String detalhes = combo.getDetalhes();
        assertTrue(detalhes.contains("Combo: Combo Familia"));
        assertTrue(detalhes.contains("X-Tudo"));
        assertTrue(detalhes.contains("Refrigerante"));
    }

    @Test
    public void testComboAninhado() {
        Combo comboGrande = new Combo("Combo Super");
        Combo comboPequeno = new Combo("Combo Lanche");
        comboPequeno.addItem(new PratoSimples("X-Salada", 15.0f));
        comboPequeno.addItem(new PratoSimples("Suco", 6.0f));
        comboGrande.addItem(comboPequeno);
        comboGrande.addItem(new PratoSimples("Batata Frita", 10.0f));
        String detalhes = comboGrande.getDetalhes();
        assertTrue(detalhes.contains("Combo Super"));
        assertTrue(detalhes.contains("Combo Lanche"));
        assertTrue(detalhes.contains("X-Salada"));
        assertTrue(detalhes.contains("Batata Frita"));
    }

    @Test
    public void testPedidoComPratoSimples() {
        Pedido pedido = new Pedido();
        pedido.setCardapio(new PratoSimples("X-Burguer", 12.0f));
        String cardapio = pedido.getCardapio();
        assertTrue(cardapio.contains("X-Burguer"));
        assertTrue(cardapio.contains("12.0"));
    }

    @Test
    public void testPedidoComCombo() {
        Pedido pedido = new Pedido();
        Combo combo = new Combo("Combo Executivo");
        combo.addItem(new PratoSimples("X-Egg", 16.0f));
        combo.addItem(new PratoSimples("Cafe", 4.0f));
        pedido.setCardapio(combo);
        String cardapio = pedido.getCardapio();
        assertTrue(cardapio.contains("Combo Executivo"));
        assertTrue(cardapio.contains("X-Egg"));
        assertTrue(cardapio.contains("Cafe"));
    }

    @Test
    public void testPedidoSemCardapio() {
        Pedido pedido = new Pedido();
        assertThrows(NullPointerException.class, () -> {
            pedido.getCardapio();
        });
    }
}