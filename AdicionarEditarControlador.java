package telas;
import dao.FilmeDAO;
import entidades.Filme;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdicionarEditarControlador {
	@FXML
	private TextField txtCodigo;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtGenero;
	@FXML
	private TextField txtDiretor;
	@FXML
	private TextField txtRoterista;
	
	private Stage palcoDialogo;
	private Filme filme;
	
	
	@FXML
	private void initialize() {
		
	}
	
	public void setPalcoDialogo(Stage palcoDialogo) {
		this.palcoDialogo = palcoDialogo;
	}
	
	public void setFilme(Filme filme) {
		this.filme = filme;
		txtCodigo.setText(String.valueOf(filme.getCodigo()));
		txtNome.setText(filme.getNome());
		txtGenero.setText(filme.getGenero());
		txtDiretor.setText(filme.getDiretor());
		txtRoterista.setText(filme.getRoterista());
	}
	@FXML
	private void cliqueOk() {
		//pessoa.setCodigo(Integer.parseInt(txtCodigo.getText()));
		filme.setGenero(txtGenero.getText());
		filme.setDiretor(txtDiretor.getText());
		filme.setNome(txtNome.getText());
		filme.setRoterista(txtRoterista.getText());
		
		//insere os dados no banco de dados
		FilmeDAO pdao = new FilmeDAO();
		if (filme.getCodigo()>0) {
			pdao.alterar(filme);
		} else {
			pdao.inserir(filme);
		}
		pdao.listar();
		
		palcoDialogo.close();
	}
	@FXML
	private void cliqueCancelar() {
		palcoDialogo.close();
	}
}
