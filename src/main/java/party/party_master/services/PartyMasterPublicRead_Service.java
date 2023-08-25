package party.party_master.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import party.party_master.model.dto.PartyMaster_DTO;
import party.party_master.model.master.PartyMaster;
import party.party_master.model.repo.PartyMasterPublicRead_Repo;

@Service("partyPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyMasterPublicRead_Service implements I_PartyMasterPublicRead_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(PartyMasterService.class);

	@Autowired
	private PartyMasterPublicRead_Repo partyPublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<PartyMaster_DTO>> getAllParties() 
	{
		CompletableFuture<CopyOnWriteArrayList<PartyMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<PartyMaster> partyList = (CopyOnWriteArrayList<PartyMaster>) partyPublicReadRepo.findAll();
		CopyOnWriteArrayList<PartyMaster_DTO> cDTOs = new CopyOnWriteArrayList<PartyMaster_DTO>();
		cDTOs = partyList != null ? this.getPartyMasterDtos(partyList) : null;
		return cDTOs;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<PartyMaster_DTO>> getSelectParties(CopyOnWriteArrayList<Long> partySeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<PartyMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<PartyMaster_DTO> cDTOs = new CopyOnWriteArrayList<PartyMaster_DTO>();
		CopyOnWriteArrayList<PartyMaster> partyMasters = (CopyOnWriteArrayList<PartyMaster>) partyPublicReadRepo.findAllById(partySeqNos);
		cDTOs = partyMasters != null ? this.getPartyMasterDtos(partyMasters) : null;
		return cDTOs;
		}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<PartyMaster_DTO> getPartyMasterDtos(CopyOnWriteArrayList<PartyMaster> cMasters) {
		PartyMaster_DTO cDTO = null;
		CopyOnWriteArrayList<PartyMaster_DTO> cDTOs = new CopyOnWriteArrayList<PartyMaster_DTO>();

		for (int i = 0; i < cMasters.size(); i++) 
		{
			cDTO = this.getPartyMaster_DTO(cMasters.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private synchronized PartyMaster_DTO getPartyMaster_DTO(PartyMaster cMaster) {
		PartyMaster_DTO cDTO = null;
		cDTO = new PartyMaster_DTO();
		cDTO.setPartySeqNo(cMaster.getPartySeqNo());
		cDTO.setParty(cMaster.getParty());
		cDTO.setPartyId(cMaster.getPartyId());			
		cDTO.setRemark(cMaster.getRemark());
		cDTO.setStatus(cMaster.getStatus());
		return cDTO;
	}

}