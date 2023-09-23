/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPesquisa;

import bean.TkslCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteControle extends AbstractTableModel {

    private List lista = new ArrayList();

    public void setList(List lista) {
        this.lista = lista;
    }

    public TkslCliente getTkslCliente(int row) {
        return (TkslCliente) lista.get(row);
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
        TkslCliente TkslCliente = (TkslCliente) lista.get(rowIndex);
        if (columnIndex == 0) {
            return TkslCliente.getTkslIdCliente();
        }
        if (columnIndex == 1) {
            return TkslCliente.getTkslNomeCompleto();
        }
        if (columnIndex == 2) {
            return TkslCliente.getTkslCargo();
        }

        return null;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nome";
            case 2:
                return "Cargo";
        }
        return null;
    }

}
