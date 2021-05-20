package ModelBeans;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {
	
		
	/**
	 * 
	 */
		private ArrayList linhas = null;
		private String[] colunas = null;
		
		public ModeloTabela(ArrayList linhas, String[] colunas) {
			
			setLinhas(linhas);
			setColunas(colunas);
			
		}

		public ArrayList getLinhas() {
			return linhas;
		}

		public void setLinhas(ArrayList linhas) {
			this.linhas = linhas;
		}

		public String[] getColunas() {
			return colunas;
		}

		public void setColunas(String[] colunas) {
			this.colunas = colunas;
		}

		public int getColumnCount() {
			return colunas.length;
		}
		
		public int getRowCount() {
			return linhas.size();
		}
		
		public String getColumnName(int numCol) {
			return colunas[numCol];
		}
		
		public Object getValueAt(int numLin, int numCol) {
			Object [] linha = (Object[])getLinhas().get(numLin);
			return linha[numCol];
		}
		
	

}
