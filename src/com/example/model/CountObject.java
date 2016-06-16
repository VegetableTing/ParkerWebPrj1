package com.example.model;

import com.example.model.CountObject.number_object;

public class CountObject {
	private String State;
	
	private number_object freq;

	public static class number_object {
		private int low;

		private int mid;

		private int high;

		public number_object(int low,int mid,int high) {
			setLow(low);
			setMid(mid);
			setHigh(high);
		}

		public int getLow(int low) {
			return this.low;
		}

		public void setLow(int low) {
			this.low = low;
		}

		public int getMid(int mid) {
			return this.mid;
		}

		public void setMid(int mid) {
			this.mid = mid;
		}

		public int getHigh(int high) {
			return this.high;
		}

		public void setHigh(int high) {
			this.high = high;
		}
	}

	public CountObject(String State, number_object temp) {
		setState(State);
		setNumberObject(temp);
	}

	public String getState(String State) {
		return this.State;
	}

	public void setState(String State) {
		this.State = State;
	}
	
	public number_object getNumberObject(number_object freqb) {
		return this.freq;
	}

	public void setNumberObject(number_object freq) {
		this.freq = freq;
	}

}
