package party.party_class.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import party.party_class.model.dto.PartyClassMaster_DTO;

public interface I_PartyClassMasterPublicRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<PartyClassMaster_DTO>> getAllPartyClasses();
	public CompletableFuture<CopyOnWriteArrayList<PartyClassMaster_DTO>> getSelectPartyClasses(CopyOnWriteArrayList<Long> partyClassSeqNos);	
}