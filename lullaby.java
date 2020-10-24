/*
	Creator : Faddi Susanto
	Java database text
	This API created where SQL is not needed
	or created Application without using SQL database
*/
package com.pos.Model;

import java.io.*;
import java.util.*;

public class lullaby{

	public String[][] store;
	public FileInputStream finput = null;
	public FileOutputStream foutput = null;
	public String selectAll = "";
	public String slt = "";
	public String fileName = "";
	public int kolom;

	/*
		fileName : file name for tables database
		kolom : number of array column
	*/
	public lullaby(String fileName, int kolom){
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
				selectAll += (char) fdata;
				slt += (char) fdata;
			}
		String[] ary = slt.split("\n");
		int lgt = ary.length;
		store = new String[lgt][kolom]; //kolom banyaknya kolom database ditentukan
		for(int i=0;i<store.length;i++){
			store[i] = ary[i].split(",");
		}
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		try{
			finput.close();
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}

	public void selectAll(){
		System.out.println(selectAll);
		return;
	}

	public String[] selectWhere(String equal, int where){
		String[] selects = null;
		for(int i=0;i<store.length;i++){
			if(store[i][where].equals(equal)){
				String ary = Arrays.toString(store[i]).replace("[","").replace("]","");
				selects = ary.split(",");
			}
		}
		return selects;
	}

	public String[][] selectmultiWhere(String equal, int where){
		String[][] selects = new String[store.length][kolom];
		for(int i=0;i<store.length;i++){
			if(store[i][where].equals(equal)){
				String ary = Arrays.toString(store[i]).replace("[","").replace("]","");
				selects[i] = ary.split(",");
			}
		}
		return selects;
	}

	public void insert(String[] inserts){
		String sve = "";
		for(int i=0;i<inserts.length;i++){
			sve += inserts[i] + ",";
		}
		sve += "\n";
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
		for(int i=0;i<store.length;i++){
			if(store[i][where].equals(equal)){
				store[i][oldString] = newString;
				String st = Arrays.toString(store[i]).replace("[","").replace("]","").replace(", ",",").replace(",  ",",");
				store[i] = st.split(",");
			}
			datas += Arrays.toString(store[i]).replace("[","").replace("]","").replace(", ",",").replace(",  ",",") + "\n";
		}
		try{
			foutput = new FileOutputStream(fileName);
		}catch(FileNotFoundException fnfe){
			System.out.println("File Tidak Ditemukan");
		}
		try{
			for(int i=0;i<datas.length();i++){
				foutput.write((int) datas.charAt(i));
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
		for(int i=0;i<store.length;i++){
			if(store[i][where].equals(equal)){
				store[i] = null;
			}
			datas += Arrays.toString(store[i]).replace("[","").replace("]","").replace(", ",",").replace(",  ",",") + "\n";
		}
		try{
			foutput = new FileOutputStream(fileName);
		}catch(FileNotFoundException fnfe){
			System.out.println("File Tidak Ditemukan");
		}
		try{
			for(int i=0;i<datas.length();i++){
				foutput.write((int) datas.charAt(i));
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
