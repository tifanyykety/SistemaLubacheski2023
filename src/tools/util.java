/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author ""
 */
public class util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
        }
    }

    //Serve para limpar os textos escritos nas telas
    public static void limparCampos(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {

            if (componentes[i] instanceof JTextField) {
                JTextField comp = (JTextField) componentes[i];
                comp.setText("");
            }
            if (componentes[i] instanceof JComboBox) {
                JComboBox comp = (JComboBox) componentes[i];
                comp.setSelectedIndex(-1);
            }
            if (componentes[i] instanceof JCheckBox) {
                JCheckBox comp = (JCheckBox) componentes[i];
                comp.setSelected(false);
            }
            if (componentes[i] instanceof JPasswordField) {
                JPasswordField comp = (JPasswordField) componentes[i];
                comp.setText("");
            }
            if (componentes[i] instanceof JTextPane) {
                JTextPane comp = (JTextPane) componentes[i];
                comp.setText("");
            }
        }
    }

    public static void mensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static boolean perguntar(String msg) {
        return JOptionPane.showConfirmDialog(null, msg, "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION;
    }

}
