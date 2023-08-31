package enterprise.designations.services;

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
import enterprise.designations.model.dto.DesignationMaster_DTO;
import enterprise.designations.model.master.DesignationMaster;
import enterprise.designations.model.repo.DesignationMasterPublicRead_Repo;

@Service("designationMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class DesignationMasterPublicRead_Service implements I_DesignationMasterPublicRead_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(DesignationMasterService.class);

	@Autowired
	private DesignationMasterPublicRead_Repo designationMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;
	
	public CompletableFuture<CopyOnWriteArrayList<DesignationMaster_DTO>> getAllDesignations() 
	{
		CompletableFuture<CopyOnWriteArrayList<DesignationMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<DesignationMaster> dList = designationMasterPublicReadRepo.getAllMasters();
		CopyOnWriteArrayList<DesignationMaster_DTO> cDTOs = dList != null ? this.getDesignationMasterDtos(dList) : null;
		return cDTOs;
   		},asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<DesignationMaster_DTO>> getSelectDesignations(CopyOnWriteArrayList<Long> designationSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<DesignationMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<DesignationMaster> dList = designationMasterPublicReadRepo.getSelectDesignationMasters(designationSeqNos);
		CopyOnWriteArrayList<DesignationMaster_DTO> cDTOs = dList != null ? this.getDesignationMasterDtos(dList) : null;
		return cDTOs;
   		},asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<DesignationMaster_DTO> getDesignationMasterDtos(CopyOnWriteArrayList<DesignationMaster> cMasters) 
	{
		DesignationMaster_DTO cDTO = null;
		CopyOnWriteArrayList<DesignationMaster_DTO> cDTOs = new CopyOnWriteArrayList<DesignationMaster_DTO>();

		for (int i = 0; i < cMasters.size(); i++) 
		{
			cDTO = this.getDesignationMaster_DTO(cMasters.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private synchronized DesignationMaster_DTO getDesignationMaster_DTO(DesignationMaster cMaster) {
		DesignationMaster_DTO cDTO = null;
		cDTO = new DesignationMaster_DTO();
		cDTO.setMasterDesignationSeqNo(cMaster.getMasterDesignationSeqNo());
		cDTO.setDesignation(cMaster.getDesignation());		
		cDTO.setRemark(cMaster.getRemark());
		cDTO.setSpecificationSeqNo(cMaster.getSpecificationSeqNo());
		return cDTO;
	}


}