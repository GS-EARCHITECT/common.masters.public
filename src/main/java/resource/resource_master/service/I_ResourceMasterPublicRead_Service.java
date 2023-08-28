package resource.resource_master.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import resource.resource_master.model.dto.ResourceMaster_DTO;

public interface I_ResourceMasterPublicRead_Service
{
    abstract public CompletableFuture<CopyOnWriteArrayList<ResourceMaster_DTO>> getAllMasterResources();    
    abstract public CompletableFuture<CopyOnWriteArrayList<ResourceMaster_DTO>> getSelectMasterResources(CopyOnWriteArrayList<Long> ids);
    abstract public CompletableFuture<CopyOnWriteArrayList<ResourceMaster_DTO>> getSelectResourcesByOEMs(CopyOnWriteArrayList<Long> ids);
}