package org.dbms.ks.models;

import java.lang.reflect.Field;
import java.util.List;

import org.json.JSONObject;

public abstract class BaseModel {

	JSONObject baseObject;
	
	protected BaseModel(String json) throws ValidationException {
		baseObject = new JSONObject(json);
	//	validateNonNull();
		validate();
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T get(String key, T defaultValue) {
		return (T) baseObject.get(key);
	}
	
	public JSONObject _getRaw() {
		return baseObject;
	}

	@SuppressWarnings("serial")
	public class ValidationException extends Exception{
		public ValidationException(String message) {
			super(message);
		}
	}
	
	protected abstract void validate() throws ValidationException;
	
	@SuppressWarnings("unused")
	private void validateNonNull() throws ValidationException {
		for(Field f : this.getClass().getDeclaredFields()) {
			if(f.getName().equals("VALIDATION_LIST")) {
				try {
					f.setAccessible(true);
					@SuppressWarnings("unchecked")
					List<String> nonNullList = (List<String>)f.get(null);
					for(String field : nonNullList) {
						if(! baseObject.has(field)) {
							throw new ValidationException("{" + field + "} is not present in model {" + getClass().getName() +"}");
						}
					}
				} catch (Exception e) {
					//TODO Log
				}
				break;
			}
		}
	}
}
