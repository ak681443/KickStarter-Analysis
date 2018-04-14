package org.dbms.ks.models;
import static org.dbms.ks.models.ColumnConstants.*;


public class Location extends BaseModel{
	
	protected Location(String json) throws ValidationException {
		super(json);
	}

	@Override
	protected void validate() throws ValidationException {
		//TODO validate
	}
	
	public static Location load(String json) throws ValidationException{
		return new Location(json);
	}
	
	// GETTERS AND SETTERS
	public int getID() {
		return get(LOC_ID, -1);
	}
	
	public String getName() {
		return get(LOC_NAME);
	}
	
	public String getSlug() {
		return get(LOC_SLUG);
	}
	
	public String getType() {
		return get(LOC_TYPE);
	}
	
	public String getCountryCode() {
		return get(LOC_COUNTRY_CODE);
	}
	
	public String getShortName() {
		return get(LOC_SHORT_NAME);
	}
	
	public String getDisplayableName() {
		return get(LOC_DISPLAYABLE_NAME);
	}
	
	public String getLocalizedName() {
		return get(LOC_LOCALIZED_NAME);
	}
}
