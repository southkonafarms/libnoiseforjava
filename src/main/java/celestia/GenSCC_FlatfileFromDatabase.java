package celestia;

import celestia.SSC_Entry_formatsI.BuildSSCFlatFile;

public class GenSCC_FlatfileFromDatabase extends BuildSSCFlatFile{
	
	public static void build(){
		BuildSSCFlatFile.genSSC_File();
	}
	
	public static void main(String[] args) {
		build();
	}

}
