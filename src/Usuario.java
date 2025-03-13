public class Usuario {

    private String nome;
    private long cpf;
    private String perfil;

    public Usuario(String nome, long cpf, String perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfil=perfil;
    }


    public String getPerfil() {
        return perfil;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }
}
