package com.bilgeadam.jakartarest.controller;

import java.util.ArrayList;

import com.bilgeadam.jakartarest.model.DersOgrenci;
import com.bilgeadam.jakartarest.repository.DersOgrenciRepository;

import jakarta.ejb.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path(value = "/dersogrenci")
@Singleton // tomee'De hata alındığı için eklendi
public class DersOgrenciController {

	private DersOgrenciRepository dersOgrenci_repo = new DersOgrenciRepository();

	@GET
	@Path(value = "/getall")
	@Produces(value = MediaType.APPLICATION_JSON) // üretilecek datanın formatını söylüyor.
	public Response getall() {

		// localhost:8080/jakartarest/dersogrenci/getall
		try {
			ArrayList<DersOgrenci> result = dersOgrenci_repo.getAll();
			return Response.ok().entity(result).build();

		} catch (Exception e) {
			return Response.serverError().entity("Bir hata oluştu").build();

		}
	}

	@GET
	@Path(value = "/getbyidqueryparam")
	@Produces(value = MediaType.APPLICATION_JSON) // üretilecek datanın formatını söylüyor.
	public Response getbyidqueryparam(@QueryParam(value = "id") long id) {

		// localhost:8080/jakartarest/dersogrenci/getbyidqueryparam?id=1
		try {
			DersOgrenci result = dersOgrenci_repo.getByID(id);

			if (result == null) {
				return Response.status(Status.NOT_FOUND).entity("kayıt bulunamadı").build();
			} else {
				return Response.ok().entity(result).build();
			}

		} catch (Exception e) {
			return Response.serverError().entity("Bir hata oluştu").build();

		}
	}

	@GET
	@Path(value = "/getbyid/{id}")
	@Produces(value = MediaType.APPLICATION_JSON) // üretilecek datanın formatını söylüyor.
	public Response getbyid(@PathParam(value = "id") long id) {

		// localhost:8080/jakartarest/dersogrenci/getbyid/1
		try {
			DersOgrenci result = dersOgrenci_repo.getByID(id);

			if (result == null) {
				return Response.status(Status.NOT_FOUND).entity("kayıt bulunamadı").build();
			} else {
				return Response.ok().entity(result).build();
			}

		} catch (Exception e) {
			return Response.serverError().entity("Bir hata oluştu").build();

		}
	}

	@GET
	@Path(value = "/getbyidheader")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getbyidheader(@HeaderParam(value = "id") long id) {
		// localhost:8080/jakartarest/dersogrenci/getbyidheader
		try {
			DersOgrenci result = dersOgrenci_repo.getByID(id);
			if (result == null) {
				return Response.status(Status.NOT_FOUND).entity("Kayıt bulunamadı").build();
			} else {
				return Response.ok().entity(result).build();
			}
		} catch (Exception e) {
			return Response.serverError().entity("Bir hata oluştu").build();
		}
	}

	@DELETE
	@Path(value = "/deletebyid/{id}")
	@Produces(value = MediaType.TEXT_PLAIN)
	public Response deletebyid(@PathParam(value = "id") long id) {
		// localhost:8080/jakartarest/dersogrenci/deletebyid/1
		try {
			if (dersOgrenci_repo.deleteByID(id)) {
				return Response.ok().entity("Başarı ile silindi").build();
			} else {
				return Response.status(Status.NOT_FOUND).entity("Kayıt bulunamadı").build();
			}
		} catch (Exception e) {
			return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
		}
	}

	@POST
	@Path(value = "save")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response save(DersOgrenci dersogrenci) {
		try {
			if (dersOgrenci_repo.save(dersogrenci)) {
				return Response.status(Status.CREATED).entity("Başarı ile kaydedildi").build();
			} else {
				return Response.serverError().entity("Başarı ile kaydedilemedi").build();
			}
		} catch (Exception e) {
			return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
		}
	}

}
