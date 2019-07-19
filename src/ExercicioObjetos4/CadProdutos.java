package ExercicioObjetos4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.senai.sp.informatica.lib.SwUtil;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class CadProdutos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblDescricao;
	private JLabel lblValor;
	private JTabbedPane tabbedPane;
	private JPanel pnAlim;
	private JLabel lblValidade;
	private JLabel lblProduto;
	private JPanel pnEletro;
	private JFormattedTextField tfValidade;
	private JFormattedTextField tfProducao;
	private JLabel lblCodForn;
	private JLabel lblNomeForn;
	private JTextField tfCodForn;
	private JTextField tfNomeForn;
	private JTextField tfCod;
	private JTextField tfDesc;
	private JTextField tfValor;
	private JButton btnInserir;
	private JButton btnListar;
	private JButton btnSair;

	private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private List <Produtos> produtos = new ArrayList<>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadProdutos frame = new CadProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadProdutos() {
		setResizable(false);
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblCodigo = new JLabel("C\u00F3digo");
		
		lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		
		lblValor = new JLabel("Valor");
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tfCod = new JTextField();
		tfCod.setColumns(10);
		
		tfDesc = new JTextField();
		tfDesc.setColumns(10);
		
		tfValor = new JTextField();
		tfValor.setColumns(10);
		
		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(this);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(148)
									.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(89)
									.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCodigo, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDescricao, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblValor, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
											.addComponent(tfDesc, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
										.addComponent(tfCod, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(tfCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescricao)
						.addComponent(tfDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnSair)
						.addComponent(btnListar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		pnAlim = new JPanel();
		tabbedPane.addTab("Alimentícios", null, pnAlim, null);
		
		lblValidade = new JLabel("Data de validade");
		tfValidade = new JFormattedTextField(SwUtil.criaMascara("##/##/####"));
		
		lblProduto = new JLabel("Data de produ\u00E7\u00E3o");
		tfProducao = new JFormattedTextField(SwUtil.criaMascara("##/##/####"));
				
		GroupLayout gl_pnAlim = new GroupLayout(pnAlim);
		gl_pnAlim.setHorizontalGroup(
			gl_pnAlim.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnAlim.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnAlim.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblValidade, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblProduto, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_pnAlim.createParallelGroup(Alignment.LEADING)
						.addComponent(tfValidade, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfProducao, 94, 94, 94))
					.addGap(174))
		);
		gl_pnAlim.setVerticalGroup(
			gl_pnAlim.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnAlim.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_pnAlim.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValidade)
						.addComponent(tfValidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_pnAlim.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProduto, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfProducao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		pnAlim.setLayout(gl_pnAlim);
		
		pnEletro = new JPanel();
		tabbedPane.addTab("Eletrodomésticos", null, pnEletro, null);
		
		lblCodForn = new JLabel("C\u00F3digo do fornecedor");
		
		lblNomeForn = new JLabel("Nome do fornecedor");
		
		tfCodForn = new JTextField();
		tfCodForn.setColumns(10);
		
		tfNomeForn = new JTextField();
		tfNomeForn.setColumns(10);
		GroupLayout gl_pnEletro = new GroupLayout(pnEletro);
		gl_pnEletro.setHorizontalGroup(
			gl_pnEletro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnEletro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnEletro.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNomeForn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCodForn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnEletro.createParallelGroup(Alignment.LEADING)
						.addComponent(tfCodForn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfNomeForn, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_pnEletro.setVerticalGroup(
			gl_pnEletro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnEletro.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_pnEletro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodForn)
						.addComponent(tfCodForn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnEletro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeForn)
						.addComponent(tfNomeForn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		pnEletro.setLayout(gl_pnEletro);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
Object botao = evento.getSource();
		
		if(botao.equals(btnInserir)) {
			try {
				Object aba = tabbedPane.getSelectedComponent();
				if(aba.equals(pnAlim)) {
					Alimenticios produto = new Alimenticios();
					produto.setCodprod(Integer.parseInt(tfCod.getText()));
					produto.setDesc(tfDesc.getText());
					produto.setValor(Double.parseDouble(tfValor.getText()));					
					produto.setValidade(LocalDate.parse(tfValidade.getText(), fmt));
					produto.setProducao(LocalDate.parse(tfProducao.getText(), fmt));
					
//					String datavalidade = tfValidade.getText();
//					LocalDate validade = LocalDate.parse(datavalidade, 
//							DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR")));
//					produto.setValidade(validade);
//					
//					String dataproducao = tfProducao.getText();
//					LocalDate producao = LocalDate.parse(dataproducao, 
//							DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR")));
//					produto.setProducao(producao);
//				
					produtos.add(produto);
					SwUtil.limpa(this);
					tfCod.requestFocus();
									
				} else {  // Eletro
					Eletrodomesticos produto = new Eletrodomesticos();
					produto.setCodprod(Integer.parseInt(tfCod.getText()));
					produto.setDesc(tfDesc.getText());
					produto.setValor(Double.parseDouble(tfValor.getText()));
					produto.setCodForn(Integer.parseInt(tfCodForn.getText()));
					produto.setNomeForn(tfNomeForn.getText());
					
					
					produtos.add(produto);
					SwUtil.limpa(this);
					tfCod.requestFocus();									
				}							
				} catch (DateTimeParseException ex) {
					JOptionPane.showMessageDialog(this, "Data invalida");
				}
		} else if(botao.equals(btnListar)) {
			int opcao = JOptionPane.showOptionDialog(this, "Selecione o Tipo de Ordenação", 
					"Relatório", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, 
					new String[] {"Por código", "Por tipo de produto"}, "Por código");
			
			if(opcao <= 0) {
				// Ordena pelo nome 
				Collections.sort(produtos, Comparator.comparing(Produtos::getCodprod));
			} else {
				// Ordena por Tipo 
				Collections.sort(produtos, 
					Comparator.comparing(Produtos::getTipo).thenComparing(Produtos::getCodprod)  );
			}
			
			String msg = "Cadastro de Produtos\n\n";
			for (Produtos produto : produtos) {
				msg += produto + "\n";
			}
			JOptionPane.showMessageDialog(this, msg);
		} else {  
			System.exit(0);
		}		
	}
}

