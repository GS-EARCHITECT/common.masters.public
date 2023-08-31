package party.party_class.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PARTY_CLASS_MASTER database table.
 * 
 */
@Entity
@Table(name = "PARTY_CLASS_MASTER")
public class PartyClassMaster implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4151227936418346866L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_class_sequence")
	@SequenceGenerator(name = "party_class_sequence", sequenceName = "party_class_sequence", allocationSize = 1)
	@Column(name = "PARTY_CLASS_SEQ_NO")
	private Long partyClassSeqNo;

	@Column(name = "PARTY_CLASS")
	private String partyClass;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	public PartyClassMaster() {
	}

	public Long getPartyClassSeqNo() {
		return this.partyClassSeqNo;
	}

	public void setPartyClassSeqNo(Long partyClassSeqNo) {
		this.partyClassSeqNo = partyClassSeqNo;
	}

	public String getPartyClass() {
		return this.partyClass;
	}

	public void setPartyClass(String partyClass) {
		this.partyClass = partyClass;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partyClassSeqNo == null) ? 0 : partyClassSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartyClassMaster other = (PartyClassMaster) obj;
		if (partyClassSeqNo == null) {
			if (other.partyClassSeqNo != null)
				return false;
		} else if (!partyClassSeqNo.equals(other.partyClassSeqNo))
			return false;
		return true;
	}

	public PartyClassMaster(Long partyClassSeqNo, String partyClass, String description,
			Long specificationSeqNo) {
		super();
		this.partyClassSeqNo = partyClassSeqNo;
		this.partyClass = partyClass;
		this.description = description;
		this.specificationSeqNo = specificationSeqNo;
	}

}