package party.party_master.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import party.party_master.model.dto.PartyMaster_DTO;

public interface I_PartyMasterPublicRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<PartyMaster_DTO>> getAllParties();
	public CompletableFuture<CopyOnWriteArrayList<PartyMaster_DTO>> getSelectParties(CopyOnWriteArrayList<Long> partySeqNos);
}