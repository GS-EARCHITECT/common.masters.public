package place.place_class.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import place.place_class.model.master.PlaceClassMaster;

@Repository("placeClassMasterPublicReadRepo")
public interface PlaceClassMasterPublicRead_Repo extends JpaRepository<PlaceClassMaster, Long> 
{}
