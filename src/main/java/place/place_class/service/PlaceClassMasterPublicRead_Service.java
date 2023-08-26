package place.place_class.service;

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
import place.place_class.model.dto.PlaceClassMaster_DTO;
import place.place_class.model.master.PlaceClassMaster;
import place.place_class.model.repo.PlaceClassMasterPublicRead_Repo;

@Service("placeClassMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PlaceClassMasterPublicRead_Service implements I_PlaceClassMasterPublicRead_Service 
{

	@Autowired
	private PlaceClassMasterPublicRead_Repo placeClassMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;
	
	public CompletableFuture<CopyOnWriteArrayList<PlaceClassMaster_DTO>> getAllPlaceClasses() 
	{
		CompletableFuture<CopyOnWriteArrayList<PlaceClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<PlaceClassMaster> placeList = (CopyOnWriteArrayList<PlaceClassMaster>) placeClassMasterPublicReadRepo.findAll();
		CopyOnWriteArrayList<PlaceClassMaster_DTO> lMasters = placeList != null ? this.getPlaceClassMaster_DTOs(placeList) : null;
		return lMasters;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<PlaceClassMaster_DTO>> getSelectPlaceClasses(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<PlaceClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<PlaceClassMaster> lMasters = (CopyOnWriteArrayList<PlaceClassMaster>) placeClassMasterPublicReadRepo.findAllById(ids);
		CopyOnWriteArrayList<PlaceClassMaster_DTO> placeClassMasterDTOs = lMasters != null ? this.getPlaceClassMaster_DTOs(lMasters) : null;
		return placeClassMasterDTOs;
		}, asyncExecutor);
		return future;
	}
	
	private synchronized CopyOnWriteArrayList<PlaceClassMaster_DTO> getPlaceClassMaster_DTOs(CopyOnWriteArrayList<PlaceClassMaster> lMasters) {
		PlaceClassMaster_DTO lDTO = null;
		CopyOnWriteArrayList<PlaceClassMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<PlaceClassMaster_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getPlaceClassMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized PlaceClassMaster_DTO getPlaceClassMaster_DTO(PlaceClassMaster lMaster) {
		PlaceClassMaster_DTO lDTO = new PlaceClassMaster_DTO();
		lDTO.setPlaceClassSeqNo(lMaster.getPlaceClassSeqNo());
		lDTO.setPlaceClass(lMaster.getPlaceClass());
		return lDTO;
	}

}