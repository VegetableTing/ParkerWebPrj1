package com.example.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class getPriceFromDB
 */

public class getPriceData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getPriceData() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int low_price=20, high_price=50;

		//low_price = Integer.valueOf(request.getParameter("price_low"));
		//high_price = Integer.valueOf(request.getParameter("price_high"));
		response.setContentType("application/json; charset=utf-8");
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");

		Gson gson = new Gson();
		ArrayList<CountObject> arr_price = new ArrayList<CountObject>();

		try {// get position
			getPriceFromDB db = new getPriceFromDB();
			arr_price = db.getPriceDB(low_price, high_price);

		} catch (Exception e) {
			System.out.println("");
			System.out.println(e.getMessage());

		}

		response.getWriter().append(gson.toJson(arr_price));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
