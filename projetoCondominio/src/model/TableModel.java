package model;

import lombok.Getter;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {
	
		
	/**
	 * 
	 */
		@Getter
        private List<String> linhas = new ArrayList<>();
		private String[] colunas = null;
		
		public TableModel(List<String> linhas, String[] colunas) {
			
			setLinhas(linhas);
			setColunas(colunas);
			
		}

        public void setLinhas(List<String> linhas) {
			this.linhas = linhas;
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


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

	//public Object getValueAt(int numLin, int numCol) {
	   //		Object [] linha = (Object[])getLinhas().get(numLin);
	  //		return linha[numCol];
	  //	}
		
	

}
