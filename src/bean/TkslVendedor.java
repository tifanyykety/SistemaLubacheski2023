package bean;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tksl_vendedor",
        catalog = "db_tifany_lubacheski"
)
public class TkslVendedor implements java.io.Serializable {

    private int tkslIdVendedor;
    private String tkslNome;
    private String tkslSenha;
    private String tkslNivel;
    private String tkslAtivo;

    public TkslVendedor() {
    }

    public TkslVendedor(int tkslIdVendedor) {
        this.tkslIdVendedor = tkslIdVendedor;
    }

    public TkslVendedor(int tkslIdVendedor, String tkslNome, String tkslSenha, String tkslNivel, String tkslAtivo, Set tkslVendases) {
        this.tkslIdVendedor = tkslIdVendedor;
        this.tkslNome = tkslNome;
        this.tkslSenha = tkslSenha;
        this.tkslNivel = tkslNivel;
        this.tkslAtivo = tkslAtivo;
    }

    @Id

    @Column(name = "tksl_idVendedor", unique = true, nullable = false)
    public int getTkslIdVendedor() {
        return this.tkslIdVendedor;
    }

    public void setTkslIdVendedor(int tkslIdVendedor) {
        this.tkslIdVendedor = tkslIdVendedor;
    }

    @Column(name = "tksl_nome", length = 60)
    public String getTkslNome() {
        return this.tkslNome;
    }

    public void setTkslNome(String tkslNome) {
        this.tkslNome = tkslNome;
    }

    @Column(name = "tksl_senha", length = 25)
    public String getTkslSenha() {
        return this.tkslSenha;
    }

    public void setTkslSenha(String tkslSenha) {
        this.tkslSenha = tkslSenha;
    }

    @Column(name = "tksl_nivel", length = 20)
    public String getTkslNivel() {
        return this.tkslNivel;
    }

    public void setTkslNivel(String tkslNivel) {
        this.tkslNivel = tkslNivel;
    }

    @Column(name = "tksl_ativo", length = 3)
    public String getTkslAtivo() {
        return this.tkslAtivo;
    }

    public void setTkslAtivo(String tkslAtivo) {
        this.tkslAtivo = tkslAtivo;
    }

    @Override
    public String toString() {
        return getTkslIdVendedor() + " - " + getTkslNome();
    }

}
