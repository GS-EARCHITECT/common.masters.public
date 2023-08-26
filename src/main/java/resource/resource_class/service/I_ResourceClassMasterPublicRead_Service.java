package resource.resource_class.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import resource.resource_class.model.dto.ResourceClassMaster_DTO;

public interface I_ResourceClassMasterPublicRead_Service
{
    abstract public CompletableFuture<CopyOnWriteArrayList<ResourceClassMaster_DTO>> getAllResourceClasses();    
    abstract public CompletableFuture<CopyOnWriteArrayList<ResourceClassMaster_DTO>> getSelectResourceClasses(CopyOnWriteArrayList<Long> ids);
}