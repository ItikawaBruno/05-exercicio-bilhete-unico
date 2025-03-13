import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner e = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = e.next();
        System.out.print("Digite seu CPF: ");
        long cpf = e.nextLong();
        System.out.print("Digite seu perfil: ");
        String perfil = e.next();
        Usuario u = new Usuario(nome,cpf,perfil);
        BilheteUnico b= new BilheteUnico(nome,cpf,perfil);



        char resp = 'S';
        while(resp == 'S'){
            System.out.println("-------- MENU --------");
            System.out.println("1- Recarga.\n"+
                                "2- Verificar o saldo.\n"+
                                "3- Passar na catraca.");

            System.out.println("Digite a opção:");
            int opcao = e.nextInt();
            if(opcao == 1){
                System.out.print("Digite o valor que deseja recarregar: ");
                double valor = e.nextDouble();
                b.recarga(valor);
            }else if(opcao == 2){
                System.out.println("Saldo atual - "+b.getSaldo());
            }else {
                b.verificaPerfil();
                b.passarNaCatraca();
            }

            System.out.println("Deseja continuar?");
            resp = e.next().toUpperCase().charAt(0);

        }

        System.out.println(b.toString());
    }
}
