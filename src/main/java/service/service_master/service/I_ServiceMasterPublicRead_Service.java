package service.service_master.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import service.service_master.model.dto.ServiceMaster_DTO;

public interface I_ServiceMasterPublicRead_Service
{
    abstract public CompletableFuture<CopyOnWriteArrayList<ServiceMaster_DTO>> getAllServiceMasters();    
    abstract public CompletableFuture<CopyOnWriteArrayList<ServiceMaster_DTO>> getSelectServices(CopyOnWriteArrayList<Long> ids);
}