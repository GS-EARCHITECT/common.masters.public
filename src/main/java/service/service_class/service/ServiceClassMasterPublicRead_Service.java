package service.service_class.service;

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
import service.service_class.model.dto.ServiceClassMaster_DTO;
import service.service_class.model.master.ServiceClassMaster;
import service.service_class.model.repo.ServiceClassMasterPublicRead_Repo;

@Service("serviceClassMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ServiceClassMasterPublicRead_Service implements I_ServiceClassMasterPublicRead_Service {

	@Autowired
	private ServiceClassMasterPublicRead_Repo serviceClassMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<ServiceClassMaster_DTO>> getAllServiceClasses() {
		CompletableFuture<CopyOnWriteArrayList<ServiceClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<ServiceClassMaster> serviceList = (CopyOnWriteArrayList<ServiceClassMaster>) serviceClassMasterPublicReadRepo
					.getAllServiceClasses();
			CopyOnWriteArrayList<ServiceClassMaster_DTO> lMasters = serviceList != null
					? this.getServiceClassMaster_DTOs(serviceList)
					: null;
			return lMasters;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<ServiceClassMaster_DTO>> getSelectServiceClasses(
			CopyOnWriteArrayList<Long> ids) {

		CompletableFuture<CopyOnWriteArrayList<ServiceClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<ServiceClassMaster> serviceList = (CopyOnWriteArrayList<ServiceClassMaster>) serviceClassMasterPublicReadRepo
					.findAllById(ids);
			CopyOnWriteArrayList<ServiceClassMaster_DTO> lMasters = serviceList != null
					? this.getServiceClassMaster_DTOs(serviceList)
					: null;
			return lMasters;
		}, asyncExecutor);
		return future;
	}

	private CopyOnWriteArrayList<ServiceClassMaster_DTO> getServiceClassMaster_DTOs(
			CopyOnWriteArrayList<ServiceClassMaster> lMasters) {
		ServiceClassMaster_DTO lDTO = null;
		CopyOnWriteArrayList<ServiceClassMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<ServiceClassMaster_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getServiceClassMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ServiceClassMaster_DTO getServiceClassMaster_DTO(ServiceClassMaster lMaster) {
		ServiceClassMaster_DTO lDTO = new ServiceClassMaster_DTO();
		lDTO.setRemark(lMaster.getRemark());
		lDTO.setServiceClassSeqNo(lMaster.getServiceClassSeqNo());
		lDTO.setServiceClass(lMaster.getServiceClass());
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());
		lDTO.setDescription(lMaster.getDescription());
		lDTO.setStatus(lMaster.getStatus());
		return lDTO;
	}

}