package place.place_class.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import place.place_class.model.master.PlaceClassMaster;

@Repository("placeClassMasterPublicReadRepo")
public interface PlaceClassMasterPublicRead_Repo extends JpaRepository<PlaceClassMaster, Long> 
{
	@Query(value = "SELECT * FROM Place_Class_Master a order by a.place_class_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PlaceClassMaster> getAllPlaceClasses();
	
}
