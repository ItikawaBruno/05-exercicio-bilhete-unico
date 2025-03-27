import javax.swing.*;

import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Integer.*;

public class Util {

    Scanner e = new Scanner(System.in);
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

        int opcao = 0;
        while(opcao != 4){
            opcao = parseInt(showInputDialog("1- Recarga.\n"+ "2- Verificar o saldo.\n"+ "3- Passar na catraca."));
            if (opcao < 1 || opcao > 4){
                showMessageDialog(null,"Opção invalida \nDigite a opção de 1 a 4.");
            }else {
                if (opcao == 1) {
                    carregaBilhete();
                } else if (opcao == 2) {
                    consultarSaldo();
                } else if (opcao == 3) {
                    passarNaCatraca();
                }
            }
        }

        listaBilhetes[index].toString();
        menuPrincipal();

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
            }

        }while(opcao != 4);

    }

    private void excluirBilhete() {
        int resposta;
        long cpf = parseLong(showInputDialog("Digite o cpf que deseja excluir"));
        for (int i = 0; i < index; i++) {
            if(listaBilhetes[i].getCpf() == cpf){
                listaBilhetes[i]=listaBilhetes[index];
                resposta = showConfirmDialog(null,"Tem certeza que deseja excluir?");
                if( resposta == YES_OPTION){
                    listaBilhetes[i] = listaBilhetes[index - 1];
                    index --;
                }
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



    private void carregaBilhete(){
        long verifica = parseLong(showInputDialog("Digite seu cpf: "));
        for (int i = 0; i < index; i++) {
            if (listaBilhetes[i].getCpf() == verifica){
                double valor = parseDouble(showInputDialog("Digite o valor do que deseja carregar"));
                listaBilhetes[i].recarga(valor);
            }
        }
    }

    private void consultarSaldo(){
        long verifica = parseLong(showInputDialog("Digite seu cpf: "));
        for (int i = 0; i < index; i++) {
            if (listaBilhetes[i].getCpf() == verifica){
                showMessageDialog(null, "Saldo: " + listaBilhetes[i].getSaldo());
            }
        }

    }

    private void passarNaCatraca(){
        long verifica = parseLong(showInputDialog("Digite seu cpf: "));
        for (int i = 0; i < index; i++) {
            if (listaBilhetes[i].getCpf() == verifica){
                listaBilhetes[i].passarNaCatraca();
            }
        }
    }



}




