package enterprise.roles.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import enterprise.roles.model.dto.RoleMaster_DTO;

public interface I_RoleMasterPublicRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<RoleMaster_DTO>> getAllRoles();
	public CompletableFuture<CopyOnWriteArrayList<RoleMaster_DTO>> getSelectRoles(CopyOnWriteArrayList<Long> roleSeqNos);
}