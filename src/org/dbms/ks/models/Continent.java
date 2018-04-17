package org.dbms.ks.models;

import org.json.JSONObject;

public class Continent extends BaseModel{

	private Continent(JSONObject json) throws ValidationException{
		super(json);
		validate();
	}
	
	public static Continent load(JSONObject json) throws ValidationException{
		return new Continent(json);
	}
		
	@Override
	protected void validate() {
		
	}
	
	// GETTERS & SETTERS
}
