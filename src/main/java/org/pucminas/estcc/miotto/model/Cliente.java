package org.pucminas.estcc.miotto.model;



import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@javax.persistence.Table(name="CLIENTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="TYPE",
        discriminatorType = DiscriminatorType.STRING
)
@XmlRootElement
public class Cliente {

    /*
    ** Foi adicionada a coluna ID para identificar o registro unico do Cliente
    ** e nao precisar enviar o Email em todas as requisicoes da API
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(
            name = "pessoa_seq",
            sequenceName = "pessoa_sequence",
            allocationSize = 1
    )
    @Column(name="CLIENTE_ID")
    private long   id;
    @Column (name="NAME", length = 500)
    private String  name;
    @Column (name="CPF", length = 500)
    private String CPF;
    @Column (name="ENDERECO", length = 500)
    private String endereco;
    @Column (name="MUNICIPIO", length = 500)
    private String municipio;
	@Column (name="ESTADO", length = 500)
    private String estado;
    @Column (name="TELEFONE", length = 500)
    private String telefone;
    @Column (name="EMAIL", length = 500, unique = true)
    private String email;
    @Column (name="SENHA", length = 500)
    private String senha;

    public Cliente(){}

    public Cliente(String name, String CPF, String endereco, String municipio, String estado, String telefone) {
        this.name = name;
        this.CPF = CPF;
        this.endereco = endereco;
        this.municipio = municipio;
		this.estado = estado;
        this.telefone = telefone;
    }

    public Cliente(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
	
	public void setEstado(String estado){
		this.estado = estado;
	}
	
	public String getEstado(){
	    return estado;
	}
}
