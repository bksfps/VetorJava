import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Ordenacao {
    public static void main(String[] args) {
        int[] tamanhos = {1000000, 1200000, 1400000};

        for (int tamanho : tamanhos) {
            try {
                FileWriter writer = new FileWriter("resultados_" + tamanho + ".txt");

                MeuVetor v1;

                for (int teste = 1; teste <= 20; teste++) {
                    v1 = new MeuVetor(tamanho);
                    v1.preencheVetor();

                    long inicio = new Date().getTime();
                    v1.bubbleSort();
                    long fim = new Date().getTime();
                    long tempoBubbleSort = fim - inicio;
                    writer.write("Bubble Sort, Teste " + teste + ", " + tempoBubbleSort + " ms\n");
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
