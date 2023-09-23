package bean;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tksl_vendas",
         catalog = "db_tifany_lubacheski"
)
public class TkslVendas implements java.io.Serializable {

    private int tkslIdVendas;
    private TkslCliente tkslCliente;
    private TkslVendedor tkslVendedor;
    private Date tkslData;
    private double tkslTotal;

    public TkslVendas() {
    }

    public TkslVendas(int tkslIdVendas, TkslCliente tkslCliente, TkslVendedor tkslVendedor) {
        this.tkslIdVendas = tkslIdVendas;
        this.tkslCliente = tkslCliente;
        this.tkslVendedor = tkslVendedor;
    }

    public TkslVendas(int tkslIdVendas, TkslCliente tkslCliente, TkslVendedor tkslVendedor, Date tkslData, double tkslTotal) {
        this.tkslIdVendas = tkslIdVendas;
        this.tkslCliente = tkslCliente;
        this.tkslVendedor = tkslVendedor;
        this.tkslData = tkslData;
        this.tkslTotal = tkslTotal;
    }

    @Id

    @Column(name = "tksl_idVendas", unique = true, nullable = false)
    public int getTkslIdVendas() {
        return this.tkslIdVendas;
    }

    public void setTkslIdVendas(int tkslIdVendas) {
        this.tkslIdVendas = tkslIdVendas;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tksl_fk_cliente", nullable = false)
    public TkslCliente getTkslCliente() {
        return this.tkslCliente;
    }

    public void setTkslCliente(TkslCliente tkslCliente) {
        this.tkslCliente = tkslCliente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tksl_fk_vendedor", nullable = false)
    public TkslVendedor getTkslVendedor() {
        return this.tkslVendedor;
    }

    public void setTkslVendedor(TkslVendedor tkslVendedor) {
        this.tkslVendedor = tkslVendedor;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tksl_data", length = 10)
    public Date getTkslData() {
        return this.tkslData;
    }

    public void setTkslData(Date tkslData) {
        this.tkslData = tkslData;
    }

    @Column(name = "tksl_total", precision = 10)
    public double getTkslTotal() {
        return this.tkslTotal;
    }

    public void setTkslTotal(double tkslTotal) {
        this.tkslTotal = tkslTotal;
    }

}
