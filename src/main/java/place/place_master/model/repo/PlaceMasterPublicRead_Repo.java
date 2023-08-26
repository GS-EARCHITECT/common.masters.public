package place.place_master.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import place.place_master.model.master.PlaceMaster;

@Repository("placeMasterPublicReadRepo")
public interface PlaceMasterPublicRead_Repo extends JpaRepository<PlaceMaster, Long> 
{}