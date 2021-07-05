package javaFinal;

import java.io.IOException;

import joinery.DataFrame;
import tech.tablesaw.api.Table;

public class StructuredData {
	private String file;
public StructuredData(String f) {
	this.file=f;
		
	}
	public Table tableSaw() throws IOException {
		Table jobs=Table.read().csv(this.file);
		return jobs;
	}
	public DataFrame<?> joinery() throws IOException {
		DataFrame<?> jobs= DataFrame.readCsv(this.file);
		return jobs;
		
	}
	

}
