package place.place_class.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import place.place_class.model.dto.PlaceClassMaster_DTO;

public interface I_PlaceClassMasterPublicRead_Service
{
    abstract public CompletableFuture<CopyOnWriteArrayList<PlaceClassMaster_DTO>> getAllPlaceClasses();    
    abstract public CompletableFuture<CopyOnWriteArrayList<PlaceClassMaster_DTO>> getSelectPlaceClasses(CopyOnWriteArrayList<Long> ids);
}