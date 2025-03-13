import java.util.Random;

public class Teste {

    public static void main(String[] args) {

        int[] vetor = new int[10];
        carrega(vetor);
        exibi(vetor);

    }

    public static void carrega(int[] vetor){
        Random r = new Random();
        for(int i=0; i<vetor.length;i++){
            vetor[i]= r.nextInt(0,100);
        }
    }

    public static void exibi(int[] vetor){
//        for (int i = 0; i < vetor.length; i++) {
//            System.out.println((i+1)+"°- "+vetor[i]);
//        }

        for(int i : vetor){
            System.out.println(i);
        }
    }

}
