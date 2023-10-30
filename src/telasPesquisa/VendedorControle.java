/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPesquisa;

import bean.TkslVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendedorControle extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
        this.fireTableDataChanged();
    }

    public void atualizar() {
        this.fireTableDataChanged();
    }

    public TkslVendedor getTkslVendedor(int row) {
        return (TkslVendedor) lista.get(row);

    }

    public void addList(TkslVendedor tkslVendedor) {
        lista.add(tkslVendedor);
        this.fireTableDataChanged();
    }

    public void removeList(int linha) {
        lista.remove(linha);
        this.fireTableDataChanged();

    }

    @Override
    public int getRowCount() {
        if (lista == null) {
            return 0;
        } else {
            return lista.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TkslVendedor TkslVendedor = (TkslVendedor) lista.get(rowIndex);
        if (columnIndex == 0) {
            return TkslVendedor.getTkslIdVendedor();
        }
        if (columnIndex == 1) {
            return TkslVendedor.getTkslNome();
        }
        if (columnIndex == 2) {
            return TkslVendedor.getTkslAtivo();
        }

        return "";
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nome";
            case 2:
                return "Ativo";
        }
        return "";
    }

}
