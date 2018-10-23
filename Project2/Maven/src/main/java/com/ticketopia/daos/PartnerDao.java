package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.Partner;

public interface PartnerDao {
	
	//Insert a new partner into the database.
	public boolean insertNewPartner(Partner partner);
	
	//Remove a partner from the database
	public boolean removePartnerById(Partner partner);
	
	//Update a partner in the database
	public boolean updatePartner(Partner partner);
	
	public List<Partner> getAllPartner();
}
