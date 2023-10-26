/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPesquisa;

import bean.TkslVendas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendaControle extends AbstractTableModel {

    private List lista = new ArrayList();

    public void setList(List lista) {
        this.lista = lista;
    }

    /*public TkslVendas getVenda(int row) {
        return (TkslVendas) lista.get(row);
    }*/
    public TkslVendas getVenda(int row) {
            return (TkslVendas) lista.get(row);
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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TkslVendas TkslVenda = (TkslVendas) lista.get(rowIndex);
        if (columnIndex == 0) {
            return TkslVenda.getTkslIdVendas();
        }
        if (columnIndex == 1) {
            return TkslVenda.getTkslData();
        }
        if (columnIndex == 2) {
            return TkslVenda.getTkslCliente();
        }
        if (columnIndex == 3) {
            return TkslVenda.getTkslVendedor();
        }
        if (columnIndex == 4) {
            return TkslVenda.getTkslTotal();
        }

        return "";
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Data";
            case 2:
                return "Cliente";
            case 3:
                return "Funcionário";
            case 4:
                return "Total";
        }
        return "";
    }

}
