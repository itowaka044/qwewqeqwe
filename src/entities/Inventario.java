package entities;

public class Inventario {
    private int quantidade;
    private String tipoItem;
    private Items[] itens;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public Items[] getItens() {
        return itens;
    }

    public void setItens(Items[] itens) {
        this.itens = itens;
    }

    public Inventario(String tipoItem) {
        this.tipoItem = tipoItem;
        this.quantidade = 0;
        this.itens = new Items[20];
    }

    public void adicionarItem(Items item) {
        if (item != null && quantidade < 20) {
            itens[quantidade++] = item;
        }
    }

    public boolean removerItem(int itemId) {
        for (int i = 0; i < quantidade; i++) {
            if (itens[i].getItemId() == itemId) {
                itens[i] = itens[--quantidade];
                itens[quantidade] = null;
                return true;
            }
        }
        return false;
    }
}
