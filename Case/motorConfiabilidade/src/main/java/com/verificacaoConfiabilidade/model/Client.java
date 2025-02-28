package com.verificacaoConfiabilidade.model;

public class Client {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String email;
    private String nomeMae;
    private String cep;
    private String endereco;
    private String numero;

   
    public Client() {
    }

    public Client(String nome, String cpf, String dataNascimento, String telefone, 
                  String email, String nomeMae, String cep, String endereco, String numero) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.nomeMae = nomeMae;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNomeMae() { return nomeMae; }
    public void setNomeMae(String nomeMae) { this.nomeMae = nomeMae; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
}
