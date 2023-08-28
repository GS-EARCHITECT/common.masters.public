package resource.resource_class.service;

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
import resource.resource_class.model.dto.ResourceClassMaster_DTO;
import resource.resource_class.model.master.ResourceClassMaster;
import resource.resource_class.model.repo.ResourceClassMasterPublicRead_Repo;

@Service("resourceClassMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceClassMasterPublicRead_Service implements I_ResourceClassMasterPublicRead_Service 
{

	@Autowired
	private ResourceClassMasterPublicRead_Repo resourceClassMasterPublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<ResourceClassMaster_DTO>> getAllResourceClasses()
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<ResourceClassMaster> resourceList = (CopyOnWriteArrayList<ResourceClassMaster>) resourceClassMasterPublicReadRepo.getAllResourceClasses();
		CopyOnWriteArrayList<ResourceClassMaster_DTO> lMasters = new CopyOnWriteArrayList<ResourceClassMaster_DTO>();
		lMasters = resourceList != null ? this.getResourceClassMaster_DTOs(resourceList) : null;
		return lMasters;
		}, asyncExecutor);
		return future;

	}

	public CompletableFuture<CopyOnWriteArrayList<ResourceClassMaster_DTO>> getSelectResourceClasses(CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<CopyOnWriteArrayList<ResourceClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<ResourceClassMaster> resourceList = (CopyOnWriteArrayList<ResourceClassMaster>) resourceClassMasterPublicReadRepo.getSelectResourceClasses(ids);
		CopyOnWriteArrayList<ResourceClassMaster_DTO> lMasters = new CopyOnWriteArrayList<ResourceClassMaster_DTO>();
		lMasters = resourceList != null ? this.getResourceClassMaster_DTOs(resourceList) : null;
		return lMasters;
	}, asyncExecutor);
	return future;
	}
	
	private synchronized CopyOnWriteArrayList<ResourceClassMaster_DTO> getResourceClassMaster_DTOs(CopyOnWriteArrayList<ResourceClassMaster> lMasters) {
		ResourceClassMaster_DTO lDTO = null;
		CopyOnWriteArrayList<ResourceClassMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<ResourceClassMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getResourceClassMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized ResourceClassMaster_DTO getResourceClassMaster_DTO(ResourceClassMaster lMaster) 
	{		
		ResourceClassMaster_DTO lDTO = new ResourceClassMaster_DTO();
		lDTO.setRemark(lMaster.getRemark());		
		lDTO.setResourceClassSeqNo(lMaster.getResourceClassSeqNo());
		lDTO.setResourceClass(lMaster.getResourceClass());
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());				
		lDTO.setDescription(lMaster.getDescription());
		lDTO.setStatus(lMaster.getStatus());		
		return lDTO;
	}

	private ResourceClassMaster setResourceClassMaster(ResourceClassMaster_DTO lDTO) {
		ResourceClassMaster lMaster = new ResourceClassMaster();				
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setSpecificationSeqNo(lDTO.getSpecificationSeqNo());				
		lMaster.setDescription(lDTO.getDescription());
		lMaster.setStatus(lDTO.getStatus());
		lMaster.setResourceClass(lDTO.getResourceClass());		
		return lMaster;
	}
}