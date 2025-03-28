package entities;

import static entities.NivelDificuldade.*;

public class Quest {
    private String titulo;
    private NivelDificuldade dificuldade;
    private String descricao;
    private String duracao;
    private boolean finalizada;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public NivelDificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(NivelDificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Quest(String titulo, NivelDificuldade dificuldade, String descricao, String duracao) {
        this.titulo = titulo;
        this.dificuldade = dificuldade;
        this.descricao = descricao;
        this.duracao = duracao;
        this.finalizada = false;
    }

    public void finalizar() {
        finalizada = true;
    }

    public int calcularXp(){

        if(dificuldade == FACIL){
            return 150;
        }
        if(dificuldade == MEDIO){
            return 300;
        }
        if(dificuldade == DIFICIL){
            return 600;
        }

        return 0;
    }

//    public int calcularXP() {
//        // XP base = 100
//        int multiplicadorDificuldade = switch (dificuldade) {
//            case NivelDificuldade.MEDIO -> 2;
//            case NivelDificuldade.DIFICIL -> 3;
//            default -> 1;
//        };
//
//    int multiplicadorDuracao = switch (duracao) {
//        case "semanal" -> 2;
//        case "mensal" -> 3;
//        default -> 1; // diária
//    };
//
//    public String getDificuldadeNome() {
//        return NivelDificuldade.;
//    }
}