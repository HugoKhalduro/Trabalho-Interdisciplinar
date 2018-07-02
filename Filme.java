package entidades;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Filme {
	    private IntegerProperty Codigo;
		private StringProperty Nome;
		private StringProperty Genero;
		private StringProperty Diretor;
		private StringProperty Roterista;
		
		
		public Filme(String nome) {
			this.Codigo = new SimpleIntegerProperty();
			this.Nome = new SimpleStringProperty(nome);
			this.Genero = new SimpleStringProperty();
			this.Diretor = new SimpleStringProperty();
			this.Roterista = new SimpleStringProperty();
		}
		
		public final IntegerProperty codigoProperty() {
			return this.Codigo;
		}
		
		public final int getCodigo() {
			return this.codigoProperty().get();
		}
		
		public final void setCodigo(final int cod_filme) {
			this.codigoProperty().set(cod_filme);
		}
		
		public final StringProperty nomeProperty() {
			return this.Nome;
		}
		
		public final String getNome() {
			return this.nomeProperty().get();
		}
		
		public final void setNome(final String nomeFilme) {
			this.nomeProperty().set(nomeFilme);
		}

		public final StringProperty generoProperty() {
			return this.Genero;
		}
		

		public final String getGenero() {
			return this.generoProperty().get();
		}
		

		public final void setGenero(final String genero) {
			this.generoProperty().set(genero);
		}

		public final StringProperty diretorProperty() {
			return this.Diretor;
		}
		

		public final String getDiretor() {
			return this.diretorProperty().get();
		}
		

		public final void setDiretor(final String diretor) {
			this.diretorProperty().set(diretor);
		}
		

		public final StringProperty roteristaProperty() {
			return this.Roterista;
		}
		

		public final String getRoterista() {
			return this.roteristaProperty().get();
		}
		

		public final void setRoterista(final String roterista) {
			this.roteristaProperty().set(roterista);
		}
		
		
		
		
}