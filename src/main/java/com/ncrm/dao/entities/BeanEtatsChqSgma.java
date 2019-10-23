package com.ncrm.dao.entities;

import java.util.Comparator;

public class BeanEtatsChqSgma {
	String pk_obj_idt_Chq, BMCH_CPT, DTEMI, BMCH_LOC, BMCH_ZBK,BMCH_ZIB, Bmch_ZBK_lib,bmch_sign,
			BMCH_NSER, BMCH_RIB, BMCH_CONF,BMCH_CODE_ERREURS, BMCH_ope_eta, BMCH_ANO,BMCH_ANO_LIB, BMCH_MNT,
			BMCH_FLAG_IMP, BMCH_FLAG_REJET,BMCH_FLAG_SCAN_GR, bmch_SQCA, bmch_ID_WEBCAPTUR,
			bmch_AGE_SCAN, BMTR_age, ageTr_lib,pk_obj_idt_rem, BMTR_ope_eta, BMTR_Ano,BMTR_ANO_LIB,
			BMTR_Flag_Rejet, BMTR_mode, BMTR_MNT, BMTR_CPT, BMTR_RIB, BMTR_loc,
			BMTR_zbk, BMTR_NSER, BMTR_NBCH, bmtr_ID_WEBCAPTUR, bmtr_AGE_SCAN,
			bmtr_SECTEUR, BMTa_ope_eta, BMTa_Ano,BMTa_Ano_lib, BMTa_Flag_Rejet, BMTa_mode,
			BMTa_MNTR, BMTA_MNTREM, BMTA_MNT_DIFF, BMTA_DIFF_NB, BMTA_NSER_TA,
			BMTA_CPT, BMTA_NSER, BMTA_COUNT_REM, BMTA_age, BMTN_Ano,BMTN_ANO_LIB,
			BMTN_ope_eta, BMTN_DIFF, BMTN_DIFF_NB, BMTN_sum_chq, BMTN_lecteur,
			DATE,BMCH_REJET_DELTA,BMCH_RIO,BMCH_LIB_REJET_DELTA ;

	public String getPk_obj_idt_Chq() {
		return pk_obj_idt_Chq;
	}

	public void setPk_obj_idt_Chq(String pk_obj_idt_Chq) {
		this.pk_obj_idt_Chq = pk_obj_idt_Chq;
	}

	public String getBMCH_CPT() {
		return BMCH_CPT;
	}

	public void setBMCH_CPT(String bMCH_CPT) {
		BMCH_CPT = bMCH_CPT;
	}

	public String getDTEMI() {
		return DTEMI;
	}

	public void setDTEMI(String dTEMI) {
		DTEMI = dTEMI;
	}

	public String getBMCH_LOC() {
		return BMCH_LOC;
	}

	public void setBMCH_LOC(String bMCH_LOC) {
		BMCH_LOC = bMCH_LOC;
	}

	public String getBMCH_ZBK() {
		return BMCH_ZBK;
	}

	public void setBMCH_ZBK(String bMCH_ZBK) {
		BMCH_ZBK = bMCH_ZBK;
	}

	public String getBmch_ZBK_lib() {
		return Bmch_ZBK_lib;
	}

	public void setBmch_ZBK_lib(String bmch_ZBK_lib) {
		Bmch_ZBK_lib = bmch_ZBK_lib;
	}

	public String getBmch_sign() {
		return bmch_sign;
	}

	public void setBmch_sign(String bmch_sign) {
		this.bmch_sign = bmch_sign;
	}

	public String getBMCH_NSER() {
		return BMCH_NSER;
	}

	public void setBMCH_NSER(String bMCH_NSER) {
		BMCH_NSER = bMCH_NSER;
	}

	public String getBMCH_RIB() {
		return BMCH_RIB;
	}

	public void setBMCH_RIB(String bMCH_RIB) {
		BMCH_RIB = bMCH_RIB;
	}

	public String getBMCH_CONF() {
		return BMCH_CONF;
	}

	public void setBMCH_CONF(String bMCH_CONF) {
		BMCH_CONF = bMCH_CONF;
	}

	public String getBMCH_CODE_ERREURS() {
		return BMCH_CODE_ERREURS;
	}

	public void setBMCH_CODE_ERREURS(String bMCH_CODE_ERREURS) {
		BMCH_CODE_ERREURS = bMCH_CODE_ERREURS;
	}

	public String getBMCH_ope_eta() {
		return BMCH_ope_eta;
	}

	public void setBMCH_ope_eta(String bMCH_ope_eta) {
		BMCH_ope_eta = bMCH_ope_eta;
	}

	public String getBMCH_ANO() {
		return BMCH_ANO;
	}

	public void setBMCH_ANO(String bMCH_ANO) {
		BMCH_ANO = bMCH_ANO;
	}

	public String getBMCH_ANO_LIB() {
		return BMCH_ANO_LIB;
	}

	public void setBMCH_ANO_LIB(String bMCH_ANO_LIB) {
		BMCH_ANO_LIB = bMCH_ANO_LIB;
	}

	public String getBMCH_MNT() {
		return BMCH_MNT;
	}

	public void setBMCH_MNT(String bMCH_MNT) {
		BMCH_MNT = bMCH_MNT;
	}

	public String getBMCH_FLAG_IMP() {
		return BMCH_FLAG_IMP;
	}

	public void setBMCH_FLAG_IMP(String bMCH_FLAG_IMP) {
		BMCH_FLAG_IMP = bMCH_FLAG_IMP;
	}

	public String getBMCH_FLAG_REJET() {
		return BMCH_FLAG_REJET;
	}

	public void setBMCH_FLAG_REJET(String bMCH_FLAG_REJET) {
		BMCH_FLAG_REJET = bMCH_FLAG_REJET;
	}

	public String getBMCH_FLAG_SCAN_GR() {
		return BMCH_FLAG_SCAN_GR;
	}

	public void setBMCH_FLAG_SCAN_GR(String bMCH_FLAG_SCAN_GR) {
		BMCH_FLAG_SCAN_GR = bMCH_FLAG_SCAN_GR;
	}

	public String getBmch_SQCA() {
		return bmch_SQCA;
	}

	public void setBmch_SQCA(String bmch_SQCA) {
		this.bmch_SQCA = bmch_SQCA;
	}

	public String getBmch_ID_WEBCAPTUR() {
		return bmch_ID_WEBCAPTUR;
	}

	public void setBmch_ID_WEBCAPTUR(String bmch_ID_WEBCAPTUR) {
		this.bmch_ID_WEBCAPTUR = bmch_ID_WEBCAPTUR;
	}

	public String getBmch_AGE_SCAN() {
		return bmch_AGE_SCAN;
	}

	public void setBmch_AGE_SCAN(String bmch_AGE_SCAN) {
		this.bmch_AGE_SCAN = bmch_AGE_SCAN;
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

	public String getBMTR_ANO_LIB() {
		return BMTR_ANO_LIB;
	}

	public void setBMTR_ANO_LIB(String bMTR_ANO_LIB) {
		BMTR_ANO_LIB = bMTR_ANO_LIB;
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

	public String getBMTR_loc() {
		return BMTR_loc;
	}

	public void setBMTR_loc(String bMTR_loc) {
		BMTR_loc = bMTR_loc;
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

	public String getBMTN_ANO_LIB() {
		return BMTN_ANO_LIB;
	}

	public void setBMTN_ANO_LIB(String bMTN_ANO_LIB) {
		BMTN_ANO_LIB = bMTN_ANO_LIB;
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

	public void setBMTN_DIFF(String bMTN_DIFF) {
		BMTN_DIFF = bMTN_DIFF;
	}

	public String getBMTN_DIFF_NB() {
		return BMTN_DIFF_NB;
	}

	public void setBMTN_DIFF_NB(String bMTN_DIFF_NB) {
		BMTN_DIFF_NB = bMTN_DIFF_NB;
	}

	public String getBMTN_sum_chq() {
		return BMTN_sum_chq;
	}

	public void setBMTN_sum_chq(String bMTN_sum_chq) {
		BMTN_sum_chq = bMTN_sum_chq;
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

	public String getBMCH_REJET_DELTA() {
		return BMCH_REJET_DELTA;
	}

	public void setBMCH_REJET_DELTA(String bMCH_REJET_DELTA) {
		BMCH_REJET_DELTA = bMCH_REJET_DELTA;
	}

	
	
	
	
	public BeanEtatsChqSgma(String pk_obj_idt_Chq, String bMCH_CPT, String dTEMI,
			String bMCH_LOC, String bMCH_ZBK, String bmch_ZBK_lib,
			String bmch_sign, String bMCH_NSER, String bMCH_RIB,
			String bMCH_CONF, String bMCH_CODE_ERREURS, String bMCH_ope_eta,
			String bMCH_ANO, String bMCH_ANO_LIB, String bMCH_MNT,
			String bMCH_FLAG_IMP, String bMCH_FLAG_REJET,
			String bMCH_FLAG_SCAN_GR, String bmch_SQCA,
			String bmch_ID_WEBCAPTUR, String bmch_AGE_SCAN, String bMTR_age,
			String ageTr_lib, String bMTR_ope_eta, String bMTR_Ano,
			String bMTR_ANO_LIB, String bMTR_Flag_Rejet, String bMTR_mode,
			String bMTR_MNT, String bMTR_CPT, String bMTR_RIB, String bMTR_loc,
			String bMTR_zbk, String bMTR_NSER, String bMTR_NBCH,
			String bmtr_ID_WEBCAPTUR, String bmtr_AGE_SCAN,
			String bmtr_SECTEUR, String bMTa_ope_eta, String bMTa_Ano,
			String bMTa_Ano_lib, String bMTa_Flag_Rejet, String bMTa_mode,
			String bMTa_MNTR, String bMTA_MNTREM, String bMTA_MNT_DIFF,
			String bMTA_DIFF_NB, String bMTA_NSER_TA, String bMTA_CPT,
			String bMTA_NSER, String bMTA_COUNT_REM, String bMTA_age,
			String bMTN_Ano, String bMTN_ANO_LIB, String bMTN_ope_eta,
			String bMTN_DIFF, String bMTN_DIFF_NB, String bMTN_sum_chq,
			String bMTN_lecteur, String dATE, String bMCH_REJET_DELTA) {
		super();
		this.pk_obj_idt_Chq = pk_obj_idt_Chq;
		BMCH_CPT = bMCH_CPT;
		DTEMI = dTEMI;
		BMCH_LOC = bMCH_LOC;
		BMCH_ZBK = bMCH_ZBK;
		Bmch_ZBK_lib = bmch_ZBK_lib;
		this.bmch_sign = bmch_sign;
		BMCH_NSER = bMCH_NSER;
		BMCH_RIB = bMCH_RIB;
		BMCH_CONF = bMCH_CONF;
		BMCH_CODE_ERREURS = bMCH_CODE_ERREURS;
		BMCH_ope_eta = bMCH_ope_eta;
		BMCH_ANO = bMCH_ANO;
		BMCH_ANO_LIB = bMCH_ANO_LIB;
		BMCH_MNT = bMCH_MNT;
		BMCH_FLAG_IMP = bMCH_FLAG_IMP;
		BMCH_FLAG_REJET = bMCH_FLAG_REJET;
		BMCH_FLAG_SCAN_GR = bMCH_FLAG_SCAN_GR;
		this.bmch_SQCA = bmch_SQCA;
		this.bmch_ID_WEBCAPTUR = bmch_ID_WEBCAPTUR;
		this.bmch_AGE_SCAN = bmch_AGE_SCAN;
		BMTR_age = bMTR_age;
		this.ageTr_lib = ageTr_lib;
		BMTR_ope_eta = bMTR_ope_eta;
		BMTR_Ano = bMTR_Ano;
		BMTR_ANO_LIB = bMTR_ANO_LIB;
		BMTR_Flag_Rejet = bMTR_Flag_Rejet;
		BMTR_mode = bMTR_mode;
		BMTR_MNT = bMTR_MNT;
		BMTR_CPT = bMTR_CPT;
		BMTR_RIB = bMTR_RIB;
		BMTR_loc = bMTR_loc;
		BMTR_zbk = bMTR_zbk;
		BMTR_NSER = bMTR_NSER;
		BMTR_NBCH = bMTR_NBCH;
		this.bmtr_ID_WEBCAPTUR = bmtr_ID_WEBCAPTUR;
		this.bmtr_AGE_SCAN = bmtr_AGE_SCAN;
		this.bmtr_SECTEUR = bmtr_SECTEUR;
		BMTa_ope_eta = bMTa_ope_eta;
		BMTa_Ano = bMTa_Ano;
		BMTa_Ano_lib = bMTa_Ano_lib;
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
		BMTN_ANO_LIB = bMTN_ANO_LIB;
		BMTN_ope_eta = bMTN_ope_eta;
		BMTN_DIFF = bMTN_DIFF;
		BMTN_DIFF_NB = bMTN_DIFF_NB;
		BMTN_sum_chq = bMTN_sum_chq;
		BMTN_lecteur = bMTN_lecteur;
		DATE = dATE;
		BMCH_REJET_DELTA = bMCH_REJET_DELTA;
	}

	public String getBMTa_Ano_lib() {
		return BMTa_Ano_lib;
	}

	public void setBMTa_Ano_lib(String bMTa_Ano_lib) {
		BMTa_Ano_lib = bMTa_Ano_lib;
	}

	public String getBMCH_RIO() {
		return BMCH_RIO;
	}

	public void setBMCH_RIO(String bMCH_RIO) {
		BMCH_RIO = bMCH_RIO;
	}

	public BeanEtatsChqSgma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPk_obj_idt_rem() {
		return pk_obj_idt_rem;
	}

	public void setPk_obj_idt_rem(String pk_obj_idt_rem) {
		this.pk_obj_idt_rem = pk_obj_idt_rem;
	}

	public String getBMCH_ZIB() {
		return BMCH_ZIB;
	}

	public void setBMCH_ZIB(String bMCH_ZIB) {
		BMCH_ZIB = bMCH_ZIB;
	}

	public String getBMCH_LIB_REJET_DELTA() {
		return BMCH_LIB_REJET_DELTA;
	}

	public void setBMCH_LIB_REJET_DELTA(String bMCH_LIB_REJET_DELTA) {
		BMCH_LIB_REJET_DELTA = bMCH_LIB_REJET_DELTA;
	}

	

	
	
}
