package br.edu.fateczl.time.model;
/*
 *@author:<Gustavo de Paula>
 */
public class Time {
    private int codigo;
    private String nome;
    private String cidade;

    public Time() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  codigo + " - " + nome + " " + cidade;
    }
}
