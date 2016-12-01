package br.edu.unirg.vendafx.bean;

/**
 *
 * @author Rogério M. de Queiroz <rogerio.mq@gmail.com>
 */
public class Cliente {
    private Integer idCliente;
    private String nome;
    private String cpf;
    private String telefone;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + '}';
    }
    
}