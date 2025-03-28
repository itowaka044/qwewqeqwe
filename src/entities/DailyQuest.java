package entities;

import java.util.Date;

public class DailyQuest extends Quest {
    private boolean foiFeito;
    private Date resetarDaily;

    public boolean isFoiFeito() {
        return foiFeito;
    }

    public void setFoiFeito(boolean foiFeito) {
        this.foiFeito = foiFeito;
    }

    public Date getResetarDaily() {
        return resetarDaily;
    }

    public void setResetarDaily(Date resetarDaily) {
        this.resetarDaily = resetarDaily;
    }

    public DailyQuest(String titulo, NivelDificuldade dificuldade, String descricao) {
        super(titulo, dificuldade, descricao, "diária");
        this.foiFeito = false;
        this.resetarDaily = new Date();
    }

    public boolean verificarReset() {
        Date dataAtual = new Date();
        return (dataAtual.getTime() - this.resetarDaily.getTime()) >= 24 * 60 * 60 * 1000;
    }

    public void completar() {
        if (!this.foiFeito) {
            this.foiFeito = true;
            this.resetarDaily = new Date();
        }
    }
}
