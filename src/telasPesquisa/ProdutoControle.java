/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPesquisa;

import bean.TkslProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProdutoControle extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public void atualizar() {
        this.fireTableDataChanged();
    }

    public TkslProduto getProduto(int row) {
        return (TkslProduto) lista.get(row);

    }

    public void addList(TkslProduto tkslProduto) {
        lista.add(tkslProduto);
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TkslProduto Produto = (TkslProduto) lista.get(rowIndex);
        if (columnIndex == 0) {
            return Produto.getTkslIdProduto();
        }
        if (columnIndex == 1) {
            return Produto.getTkslNome();
        }
        if (columnIndex == 2) {
            return Produto.getTkslTamanho();
        }
        if (columnIndex == 3) {
            return Produto.getTkslValorUnitario();
        }

        return "";
    }
//ValorUnitario

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nome";
            case 2:
                return "Tamanho";
            case 3:
                return "Valor";
        }
        return "";
    }

}
