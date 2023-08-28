package party.party_master.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import party.party_master.model.master.PartyMaster;

@Repository("partyPublicReadRepo")
public interface PartyMasterPublicRead_Repo extends JpaRepository<PartyMaster, Long> 
{
	@Query(value = "SELECT * FROM Party_Master a order by a.party_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PartyMaster> getAllParties();
	
	@Query(value = "SELECT * FROM Party_Master a where party_seq_no in :ids order by a.party_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PartyMaster> getSelectParties(@Param("ids") CopyOnWriteArrayList<Long> ids);;	

}
