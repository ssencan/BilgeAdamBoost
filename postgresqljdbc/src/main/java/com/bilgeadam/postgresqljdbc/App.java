package com.bilgeadam.postgresqljdbc;

import java.sql.SQLException;

import com.bilgeadam.postgresqljdbc.model.DersOgrenci;
import com.bilgeadam.postgresqljdbc.model.Ogretmen;
import com.bilgeadam.postgresqljdbc.repository.DersOgrenciRepository;
import com.bilgeadam.postgresqljdbc.repository.DersRepository;
import com.bilgeadam.postgresqljdbc.repository.KonuRepository;
import com.bilgeadam.postgresqljdbc.repository.OgrenciRepository;
import com.bilgeadam.postgresqljdbc.repository.OgretmenRepository;

public class App {
	private static OgretmenRepository ogretmen_repo = new OgretmenRepository();
	private static DersRepository ders_repo = new DersRepository();
	private static KonuRepository konu_repo = new KonuRepository();
	private static OgrenciRepository ogrenci_repo = new OgrenciRepository();
	private static DersOgrenciRepository dersogrenci_repo = new DersOgrenciRepository();

	public static void main(String[] args) {
		try {
//			Ogretmen ogr = new Ogretmen("numan2", true); // Örnek bir Ogretmen nesnesi oluşturuldu
//			ogr.setID(1);
//			Ogretmen ogr2 = ogretmen_repo.getByID(2);
//			Konu konu = new Konu("java");
//			konu.setID(1); // SaveDTO için var olan objeleri atadık getbyid ile de yapılabilir. Ogretmen ogr = ogretmenRepository.getById(1);
//			System.err.println(ogretmen_repo.save(new Ogretmen("gökhan", true)));
//			System.err.println(ogretmen_repo.getAll());
//			System.err.println(ders_repo.getAll());
//			System.err.println(ders_repo.getAllDTO());
//			System.err.println(ogretmen_repo.getByID(22));
//			System.err.println(ogretmen_repo.deleteByID(7));
//			System.out.println(ders_repo.save(new Ders(6,3)));
//			System.out.println(ders_repo.saveDTO(new DersDTO(ogr2, konu)));
//			System.out.println(ders_repo.deleteByID(11));
//			System.out.println(ders_repo.getByID(17));
//			System.out.println(konu_repo.save(new Konu("React")));
//			System.out.println(konu_repo.deleteByID(4));
//			System.out.println(konu_repo.getByID(2));
//			System.out.println(konu_repo.getAll());
//			System.out.println(ogrenci_repo.getAll());
//			System.out.println(ogrenci_repo.save(new Ogrenci("şükrü",911,13)));
//			System.out.println(ogrenci_repo.deleteByID(6));
//			System.out.println(ogrenci_repo.getByID(7));
//			System.out.println(dersogrenci_repo.getAll());
//			System.out.println(dersogrenci_repo.save(new DersOgrenci(13,7,1,100)));
//			System.out.println(dersogrenci_repo.deleteByID(15));
//			System.out.println(dersogrenci_repo.getByID(16));
			System.out.println(ogretmen_repo.update(6,new Ogretmen("updated",false)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
