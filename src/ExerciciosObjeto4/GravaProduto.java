package ExerciciosObjeto4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class GravaProduto {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost/cursojava"
							+ "?useTimezone=true&serverTimezone=UTC&useSSL=false",
							"root","root132" );
			
			Produto produto = new Produto();
			produto.setCodigo(123);   
			produto.setNome("Blusa de Moletom");
			produto.setDescricao("Blusa vermelha");
			produto.setValor(50);
			produto.setQuantidade(1);
			
			PreparedStatement sql = con.prepareStatement
					("INSERT INTO produto (codigo, nome, descricao,valor,quantidade) VALUES (?,?,?,?,?)");   
			
			sql.setInt (1, produto.getCodigo());
			sql.setString(2, produto.getNome());
			sql.setString(3, produto.getDescricao());
			sql.setDouble(4, produto.getValor());
			sql.setInt(5, produto.getQuantidade());
			 
			sql.execute();
			
			con.close(); 
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Driver JDBC não encontrado");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	}

   