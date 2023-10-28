//Isabela Nunes Zeferino
// Maria Fernanda Rizzo Rodrigues da Costa

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // vetor de palavras
        String[] palavras = {
                "placa", "tenis", "janela", "mesa", "chuva",
                "grama", "blusa", "garrafa", "lousa", "carregador",
                "peneira", "cadeira", "oculos", "caneta", "piscina",
                "mouse", "estilete", "estojo", "javascript", "lapis"
        };

        String palavraSelecionada = palavras[(int) (Math.random() * palavras.length)]; // gerar ua palavra aleatoria
        char[] letrasUsadas = new char[26]; // pegar letras já usadas
        int tentativasRestantes = 6; // mostrar tentativas restantes

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Forca!");
        char[] palavraAdivinhada = inicializarPalavraAdivinhada(palavraSelecionada); // inicializa com hifens

        while (true) {
            // mostrar desenho da forca
            imprimirForca(tentativasRestantes);

            System.out.println("Palavra: " + String.valueOf(palavraAdivinhada)); // exibir a palavra adivinhada até
                                                                                 // agora
            System.out.println("Tentativas restantes: " + tentativasRestantes); // exibir o número de tentativas
                                                                                // restantes
            System.out.println("Letras usadas: " + String.valueOf(letrasUsadas)); // exibir as letras já usadas
            System.out.print("Digite uma letra: "); // pedir pro usuario digitar uma letra
            char letra = scanner.nextLine().charAt(0);

            if (letraJaUsada(letra, letrasUsadas)) { // verifica se a letra já foi usada
                System.out.println("Você já usou a letra '" + letra + "'. Tente outra letra.");
                continue;
            }

            letrasUsadas[letra - 'a'] = letra; // guarda a letra usada

            if (palavraSelecionada.contains(String.valueOf(letra))) {
                for (int i = 0; i < palavraSelecionada.length(); i++) {
                    if (palavraSelecionada.charAt(i) == letra) {
                        palavraAdivinhada[i] = letra; // Preenche as letras adivinhadas na palavra
                    }
                }
            } else {
                tentativasRestantes--; // diminui as tentativas restantes se a letra não estiver na palavra
            }

            if (tentativasRestantes == 0) { // verifica se o jogador perdeu
                // imprimir desenho da forca com boneco completo
                imprimirForca(tentativasRestantes);
                System.out.println("Você perdeu! A palavra era: " + palavraSelecionada);
                break;
            }

            if (palavraSelecionada.equals(String.valueOf(palavraAdivinhada))) { // Verifica se o jogador ganhou
                System.out.println("Parabéns! Você adivinhou a palavra: " + palavraSelecionada);
                break;
            }
        }
    }

    public static boolean letraJaUsada(char letra, char[] letrasUsadas) {
        return letrasUsadas[letra - 'a'] != 0; // Verifica se a letra já foi usada
    }

    public static void imprimirForca(int tentativasRestantes) {
        // Desenho da forca e do boneco com base no número de tentativas restantes
        String[] forca = {
                "  ________     ",
                " |        |    ",
                " |        " + (tentativasRestantes < 6 ? "O" : "") + "    ",
                " |       " + (tentativasRestantes < 5 ? "/" : "") + (tentativasRestantes < 4 ? "|" : "")
                        + (tentativasRestantes < 3 ? "\\" : "") + "   ",
                " |       " + (tentativasRestantes < 2 ? "/" : " ") + " " + (tentativasRestantes < 1 ? "\\" : "")
                        + "   ",
                " |              ",
                " |              ",
                " |              ",
                " |              ",
                " |              "
        };

        for (int i = 0; i < forca.length; i++) {
            System.out.println(forca[i]);
        }
    }

    public static char[] inicializarPalavraAdivinhada(String palavra) {
        char[] palavraAdivinhada = new char[palavra.length()];
        for (int i = 0; i < palavraAdivinhada.length; i++) {
            palavraAdivinhada[i] = '_'; // Inicializa com hifens
        }
        return palavraAdivinhada;
    }
}
