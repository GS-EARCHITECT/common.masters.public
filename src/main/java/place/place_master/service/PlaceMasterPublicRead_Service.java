package place.place_master.service;

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
import place.place_master.model.dto.PlaceMaster_DTO;
import place.place_master.model.master.PlaceMaster;
import place.place_master.model.repo.PlaceMasterPublicRead_Repo;

@Service("placeMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PlaceMasterPublicRead_Service implements I_PlaceMasterPublicRead_Service 
{

	@Autowired
	private PlaceMasterPublicRead_Repo placeMasterPublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<PlaceMaster_DTO>> getAllPlaces() 
	{
		CompletableFuture<CopyOnWriteArrayList<PlaceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<PlaceMaster> placeList = (CopyOnWriteArrayList<PlaceMaster>) placeMasterPublicReadRepo.getAllPlaces();
			CopyOnWriteArrayList<PlaceMaster_DTO> lMasters = placeList != null ? this.getPlaceMaster_DTOs(placeList) : null;
			return lMasters;
			}, asyncExecutor);
			return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<PlaceMaster_DTO>> getSelectPlaces(CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<CopyOnWriteArrayList<PlaceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<PlaceMaster> lMasters = (CopyOnWriteArrayList<PlaceMaster>) placeMasterPublicReadRepo.getSelectPlaces(ids);
		CopyOnWriteArrayList<PlaceMaster_DTO> placeMaster_DTOs = new CopyOnWriteArrayList<PlaceMaster_DTO>();
		placeMaster_DTOs = lMasters != null ? this.getPlaceMaster_DTOs(lMasters) : null;
		return placeMaster_DTOs;
		}, asyncExecutor);
		return future;
	}
		
	private synchronized CopyOnWriteArrayList<PlaceMaster_DTO> getPlaceMaster_DTOs(CopyOnWriteArrayList<PlaceMaster> lMasters) {
		PlaceMaster_DTO lDTO = null;
		CopyOnWriteArrayList<PlaceMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<PlaceMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getPlaceMasterDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized PlaceMaster_DTO getPlaceMasterDTO(PlaceMaster lMaster) 
	{		
		PlaceMaster_DTO lDTO = new PlaceMaster_DTO();
		lDTO.setRemark(lMaster.getRemark());		
		lDTO.setPlaceSeqNo(lMaster.getPlaceSeqNo());
		lDTO.setPlace(lMaster.getPlace());
		lDTO.setSpatialSeqNo(lMaster.getSpatialSeqNo());		
		lDTO.setStatus(lMaster.getStatus());
		lDTO.setSpecification_seq_no(lMaster.getSpecification_seq_no());
		lDTO.setRemark(lMaster.getRemark());
		return lDTO;
	}

}