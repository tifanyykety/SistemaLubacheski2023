/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPesquisa;

import bean.TkslUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsuarioControle extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public TkslUsuarios getUsuaruio(int row) {
        return (TkslUsuarios) lista.get(row);
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
        TkslUsuarios usuarios = (TkslUsuarios) lista.get(rowIndex);
        if (columnIndex == 0) {
            return usuarios.getTkslIdUsuarios();
        }
        if (columnIndex == 1) {
            return usuarios.getTkslNome();
        }
        if (columnIndex == 2) {
            return usuarios.getTkslApelido();
        }
        if (columnIndex == 3) {
            return usuarios.getTkslCpf();
        }
        if (columnIndex == 4) {
            return usuarios.getTkslNivel();
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
                return "Apelido";
            case 3:
                return "CPF";
            case 4:
                return "Nível";
        }
        return "";
    }

}
