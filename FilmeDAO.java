package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entidades.Filme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FilmeDAO {
	// Estrutura de Dados
	private ObservableList<Filme> listaFilme=FXCollections.observableArrayList();;
	
	public FilmeDAO() {
		//listaFilmes=FXCollections.observableArrayList();
	}
	
	public void inserir(Filme p) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO filme "
					+ "(codigo, nome, diretor,genero,roterista) "
					+ "VALUES (?,?,?,?,?)";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setInt(1, p.getCodigo());
			prep.setString(2, p.getNome());
			prep.setString(3, p.getDiretor());
			prep.setString(4,p.getGenero());
			prep.setString(5, p.getRoterista());
			prep.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	public void alterar(Filme p) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE filme SET "
					+ "nome = ?, diretor = ?, genero = ?, roterista = ?"
					+ "WHERE codigo = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getDiretor());
			prep.setString(3, p.getGenero());
			prep.setString(4, p.getRoterista());
			prep.setInt(5, p.getCodigo());
			prep.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	public void excluir(Filme p) {
		Conexao con = new Conexao();
		try {
			String sql = "DELETE FROM filme "
					+ "WHERE codigo = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setInt(1, p.getCodigo());
			prep.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	public ObservableList<Filme> listar() {
		Conexao con = new Conexao();
		try {
			String sql = "SELECT * FROM filme "
					+ "ORDER BY nome";
			Statement prep = con.getConexao().createStatement();
			ResultSet res = prep.executeQuery(sql);
			while (res.next()) {
				//instancia o objeto Filme pegando o seu nome do bd
				Filme p = new Filme(res.getString("nome"));
				//atribui os valores ao objeto de entidade buscando os dados no bd 
				p.setCodigo(res.getInt("codigo"));
				p.setDiretor(res.getString("diretor"));
				p.setGenero(res.getString("genero"));
				p.setRoterista(res.getString("roterista"));
				listaFilme.add(p);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
		
		return listaFilme;
	}
	
	
	// SIMULAR CONSULTA DE ELEMENTOS
	public ObservableList<Filme> getListaFilme(){
		//criaPessoas();
		listar();
		return listaFilme;
	}
	
}