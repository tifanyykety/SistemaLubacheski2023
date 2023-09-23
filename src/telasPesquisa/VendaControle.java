/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPesquisa;

import bean.TkslVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendaControle extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    /*public TkslVendas getVenda(int row) {
        return (TkslVendas) lista.get(row);
    }*/
    public TkslVendas getVenda(int row) {
        if (lista != null && row >= 0 && row < lista.size()) {
            return (TkslVendas) lista.get(row);
        }
        return null;
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
        TkslVendas Venda = (TkslVendas) lista.get(rowIndex);
        if (columnIndex == 0) {
            return Venda.getTkslIdVendas();
        }
        if (columnIndex == 1) {
            return Venda.getTkslVendedor().getTkslNome();
        }
        if (columnIndex == 2) {
            return Venda.getTkslTotal();
        }

        return "";
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Funcionario";
            case 2:
                return "Total";
        }
        return "";
    }

}
