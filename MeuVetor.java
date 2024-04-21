import java.util.Random;

public class MeuVetor {
    private double[] v;
    private int ultimaPos;

    public MeuVetor (int capacidade) {
        v = new double[capacidade];
        ultimaPos = -1;
    }
    //métodos de acesso
    public int getUltimaPos (){
        return ultimaPos;
    } 
    public double[] getV () {
        return v;
    }
    //métodos modificadores
    public void setUltimaPos(int pos) {
        if (pos >=0 && pos < v.length) {
            ultimaPos = pos;
        }
        else {
            ultimaPos = v.length - 1;
        }
    }
    public boolean estaCheio () {
        return ultimaPos == v.length - 1;
    }
    public boolean estaVazio() {
        return ultimaPos == -1;
    }
    private void redimensiona (int novaCapacidade) {
        double[] temp = new double[novaCapacidade];
        for (int i=0; i<=ultimaPos; i++)
            temp[i] = v[i];
        v = temp;
    }
    public void adiciona (double e){
        if (estaCheio()) redimensiona(v.length*2);
        v[++ultimaPos] = e;
    }
    public double remove () {
        if (estaVazio()) return 0;
        double aux = v[ultimaPos--];
        if (v.length>=10 && ultimaPos <= v.length/4) redimensiona(v.length/2);
        return aux;
    }

    @Override
    public String toString () {
        String s = "";
        if (estaVazio()) {
            s = s + "esta vazio";
        }
        else {
            for (int i=0; i<=ultimaPos; i++) {
                s = s + String.format("%.0f ", v[i]);
            }
        }
        return s + "\n";
    }
    public void bubbleSort () {
        //int cont=0;
        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j < v.length - i; j++) {
                //cont++;
                if (v[j] > v[j+1]) {
                    double aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
        //return cont;
    }
    public void preencheVetor () {
        Random r = new Random();
        for (int i=0; i<v.length; i++) {
            //adiciona(Math.random());
            //adiciona(r.nextDouble());
            adiciona(r.nextInt(v.length*10) + 1);
        }
    }
}