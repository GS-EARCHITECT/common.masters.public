package place.place_master.service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import place.place_master.model.dto.PlaceMaster_DTO;

public interface I_PlaceMasterPublicRead_Service
{
    abstract public CompletableFuture<CopyOnWriteArrayList<PlaceMaster_DTO>> getAllPlaces();    
    abstract public CompletableFuture<CopyOnWriteArrayList<PlaceMaster_DTO>> getSelectPlaces(CopyOnWriteArrayList<Long> ids);    
}