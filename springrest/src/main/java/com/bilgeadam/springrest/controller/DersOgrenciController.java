package com.bilgeadam.springrest.controller;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bilgeadam.springrest.model.DersOgrenci;
import com.bilgeadam.springrest.repository.DersOgrenciRepository;

@RequestMapping(path = "dersogrenci")
@RestController
public class DersOgrenciController {

	private DersOgrenciRepository dersogrenci_repo;

	public DersOgrenciController(DersOgrenciRepository dersogrenci_repo) {
		this.dersogrenci_repo = dersogrenci_repo;
	}

	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DersOgrenci>> getall() {

		// localhost:8080/springrest/dersogrenci/getall
		try {
			return ResponseEntity.ok(dersogrenci_repo.getAll());

		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();

		}
	}

	@GetMapping(path = "/getbyid/{id}")
	public ResponseEntity<DersOgrenci> getbyid(@PathVariable(value = "id") long id) {

		// localhost:8080/springrest/dersogrenci/getbyid/1
		try {
			return ResponseEntity.ok(dersogrenci_repo.getByID(id));
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Kayıt bulunamadı");
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable(value = "id") long id) {
		// localhost:8080/springrest/dersogrenci/deletebyid/1
		try {
			boolean result = dersogrenci_repo.deleteByID(id);
			if (result) {
				return ResponseEntity.ok(id + "id 'li kayıt başarı ile silindi");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "id 'li kayıt bulunamadı");
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(id + "id 'li kayıt silinemedi");
		}
	}
	
	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody DersOgrenci dersogr) {
		// localhost:8080/springrest/dersogrenci/save
		try {
			boolean result = dersogrenci_repo.save(dersogr);
			if (result) {
				return ResponseEntity.ok("Kayıt başarılı");
			} else {
				return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
		}
	}
//	@POST
//	@Path(value = "save")
//	@Consumes(value = MediaType.APPLICATION_JSON)
//	public Response print() {
//		return Response.status(Status.CREATED).entity("Başarı ile kaydedildi").build();
//	}
//
//	@GET
//	@Path(value = "/getbyidqueryparam")
//	@Produces(value = MediaType.APPLICATION_JSON) // üretilecek datanın formatını söylüyor.
//	public Response getbyidqueryparam(@QueryParam(value = "id") long id) {
//
//		// localhost:8080/jakartarest/dersogrenci/getbyidqueryparam?id=1
//		try {
//			DersOgrenci result = dersOgrenci_repo.getByID(id);
//
//			if (result == null) {
//				return Response.status(Status.NOT_FOUND).entity("kayıt bulunamadı").build();
//			} else {
//				return Response.ok().entity(result).build();
//			}
//
//		} catch (Exception e) {
//			return Response.serverError().entity("Bir hata oluştu").build();
//
//		}
//	}
//
//	@GET
//	@Path(value = "/getbyid/{id}")
//	@Produces(value = MediaType.APPLICATION_JSON) // üretilecek datanın formatını söylüyor.
//	public Response getbyid(@PathParam(value = "id") long id) {
//
//		// localhost:8080/jakartarest/dersogrenci/getbyid/1
//		try {
//			DersOgrenci result = dersOgrenci_repo.getByID(id);
//
//			if (result == null) {
//				return Response.status(Status.NOT_FOUND).entity("kayıt bulunamadı").build();
//			} else {
//				return Response.ok().entity(result).build();
//			}
//
//		} catch (Exception e) {
//			return Response.serverError().entity("Bir hata oluştu").build();
//
//		}
//	}
//
//	@GET
//	@Path(value = "/getbyidheader")
//	@Produces(value = MediaType.APPLICATION_JSON)
//	public Response getbyidheader(@HeaderParam(value = "id") long id) {
//		// localhost:8080/jakartarest/dersogrenci/getbyidheader
//		try {
//			DersOgrenci result = dersOgrenci_repo.getByID(id);
//			if (result == null) {
//				return Response.status(Status.NOT_FOUND).entity("Kayıt bulunamadı").build();
//			} else {
//				return Response.ok().entity(result).build();
//			}
//		} catch (Exception e) {
//			return Response.serverError().entity("Bir hata oluştu").build();
//		}
//	}
//
//	@DELETE
//	@Path(value = "/deletebyid/{id}")
//	@Produces(value = MediaType.TEXT_PLAIN)
//	public Response deletebyid(@PathParam(value = "id") long id) {
//		// localhost:8080/jakartarest/dersogrenci/deletebyid/1
//		try {
//			if (dersOgrenci_repo.deleteByID(id)) {
//				return Response.ok().entity("Başarı ile silindi").build();
//			} else {
//				return Response.status(Status.NOT_FOUND).entity("Kayıt bulunamadı").build();
//			}
//		} catch (Exception e) {
//			return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
//		}
//	}
//
//	@POST
//	@Path(value = "save")
//	@Consumes(value = MediaType.APPLICATION_JSON)
//	public Response save(DersOgrenci dersogrenci) {
//		try {
//			if (dersOgrenci_repo.save(dersogrenci)) {
//				return Response.status(Status.CREATED).entity("Başarı ile kaydedildi").build();
//			} else {
//				return Response.serverError().entity("Başarı ile kaydedilemedi").build();
//			}
//		} catch (Exception e) {
//			return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
//		}
//	}

}
