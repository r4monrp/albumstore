package com.ramon.pereira.albumstore.resources.v1.controllers;

import com.ramon.pereira.albumstore.business.DiscCatalogBusiness;
import com.ramon.pereira.albumstore.model.Disc;
import com.ramon.pereira.albumstore.model.enDiscGenre;
import com.ramon.pereira.albumstore.resources.mapper.disc.DiscMapper;
import com.ramon.pereira.albumstore.resources.v1.dtos.disc.DiscResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albumstore/v1/disccatalog")
@Api(value = "Catalog Disks", description = "REST API Catalog Disks", tags = {"CatalogDisks"})
public class DiscCatalogController {

  @Autowired
  private DiscCatalogBusiness discCatalogBusiness;

  @Autowired
  private DiscMapper discMapper;

  @GetMapping("/{id}")
  @ResponseBody
  @ApiOperation(value = "Get By ID", response = Disc.class, produces = "application/json")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 500, message = "Internal Server Error")})
  public Optional<DiscResponseDto> findById(@PathVariable final Integer id) {

    return discMapper.serialize(discCatalogBusiness.findById(id));
  }


  @GetMapping("/genre")
  @ResponseBody
  @ApiOperation(value = "Filter Albuns By Genre", response = String.class, produces = "application/json")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 500, message = "Internal Server Error")})
  public Optional<List<DiscResponseDto>> findByGenreOrderByNameAsc(@RequestParam final enDiscGenre genre,
                                                        @RequestParam(value = "page", defaultValue = "0") final int page,
                                                        @RequestParam(value = "pagesize", defaultValue = "10") final int pagesize) {

    return discMapper.serializeList(discCatalogBusiness.findByGenreOrderByNameAsc(genre, PageRequest.of(page, pagesize)));
  }
}
