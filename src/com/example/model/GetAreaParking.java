package com.example.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class GetAreaParking extends HttpServlet {
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAreaParking() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		Gson gson = new Gson();
		ArrayList<SimpleParkingFeeObject> ObjArray = new ArrayList<SimpleParkingFeeObject>();


		String theArea = request.getParameter("TaiwanArea");
		String theId = request.getParameter("id");
		if(theArea==null){theArea="板橋區";}
		
		if(theId==null){
			
			try {// get position
				GetAreaDataFromDB db = new GetAreaDataFromDB();
				ObjArray = db.getAreaDB(theArea);
	
			} catch (Exception e) {
				System.out.println("");
				System.out.println(e.getMessage());
	
			}
		
		}else{
		
			try {// get position
				GetAreaDetailDataFromDB detail = new GetAreaDetailDataFromDB();
				ObjArray = detail.getTheParkingData(theId);
	
			} catch (Exception e) {
				System.out.println("");
				System.out.println(e.getMessage());
	
			}
		
			
			
		}

		response.getWriter().append(gson.toJson(ObjArray));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
