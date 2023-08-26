package resource.resource_master.service;

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
import resource.resource_master.model.dto.ResourceMaster_DTO;
import resource.resource_master.model.master.ResourceMaster;
import resource.resource_master.model.repo.ResourceMasterPublicRead_Repo;

@Service("resourceMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceMasterPublicRead_Service implements I_ResourceMasterPublicRead_Service 
{

	@Autowired
	private ResourceMasterPublicRead_Repo resourceMasterPublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<ResourceMaster_DTO>> getAllMasterResources() 
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<ResourceMaster> resourceList = (CopyOnWriteArrayList<ResourceMaster>) resourceMasterPublicReadRepo.findAll();
		CopyOnWriteArrayList<ResourceMaster_DTO> lMasterss = resourceList != null ? this.getResourceMaster_DTOs(resourceList) : null;
		return lMasterss;
	}, asyncExecutor);
	return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<ResourceMaster_DTO>> getSelectMasterResources(CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<ResourceMaster> resourceList = (CopyOnWriteArrayList<ResourceMaster>) resourceMasterPublicReadRepo.findAllById(ids);
			CopyOnWriteArrayList<ResourceMaster_DTO> lMasterss = resourceList != null ? this.getResourceMaster_DTOs(resourceList) : null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}
   
	private synchronized CopyOnWriteArrayList<ResourceMaster_DTO> getResourceMaster_DTOs(CopyOnWriteArrayList<ResourceMaster> lMasters) 
	{
		ResourceMaster_DTO lDTO = null;
		CopyOnWriteArrayList<ResourceMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<ResourceMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getResourceMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourceMaster_DTO getResourceMaster_DTO(ResourceMaster lMaster) 
	{		
		ResourceMaster_DTO lDTO = new ResourceMaster_DTO();
		lDTO.setDescription(lMaster.getDescription());		
		lDTO.setMasterResourceSeqNo(lMaster.getMasterResourceSeqNo());
		lDTO.setResourceName(lMaster.getResourceName());
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());				
		return lDTO;
	}
	
}