import java.util.Date;
import java.util.Scanner;

import entities.NivelDificuldade;
import entities.Player;
import entities.Quest;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Player player = criarJogador();
        mostrarStatusInicial(player);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1 - Criar Nova Missão");
            System.out.println("2 - Ver Status");
            System.out.println("3 - Ver Missões");
            System.out.println("4 - Finalizar Missão");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    criarMissaoUsuario(player);
                    break;
                case 2:
                    mostrarStatusInicial(player);
                    break;
                case 3:
                    mostrarMissoes(player);
                    break;
                case 4:
                    finalizarMissao(player);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("\nPrograma finalizado!");
        sc.close();
    }

    private static Player criarJogador() {
        System.out.println("Digite o nome do seu personagem: ");
        String nome = sc.nextLine();

        System.out.println("Digite a idade do seu personagem: ");
        int idadeInt = sc.nextInt();
        Date idade = new Date(idadeInt, 1, 1);

        return new Player(nome, idade);
    }

    private static void mostrarStatusInicial(Player player) {
        System.out.println("\n=== Status do Jogador ===");
        System.out.println("Nome: " + player.getNome());
        System.out.println("Nível: " + player.getLvl());
        System.out.println("XP: " + player.getXp());
        System.out.println("Mana: " + player.getMana());
        System.out.println("Força: " + player.getForca());
        System.out.println("Inteligência: " + player.getInteligencia());
        System.out.println("Constituição: " + player.getConstituicao());
        System.out.println("Modo Ofensivo: " + (player.getOfensiva() ? "Ativado" : "Desativado"));
    }

    private static void mostrarMissoes(Player player) {
        System.out.println("\n=== Suas Missões ===");
        if (player.getQuantidadeQuests() == 0) {
            System.out.println("Você ainda não tem missões!");
            return;
        }
        for (int i = 0; i < player.getQuantidadeQuests(); i++) {
            Quest quest = player.getListaQuests()[i];
            System.out.println((i + 1) + " - " + quest.getTitulo() +
                    " (XP: " + quest.calcularXp() +
                    ", Dificuldade: " + quest.getDificuldade() +
                    ", Duração: " + quest.getDuracao() + ")");
        }
    }

    private static void criarMissaoUsuario(Player player) {
        System.out.println("\n=== Criar Nova Missão ===");

        System.out.println("Digite o título da missão: ");
        String titulo = sc.nextLine();

        System.out.println("Digite a descrição da missão: ");
        String descricao = sc.nextLine();

        System.out.println("Escolha o nível de dificuldade:");
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Difícil");
        System.out.print("Escolha: ");
        int qualDificuldade = sc.nextInt();
        NivelDificuldade dificuldade = NivelDificuldade.FACIL;

        switch(qualDificuldade){
            case 1:
                dificuldade = NivelDificuldade.FACIL;
                break;
            case 2:
                dificuldade = NivelDificuldade.MEDIO;
                break;
            case 3:
                dificuldade = NivelDificuldade.DIFICIL;
                break;
        }



        System.out.println("Escolha a duração da missão:");
        System.out.println("1 - Diária");
        System.out.println("2 - Semanal");
        System.out.println("3 - Mensal");
        System.out.print("Escolha: ");
        int duracaoOpcao = sc.nextInt();
        String duracao;

        switch (duracaoOpcao) {
            case 1:
                duracao = "diária";
                break;
            case 2:
                duracao = "semanal";
                break;
            case 3:
                duracao = "mensal";
                break;
            default:
                duracao = "diária";
        }

        Quest novaQuest = new Quest(titulo, dificuldade, descricao, duracao);
        player.adicionarQuest(novaQuest);
        System.out.println("Missão " + duracao + " criada com sucesso!");
    }

    private static void finalizarMissao(Player player) {
        if (player.getQuantidadeQuests() == 0) {
            System.out.println("Você não tem missões para finalizar!");
            return;
        }

        mostrarMissoes(player);
        System.out.print("\nDigite o número da missão que deseja finalizar: ");
        int numeroMissao = sc.nextInt() - 1;

        if (numeroMissao >= 0 && numeroMissao < player.getQuantidadeQuests()) {
            Quest quest = player.getListaQuests()[numeroMissao];
            if (!quest.isFinalizada()) {
                int xpGanho = quest.calcularXp();
                quest.finalizar();
                player.adicionarXP(xpGanho);
                System.out.println("Missão finalizada! Você ganhou " + xpGanho + " XP!");
            } else {
                System.out.println("Esta missão já foi finalizada!");
            }
        } else {
            System.out.println("Número de missão inválido!");
        }
    }
}
