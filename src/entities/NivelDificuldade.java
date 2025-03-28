package entities;

public enum NivelDificuldade {
  FACIL(1), MEDIO(2), DIFICIL(3);

  private final int valor;

  NivelDificuldade(int valor) {
    this.valor = valor;
  }

  public int getValor() {
    return valor;
  }
}