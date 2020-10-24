/*
	Creator : Faddi Susanto
	Java database text to store your data
	This API created where SQL is not needed
	or created Application without using SQL database
*/

import java.io.*;
import java.util.*;

public class lullaby {

	public String[][] store;
	public FileInputStream finput = null;
	public FileOutputStream foutput = null;
	public String slt = "";
	public String fileName = "";
	public int kolom;

	/*
		fileName : file name for tables database
		kolom : number of array column
	*/
	public lullaby(String fileName, int kolom) {
		this.fileName = fileName;
		this.kolom = kolom;
		int fdata;
		try{
			finput = new FileInputStream(fileName); //nama files
		}catch(FileNotFoundException fnfe){
			System.out.println("File Tidak Ditemukan.");
		}
		try{
			while((fdata = finput.read()) != -1){
				this.slt += (char) fdata;
			}
			byte[] decrypted = Base64.getDecoder().decode((this.slt.getBytes("UTF-8")));
			String[] ary = new String(decrypted).split("\n");
			int lgt = ary.length;
			this.store = new String[lgt][kolom]; //kolom banyaknya kolom database ditentukan
			for(int i=0;i<this.store.length;i++){
				this.store[i] = ary[i].split(",");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			finput.close();
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}

	public void selectAll() throws Exception {
		byte[] decrypted = Base64.getDecoder().decode((this.slt.getBytes("UTF-8")));
		System.out.println(new String(decrypted));
		return;
	}

	public String[] selectWhere(String equal, int where){
		String[] selects = null;
		for(int i=0;i<this.store.length;i++){
			if(this.store[i][where].equals(equal)){
				String ary = Arrays.toString(this.store[i]).replace("[","").replace("]","");
				selects = ary.split(",");
			}
		}
		return selects;
	}

	public String[][] selectMultiWhere(String equal, int where){
		String[][] selects = new String[this.store.length][kolom];
		for(int i=0;i<this.store.length;i++){
			if(this.store[i][where].equals(equal)){
				String ary = Arrays.toString(this.store[i]).replace("[","").replace("]","");
				selects[i] = ary.split(",");
			}
		}
		return selects;
	}

	public void insert(String[] inserts) throws Exception {
		String sva = "";
		for(int i=0;i<inserts.length;i++){
			sva += inserts[i] + ",";
		}
		sva += "\n";
		String sve = Base64.getEncoder().encodeToString(sva.getBytes("UTF-8"));
		try{
			foutput = new FileOutputStream(fileName, true); //nama files
		}catch(FileNotFoundException fnfe){
			System.out.println("File Tidak Ditemukan.");
		}
		try{
			for(int i=0;i<sve.length();i++){
				foutput.write((int) sve.charAt(i));
			}
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		try{
			foutput.flush();
			foutput.close();
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		return;
	}

	public void update(String equal, int where, int oldString, String newString){
		String datas = "";
		for(int i=0;i<this.store.length;i++){
			if(this.store[i][where].equals(equal)){
				this.store[i][oldString] = newString;
				String st = Arrays.toString(this.store[i]).replace("[","").replace("]","").replace(", ",",").replace(",  ",",");
				this.store[i] = st.split(",");
			}
			datas += Arrays.toString(this.store[i]).replace("[","").replace("]","").replace(", ",",").replace(",  ",",") + "\n";
		}
		try{
			foutput = new FileOutputStream(fileName);
		}catch(FileNotFoundException fnfe){
			System.out.println("File Tidak Ditemukan");
		}
		try{
			String dataSave = Base64.getEncoder().encodeToString(datas.getBytes("UTF-8"));
			for(int i=0;i<dataSave.length();i++){
				foutput.write((int) dataSave.charAt(i));
			}
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		try{
			foutput.flush();
			foutput.close();
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		return;
	}

	public void delete(String equal, int where){
		String datas = "";
		for(int i=0;i<this.store.length;i++){
			if(this.store[i][where].equals(equal)){
				this.store[i] = null;
			}
			datas += Arrays.toString(this.store[i]).replace("[","").replace("]","").replace(", ",",").replace(",  ",",") + "\n";
		}
		try{
			foutput = new FileOutputStream(fileName);
		}catch(FileNotFoundException fnfe){
			System.out.println("File Tidak Ditemukan");
		}
		try{
			String dataSave = Base64.getEncoder().encodeToString(datas.getBytes("UTF-8"));
			for(int i=0;i<dataSave.length();i++){
				foutput.write((int) dataSave.charAt(i));
			}
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		try{
			foutput.flush();
			foutput.close();
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		return;
	}
}
