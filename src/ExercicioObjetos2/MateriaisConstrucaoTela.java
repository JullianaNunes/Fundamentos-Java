package ExercicioObjetos2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.senai.sp.informatica.lib.SwUtil;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.util.Comparator;

@SuppressWarnings({ "serial" })
public class MateriaisConstrucaoTela extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNome;
	private JLabel lblDescrio;
	private JLabel lblDataDeValidade;
	private JLabel lblTipoDeProduto;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JButton btnSalvar;
	private JButton btnSair;
	private JComboBox<Produto>comboBox;
	
	private List<MaterialConstrucao> lista = new ArrayList<>();
	private JButton btnPorNome;
	private JButton btnPorTipo;
	private JFormattedTextField TxtData;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MateriaisConstrucaoTela frame = new MateriaisConstrucaoTela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MateriaisConstrucaoTela() {
		setResizable(false);
		setTitle("Loja de materiais de constru\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNome = new JLabel("Nome:");
		
		lblDescrio = new JLabel("Descrição");
		
		lblDataDeValidade = new JLabel("Data de validade");
		
		lblTipoDeProduto = new JLabel("Tipo de Produto");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		
		TxtData = new JFormattedTextField(SwUtil.criaMascara("##/##/####"));
		TxtData.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		btnPorNome = new JButton("Listar por nome");
		btnPorNome.addActionListener(this);
		
		btnPorTipo = new JButton("Listar por tipo");
		btnPorTipo.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<Produto>(Produto.values()));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPorNome)
							.addGap(10)
							.addComponent(btnPorTipo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblDataDeValidade, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(TxtData, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addGap(12)
								.addComponent(lblTipoDeProduto, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox, 0, 151, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(18)
										.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(18)
										.addComponent(txtDescricao, 359, 359, 359))))))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescrio)
						.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeValidade)
						.addComponent(lblTipoDeProduto)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TxtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPorNome)
						.addComponent(btnPorTipo)
						.addComponent(btnSair)
						.addComponent(btnSalvar))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void actionPerformed(ActionEvent evento) {
			Object botao = evento.getSource();
			
			if(botao.equals(btnSalvar)) {
				try {
					MaterialConstrucao obj = new MaterialConstrucao(null, null, null, null);
					obj.setNome(txtNome.getText());
					obj.setDescricao(txtDescricao.getText());
					obj.setProdutos((Produto)comboBox.getSelectedItem());
					
					
					String data = TxtData.getText();
					LocalDate validade = LocalDate.parse(data, 
							DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR")));
					obj.setValidade(validade);
					
					lista.add(obj);
					
					SwUtil.limpa(this);
					txtNome.requestFocus();
				
					
				} catch (DateTimeParseException ex) {
					JOptionPane.showMessageDialog(this, "Data invalida");
				}
			
			} else if(botao.equals(btnPorNome)){
				Collections.sort(lista,Comparator.comparing(MaterialConstrucao::getNome));	
				String msg = "Lista de produtos por nome\n\n";
				for (MaterialConstrucao materiaispornome : lista) {
					msg += materiaispornome + "\n";
					
				}
				JOptionPane.showMessageDialog(this, msg);
				
			} else if(botao.equals(btnPorTipo)){
				Collections.sort(lista,Comparator.comparing(MaterialConstrucao::getProdutos));	

				String msg1 = "Lista de produtos por tipo\n\n";
				for (MaterialConstrucao materiaisportipo : lista) {
					msg1 += materiaisportipo + "\n";
				} 
				JOptionPane.showMessageDialog(this, msg1);
			   } else {
				System.exit(0);
				}
			}
	}

