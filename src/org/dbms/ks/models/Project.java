package org.dbms.ks.models;

import static org.dbms.ks.models.ColumnConstants.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dbms.ks.util.DBUtil;
import org.dbms.ks.util.DBUtil.DBConnection;
import org.json.JSONObject;

public class Project extends BaseModel{

	private Project(JSONObject json) throws ValidationException{
		super(json);
		validate();
	}
	
	public static Project load(JSONObject json) throws ValidationException{
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
			location = DBUtil.getFirst("get.location", Location.class, get(PROJ_LOCATION_ID, -1));
		}
		return location;
	}
	
	Owner owner = null;
	public Owner getOwner() {
		if(owner == null){
			owner = DBUtil.getFirst("get.owner", Location.class, get(PROJ_OWNER_ID, -1));
		}
		return owner;
	}
	
	ArrayList<Project> nearbyProjects = null;
	public List<Project> getNearbyProjects() {
		if(nearbyProjects == null) {
			nearbyProjects = new ArrayList<>();
			DBConnection con = null;
			try {
				con = DBUtil.getConnection();
				con.prepareQuery("get.nearby.projects")
					.setQueryParam(1, getLocation().getLatitude())
					.setQueryParam(2, getLocation().getLatitude())
					.setQueryParam(3, getLocation().getLongitude())
					.setQueryParam(4, getLocation().getLatitude() - 3)
					.setQueryParam(5, getLocation().getLatitude() + 3)
					.setQueryParam(6, getLocation().getCountryCode())
					.setQueryParam(7, getID())
					.executeQuery();
				
				while(con.hasNext()) {
					nearbyProjects.add(con.getNext(Project.class));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(con != null) con.safeClose();
			}
		}
		
		return nearbyProjects;
	}

	ArrayList<Project> similarProjects = null;
	public List<Project> getSimilarProjects() {
		if(similarProjects == null) {
			similarProjects = new ArrayList<>();
			DBConnection con = null;
			try {
				con = DBUtil.getConnection();
				con.prepareQuery("get.similar.projects")
					.setQueryParam(1, getLocation().getID())
					.setQueryParam(2, getLocation().getID())
					.executeQuery();
				
				while(con.hasNext()) {
					similarProjects.add(con.getNext(Project.class));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(con != null) con.safeClose();
			}
		}
		return similarProjects;
	}
}
