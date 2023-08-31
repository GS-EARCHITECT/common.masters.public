package party.party_class.services;

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

import party.party_class.model.dto.PartyClassMaster_DTO;
import party.party_class.model.master.PartyClassMaster;
import party.party_class.model.repo.PartyClassMasterPublicRead_Repo;

@Service("partyClassPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyClassMasterPublicRead_Service implements I_PartyClassMasterPublicRead_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(PartyClassMasterService.class);

	@Autowired
	private PartyClassMasterPublicRead_Repo partyClassPublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	public CompletableFuture<CopyOnWriteArrayList<PartyClassMaster_DTO>> getAllPartyClasses() 
	{
		CompletableFuture<CopyOnWriteArrayList<PartyClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<PartyClassMaster> partyList = partyClassPublicReadRepo.getAllMasters();
		CopyOnWriteArrayList<PartyClassMaster_DTO> cDTOs = partyList != null ? this.getPartyClassMasterDtos(partyList) : null;
		return cDTOs;
   		},asyncExecutor);
		return future;
		
	}

	public CompletableFuture<CopyOnWriteArrayList<PartyClassMaster_DTO>>  getSelectPartyClasses(CopyOnWriteArrayList<Long> partySeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<PartyClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<PartyClassMaster> partyList = partyClassPublicReadRepo.getSelectPartyClassMasters(partySeqNos);
		CopyOnWriteArrayList<PartyClassMaster_DTO> cDTOs = partyList != null ? this.getPartyClassMasterDtos(partyList) : null;
		return cDTOs;
   		},asyncExecutor);
		return future;
	}
	
	private synchronized CopyOnWriteArrayList<PartyClassMaster_DTO> getPartyClassMasterDtos(CopyOnWriteArrayList<PartyClassMaster> cClasss) 
	{
		PartyClassMaster_DTO cDTO = null;
		CopyOnWriteArrayList<PartyClassMaster_DTO> cDTOs = new CopyOnWriteArrayList<PartyClassMaster_DTO>();

		for (int i = 0; i < cClasss.size(); i++) 
		{
			cDTO = this.getPartyClassMaster_DTO(cClasss.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private synchronized PartyClassMaster_DTO getPartyClassMaster_DTO(PartyClassMaster cClass) 
	{
		PartyClassMaster_DTO cDTO = null;
		cDTO = new PartyClassMaster_DTO();
		cDTO.setPartyClass(cClass.getPartyClass());
		cDTO.setPartyClassSeqNo(cClass.getPartyClassSeqNo());
		cDTO.setDescription(cClass.getDescription());
		cDTO.setSpecificationSeqNo(cClass.getSpecificationSeqNo());		
		return cDTO;
	}

}