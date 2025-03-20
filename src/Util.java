import javax.swing.*;

import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Integer.*;

public class Util {

    private BilheteUnico[] listaBilhetes = new BilheteUnico[2];
    private int index = 0;


    public void menuPrincipal(){
        int opcao = 0;
        String menu = "1. Administrador\n2. Usúario\n3. Finalizar";


        do{
            opcao = parseInt(showInputDialog(menu));
            if (opcao == 2){
                carregaUsuario();
            }else if(opcao == 1){
                carregaAdmin();
            }
        }while (opcao != 3);

    }

    private void carregaUsuario(){

        Scanner e = new Scanner(System.in);

        String nome = showInputDialog("Digite seu nome: ");

        long cpf = parseLong(showInputDialog("Digite seu CPF: "));
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



    private void carregaAdmin(){
        int opcao= 0;
        do {
            String menuAdmin = "1. Emitir Bilhete\n2. Listar Bilhetes\n3. Excluir Bilhetes\n4. Sair";

            opcao = Integer.parseInt(showInputDialog(menuAdmin));

            switch (opcao){
                case 1:
                    emitirBilhete();
                    break;
                case 2:
                    listarBilhetes();
                    break;
                case 3:
                    excluirBilhete();
                    break;
            }

        }while(opcao != 4);
        new Util().menuPrincipal();
    }

    private void excluirBilhete() {
        long id=0;
        id = parseLong(showInputDialog("Digite o numero do bilhete que deseja excluir"));
        for (int i = 0; i < index; i++) {
            if(listaBilhetes[i].getId() == id){

            }
        }

    }

    private void listarBilhetes() {
        String aux = "";
        for (int i = 0; i < index; i++) aux+=listaBilhetes[i].toString();

        showMessageDialog(null,aux);
    }


    private void emitirBilhete(){
        if(index < listaBilhetes.length){
            String nome = showInputDialog("Digite o nome do usuário: ");
            long cpf = parseLong(showInputDialog("Digite o CPF do usuário"));
            String perfil = JOptionPane.showInputDialog("Estudante ou Professor ou Comum: ");
            listaBilhetes[index] = new BilheteUnico(nome,cpf,perfil);
            index++;
        }else{
            showMessageDialog(null,"Procure um posto de atendimento.");
        }


    }




}




