package service.service_master.service;

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
import service.service_master.model.dto.ServiceMaster_DTO;
import service.service_master.model.master.ServiceMaster;
import service.service_master.model.repo.ServiceMasterPublicRead_Repo;

@Service("serviceMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceMasterPublicRead_Service implements I_ServiceMasterPublicRead_Service 
{

	@Autowired
	private ServiceMasterPublicRead_Repo serviceMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;
	
	public CompletableFuture<CopyOnWriteArrayList<ServiceMaster_DTO>> getAllServiceMasters() 
	{
		CompletableFuture<CopyOnWriteArrayList<ServiceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ServiceMaster> serviceList = (CopyOnWriteArrayList<ServiceMaster>) serviceMasterPublicReadRepo.getAllServices();		
		CopyOnWriteArrayList<ServiceMaster_DTO> lMasterss = serviceList != null ? this.getServiceMaster_DTOs(serviceList) : null;
		return lMasterss;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<ServiceMaster_DTO>> getSelectServices(CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<CopyOnWriteArrayList<ServiceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<ServiceMaster> serviceList = (CopyOnWriteArrayList<ServiceMaster>) serviceMasterPublicReadRepo.findAllById(ids);		
		CopyOnWriteArrayList<ServiceMaster_DTO> lMasterss = serviceList != null ? this.getServiceMaster_DTOs(serviceList) : null;
		return lMasterss;
		}, asyncExecutor);
		return future;
		}
   
	private CopyOnWriteArrayList<ServiceMaster_DTO> getServiceMaster_DTOs(CopyOnWriteArrayList<ServiceMaster> lMasters) {
		ServiceMaster_DTO lDTO = null;
		CopyOnWriteArrayList<ServiceMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<ServiceMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceMaster_DTO getServiceMaster_DTO(ServiceMaster lMaster) 
	{		
		ServiceMaster_DTO lDTO = new ServiceMaster_DTO();
		lDTO.setMasterServiceSeqNo(lMaster.getMasterServiceSeqNo());		
		lDTO.setDescription(lMaster.getDescription());
		lDTO.setService(lMaster.getService());
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());
		return lDTO;
	}

}