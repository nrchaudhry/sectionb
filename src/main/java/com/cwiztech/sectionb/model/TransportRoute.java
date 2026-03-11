package com.cwiztech.sectionb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBLTRANSPORTROUTE")
public class TransportRoute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long TRANSPORTROUTE_ID;
	
	@Column(name = "TRANSPORTROUTE_CODE")
	private String TRANSPORTROUTE_CODE;
	
	@Column(name = "TRANSPORTROUTE_DESC")
	private String TRANSPORTROUTE_DESC;
	
	@Column(name = "ROUTETYPE_ID")
	private Long ROUTETYPE_ID;
	
	@Transient
	private String ROUTETYPE_DETAIL;
	
	@Column(name = "COLOUR_ID")
	private Long COLOUR_ID;
	
	@Transient
	private String COLOUR_DETAIL;
	
	@Column(name = "ISACTIVE")
	private String ISACTIVE;
	
	@JsonIgnore
	@Column(name = "MODIFIED_BY")
	private Long MODIFIED_BY;

	@JsonIgnore 
	@Column(name = "MODIFIED_WHEN")
	private String MODIFIED_WHEN;

	@JsonIgnore 
	@Column(name = "MODIFIED_WORKSTATION")
	private String MODIFIED_WORKSTATION;

	public long getTRANSPORTROUTE_ID() {
		return TRANSPORTROUTE_ID;
	}

	public void setTRANSPORTROUTE_ID(long tRANSPORTROUTE_ID) {
		TRANSPORTROUTE_ID = tRANSPORTROUTE_ID;
	}

	public String getTRANSPORTROUTE_CODE() {
		return TRANSPORTROUTE_CODE;
	}

	public void setTRANSPORTROUTE_CODE(String tRANSPORTROUTE_CODE) {
		TRANSPORTROUTE_CODE = tRANSPORTROUTE_CODE;
	}

	public String getTRANSPORTROUTE_DESC() {
		return TRANSPORTROUTE_DESC;
	}

	public void setTRANSPORTROUTE_DESC(String tRANSPORTROUTE_DESC) {
		TRANSPORTROUTE_DESC = tRANSPORTROUTE_DESC;
	}

	public Long getROUTETYPE_ID() {
		return ROUTETYPE_ID;
	}

	public void setROUTETYPE_ID(Long rOUTETYPE_ID) {
		ROUTETYPE_ID = rOUTETYPE_ID;
	}

	public String getROUTETYPE_DETAIL() {
		return ROUTETYPE_DETAIL;
	}

	public void setROUTETYPE_DETAIL(String rOUTETYPE_DETAIL) {
		ROUTETYPE_DETAIL = rOUTETYPE_DETAIL;
	}

	public Long getCOLOUR_ID() {
		return COLOUR_ID;
	}

	public void setCOLOUR_ID(Long cOLOUR_ID) {
		COLOUR_ID = cOLOUR_ID;
	}

	public String getCOLOUR_DETAIL() {
		return COLOUR_DETAIL;
	}

	public void setCOLOUR_DETAIL(String cOLOUR_DETAIL) {
		COLOUR_DETAIL = cOLOUR_DETAIL;
	}

	public String getISACTIVE() {
		return ISACTIVE;
	}

	public void setISACTIVE(String iSACTIVE) {
		ISACTIVE = iSACTIVE;
	}

	@JsonIgnore 
	public Long getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(Long mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	@JsonIgnore 
	public String getMODIFIED_WHEN() {
		return MODIFIED_WHEN;
	}

	public void setMODIFIED_WHEN(String mODIFIED_WHEN) {
		MODIFIED_WHEN = mODIFIED_WHEN;
	}

	@JsonIgnore 
	public String getMODIFIED_WORKSTATION() {
		return MODIFIED_WORKSTATION;
	}

	public void setMODIFIED_WORKSTATION(String mODIFIED_WORKSTATION) {
		MODIFIED_WORKSTATION = mODIFIED_WORKSTATION;
	}
}
