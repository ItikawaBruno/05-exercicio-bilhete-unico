import java.util.Random;

public class BilheteUnico {
    private double saldo;
    private long id;
    private Usuario usuario;
    private static final double TARIFA= 5.20;



    public BilheteUnico(String nome, long cpf, String perfil) {
        usuario = new Usuario(nome, cpf, perfil);
        Random random = new Random();
        id= random.nextLong(1000,10000);
    }

    public double recarga(double valor){
        return this.saldo+=valor;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public double verificaPerfil(){
        double valorPagar = TARIFA;
        if(usuario.getPerfil().equalsIgnoreCase("professor")){
            return valorPagar/2;
        }else if(usuario.getPerfil().equalsIgnoreCase("estudante")){
            return  valorPagar/2;
        }
        return valorPagar;
    }

    public void passarNaCatraca(){
        if(saldo>=this.verificaPerfil()) {
            this.saldo -= this.verificaPerfil();
            System.out.println("Catraca liberada!");
        }else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public String toString(){
        return "Nome: "+ usuario.getNome()+" Saldo: "+this.saldo;
    }

}
