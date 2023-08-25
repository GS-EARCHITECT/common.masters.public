package party.party_master.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import party.party_master.model.master.PartyMaster;

@Repository("partyPublicReadRepo")
public interface PartyMasterPublicRead_Repo extends JpaRepository<PartyMaster, Long> 
{}
