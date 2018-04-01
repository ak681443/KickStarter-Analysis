package org.dbms.ks.models;

public class Continent extends BaseModel{

	private Continent(String json) throws ValidationException{
		super(json);
		validate();
	}
	
	public static Continent load(String json) throws ValidationException{
		return new Continent(json);
	}
		
	@Override
	protected void validate() {
		
	}
	
	// GETTERS & SETTERS
}
