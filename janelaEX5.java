/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc171.modelo;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author gabriel
 */
public class janelaEX5 extends JFrame{
    private final JLabel valorDolar = new JLabel("Valor USD: ");
    private final JTextField campo1 = new JTextField(10);
    private final JLabel valorCotacao = new JLabel("Cotação BRL/USD: ");
    private final JTextField campo2 = new JTextField(10);
    private final JLabel valorReal = new JLabel("Valor BRL: ");
    private final JTextField campo3 = new JTextField(10);
    private final JCheckBox chktributado = new JCheckBox("Tributado");
    private final JCheckBox chkIcms = new JCheckBox("ICMS");
    private final JCheckBox chkIsento = new JCheckBox("Isento");
    private final JButton  calcular = new JButton("Calcular");
    private float dolar=0, cotacao=0, preco=0;
    
    public janelaEX5() throws HeadlessException{
        super("Preço Final");
         setLayout(new FlowLayout(FlowLayout.LEFT));
         add(valorDolar);
         add(campo1);
         add(valorCotacao);
         add(campo2);
         add(chktributado);
         add(chkIcms);
         add(chkIsento);
         add(calcular);
         add(valorReal);
         add(campo3);
         
      
         
         realizaAcao acao = new realizaAcao();
         chkIcms.addItemListener(acao);
         chktributado.addItemListener(acao);
         chkIsento.addItemListener(acao);
         
         botaoClicado botao = new botaoClicado();
         calcular.addActionListener(botao);
         
    }

    private class realizaAcao implements ItemListener{
    
        @Override
        public void itemStateChanged(ItemEvent e){
            if(chktributado.isSelected()){
                dolar = Float.parseFloat(campo1.getText());
                cotacao = Float.parseFloat(campo2.getText());
                preco = cotacao * dolar;
                preco = (float) (preco * (1.60));
            }if(chkIcms.isSelected()){
                dolar = Float.parseFloat(campo1.getText());
                cotacao = Float.parseFloat(campo2.getText());
                preco = cotacao * dolar;
                preco = (float) (preco * (1.78));
            }if(chkIsento.isSelected()){
                dolar = Float.parseFloat(campo1.getText());
                cotacao = Float.parseFloat(campo2.getText());
                preco = cotacao * dolar;
            }
        }
    }
    
    private class botaoClicado implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           campo3.setText("R$ " + preco);
        }
    }
}
