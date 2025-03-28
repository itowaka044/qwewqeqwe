package entities;

public class Sombras {
    private String nomeSombra;
    private String descSombra;
    private String[] raridade;
    private Items[] itens;
    private int quantidadeItens;

    public String getNomeSombra() {
        return nomeSombra;
    }

    public void setNomeSombra(String nomeSombra) {
        this.nomeSombra = nomeSombra;
    }

    public String getDescSombra() {
        return descSombra;
    }

    public void setDescSombra(String descSombra) {
        this.descSombra = descSombra;
    }

    public String[] getRaridade() {
        return raridade;
    }

    public void setRaridade(String[] raridade) {
        this.raridade = raridade;
    }

    public Items[] getItens() {
        return itens;
    }

    public void setItens(Items[] itens) {
        this.itens = itens;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public Sombras(String nomeSombra, String descSombra) {
        this.nomeSombra = nomeSombra;
        this.descSombra = descSombra;
        this.raridade = new String[] { "Comum", "Raro", "Lendário" };
        this.itens = new Items[5];
        this.quantidadeItens = 0;
    }

    public void adicionarItem(Items item) {
        if (item != null && quantidadeItens < 5) {
            itens[quantidadeItens++] = item;
        }
    }

    public boolean removerItem(int itemId) {
        for (int i = 0; i < quantidadeItens; i++) {
            if (itens[i].getItemId() == itemId) {
                itens[i] = itens[--quantidadeItens];
                itens[quantidadeItens] = null;
                return true;
            }
        }
        return false;
    }
}
