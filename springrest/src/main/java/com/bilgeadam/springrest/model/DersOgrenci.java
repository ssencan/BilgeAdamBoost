package com.bilgeadam.springrest.model;

public class DersOgrenci
{
	private long ID;
	private long DERS_ID;
	private long OGRENCI_ID;
	private int DEVAMSIZLIK;
	private int NOTE;

	public long getID()
	{
		return ID;
	}

	public DersOgrenci()
	{
	}

	public DersOgrenci(long dERS_ID, long oGR_ID, int dEVAMSIZLIK, int nOTE)
	{
		DERS_ID = dERS_ID;
		OGRENCI_ID = oGR_ID;
		DEVAMSIZLIK = dEVAMSIZLIK;
		NOTE = nOTE;
	}

	public DersOgrenci(long iD, long dERS_ID, long oGR_ID, int dEVAMSIZLIK, int nOTE)
	{
		ID = iD;
		DERS_ID = dERS_ID;
		OGRENCI_ID = oGR_ID;
		DEVAMSIZLIK = dEVAMSIZLIK;
		NOTE = nOTE;
	}

	public void setID(long iD)
	{
		ID = iD;
	}

	public long getDERS_ID()
	{
		return DERS_ID;
	}

	public void setDERS_ID(long dERS_ID)
	{
		DERS_ID = dERS_ID;
	}

	public long getOGR_ID()
	{
		return OGRENCI_ID;
	}

	public void setOGRENCI_ID(long oGR_ID)
	{
		OGRENCI_ID = oGR_ID;
	}

	public int getDEVAMSIZLIK()
	{
		return DEVAMSIZLIK;
	}

	public void setDEVAMSIZLIK(int dEVAMSIZLIK)
	{
		DEVAMSIZLIK = dEVAMSIZLIK;
	}

	public int getNOTE()
	{
		return NOTE;
	}

	public void setNOTE(int nOTE)
	{
		NOTE = nOTE;
	}

	@Override
	public String toString()
	{
		return "DersOgrenci [ID=" + ID + ", DERS_ID=" + DERS_ID + ", OGR_ID=" + OGRENCI_ID + ", DEVAMSIZLIK=" + DEVAMSIZLIK + ", NOTE=" + NOTE + "]";
	}
}
