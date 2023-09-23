package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tksl_vendasproduto",
         catalog = "db_tifany_lubacheski"
)
public class TkslVendasproduto implements java.io.Serializable {

    private int tkslIdVendasProduto;
    private TkslVendas tkslVendas;
    private int tkslQuantidade;
    private double tkslValorUnitario;
    private double tkslTotal;

    public TkslVendasproduto() {
    }

    public TkslVendasproduto(TkslVendas tkslVendas) {
        this.tkslVendas = tkslVendas;
    }

    public TkslVendasproduto(TkslVendas tkslVendas, int tkslQuantidade, double tkslValorUnitario, double tkslTotal) {
        this.tkslVendas = tkslVendas;
        this.tkslQuantidade = tkslQuantidade;
        this.tkslValorUnitario = tkslValorUnitario;
        this.tkslTotal = tkslTotal;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "tksl_idVendasProduto", unique = true, nullable = false)
    public int getTkslIdVendasProduto() {
        return this.tkslIdVendasProduto;
    }

    public void setTkslIdVendasProduto(int tkslIdVendasProduto) {
        this.tkslIdVendasProduto = tkslIdVendasProduto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tksl_fk_venda", nullable = false)
    public TkslVendas getTkslVendas() {
        return this.tkslVendas;
    }

    public void setTkslVendas(TkslVendas tkslVendas) {
        this.tkslVendas = tkslVendas;
    }

    @Column(name = "tksl_quantidade")
    public int getTkslQuantidade() {
        return this.tkslQuantidade;
    }

    public void setTkslQuantidade(int tkslQuantidade) {
        this.tkslQuantidade = tkslQuantidade;
    }

    @Column(name = "tksl_valorUnitario", precision = 10)
    public double getTkslValorUnitario() {
        return this.tkslValorUnitario;
    }

    public void setTkslValorUnitario(double tkslValorUnitario) {
        this.tkslValorUnitario = tkslValorUnitario;
    }

    @Column(name = "tksl_total", precision = 10)
    public double getTkslTotal() {
        return this.tkslTotal;
    }

    public void setTkslTotal(double tkslTotal) {
        this.tkslTotal = tkslTotal;
    }

}
