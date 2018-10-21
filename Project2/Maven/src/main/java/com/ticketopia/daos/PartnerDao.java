package com.ticketopia.daos;

import com.ticketopia.beans.Partner;

public interface PartnerDao {
	
	//Insert a new partner into the database.
	public boolean insertNewPartner(Partner partner);
	
	//Remove a partner from the database
	public boolean removePartnerById(Integer id);
	
	//Update a partner in the database
	public boolean updatePartner(Partner partner);
}
