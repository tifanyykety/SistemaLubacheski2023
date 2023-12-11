package telasPesquisa;

import bean.TkslVendasproduto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendasProdControle extends AbstractTableModel {

    List lstVendasProduto;
  

    public VendasProdControle() {
        lstVendasProduto = new ArrayList<>();
    }

    public void setList(List lstVendasProduto) {
        this.lstVendasProduto = lstVendasProduto;
        this.fireTableDataChanged();
    }

    public void addList(TkslVendasproduto vendasProduto) {
        lstVendasProduto.add(vendasProduto);
        this.fireTableDataChanged();
    }

    public void removeList(int linha) {
        lstVendasProduto.remove(linha);
        this.fireTableDataChanged();

    }
    public TkslVendasproduto getBean(int row){
        return (TkslVendasproduto) lstVendasProduto.get(row);
    }

    @Override
    public int getRowCount() {
        return lstVendasProduto.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TkslVendasproduto vendasProduto = (TkslVendasproduto) lstVendasProduto.get(rowIndex);
        if (columnIndex == 0) {
            return vendasProduto.getTkslIdVendasProduto();
        }
        if (columnIndex == 1) {
            return vendasProduto.getTkslVendas().getTkslIdVendas();
        }
        if (columnIndex == 2) {
            return vendasProduto.getTkslQuantidade();
        }
        if (columnIndex == 3) {
            return vendasProduto.getTkslValorUnitario();
        }
        if (columnIndex == 4) {
            return vendasProduto.getTkslQuantidade() * vendasProduto.getTkslValorUnitario();
            
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Venda";
        }
        if (columnIndex == 1) {
            return "Produto";
        }
        if (columnIndex == 2) {
            return "Quantidade";
        }
        if (columnIndex == 3) {
            return "Valor Unitario";
        }
        if (columnIndex == 4) {
            return "total";
        }
        return "";
    }


}
