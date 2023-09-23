package bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tksl_cliente",
         catalog = "db_tifany_lubacheski"
)
public class TkslCliente implements java.io.Serializable {

    private int tkslIdCliente;
    private String tkslNomeCompleto;
    private String tkslNomeFantasia;
    private String tkslSexo;
    private Date tkslDataNascimento;
    private String tkslNumeroFone;
    private String tkslNacionalidade;
    private String tkslRg;
    private String tkslCpf;
    private String tkslEmail;
    private String tkslCargo;
    private String tkslCep;
    private String tkslLogradouro;
    private String tkslPais;
    private String tkslEstadoUf;
    private String tkslCidade;
    private String tkslBairro;

    public TkslCliente() {
    }

    public TkslCliente(int tkslIdCliente) {
        this.tkslIdCliente = tkslIdCliente;
    }

    public TkslCliente(int tkslIdCliente, String tkslNomeCompleto, String tkslNomeFantasia, String tkslSexo, Date tkslDataNascimento, String tkslNumeroFone, String tkslNacionalidade, String tkslRg, String tkslCpf, String tkslEmail, String tkslCargo, String tkslCep, String tkslLogradouro, String tkslPais, String tkslEstadoUf, String tkslCidade, String tkslBairro) {
        this.tkslIdCliente = tkslIdCliente;
        this.tkslNomeCompleto = tkslNomeCompleto;
        this.tkslNomeFantasia = tkslNomeFantasia;
        this.tkslSexo = tkslSexo;
        this.tkslDataNascimento = tkslDataNascimento;
        this.tkslNumeroFone = tkslNumeroFone;
        this.tkslNacionalidade = tkslNacionalidade;
        this.tkslRg = tkslRg;
        this.tkslCpf = tkslCpf;
        this.tkslEmail = tkslEmail;
        this.tkslCargo = tkslCargo;
        this.tkslCep = tkslCep;
        this.tkslLogradouro = tkslLogradouro;
        this.tkslPais = tkslPais;
        this.tkslEstadoUf = tkslEstadoUf;
        this.tkslCidade = tkslCidade;
        this.tkslBairro = tkslBairro;
    }

    @Id

    @Column(name = "tksl_idCliente", unique = true, nullable = false)
    public int getTkslIdCliente() {
        return this.tkslIdCliente;
    }

    public void setTkslIdCliente(int tkslIdCliente) {
        this.tkslIdCliente = tkslIdCliente;
    }

    @Column(name = "tksl_nomeCompleto", length = 60)
    public String getTkslNomeCompleto() {
        return this.tkslNomeCompleto;
    }

    public void setTkslNomeCompleto(String tkslNomeCompleto) {
        this.tkslNomeCompleto = tkslNomeCompleto;
    }

    @Column(name = "tksl_nomeFantasia", length = 50)
    public String getTkslNomeFantasia() {
        return this.tkslNomeFantasia;
    }

    public void setTkslNomeFantasia(String tkslNomeFantasia) {
        this.tkslNomeFantasia = tkslNomeFantasia;
    }

    @Column(name = "tksl_sexo", length = 10)
    public String getTkslSexo() {
        return this.tkslSexo;
    }

    public void setTkslSexo(String tkslSexo) {
        this.tkslSexo = tkslSexo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tksl_dataNascimento", length = 10)
    public Date getTkslDataNascimento() {
        return this.tkslDataNascimento;
    }

    public void setTkslDataNascimento(Date tkslDataNascimento) {
        this.tkslDataNascimento = tkslDataNascimento;
    }

    @Column(name = "tksl_numeroFone", length = 15)
    public String getTkslNumeroFone() {
        return this.tkslNumeroFone;
    }

    public void setTkslNumeroFone(String tkslNumeroFone) {
        this.tkslNumeroFone = tkslNumeroFone;
    }

    @Column(name = "tksl_nacionalidade", length = 50)
    public String getTkslNacionalidade() {
        return this.tkslNacionalidade;
    }

    public void setTkslNacionalidade(String tkslNacionalidade) {
        this.tkslNacionalidade = tkslNacionalidade;
    }

    @Column(name = "tksl_rg", length = 9)
    public String getTkslRg() {
        return this.tkslRg;
    }

    public void setTkslRg(String tkslRg) {
        this.tkslRg = tkslRg;
    }

    @Column(name = "tksl_cpf", length = 14)
    public String getTkslCpf() {
        return this.tkslCpf;
    }

    public void setTkslCpf(String tkslCpf) {
        this.tkslCpf = tkslCpf;
    }

    @Column(name = "tksl_email", length = 80)
    public String getTkslEmail() {
        return this.tkslEmail;
    }

    public void setTkslEmail(String tkslEmail) {
        this.tkslEmail = tkslEmail;
    }

    @Column(name = "tksl_cargo", length = 50)
    public String getTkslCargo() {
        return this.tkslCargo;
    }

    public void setTkslCargo(String tkslCargo) {
        this.tkslCargo = tkslCargo;
    }

    @Column(name = "tksl_cep", length = 9)
    public String getTkslCep() {
        return this.tkslCep;
    }

    public void setTkslCep(String tkslCep) {
        this.tkslCep = tkslCep;
    }

    @Column(name = "tksl_logradouro", length = 50)
    public String getTkslLogradouro() {
        return this.tkslLogradouro;
    }

    public void setTkslLogradouro(String tkslLogradouro) {
        this.tkslLogradouro = tkslLogradouro;
    }

    @Column(name = "tksl_pais", length = 30)
    public String getTkslPais() {
        return this.tkslPais;
    }

    public void setTkslPais(String tkslPais) {
        this.tkslPais = tkslPais;
    }

    @Column(name = "tksl_estadoUf", length = 2)
    public String getTkslEstadoUf() {
        return this.tkslEstadoUf;
    }

    public void setTkslEstadoUf(String tkslEstadoUf) {
        this.tkslEstadoUf = tkslEstadoUf;
    }

    @Column(name = "tksl_cidade", length = 50)
    public String getTkslCidade() {
        return this.tkslCidade;
    }

    public void setTkslCidade(String tkslCidade) {
        this.tkslCidade = tkslCidade;
    }

    @Column(name = "tksl_bairro", length = 50)
    public String getTkslBairro() {
        return this.tkslBairro;
    }

    public void setTkslBairro(String tkslBairro) {
        this.tkslBairro = tkslBairro;
    }
    public String toString(){
        return getTkslNomeCompleto();
    }

}
