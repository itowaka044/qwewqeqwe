package entities;

import java.util.Date;

public class Player {
    private String nome;
    private Date idade;
    private int xp;
    private int lvl;
    private int mana;
    private int forca;
    private int inteligencia;
    private int constituicao;
    private boolean ofensiva;
    private Quest[] listaQuests;
    private int quantidadeQuests;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getIdade() {
        return idade;
    }

    public void setIdade(Date idade) {
        this.idade = idade;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public boolean getOfensiva() {
        return ofensiva;
    }

    public void setOfensiva(boolean ofensiva) {
        this.ofensiva = ofensiva;
    }

    public Quest[] getListaQuests() {
        return listaQuests;
    }

    public void setListaQuests(Quest[] listaQuests) {
        this.listaQuests = listaQuests;
    }

    public int getQuantidadeQuests() {
        return quantidadeQuests;
    }

    public void setQuantidadeQuests(int quantidadeQuests) {
        this.quantidadeQuests = quantidadeQuests;
    }

    public Player(String nome, Date idade) {
        this.nome = nome;
        this.idade = idade;
        this.xp = 100;
        this.lvl = 1;
        this.mana = 100;
        this.forca = 0;
        this.inteligencia = 0;
        this.constituicao = 0;
        this.ofensiva = false;
        this.listaQuests = new Quest[10];
        this.quantidadeQuests = 0;
    }

    public void adicionarQuest(Quest quest) {
        if (quest != null && quantidadeQuests < 10) {
            listaQuests[quantidadeQuests++] = quest;
        }
    }

    public void adicionarXP(int xp) {
        this.xp += xp;
        verificarSubirNivel();
    }

    public int paraProximoNivel(int lvl){

        if(lvl <= 30){
            return lvl * 150;
        }
        if(lvl > 30 && lvl <= 60){
            return lvl * 140;
        }
        if(lvl > 60){
            return lvl * 130;
        }

        return 0;
    }

    private void verificarSubirNivel() {
        while (this.xp >= paraProximoNivel(lvl)) {
            this.lvl++;
            this.xp -= 900;
            System.out.println("\n🎉 PARABÉNS! Você subiu para o nível " + this.lvl + "! 🎉");
        }
    }

//    public void subirNivel() {
//        this.lvl++;
//        this.xp = 100;
//    }

    public void subirNivel() {
        xp = xp - paraProximoNivel(lvl);
        lvl++;
    }

    public boolean alternarModoOfensivo() {
        return this.ofensiva = !this.ofensiva;
    }
}
