package bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tksl_produto",
        catalog = "db_tifany_lubacheski"
)
public class TkslProduto implements java.io.Serializable {

    private int tkslIdProduto;
    private String tkslTime;
    private String tkslCor;
    private String tkslTamanho;
    private Date tkslModeloAno;
    private String tkslNumero;
    private String tkslNome;
    private double tkslValorUnitario;

    public TkslProduto() {
    }

    public TkslProduto(int tkslIdProduto, Date tkslModeloAno) {
        this.tkslIdProduto = tkslIdProduto;
        this.tkslModeloAno = tkslModeloAno;
    }

    public TkslProduto(int tkslIdProduto, String tkslTime, String tkslCor, String tkslTamanho, Date tkslModeloAno, String tkslNumero, String tkslNome, double tkslValorUnitario) {
        this.tkslIdProduto = tkslIdProduto;
        this.tkslTime = tkslTime;
        this.tkslCor = tkslCor;
        this.tkslTamanho = tkslTamanho;
        this.tkslModeloAno = tkslModeloAno;
        this.tkslNumero = tkslNumero;
        this.tkslNome = tkslNome;
        this.tkslValorUnitario = tkslValorUnitario;
    }

    @Id

    @Column(name = "tksl_idProduto", unique = true, nullable = false)
    public int getTkslIdProduto() {
        return this.tkslIdProduto;
    }

    public void setTkslIdProduto(int tkslIdProduto) {
        this.tkslIdProduto = tkslIdProduto;
    }

    @Column(name = "tksl_time", length = 45)
    public String getTkslTime() {
        return this.tkslTime;
    }

    public void setTkslTime(String tkslTime) {
        this.tkslTime = tkslTime;
    }

    @Column(name = "tksl_cor", length = 20)
    public String getTkslCor() {
        return this.tkslCor;
    }

    public void setTkslCor(String tkslCor) {
        this.tkslCor = tkslCor;
    }

    @Column(name = "tksl_tamanho", length = 3)
    public String getTkslTamanho() {
        return this.tkslTamanho;
    }

    public void setTkslTamanho(String tkslTamanho) {
        this.tkslTamanho = tkslTamanho;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tksl_modeloAno", nullable = false, length = 10)
    public Date getTkslModeloAno() {
        return this.tkslModeloAno;
    }

    public void setTkslModeloAno(Date tkslModeloAno) {
        this.tkslModeloAno = tkslModeloAno;
    }

    @Column(name = "tksl_numero", length = 2)
    public String getTkslNumero() {
        return this.tkslNumero;
    }

    public void setTkslNumero(String tkslNumero) {
        this.tkslNumero = tkslNumero;
    }

    @Column(name = "tksl_nome", length = 15)
    public String getTkslNome() {
        return this.tkslNome;
    }

    public void setTkslNome(String tkslNome) {
        this.tkslNome = tkslNome;
    }

    @Column(name = "tksl_valorUnitario", precision = 10)
    public double getTkslValorUnitario() {
        return this.tkslValorUnitario;
    }

    public void setTkslValorUnitario(double tkslValorUnitario) {
        this.tkslValorUnitario = tkslValorUnitario;
    }

    @Override
    public String toString() {
        return getTkslIdProduto() + " - " + getTkslNome();
    }

}
