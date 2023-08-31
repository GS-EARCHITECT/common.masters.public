package enterprise.roles.services;

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
import enterprise.roles.model.dto.RoleMaster_DTO;
import enterprise.roles.model.master.RoleMaster;
import enterprise.roles.model.repo.RoleMasterPublicRead_Repo;

@Service("roleMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class RoleMasterPublicRead_Service implements I_RoleMasterPublicRead_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(RoleMasterService.class);

	@Autowired
	private RoleMasterPublicRead_Repo roleMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;
	
	public CompletableFuture<CopyOnWriteArrayList<RoleMaster_DTO>> getAllRoles() 
	{
		CompletableFuture<CopyOnWriteArrayList<RoleMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<RoleMaster> dList = roleMasterPublicReadRepo.getAllMasters();
		CopyOnWriteArrayList<RoleMaster_DTO> cDTOs = dList != null ? this.getRoleMasterDtos(dList) : null;
		return cDTOs;
   		},asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<RoleMaster_DTO>> getSelectRoles(CopyOnWriteArrayList<Long> roleSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<RoleMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<RoleMaster> dList = roleMasterPublicReadRepo.getSelectRoleMasters(roleSeqNos);
		CopyOnWriteArrayList<RoleMaster_DTO> cDTOs = dList != null ? this.getRoleMasterDtos(dList) : null;
		return cDTOs;
   		},asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<RoleMaster_DTO> getRoleMasterDtos(CopyOnWriteArrayList<RoleMaster> cMasters) 
	{
		RoleMaster_DTO cDTO = null;
		CopyOnWriteArrayList<RoleMaster_DTO> cDTOs = new CopyOnWriteArrayList<RoleMaster_DTO>();

		for (int i = 0; i < cMasters.size(); i++) 
		{
			cDTO = this.getRoleMaster_DTO(cMasters.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private synchronized RoleMaster_DTO getRoleMaster_DTO(RoleMaster cMaster) {
		RoleMaster_DTO cDTO = null;
		cDTO = new RoleMaster_DTO();
		cDTO.setMasterRoleSeqNo(cMaster.getMasterRoleSeqNo());
		cDTO.setRole(cMaster.getRole());		
		cDTO.setRemark(cMaster.getRemark());
		cDTO.setSpecificationSeqNo(cMaster.getSpecificationSeqNo());
		return cDTO;
	}


}