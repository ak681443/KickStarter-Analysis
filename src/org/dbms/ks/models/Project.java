package org.dbms.ks.models;

import static org.dbms.ks.models.ColumnConstants.*;

import java.util.Date;

import org.dbms.ks.util.DBUtil;

public class Project extends BaseModel{

	private Project(String json) throws ValidationException{
		super(json);
		validate();
	}
	
	public static Project load(String json) throws ValidationException{
		return new Project(json);
	}
	
	public static Project fetch(int projectId) {
		return DBUtil.getFirst("get.project", Project.class, projectId);
	}
		
	@Override
	protected void validate() {
		
	}
	
	// GETTERS & SETTERS
	public int getID() {
		return get(PROJ_ID, -1);
	}
	
	public String getName() {
		return get(PROJ_NAME);
	}
	
	public String getBlurb() {
		return get(PROJ_BLURB);
	}
	
	public String getPhoto() {
		return get(PROJ_PHOTO);
	}
	
	public int getCurrency() {
		return get(PROJ_CURRENCY, 0);
	}
	
	@SuppressWarnings("deprecation")
	public Date getLaunchDate() {
		String date = get(PROJ_LAUNCH_DATE);
		return new Date(Date.parse(date));
	}

	@SuppressWarnings("deprecation")
	public Date getDeadline() {
		String date = get(PROJ_DEADLINE);
		return new Date(Date.parse(date));
	}
		
	public boolean isSuccessfull() {
		return get(PROJ_STATUS).equals("successfull");
	}
	
	public int getGoal() {
		return get(PROJ_GOAL, 0);
	}
	
	public int getPledged() {
		return get(PROJ_MONEY_PLEDGED, 0);
	}
	
	public int getPledgedUSD() {
		return get(PROJ_MONEY_PLEDGED_USD, 0);
	}
	
	Location location = null;
	public Location getLocation() {
		if(location == null){
			location = DBUtil.getFirst("get.location", Location.class, get(PROJ_LOCATION_ID));
		}
		return location;
	}
	
	// add owner & sub category
}
