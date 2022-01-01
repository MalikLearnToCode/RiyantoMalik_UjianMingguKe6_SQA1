package com.juaracoding.wptesting.utils;

public enum TestCases {

	T1("Testing register"),
	T2("Testing the authentication"),
	T3("Testing add to cart");
	
	private String testName;	

	TestCases(String value){
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
