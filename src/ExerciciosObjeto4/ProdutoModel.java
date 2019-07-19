package ExerciciosObjeto4;

import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ProdutoModel extends AbstractTableModel{
	private String[] titulos = {"Cod.", "Nome", "Valor", "Quantidade" };
	private List<Produto> lista;
	private NumberFormat fmt = NumberFormat.getNumberInstance();
	
	public ProdutoModel(List<Produto> lista) {
		this.lista = lista;
		fmt.setMaximumFractionDigits(2);
		fmt.setMinimumFractionDigits(2);
	}
	
	public void setLista(List<Produto> lista) {
		this.lista = lista;
		fireTableDataChanged();
	}
	
	@Override
	public String getColumnName(int col) {
		return titulos[col];
	}
	
	@Override
	public int getColumnCount() {
		return titulos.length;
	}   
		
	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int linha, int col) {
		Produto obj = lista.get(linha);
		Object valor = null;
		
		switch (col) {
		case 0:
			valor= obj.getCodigo();			
			break;
			
		case 1:
			valor = obj.getNome();			
			break;
			
		case 2:
			valor = fmt.format(obj.getValor());
			break;
			
		case 3:
			valor = obj.getQuantidade();
			break;
			
		default:
			break;
		}
		
		return valor;
	}

}
