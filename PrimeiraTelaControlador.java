package telas;

import aplicacao.MainApp;
import dao.FilmeDAO;
import entidades.Filme;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PrimeiraTelaControlador {
	@FXML
	private TableView<Filme> tabelaFilme;
	@FXML
	private TableColumn<Filme, Number> colunaCodigo;
	@FXML
	private TableColumn<Filme, String> colunaNome;
	@FXML	
	private TableColumn<Filme, String> colunaDiretor;
	@FXML	
	private TableColumn<Filme, String> colunaGenero;
	@FXML	
	private TableColumn<Filme, String> colunaRoterista;
	@FXML
	private Label lblNome;
	@FXML
	private Label lblCodigo;
	@FXML
	private Label lblDiretor;
	@FXML
	private Label lblGenero;
	@FXML
	private Label lblRoterista;
	
	private MainApp mainApp;
	
	public PrimeiraTelaControlador() {
		
	}
	
	@FXML
	private void initialize() {
		colunaCodigo.setCellValueFactory(c->c.getValue().codigoProperty());
		colunaNome.setCellValueFactory(c->c.getValue().nomeProperty());
		colunaDiretor.setCellValueFactory(c->c.getValue().diretorProperty());
		colunaGenero.setCellValueFactory(c->c.getValue().generoProperty());
		colunaRoterista.setCellValueFactory(c->c.getValue().roteristaProperty());
		// limpar os detalhes
		mostraDetalhes(null);
		
		// detectar mudanças na seleção
		tabelaFilme.getSelectionModel().
		selectedItemProperty().
		addListener((observando,valorAntigo, novoValor)->
		mostraDetalhes(novoValor));
	}


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;		
		FilmeDAO dao = new FilmeDAO();
		
		tabelaFilme.setItems(dao.getListaFilme());	
		
	}
	
	@FXML
	private void deletar() {
	
		int indiceSelecionado = tabelaFilme.getSelectionModel()
				.getSelectedIndex();
		if(indiceSelecionado>=0) {
			//remove a pessoa do banco de dados
			FilmeDAO pdao = new FilmeDAO();
			pdao.excluir( tabelaFilme.getItems().get(indiceSelecionado));
			
			tabelaFilme.getItems().remove(indiceSelecionado);
		}else {
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Nenhum registro selecionado");
			alerta.setHeaderText("Nenhuma pessoa selecionada");
			alerta.setContentText("Você deve selecionar um registro na tabela");
			alerta.showAndWait();
		}
		
	}
	
	
	public void mostraDetalhes(Filme filme) {
		if(filme !=null) {
			lblCodigo.setText(String.valueOf(filme.getCodigo()));
			lblNome.setText(filme.getNome());
			lblDiretor.setText(filme.getDiretor());
			lblGenero.setText(filme.getGenero());
			lblRoterista.setText(filme.getRoterista());
		}else {
			lblCodigo.setText("");
			lblNome.setText("");
			lblDiretor.setText("");
			lblGenero.setText("");
			lblRoterista.setText("");
		}
		
	}
	@FXML
	private void cliqueNovoFilme() {
		Filme filme = new Filme("");
		mainApp.mostrarAdicionarEditarFilme(filme);
		tabelaFilme.getItems().add(filme);
		
		//recarrega os dados do BD
		FilmeDAO dao = new FilmeDAO();
		tabelaFilme.setItems(dao.getListaFilme());	
	//	mostraDetalhes(Filme);
		
	}
	
	@FXML
	private void cliqueEditar() {
		Filme filme = tabelaFilme.getSelectionModel().getSelectedItem();
		if(filme!=null) {
			mainApp.mostrarAdicionarEditarFilme(filme);
			mostraDetalhes(filme);
		}
	}
	

}
