package bean;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="tksl_usuarios"
    ,catalog="db_tifany_lubacheski"
)
public class TkslUsuarios  implements java.io.Serializable {


     private int tkslIdUsuarios;
     private String tkslNome;
     private String tkslApelido;
     private String tkslCpf;
     private Date tkslDataNascimento;
     private String tkslSenha;
     private String tkslNivel;
     private String tkslAtivo;

    public TkslUsuarios() {
    }

	
    public TkslUsuarios(int tkslIdUsuarios) {
        this.tkslIdUsuarios = tkslIdUsuarios;
    }
    public TkslUsuarios(int tkslIdUsuarios, String tkslNome, String tkslApelido, String tkslCpf, Date tkslDataNascimento, String tkslSenha, String tkslNivel, String tkslAtivo) {
       this.tkslIdUsuarios = tkslIdUsuarios;
       this.tkslNome = tkslNome;
       this.tkslApelido = tkslApelido;
       this.tkslCpf = tkslCpf;
       this.tkslDataNascimento = tkslDataNascimento;
       this.tkslSenha = tkslSenha;
       this.tkslNivel = tkslNivel;
       this.tkslAtivo = tkslAtivo;
    }
   
     @Id 

    
    @Column(name="tksl_idUsuarios", unique=true, nullable=false)
    public int getTkslIdUsuarios() {
        return this.tkslIdUsuarios;
    }
    
    public void setTkslIdUsuarios(int tkslIdUsuarios) {
        this.tkslIdUsuarios = tkslIdUsuarios;
    }

    
    @Column(name="tksl_nome", length=60)
    public String getTkslNome() {
        return this.tkslNome;
    }
    
    public void setTkslNome(String tkslNome) {
        this.tkslNome = tkslNome;
    }

    
    @Column(name="tksl_apelido", length=25)
    public String getTkslApelido() {
        return this.tkslApelido;
    }
    
    public void setTkslApelido(String tkslApelido) {
        this.tkslApelido = tkslApelido;
    }

    
    @Column(name="tksl_cpf", length=14)
    public String getTkslCpf() {
        return this.tkslCpf;
    }
    
    public void setTkslCpf(String tkslCpf) {
        this.tkslCpf = tkslCpf;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="tksl_dataNascimento", length=10)
    public Date getTkslDataNascimento() {
        return this.tkslDataNascimento;
    }
    
    public void setTkslDataNascimento(Date tkslDataNascimento) {
        this.tkslDataNascimento = tkslDataNascimento;
    }

    
    @Column(name="tksl_senha", length=20)
    public String getTkslSenha() {
        return this.tkslSenha;
    }
    
    public void setTkslSenha(String tkslSenha) {
        this.tkslSenha = tkslSenha;
    }

    
    @Column(name="tksl_nivel", length=15)
    public String getTkslNivel() {
        return this.tkslNivel;
    }
    
    public void setTkslNivel(String tkslNivel) {
        this.tkslNivel = tkslNivel;
    }

    
    @Column(name="tksl_ativo", length=3)
    public String getTkslAtivo() {
        return this.tkslAtivo;
    }
    
    public void setTkslAtivo(String tkslAtivo) {
        this.tkslAtivo = tkslAtivo;
    }




}


