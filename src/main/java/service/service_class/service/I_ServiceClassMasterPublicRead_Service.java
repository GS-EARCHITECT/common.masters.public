package service.service_class.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import service.service_class.model.dto.ServiceClassMaster_DTO;

public interface I_ServiceClassMasterPublicRead_Service
{
    abstract public CompletableFuture<CopyOnWriteArrayList<ServiceClassMaster_DTO>> getAllServiceClasses();    
    abstract public CompletableFuture<CopyOnWriteArrayList<ServiceClassMaster_DTO>> getSelectServiceClasses(CopyOnWriteArrayList<Long> ids);
}