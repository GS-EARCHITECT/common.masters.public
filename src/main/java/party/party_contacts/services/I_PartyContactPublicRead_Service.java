package party.party_contacts.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import party.party_contacts.model.dto.PartyContact_DTO;

public interface I_PartyContactPublicRead_Service
{
    public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getAllPartyContacts();
    public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartyContacts(CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartyContactsBetweenTimes(CopyOnWriteArrayList<Long> ids, String frDtTm, String toDtTm);
    public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartiesByMobiles(CopyOnWriteArrayList<Long> mbs);
    public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartiesByEmail(String eid);
    public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartiesByLandlines(CopyOnWriteArrayList<Long> lls);
}



