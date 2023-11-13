package com.bilgeadam.springbootrest.model;

public class DersOgrenciDTO
{
	private DersOgrenci dersogr;
	private Ders ders;
	private Ogrenci ogrenci;

	public DersOgrenciDTO()
	{

	}

	public DersOgrenciDTO(Ders ders, Ogrenci ogrenci)
	{
		this.ders = ders;
		this.ogrenci = ogrenci;
	}
	

	public DersOgrenci getDersogr() {
		return dersogr;
	}

	public void setDersogr(DersOgrenci dersogr) {
		this.dersogr = dersogr;
	}

	public Ders getDers()
	{
		return ders;
	}

	public void setDers(Ders ders)
	{
		this.ders = ders;
	}

	public Ogrenci getOgrenci()
	{
		return ogrenci;
	}

	public void setOgrenci(Ogrenci ogrenci)
	{
		this.ogrenci = ogrenci;
	}

	@Override
	public String toString()
	{
		return "DersOgrenciDTO [ogrenci=" + ogrenci + ", ders=" + ders + "]";
	}
}
