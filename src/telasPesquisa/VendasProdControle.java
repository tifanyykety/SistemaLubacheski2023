package telasPesquisa;

import bean.TkslVendasproduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendasProdControle extends AbstractTableModel {

    List lstVendasProduto;

    public void setList(List lstVendasProduto) {
        this.lstVendasProduto = lstVendasProduto;
        this.fireTableDataChanged();
    }

    public void addList(TkslVendasproduto vendasProduto) {
        lstVendasProduto.add(vendasProduto);
        this.fireTableDataChanged();

    }

    public void updateBean(int index, TkslVendasproduto vendasProduto) {
        lstVendasProduto.set(index, vendasProduto);
        this.fireTableDataChanged();
    }

    public void limparTabela() {
        lstVendasProduto.clear();
        this.fireTableDataChanged();
    }

    public void removeList(int linha) {
        if (lstVendasProduto != null && linha >= 0 && linha < lstVendasProduto.size()) {
            lstVendasProduto.remove(linha);
            this.fireTableDataChanged();
        } else {
            System.out.println("Índice inválido ou lista não inicializada corretamente.");
        }
    }

    public TkslVendasproduto getBean(int row) {
        return (TkslVendasproduto) lstVendasProduto.get(row);
    }

    @Override
    public int getRowCount() {
        return lstVendasProduto.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TkslVendasproduto vendasProduto = (TkslVendasproduto) lstVendasProduto.get(rowIndex);
        if (columnIndex == 0) {
            return vendasProduto.getTkslProduto().getTkslNome();
        }
        if (columnIndex == 1) {
            return vendasProduto.getTkslQuantidade();
        }
        if (columnIndex == 2) {
            return vendasProduto.getTkslValorUnitario();
        }
        if (columnIndex == 3) {
            return vendasProduto.getTkslTotal();

        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Nome Produto";
        }
        if (columnIndex == 1) {
            return "Quantidade";
        }
        if (columnIndex == 2) {
            return "Valor Unitario";
        }
        if (columnIndex == 3) {
            return "total";
        }
        return "";
    }

}
