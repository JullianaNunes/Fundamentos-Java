package ExerciciosObjeto4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class LerProduto {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost/cursojava"
							+ "?useTimezone=true&serverTimezone=UTC&useSSL=false",
							"root","root132" );
			
			PreparedStatement sql = con.prepareStatement
					("select * from produto");  
			
			List<Produto> lista = new ArrayList<>();
			
			ResultSet resultado = sql.executeQuery();
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
			
			con.close();
			String msg = "Produtos Cadastrados\n\n";
			for (Produto produto : lista) {
				msg += produto + "\n";
			}
			
			JOptionPane.showMessageDialog(null, msg);
				
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Driver JDBC não encontrado");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	}

   