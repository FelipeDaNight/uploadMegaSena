package uploadMegaSena;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mega_sena {
    public static void main(String[] args) {
        int[] numerosSorteados = {1, 15, 16, 25, 32, 36};

        List<Integer> listaNumeros = gerarNumerosAleatorios(51000000);

        // Percorrendo a lista em ordem direta
        int posicao = -1;
        int sequenciasEncontradas = 0;
        for (int i = 0; i < listaNumeros.size() - numerosSorteados.length + 1; i++) {
            boolean sequenciaEncontrada = true;
            for (int j = 0; j < numerosSorteados.length; j++) {
                if (listaNumeros.get(i + j) != numerosSorteados[j]) {
                    sequenciaEncontrada = false;
                    break;
                }
            }
            if (sequenciaEncontrada) {
                posicao = i;
                sequenciasEncontradas++;
                System.out.println("Sequência encontrada na posição " + posicao);
            }
        }

        System.out.println("Quantidade de sequências encontradas: " + sequenciasEncontradas);

        // Percorrendo a lista em ordem inversa
        posicao = -1;
        sequenciasEncontradas = 0;
        for (int i = listaNumeros.size() - 1; i >= numerosSorteados.length - 1; i--) {
            boolean sequenciaEncontrada = true;
            for (int j = numerosSorteados.length - 1, k = 0; j >= 0; j--, k++) {
                if (listaNumeros.get(i - k) != numerosSorteados[j]) {
                    sequenciaEncontrada = false;
                    break;
                }
            }
            if (sequenciaEncontrada) {
                posicao = i - numerosSorteados.length + 1;
                sequenciasEncontradas++;
                System.out.println("Sequência encontrada na posição " + posicao);
            }
        }

        System.out.println("Quantidade de sequências encontradas: " + sequenciasEncontradas);
    }

    private static List<Integer> gerarNumerosAleatorios(int quantidade) {
        Random random = new Random();
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            numeros.add(random.nextInt(60) + 1);
        }

        return numeros;
    }
}
