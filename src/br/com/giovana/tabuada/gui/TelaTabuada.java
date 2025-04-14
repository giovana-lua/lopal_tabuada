package br.com.giovana.tabuada.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.com.giovana.tabuada.model.Tabuada;

public class TelaTabuada {

	private JLabel labelMultiplicando;
	private JTextField txtmultiplicando;
	private JLabel labelMinMultiplicador;
	private JTextField txtMinMultiplicador;
	private JLabel labelMaxMultiplicador;
	private JTextField txtMaxMultiplicador;
	private JButton btnCalcular;
	private JButton btnLimpar;
	private JLabel labelResultado;
	private JScrollPane scrollTabuada;
	private JList<String> listaTabuada;

	private Font labels = new Font("Arial", Font.BOLD, 13);
	private Color labelsColor = new Color(178, 23, 241);
	
	public void criarTela() {

		JFrame tela = new JFrame();

		// definir o tamanho da tela
		// através de um objeto Dimension
		Dimension tamanho = new Dimension();
		tamanho.setSize(335, 700);
		tela.setSize(tamanho);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Tabuada");
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);

		// criar um JLabel e um JtextField para o Multiplicando
		labelMultiplicando = new JLabel();
		labelMultiplicando.setFont(labels);
		labelMultiplicando.setForeground(labelsColor);
		labelMultiplicando.setText("Valor do multiplicando:");
		labelMultiplicando.setBounds(50, 40, 150, 30);

		txtmultiplicando = new JTextField();
		txtmultiplicando.setHorizontalAlignment(JTextField.RIGHT);
		txtmultiplicando.setBounds(210, 40, 60, 30);

		// criar um JLabel e um JtextField para o Mínimo Multiplicador
		labelMinMultiplicador = new JLabel();
		labelMinMultiplicador.setText("Mínimo Multiplicador:");
		labelMinMultiplicador.setBounds(50, 80, 150, 30);

		txtMinMultiplicador = new JTextField();
		txtMinMultiplicador.setHorizontalAlignment(JTextField.RIGHT);
		txtMinMultiplicador.setBounds(210, 80, 60, 30);

		// criar um JLabel e um JtextField para o Máximo multiplicador
		labelMaxMultiplicador = new JLabel();
		labelMaxMultiplicador.setText("Máximo Multiplicador:");
		labelMaxMultiplicador.setBounds(50, 120, 150, 30);

		txtMaxMultiplicador = new JTextField();
		txtMaxMultiplicador.setHorizontalAlignment(JTextField.RIGHT);
		txtMaxMultiplicador.setBounds(210, 120, 60, 30);

		// Criando botões da tela
		btnCalcular = new JButton();
		btnCalcular.setText("Calcular");
		btnCalcular.setFont(labels);
		btnCalcular.setForeground(labelsColor);
		btnCalcular.setBounds(50, 160, 105, 30);

		btnLimpar = new JButton();
		btnLimpar.setText("Limpar");
		btnLimpar.setBounds(165, 160, 105, 30);

		// Label do resultado
		labelResultado = new JLabel();
		labelResultado.setText("Resultado:");
		labelResultado.setBounds(50, 200, 200, 30);
		
		// Criando a lista que exibirá a tabuada
		listaTabuada = new JList();
		
		
		// Criando o painel de rolagem para a lista
		scrollTabuada = new JScrollPane(listaTabuada);
		scrollTabuada.setBounds(50, 240, 220, 380);

		//scrollTabuada.add(listaTabuada);

		// Adicionando os componentes ao painel de conteúdo
		tela.getContentPane().add(labelMultiplicando);
		tela.getContentPane().add(txtmultiplicando);
		tela.getContentPane().add(labelMinMultiplicador);
		tela.getContentPane().add(txtMinMultiplicador);
		tela.getContentPane().add(labelMaxMultiplicador);
		tela.getContentPane().add(txtMaxMultiplicador);
		tela.getContentPane().add(btnCalcular);
		tela.getContentPane().add(btnLimpar);
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(scrollTabuada);

		// Adicionar um ouvinte de ação (Listener) ao botão calcular
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent  e) {
				// TODO Auto-generated method stub
			
				Tabuada tabuada = new Tabuada();
				
				double multiplicando = Double.parseDouble(txtmultiplicando.getText());
				double minMultiplicador = Double.parseDouble(txtMinMultiplicador.getText());
				double maxMultiplicador = Double.parseDouble(txtMaxMultiplicador.getText());
				
				tabuada.setMultiplicando(multiplicando);
				tabuada.setMenorMultiplicador(minMultiplicador);
				tabuada.setMaiorMultiplicador(maxMultiplicador);
				
				String[] resultado = tabuada.exibirTabuada();
				
				listaTabuada.setListData(resultado);
		
				
				
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				txtmultiplicando.setText(null);
				txtMaxMultiplicador.setText(null);
				txtMinMultiplicador.setText(null);
				txtmultiplicando.requestFocus();
				listaTabuada.setListData(new String [0]);
				
				
				
			}
		});
		
		
		
		
		
		// Tornar a tela vísivel deverá ser a última linha deste método
		tela.setVisible(true);

	}
}
