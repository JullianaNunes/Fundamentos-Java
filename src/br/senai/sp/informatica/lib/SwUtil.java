package br.senai.sp.informatica.lib;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.senai.sp.informatica.lib.optional.OptionalTextField;
import br.senai.sp.informatica.lib.optional.StatusValidador;
import br.senai.sp.informatica.lib.optional.Validador;

public class SwUtil {
	private SwUtil() {}
	
	/**
	 * Retorna a instância de CurrencyFormat o formatador de números
	 * reais para a região Brasileira
	 * @return a instância de CurrencyFormat
	 */
	public static CurrencyFormat getFormatador() {
		return new CurrencyFormat();
	}
	
	/**
	 * Implementa método de leitura de Strings
	 * @param args lista de arqumentos a serem utilizados como prompt
	 * @return o texto lido
	 */
	public static String leTexto(Object ... args) {
		String txt = "";

		for (Object arg : args) {
			if (arg instanceof String) {
				txt += String.format("%s", arg);
			} else if (arg instanceof Integer) {
				txt += String.format("%d", arg);
			} else if (arg instanceof Double) {
				txt += String.format(new Locale("pt","BR"), "%,.2f", arg);
			}
		}

		return JOptionPane.showInputDialog(txt);
	}
	
	private static Number leNumber(Class<?> type, Object... args) {
		Number ret = 0;
		while (true) {
			try {
				if(type.equals(Integer.class))
					ret = Integer.parseInt(leTexto(args));
				else
					ret = getFormatador().parse(leTexto(args));
				break;
			} catch (NumberFormatException ex) {
				escrevaErro("Número inválido");
			} catch (Error ex) {
				escrevaErro("Valor inválido");
			}
		}
		return ret;
	}
	
	/**
	 * Implementa método de leitura de Integers
	 * @param args lista de arqumentos a serem utilizados como prompt
	 * @return o inteiro lido
	 */
	public static Integer leInteiro(Object... args) {
		int ret = leNumber(Integer.class, args).intValue();
		return ret;
	}
	
	/**
	 * Implementa método de leitura de Doubles
	 * @param args lista de arqumentos a serem utilizados como prompt
	 * @return o double lido
	 */
	public static Double leReal(Object... args) {
		double ret = leNumber(Double.class, args).doubleValue();
		return ret;
	}
	
	/**
	 * Implementa método de escrita sem salto de linha ao final
	 * @param args lista de arqumentos a serem apresentados
	 */
	public static void escreva(Object ... args) {
		String txt = "";
		
		for (Object arg : args) {
			if (arg instanceof String) {
				txt += String.format("%s", arg);
			} else if (arg instanceof Character) {
				txt += String.format("%c", arg);
			} else if (arg instanceof Integer) {
				txt += String.format(new Locale("pt","BR"),"%d", arg);
			} else if (arg instanceof Double) {
				txt += String.format(new Locale("pt","BR"),"%,.2f", arg);
			}
		}

		JOptionPane.showMessageDialog(null, txt);
	}

	private static void escrevaErro(String txt) {
		JOptionPane.showMessageDialog(null, txt, "Erro", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Limpa recursivamente os campos de um JFrame
	 * @param obj o container que contém os componentes da tela, normalmente a 
	 * 			  referência do JFrame
	 */
	@SuppressWarnings("rawtypes")
	public static void limpa(Container obj) {
		for (Component comp : obj.getComponents()) {
			if (comp instanceof JTextField) {
				((JTextField) comp).setText("");
			} else if (comp instanceof JTextArea) {
				((JTextArea) comp).setText("");
			} else if (comp instanceof JComboBox) {
				((JComboBox) comp).setSelectedIndex(0);
			} else if (comp instanceof Container) {
				limpa((Container) comp);
			}
		}
	}

	public static StatusValidador verificaStatus(Container obj) {
		StatusValidador resultado = StatusValidador.OK;

		for (Component comp : obj.getComponents()) {
			if (comp instanceof JTextField) {
				InputVerifier verifier = ((JTextField) comp).getInputVerifier();
				if (verifier != null && verifier instanceof Validador) {
					StatusValidador status = ((Validador) verifier).isOk();
					if (!status.equals(StatusValidador.OK)) {
						if(status.equals(StatusValidador.ERRO)) {
							resultado = status;
						} else if(!(comp instanceof OptionalTextField) || 
								(comp instanceof OptionalTextField && 
										!((OptionalTextField)comp).isOptional())) {
							resultado = status;						
						}
					}
				}
			} else if (comp instanceof Container) {
				StatusValidador st = verificaStatus((Container) comp);
				if (!st.equals(StatusValidador.OK))
					resultado = st;
			}
		}

		return resultado;
	}

	public static boolean verificaVazio(Container obj) {
		boolean resultado = true;

		for (Component comp : obj.getComponents()) {
			if (comp instanceof JTextField) {
				if(!(comp instanceof OptionalTextField) ||
				    !((OptionalTextField)comp).isOptional()) {
					if (((JTextField) comp).getText().isEmpty())
						resultado = false;
				} 
			} else if (comp instanceof JTextArea) {
				if (((JTextArea) comp).getText().isEmpty())
					resultado = false;
			} else if (comp instanceof Container) {
				if (!verificaVazio((Container) comp))
					resultado = false;
			}
		}

		return resultado;
	}

	public static MaskFormatter criaMascara(String s) {
		return criaMascara(s, null);
	}
	
	/*
	Character   Description
	  #         Qualquer número valido, usa Character.isDigit.
	  '         Permite a utilização de qualquer caractere de formatação que está nesta lista
	  U         Qualquer charactere (Character.isLetter). Todas as letras minúsculas  são mapeadas para Maiúculas.
	  L         Qualquer charactere (Character.isLetter). Todas as letras Maiúculas  são mapeadas para minúsculas.
	  A         Qualquer charactere ou numero (Character.isLetter ou Character.isDigit)
	  ?         Qualquer charactere (Character.isLetter).
	  *         Qualquer coisa.
	  H         Qualquer charactere hexadecimal (0-9, a-f or A-F).
	*/

	public static MaskFormatter criaMascara(String s, String chars) {
		MaskFormatter formatter = null;

		try {
			formatter = new MaskFormatter(s);
			if(chars != null)
				formatter.setValidCharacters(chars);
		} catch(ParseException exc) {
			System.err.println("Máscara inválida: " + exc.getMessage());
			System.exit(-1);
		}

		return formatter;
	}
	public static JPanel criaPainel(String label, JComponent obj) {

		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel(label));
		p.add(obj);
		return p;
	}

	public static JPanel criaPainel(LayoutManager layout, JComponent... obj) {

		JPanel p = new JPanel(layout);
		for (JComponent comp : obj)
			p.add(comp);

		return p;
	}

	public static JPanel criaPainel(JButton... obj) {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
		for (JComponent comp : obj) {
			p.add(comp);
		}
		return p;
	}

	public static JButton criaBotao(String label, int key, ActionListener act) {
		JButton bt = new JButton(label);
		bt.setMnemonic(key);
		bt.addActionListener(act);
		return bt;
	}

}
