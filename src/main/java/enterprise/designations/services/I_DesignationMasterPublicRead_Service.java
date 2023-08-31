package enterprise.designations.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import enterprise.designations.model.dto.DesignationMaster_DTO;

public interface I_DesignationMasterPublicRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<DesignationMaster_DTO>> getAllDesignations();
	public CompletableFuture<CopyOnWriteArrayList<DesignationMaster_DTO>> getSelectDesignations(CopyOnWriteArrayList<Long> designationSeqNos);
}