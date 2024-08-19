package anotacao.domain;

public class Nota {
    private int idNota;
    private String tituloNota;
    private String conteudoNota;

    public Nota(int idNota, String tituloNota, String conteudoNota) {
        this.idNota = idNota;
        this.tituloNota = tituloNota;
        this.conteudoNota = conteudoNota;
    }

    public void imprimirNota() {
        System.out.println("--------------------------------------------------");
        System.out.print("[ID: " + this.idNota + "] ");
        System.out.println("Titulo: " + this.tituloNota);
        System.out.println(this.conteudoNota);
        System.out.println("--------------------------------------------------");
    }

    public int getIdNota() {
        return idNota;
    }

    public String getTituloNota() {
        return tituloNota;
    }

    public String getConteudoNota() {
        return conteudoNota;
    }

}
