package party.party_class.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import party.party_class.model.master.PartyClassMaster;

@Repository("compClassPublicReadRepo")
public interface PartyClassMasterPublicRead_Repo extends JpaRepository<PartyClassMaster, Long> 
{
	@Query(value = "select * from PARTY_CLASS_MASTER ORDER BY PARTY_CLASS_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PartyClassMaster> getAllMasters();

	@Query(value = "select * from PARTY_CLASS_MASTER where PARTY_CLASS_SEQ_NO in :ids ORDER BY MASTER_PARTY_CLASS_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PartyClassMaster> getSelectPartyClassMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
}
