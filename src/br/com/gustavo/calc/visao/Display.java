package br.com.gustavo.calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.gustavo.calc.modelo.Memoria;
import br.com.gustavo.calc.modelo.MemoriaObserver;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObserver{

	private JLabel label;
	
	public Display() {
		
		Memoria.getInstancia().adicionarObserver(this);		
		
		setBackground(new Color(46, 49,50));
		label = new JLabel(Memoria.getInstancia().getTextoAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 45));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 25));
		
		add(label);
	}
	
	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
	}
}
