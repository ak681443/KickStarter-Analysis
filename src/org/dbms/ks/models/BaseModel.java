package org.dbms.ks.models;

import static org.dbms.ks.models.ColumnConstants.EMPTY_VALUE;

import java.lang.reflect.Field;
import java.util.List;

import org.json.JSONObject;

public abstract class BaseModel {

	JSONObject baseObject;
	
	protected BaseModel(JSONObject json) throws ValidationException {
		baseObject = json;
	//	validateNonNull();
		validate();
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T get(String key, T defaultValue) {
		return (T) (baseObject.has(key) ? baseObject.get(key) : defaultValue);
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T get(String key) {
		return (T) get(key, EMPTY_VALUE);
	}
	
	public JSONObject _getRaw() {
		return baseObject;
	}
	
	@SuppressWarnings("unchecked")
	public <T>T join(Class<? extends BaseModel> schema ) throws Exception {
		return (T)schema.getConstructor(JSONObject.class).newInstance(baseObject);
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
