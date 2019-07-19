package ExerciciosObjeto4;

import java.awt.EventQueue;
import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.senai.sp.informatica.lib.SwUtil;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CadProdutoDB extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCod;
	private JTextField tfCod;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblDescrio;
	private JTextField tfDescricao;
	private JLabel lblValor;
	private JTextField tfValor;
	private JLabel lblQuantidade;
	private JTextField tfQuantidade;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnInserir;
	private JButton btnSair;
	
	private List<Produto> lista = new ArrayList<>();
	private ProdutoModel model = new ProdutoModel(lista);
	private NumberFormat fmt = NumberFormat.getNumberInstance();
	private static Connection con;
	private static PreparedStatement consulta;
	private static PreparedStatement inclui;

 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unchecked")
			public void run() {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					con = DriverManager.getConnection
							("jdbc:mysql://localhost/cursojava"
									+ "?useTimezone=true&serverTimezone=UTC&useSSL=false",
									"root","root132" );
					
				consulta = con.prepareStatement
							("select * from produto");  
					

				inclui = con.prepareStatement
							("INSERT INTO produto "
									+ "(codigo, nome, descricao,valor,quantidade) "
									+ "VALUES (?,?,?,?,?)");
					
					CadProdutoDB frame = new CadProdutoDB();	
					
					frame.carregaProdutos();
					
					
					
					frame.setVisible(true);
					
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null,"Driver JDBC não encontrado");
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Falha na Conexão");
					e.printStackTrace();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 	
 	public void carregaProdutos() throws SQLException {
 	ResultSet resultado = consulta.executeQuery();
	while (resultado.next()) {  
		Produto produto = new Produto ();
		produto.setIdproduto(resultado.getInt("idproduto"));
		produto.setCodigo(resultado.getInt("codigo"));
		produto.setNome(resultado.getString("nome"));
		produto.setDescricao(resultado.getString("descricao"));
		produto.setValor(resultado.getDouble("valor"));
		produto.setQuantidade(resultado.getInt("quantidade"));
		
		lista.add(produto);  
	}
		}
 	

	public CadProdutoDB() {
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblCod = new JLabel("Cod.");
		
		tfCod = new JTextField();
		tfCod.setColumns(10);
		
		lblNome = new JLabel("Nome");
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		
		tfDescricao = new JTextField();
		tfDescricao.setColumns(10);
		
		lblValor = new JLabel("Valor");
		
		tfValor = new JTextField();
		tfValor.setColumns(10);
		
		lblQuantidade = new JLabel("Quantidade");
		
		tfQuantidade = new JTextField();
		tfQuantidade.setColumns(10);
		
		scrollPane = new JScrollPane();
		
		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblValor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfValor, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addGap(145)
							.addComponent(lblQuantidade, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfQuantidade, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfDescricao, 415, 415, 415))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCod, 105, 105, 105)
							.addGap(39)
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescrio)
						.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantidade))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnInserir))
					.addContainerGap())
		);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void actionPerformed(ActionEvent evento) {
		Object botao = evento.getSource();
		
		if(botao.equals(btnInserir)) {
			try {	
				Produto obj = new Produto();
				obj.setCodigo(Integer.parseInt(tfCod.getText()));
				obj.setNome(tfNome.getText());
				obj.setDescricao(tfDescricao.getText());
				obj.setValor(fmt.parse(tfValor.getText()).doubleValue());
				obj.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
						
				inclui.setInt (1, obj.getCodigo());
				inclui.setString(2, obj.getNome());
				inclui.setString(3, obj.getDescricao());
				inclui.setDouble(4, obj.getValor());
				inclui.setInt(5, obj.getQuantidade());
				 
				inclui.execute();
				
				lista.add(obj);						
				
				// Avisa ao JTable que foi incluido um produto
				model.fireTableDataChanged();
				
				SwUtil.limpa(this);
				tfCod.requestFocus();
			
			} catch (ParseException ex) {
				JOptionPane.showMessageDialog(this, "Esse valor é inválido");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this,"Falha ao incluir o Produto");
				e.printStackTrace();
			} 
		} else {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.exit(0);
		
		}
	}
}
