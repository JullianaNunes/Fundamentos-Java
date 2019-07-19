package ExercicioRegex;

import static br.senai.sp.informatica.lib.SwUtil.criaBotao;
import static br.senai.sp.informatica.lib.SwUtil.criaPainel;
import java.awt.BorderLayout;
import java.lang.module.FindException;
import java.lang.module.InvalidModuleDescriptorException;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class ExercicioExpressoes extends JFrame implements ActionListener {
	
	String cep = "[0-9]{5}-[0-9]{3}";

	// FONE: "[[99 ](99) ][9]9999-9999"
	String telefone = "[[[0-9]{2}][0-9]{2}]?[0-9]{5}-[0-9]{4}";

	// RG: "[99]9.999.999[-9|X]"
	String rg = "[0-9]{2}.[0-9]{3}.[0-9]{3}-\\w{2}";

	// CPF: "[99]9.999.999-99"
	String cpf = "[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}";

	// CNPJ: "[99]9.999.999/9999-99"
	String cnpj = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{4}-[0-9]{2}";

	// E-mail: "[xx.]xx@xxxxx.xxxxx.xxxxx"
	String email = "\\w{2,}@\\w{2,}\\.\\w{3}";
	
	// URL: "xxxx.xxxxx.xxxxx"
	String site = "\\w{3}\\.?\\w{2,}\\.\\w{1,}";
	
	
	private JTextField tfCep = new JTextField(9);
	private JTextField tfFone = new JTextField(18);
	private JTextField tfRg = new JTextField(13);
	private JTextField tfCpf = new JTextField(14);
	private JTextField tfCnpj = new JTextField(19);
	private JTextField tfEmail = new JTextField(25);
	private JTextField tfSite = new JTextField(25);	
	private JButton btValidar = criaBotao("Valida", KeyEvent.VK_V, this); private
	JButton btnSair = criaBotao("Sair", KeyEvent.VK_S, this);
	 

	private List<Regra> lista = new ArrayList<Regra>();
	
	
	public ExercicioExpressoes() {
		setResizable(false);
		// Inicializa a Lista de Regras de Validação
		lista.add(new Regra(tfCep, "CEP Inválido!", cep));
		lista.add(new Regra(tfFone, "Fone Inválido!", telefone));
		lista.add(new Regra(tfRg, "RG Inválido!", rg));
		lista.add(new Regra(tfCpf, "CPF Inválido!", cpf));
		lista.add(new Regra(tfCnpj, "CNPJ Inválido!", cnpj));
		lista.add(new Regra(tfEmail, "E-Mail Inválido!", email));
		lista.add(new Regra(tfSite, "Site Inválido!", site));
		
		// Controi a Tela
		setTitle("Validador");

		JPanel painelCentral = new JPanel();
		painelCentral.setLayout(new BoxLayout(painelCentral,
				BoxLayout.PAGE_AXIS));
		painelCentral.add(criaPainel("CEP", tfCep));
		painelCentral.add(criaPainel("Fone", tfFone));
		painelCentral.add(criaPainel("RG", tfRg));
		painelCentral.add(criaPainel("CPF", tfCpf));
		painelCentral.add(criaPainel("CNPJ", tfCnpj));
		painelCentral.add(criaPainel("E-Mail", tfEmail));
		painelCentral.add(criaPainel("Site", tfSite));
		getContentPane().add(painelCentral, BorderLayout.CENTER);
		btValidar.addActionListener(this);
		
		painelCentral.add(btValidar);
		
		painelCentral.add(btnSair);
	
		painelCentral.add(btValidar); 
		
		painelCentral.add(btnSair);getContentPane().add(criaPainel(btValidar,
		 btnSair), BorderLayout.SOUTH);
		

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setDefaultButton(btValidar);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == btValidar) {
			String msg = "";
			JTextField obj = null;
			for (Regra regex : lista) {
				if(!regex.valida()) {
					msg += regex.msg + "\n";
					
					if(obj == null)
						obj = regex.campo;
				}
			}
			
			if(msg.isEmpty())
				JOptionPane.showMessageDialog(null, "Teste Ok!");
			else
				JOptionPane.showMessageDialog(null, "Lista de Erros\n\n" + msg);
			
			if(obj == null)
				tfCep.requestFocus();
			else
				obj.requestFocus();
		} else {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new ExercicioExpressoes();
	}

	@Data
	@AllArgsConstructor
	public class Regra {
		private JTextField campo;
		private String msg;
		private String regra;

		public boolean valida() {
			return Pattern.matches(regra, campo.getText());
		}
	}
}
