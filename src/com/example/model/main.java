package com.example.model;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import com.example.model.*;


public class main {

		public static void main(String[] argv) {
		
			
			ConnectionManager.openConnection();
			
			
			SimpleParkingFeeObject object=new SimpleParkingFeeObject("新北市","三峽區","Times 三峽國際一街停車場",80);
			ConnectionManager.inserToDB(object);
			
			return;
		
		}
		        


	
}
