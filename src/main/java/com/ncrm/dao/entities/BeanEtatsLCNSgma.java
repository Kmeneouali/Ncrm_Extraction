package com.ncrm.dao.entities;

public class BeanEtatsLCNSgma {
	String pk_obj_idt_rem,pk_obj_idt_LCN, bmlcn_CPT, DTEMI, bmlcn_LOC, bmlcn_ZBK, bmlcn_ZBK_lib,BMLCN_ZIB,
	bmlcn_NSER, bmlcn_RIB, bmlcn_CONF,bmlcn_CODE_ERREURS, bmlcn_ope_eta, bmlcn_ANO,bmlcn_ANO_LIB, bmlcn_MNT,
	bmlcn_FLAG_IMP, bmlcn_FLAG_REJET,bmlcn_FLAG_SCAN_GR, bmlcn_SQCA, bmlcn_ID_WEBCAPTUR,
	bmlcn_AGE_SCAN,bmlcn_sign,bmlcn_rio, 
	BMTR_age, ageTr_lib, 
	BMTR_ope_eta, BMTR_Ano,BMTR_Ano_LIB,
	BMTR_Flag_Rejet, BMTR_mode, BMTR_MNT, BMTR_CPT, BMTR_RIB, 
//	BMTR_loc,
			BMTR_zbk, BMTR_NSER, 
			BMTR_NBCH, 
			bmtr_ID_WEBCAPTUR,
			bmtr_AGE_SCAN,bmlcn_REJET_DELTA,BMLCN_LIB_REJET_DELTA,
			bmtr_SECTEUR, BMTa_ope_eta, BMTa_Ano,BMTa_Ano_lib, BMTa_Flag_Rejet, BMTa_mode,
			BMTa_MNTR, BMTA_MNTREM, BMTA_MNT_DIFF, BMTA_DIFF_NB, BMTA_NSER_TA,
			BMTA_CPT, BMTA_NSER, BMTA_COUNT_REM, BMTA_age, BMTN_Ano,BMTN_Ano_LIB,
			BMTN_ope_eta, BMTN_DIFF, BMTN_DIFF_NB, BMTN_sum_Lcn, BMTN_lecteur,bmlcn_dteec,
			DATE;

	public String getBMLCN_ZIB() {
		return BMLCN_ZIB;
	}

	public void setBMLCN_ZIB(String bMLCN_ZIB) {
		BMLCN_ZIB = bMLCN_ZIB;
	}

	public String getBMTa_Ano_lib() {
		return BMTa_Ano_lib;
	}

	public void setBMTa_Ano_lib(String bMTa_Ano_lib) {
		BMTa_Ano_lib = bMTa_Ano_lib;
	}

	public String getPk_obj_idt_LCN() {
		return pk_obj_idt_LCN;
	}

	public void setPk_obj_idt_LCN(String pk_obj_idt_LCN) {
		this.pk_obj_idt_LCN = pk_obj_idt_LCN;
	}

	public String getBmlcn_CPT() {
		return bmlcn_CPT;
	}

	public void setBmlcn_CPT(String bmlcn_CPT) {
		this.bmlcn_CPT = bmlcn_CPT;
	}

	public String getDTEMI() {
		return DTEMI;
	}

	public void setDTEMI(String dTEMI) {
		DTEMI = dTEMI;
	}

	public String getBmlcn_LOC() {
		return bmlcn_LOC;
	}

	public void setBmlcn_LOC(String bmlcn_LOC) {
		this.bmlcn_LOC = bmlcn_LOC;
	}

	public String getBmlcn_ZBK() {
		return bmlcn_ZBK;
	}

	public void setBmlcn_ZBK(String bmlcn_ZBK) {
		this.bmlcn_ZBK = bmlcn_ZBK;
	}

	public String getBmlcn_ZBK_lib() {
		return bmlcn_ZBK_lib;
	}

	public void setBmlcn_ZBK_lib(String bmlcn_ZBK_lib) {
		this.bmlcn_ZBK_lib = bmlcn_ZBK_lib;
	}

	public String getBmlcn_NSER() {
		return bmlcn_NSER;
	}

	public void setBmlcn_NSER(String bmlcn_NSER) {
		this.bmlcn_NSER = bmlcn_NSER;
	}

	public String getBmlcn_RIB() {
		return bmlcn_RIB;
	}

	public void setBmlcn_RIB(String bmlcn_RIB) {
		this.bmlcn_RIB = bmlcn_RIB;
	}

	public String getBmlcn_CONF() {
		return bmlcn_CONF;
	}

	public void setBmlcn_CONF(String bmlcn_CONF) {
		this.bmlcn_CONF = bmlcn_CONF;
	}

	public String getBmlcn_CODE_ERREURS() {
		return bmlcn_CODE_ERREURS;
	}

	public void setBmlcn_CODE_ERREURS(String bmlcn_CODE_ERREURS) {
		this.bmlcn_CODE_ERREURS = bmlcn_CODE_ERREURS;
	}

	public String getBmlcn_ope_eta() {
		return bmlcn_ope_eta;
	}

	public void setBmlcn_ope_eta(String bmlcn_ope_eta) {
		this.bmlcn_ope_eta = bmlcn_ope_eta;
	}

	public String getBmlcn_ANO() {
		return bmlcn_ANO;
	}

	public void setBmlcn_ANO(String bmlcn_ANO) {
		this.bmlcn_ANO = bmlcn_ANO;
	}

	public String getBmlcn_MNT() {
		return bmlcn_MNT;
	}

	public void setBmlcn_MNT(String bmlcn_MNT) {
		this.bmlcn_MNT = bmlcn_MNT;
	}

	public String getBmlcn_FLAG_IMP() {
		return bmlcn_FLAG_IMP;
	}

	public void setBmlcn_FLAG_IMP(String bmlcn_FLAG_IMP) {
		this.bmlcn_FLAG_IMP = bmlcn_FLAG_IMP;
	}

	public String getBmlcn_FLAG_REJET() {
		return bmlcn_FLAG_REJET;
	}

	public void setBmlcn_FLAG_REJET(String bmlcn_FLAG_REJET) {
		this.bmlcn_FLAG_REJET = bmlcn_FLAG_REJET;
	}

	public String getBmlcn_FLAG_SCAN_GR() {
		return bmlcn_FLAG_SCAN_GR;
	}

	public void setBmlcn_FLAG_SCAN_GR(String bmlcn_FLAG_SCAN_GR) {
		this.bmlcn_FLAG_SCAN_GR = bmlcn_FLAG_SCAN_GR;
	}

	public String getBmlcn_SQCA() {
		return bmlcn_SQCA;
	}

	public void setBmlcn_SQCA(String bmlcn_SQCA) {
		this.bmlcn_SQCA = bmlcn_SQCA;
	}

	public String getBmlcn_ID_WEBCAPTUR() {
		return bmlcn_ID_WEBCAPTUR;
	}

	public void setBmlcn_ID_WEBCAPTUR(String bmlcn_ID_WEBCAPTUR) {
		this.bmlcn_ID_WEBCAPTUR = bmlcn_ID_WEBCAPTUR;
	}

	public String getBmlcn_AGE_SCAN() {
		return bmlcn_AGE_SCAN;
	}

	public void setBmlcn_AGE_SCAN(String bmlcn_AGE_SCAN) {
		this.bmlcn_AGE_SCAN = bmlcn_AGE_SCAN;
	}

	public String getBMTR_ope_eta() {
		return BMTR_ope_eta;
	}

	public void setBMTR_ope_eta(String bMTR_ope_eta) {
		BMTR_ope_eta = bMTR_ope_eta;
	}

	public String getBMTR_Ano() {
		return BMTR_Ano;
	}

	public void setBMTR_Ano(String bMTR_Ano) {
		BMTR_Ano = bMTR_Ano;
	}

	public String getBMTR_Flag_Rejet() {
		return BMTR_Flag_Rejet;
	}

	public void setBMTR_Flag_Rejet(String bMTR_Flag_Rejet) {
		BMTR_Flag_Rejet = bMTR_Flag_Rejet;
	}

	public String getBMTR_mode() {
		return BMTR_mode;
	}

	public void setBMTR_mode(String bMTR_mode) {
		BMTR_mode = bMTR_mode;
	}

	public String getBMTR_MNT() {
		return BMTR_MNT;
	}

	public void setBMTR_MNT(String bMTR_MNT) {
		BMTR_MNT = bMTR_MNT;
	}

	public String getBMTR_CPT() {
		return BMTR_CPT;
	}

	public void setBMTR_CPT(String bMTR_CPT) {
		BMTR_CPT = bMTR_CPT;
	}

	public String getBMTR_RIB() {
		return BMTR_RIB;
	}

	public void setBMTR_RIB(String bMTR_RIB) {
		BMTR_RIB = bMTR_RIB;
	}

	public String getBMTR_zbk() {
		return BMTR_zbk;
	}

	public void setBMTR_zbk(String bMTR_zbk) {
		BMTR_zbk = bMTR_zbk;
	}

	public String getBMTR_NSER() {
		return BMTR_NSER;
	}

	public void setBMTR_NSER(String bMTR_NSER) {
		BMTR_NSER = bMTR_NSER;
	}

	public String getBMTR_NBCH() {
		return BMTR_NBCH;
	}

	public void setBMTR_NBCH(String bMTR_NBCH) {
		BMTR_NBCH = bMTR_NBCH;
	}

	public String getBmtr_ID_WEBCAPTUR() {
		return bmtr_ID_WEBCAPTUR;
	}

	public void setBmtr_ID_WEBCAPTUR(String bmtr_ID_WEBCAPTUR) {
		this.bmtr_ID_WEBCAPTUR = bmtr_ID_WEBCAPTUR;
	}

	public String getBmtr_AGE_SCAN() {
		return bmtr_AGE_SCAN;
	}

	public void setBmtr_AGE_SCAN(String bmtr_AGE_SCAN) {
		this.bmtr_AGE_SCAN = bmtr_AGE_SCAN;
	}

	public String getBmtr_SECTEUR() {
		return bmtr_SECTEUR;
	}

	public void setBmtr_SECTEUR(String bmtr_SECTEUR) {
		this.bmtr_SECTEUR = bmtr_SECTEUR;
	}

	public String getBMTa_ope_eta() {
		return BMTa_ope_eta;
	}

	public void setBMTa_ope_eta(String bMTa_ope_eta) {
		BMTa_ope_eta = bMTa_ope_eta;
	}

	public String getBMTa_Ano() {
		return BMTa_Ano;
	}

	public void setBMTa_Ano(String bMTa_Ano) {
		BMTa_Ano = bMTa_Ano;
	}

	public String getBMTa_Flag_Rejet() {
		return BMTa_Flag_Rejet;
	}

	public void setBMTa_Flag_Rejet(String bMTa_Flag_Rejet) {
		BMTa_Flag_Rejet = bMTa_Flag_Rejet;
	}

	public String getBMTa_mode() {
		return BMTa_mode;
	}

	public void setBMTa_mode(String bMTa_mode) {
		BMTa_mode = bMTa_mode;
	}

	public String getBMTa_MNTR() {
		return BMTa_MNTR;
	}

	public void setBMTa_MNTR(String bMTa_MNTR) {
		BMTa_MNTR = bMTa_MNTR;
	}

	public String getBMTA_MNTREM() {
		return BMTA_MNTREM;
	}

	public void setBMTA_MNTREM(String bMTA_MNTREM) {
		BMTA_MNTREM = bMTA_MNTREM;
	}

	public String getBMTA_MNT_DIFF() {
		return BMTA_MNT_DIFF;
	}

	public void setBMTA_MNT_DIFF(String bMTA_MNT_DIFF) {
		BMTA_MNT_DIFF = bMTA_MNT_DIFF;
	}

	public String getBMTA_DIFF_NB() {
		return BMTA_DIFF_NB;
	}

	public void setBMTA_DIFF_NB(String bMTA_DIFF_NB) {
		BMTA_DIFF_NB = bMTA_DIFF_NB;
	}

	public String getBMTA_NSER_TA() {
		return BMTA_NSER_TA;
	}

	public void setBMTA_NSER_TA(String bMTA_NSER_TA) {
		BMTA_NSER_TA = bMTA_NSER_TA;
	}

	public String getBMTA_CPT() {
		return BMTA_CPT;
	}

	public void setBMTA_CPT(String bMTA_CPT) {
		BMTA_CPT = bMTA_CPT;
	}

	public String getBMTA_NSER() {
		return BMTA_NSER;
	}

	public void setBMTA_NSER(String bMTA_NSER) {
		BMTA_NSER = bMTA_NSER;
	}

	public String getBMTA_COUNT_REM() {
		return BMTA_COUNT_REM;
	}

	public void setBMTA_COUNT_REM(String bMTA_COUNT_REM) {
		BMTA_COUNT_REM = bMTA_COUNT_REM;
	}

	public String getBMTA_age() {
		return BMTA_age;
	}

	public void setBMTA_age(String bMTA_age) {
		BMTA_age = bMTA_age;
	}

	public String getBMTN_Ano() {
		return BMTN_Ano;
	}

	public void setBMTN_Ano(String bMTN_Ano) {
		BMTN_Ano = bMTN_Ano;
	}

	public String getBMTN_ope_eta() {
		return BMTN_ope_eta;
	}

	public void setBMTN_ope_eta(String bMTN_ope_eta) {
		BMTN_ope_eta = bMTN_ope_eta;
	}

	public String getBMTN_DIFF() {
		return BMTN_DIFF;
	}

	

	public String getBMTR_age() {
		return BMTR_age;
	}

	public void setBMTR_age(String bMTR_age) {
		BMTR_age = bMTR_age;
	}

	public String getAgeTr_lib() {
		return ageTr_lib;
	}

	public void setAgeTr_lib(String ageTr_lib) {
		this.ageTr_lib = ageTr_lib;
	}

	public void setBMTN_DIFF(String bMTN_DIFF) {
		BMTN_DIFF = bMTN_DIFF;
	}

	public String getBMTN_DIFF_NB() {
		return BMTN_DIFF_NB;
	}

	public void setBMTN_DIFF_NB(String bMTN_DIFF_NB) {
		BMTN_DIFF_NB = bMTN_DIFF_NB;
	}

	public String getBMTN_sum_Lcn() {
		return BMTN_sum_Lcn;
	}

	public void setBMTN_sum_Lcn(String bMTN_sum_Lcn) {
		BMTN_sum_Lcn = bMTN_sum_Lcn;
	}

	public String getBMTN_lecteur() {
		return BMTN_lecteur;
	}

	public void setBMTN_lecteur(String bMTN_lecteur) {
		BMTN_lecteur = bMTN_lecteur;
	}

	public String getDATE() {
		return DATE;
	}

	public void setDATE(String dATE) {
		DATE = dATE;
	}


	public String getBmlcn_dteec() {
		return bmlcn_dteec;
	}

	public void setBmlcn_dteec(String bmlcn_dteec) {
		this.bmlcn_dteec = bmlcn_dteec;
	}

	public BeanEtatsLCNSgma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeanEtatsLCNSgma(String pk_obj_idt_LCN, String bmlcn_CPT, String dTEMI,
			String bmlcn_LOC, String bmlcn_ZBK, String bmlcn_ZBK_lib,
			String bmlcn_NSER, String bmlcn_RIB, String bmlcn_CONF,
			String bmlcn_CODE_ERREURS, String bmlcn_ope_eta, String bmlcn_ANO,
			String bmlcn_MNT, String bmlcn_FLAG_IMP, String bmlcn_FLAG_REJET,
			String bmlcn_FLAG_SCAN_GR, String bmlcn_SQCA,
			String bmlcn_ID_WEBCAPTUR, String bmlcn_AGE_SCAN, String bMTR_age,
			String ageTr_lib, String bMTR_ope_eta, String bMTR_Ano,
			String bMTR_Flag_Rejet, String bMTR_mode, String bMTR_MNT,
			String bMTR_CPT, String bMTR_RIB, String bMTR_zbk,
			String bMTR_NSER, String bMTR_NBCH, String bmtr_ID_WEBCAPTUR,
			String bmtr_AGE_SCAN, String bmtr_SECTEUR, String bMTa_ope_eta,
			String bMTa_Ano, String bMTa_Flag_Rejet, String bMTa_mode,
			String bMTa_MNTR, String bMTA_MNTREM, String bMTA_MNT_DIFF,
			String bMTA_DIFF_NB, String bMTA_NSER_TA, String bMTA_CPT,
			String bMTA_NSER, String bMTA_COUNT_REM, String bMTA_age,
			String bMTN_Ano, String bMTN_ope_eta, String bMTN_DIFF,
			String bMTN_DIFF_NB, String bMTN_sum_Lcn, String bMTN_lecteur,
			String bmlcn_dteec, String dATE) {
		super();
		this.pk_obj_idt_LCN = pk_obj_idt_LCN;
		this.bmlcn_CPT = bmlcn_CPT;
		DTEMI = dTEMI;
		this.bmlcn_LOC = bmlcn_LOC;
		this.bmlcn_ZBK = bmlcn_ZBK;
		this.bmlcn_ZBK_lib = bmlcn_ZBK_lib;
		this.bmlcn_NSER = bmlcn_NSER;
		this.bmlcn_RIB = bmlcn_RIB;
		this.bmlcn_CONF = bmlcn_CONF;
		this.bmlcn_CODE_ERREURS = bmlcn_CODE_ERREURS;
		this.bmlcn_ope_eta = bmlcn_ope_eta;
		this.bmlcn_ANO = bmlcn_ANO;
		this.bmlcn_MNT = bmlcn_MNT;
		this.bmlcn_FLAG_IMP = bmlcn_FLAG_IMP;
		this.bmlcn_FLAG_REJET = bmlcn_FLAG_REJET;
		this.bmlcn_FLAG_SCAN_GR = bmlcn_FLAG_SCAN_GR;
		this.bmlcn_SQCA = bmlcn_SQCA;
		this.bmlcn_ID_WEBCAPTUR = bmlcn_ID_WEBCAPTUR;
		this.bmlcn_AGE_SCAN = bmlcn_AGE_SCAN;
		BMTR_age = bMTR_age;
		this.ageTr_lib = ageTr_lib;
		BMTR_ope_eta = bMTR_ope_eta;
		BMTR_Ano = bMTR_Ano;
		BMTR_Flag_Rejet = bMTR_Flag_Rejet;
		BMTR_mode = bMTR_mode;
		BMTR_MNT = bMTR_MNT;
		BMTR_CPT = bMTR_CPT;
		BMTR_RIB = bMTR_RIB;
		BMTR_zbk = bMTR_zbk;
		BMTR_NSER = bMTR_NSER;
		BMTR_NBCH = bMTR_NBCH;
		this.bmtr_ID_WEBCAPTUR = bmtr_ID_WEBCAPTUR;
		this.bmtr_AGE_SCAN = bmtr_AGE_SCAN;
		this.bmtr_SECTEUR = bmtr_SECTEUR;
		BMTa_ope_eta = bMTa_ope_eta;
		BMTa_Ano = bMTa_Ano;
		BMTa_Flag_Rejet = bMTa_Flag_Rejet;
		BMTa_mode = bMTa_mode;
		BMTa_MNTR = bMTa_MNTR;
		BMTA_MNTREM = bMTA_MNTREM;
		BMTA_MNT_DIFF = bMTA_MNT_DIFF;
		BMTA_DIFF_NB = bMTA_DIFF_NB;
		BMTA_NSER_TA = bMTA_NSER_TA;
		BMTA_CPT = bMTA_CPT;
		BMTA_NSER = bMTA_NSER;
		BMTA_COUNT_REM = bMTA_COUNT_REM;
		BMTA_age = bMTA_age;
		BMTN_Ano = bMTN_Ano;
		BMTN_ope_eta = bMTN_ope_eta;
		BMTN_DIFF = bMTN_DIFF;
		BMTN_DIFF_NB = bMTN_DIFF_NB;
		BMTN_sum_Lcn = bMTN_sum_Lcn;
		BMTN_lecteur = bMTN_lecteur;
		this.bmlcn_dteec = bmlcn_dteec;
		DATE = dATE;
	}

	public String getBmlcn_ANO_LIB() {
		return bmlcn_ANO_LIB;
	}

	public void setBmlcn_ANO_LIB(String bmlcn_ANO_LIB) {
		this.bmlcn_ANO_LIB = bmlcn_ANO_LIB;
	}

	public String getBmlcn_sign() {
		return bmlcn_sign;
	}

	public void setBmlcn_sign(String bmlcn_sign) {
		this.bmlcn_sign = bmlcn_sign;
	}

	public String getBMTR_Ano_LIB() {
		return BMTR_Ano_LIB;
	}

	public void setBMTR_Ano_LIB(String bMTR_Ano_LIB) {
		BMTR_Ano_LIB = bMTR_Ano_LIB;
	}

	public String getBMTN_Ano_LIB() {
		return BMTN_Ano_LIB;
	}

	public void setBMTN_Ano_LIB(String bMTN_Ano_LIB) {
		BMTN_Ano_LIB = bMTN_Ano_LIB;
	}

	public String getBmlcn_rio() {
		return bmlcn_rio;
	}

	public void setBmlcn_rio(String bmlcn_rio) {
		this.bmlcn_rio = bmlcn_rio;
	}

	public String getPk_obj_idt_rem() {
		return pk_obj_idt_rem;
	}

	public void setPk_obj_idt_rem(String pk_obj_idt_rem) {
		this.pk_obj_idt_rem = pk_obj_idt_rem;
	}

	public String getBmlcn_REJET_DELTA() {
		return bmlcn_REJET_DELTA;
	}

	public void setBmlcn_REJET_DELTA(String bmlcn_REJET_DELTA) {
		this.bmlcn_REJET_DELTA = bmlcn_REJET_DELTA;
	}

	public String getBMLCN_LIB_REJET_DELTA() {
		return BMLCN_LIB_REJET_DELTA;
	}

	public void setBMLCN_LIB_REJET_DELTA(String bMLCN_LIB_REJET_DELTA) {
		BMLCN_LIB_REJET_DELTA = bMLCN_LIB_REJET_DELTA;
	}

	
	
	
}