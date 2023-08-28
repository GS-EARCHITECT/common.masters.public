package party.party_contacts.model.repo;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import party.party_contacts.model.master.PartyContact;
import party.party_contacts.model.master.PartyContactPK;

@Repository("partyContactPublicReadRepo")
public interface PartyContactPublicRead_Repo extends JpaRepository<PartyContact, PartyContactPK> 
{

	@Query(value = "SELECT * FROM Party_Contacts a order by a.party_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PartyContact> getAllPartyContacts();
	
	@Query(value = "SELECT * FROM Party_Contacts a WHERE ((a.party_SEQ_NO in :ids) and (a.ON_DTTM BETWEEN :frDtTm  and :toDtTm)) order by a.party_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PartyContact> getSelectPartyContactsBetweenTimes(@Param("ids") CopyOnWriteArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Query(value = "SELECT * FROM Party_Contacts a WHERE a.party_SEQ_NO in :ids order by party_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PartyContact> getSelectPartyContacts(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * FROM Party_Contacts a WHERE MOBILE_NO in :mbs order by party_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PartyContact> getSelectPartiesByMobiles(@Param("mbs") CopyOnWriteArrayList<Long> mbs);

	@Query(value = "SELECT * FROM Party_Contacts a WHERE upper(trim(a.email_id)) = upper(trim(:eid)) order by party_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PartyContact> getSelectPartiesByEmail(@Param("eid") String eid);
	
	@Query(value = "SELECT * FROM Party_Contacts a WHERE a.landline in :lls order by party_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PartyContact> getSelectPartiesByLandlines(@Param("lls") CopyOnWriteArrayList<Long> lls);
}
