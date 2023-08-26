package party.party_contacts.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import party.party_contacts.model.dto.PartyContact_DTO;
import party.party_contacts.model.master.PartyContact;
import party.party_contacts.model.repo.PartyContactPublicRead_Repo;

@Service("partyContactPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyContactPublicRead_Service implements I_PartyContactPublicRead_Service {

	@Autowired
	private PartyContactPublicRead_Repo partyContactPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getAllPartyContacts() 
	{
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<PartyContact> supplierList = (CopyOnWriteArrayList<PartyContact>) partyContactPublicReadRepo
					.getAllPartyContacts();
			CopyOnWriteArrayList<PartyContact_DTO> lPartyContacts = new CopyOnWriteArrayList<PartyContact_DTO>();
			lPartyContacts = supplierList != null ? this.getPartyContact_DTOs(supplierList) : null;
			return lPartyContacts;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartyContactsBetweenTimes(
			CopyOnWriteArrayList<Long> ids, String frDtTm, String toDtTm) {
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> future = CompletableFuture.supplyAsync(() -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
			LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
			Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
			Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);
			CopyOnWriteArrayList<PartyContact> partyContacts = partyContactPublicReadRepo
					.getSelectPartyContactsBetweenTimes(ids, frTsTimestamp, toTsTimestamp);
			CopyOnWriteArrayList<PartyContact_DTO> partyContactDTOs = partyContacts != null
					? this.getPartyContact_DTOs(partyContacts)
					: null;
			return partyContactDTOs;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartyContacts(
			CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<PartyContact> lPartyContact = partyContactPublicReadRepo.getSelectPartyContacts(ids);
			CopyOnWriteArrayList<PartyContact_DTO> partyContactDTOs = lPartyContact != null
					? this.getPartyContact_DTOs(lPartyContact)
					: null;
			return partyContactDTOs;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartiesByLandlines(
			CopyOnWriteArrayList<Long> lls) {
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<PartyContact> lPartyContact = partyContactPublicReadRepo
					.getSelectPartiesByLandlines(lls);
			CopyOnWriteArrayList<PartyContact_DTO> partyContactDTOs = lPartyContact != null
					? this.getPartyContact_DTOs(lPartyContact)
					: null;
			return partyContactDTOs;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartiesByEmail(String eid) {
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<PartyContact> lPartyContact = partyContactPublicReadRepo.getSelectPartiesByEmail(eid);
			CopyOnWriteArrayList<PartyContact_DTO> partyContactDTOs = lPartyContact != null
					? this.getPartyContact_DTOs(lPartyContact)
					: null;
			return partyContactDTOs;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartiesByMobiles(
			CopyOnWriteArrayList<Long> mbs) {
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<PartyContact> lPartyContact = partyContactPublicReadRepo
					.getSelectPartiesByMobiles(mbs);
			CopyOnWriteArrayList<PartyContact_DTO> partyContactDTOs = lPartyContact != null
					? this.getPartyContact_DTOs(lPartyContact)
					: null;
			return partyContactDTOs;
		}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<PartyContact_DTO> getPartyContact_DTOs(
			CopyOnWriteArrayList<PartyContact> lPartyContact) {
		PartyContact_DTO lDTO = null;
		CopyOnWriteArrayList<PartyContact_DTO> lPartyContact_DTOs = new CopyOnWriteArrayList<PartyContact_DTO>();
		for (int i = 0; i < lPartyContact.size(); i++) {
			lDTO = getPartyContact_DTO(lPartyContact.get(i));
			lPartyContact_DTOs.add(lDTO);
		}
		return lPartyContact_DTOs;
	}

	private synchronized PartyContact_DTO getPartyContact_DTO(PartyContact lPartyContact) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		PartyContact_DTO lDTO = new PartyContact_DTO();
		lDTO.setOnDttm(formatter.format(lPartyContact.getId().getOnDttm().toLocalDateTime()));
		lDTO.setPartySeqNo(lPartyContact.getId().getPartySeqNo());
		lDTO.setEmailId(lPartyContact.getId().getEmailId());
		lDTO.setLandline(lPartyContact.getId().getLandline());
		lDTO.setMobileNo(lPartyContact.getId().getMobileNo());
		lDTO.setStatus(lPartyContact.getStatus());
		lDTO.setRemark(lPartyContact.getRemark());
		return lDTO;
	}

}