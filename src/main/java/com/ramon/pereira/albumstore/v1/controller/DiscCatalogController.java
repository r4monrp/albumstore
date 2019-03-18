package com.ramon.pereira.albumstore.v1.controller;

import com.ramon.pereira.albumstore.business.DiscCatalogBusiness;
import com.ramon.pereira.albumstore.model.Disc;
import com.ramon.pereira.albumstore.model.enDiscGenre;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/albumstore/disccatalog")
public class DiscCatalogController {

    @Autowired
    private DiscCatalogBusiness discCatalogBusiness;

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Busca de album por ID", response = Disc.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    }
    )
    public Optional<Disc> findById(@PathVariable final Integer id) {
        return discCatalogBusiness.findById(id);
    }

    @GetMapping("/genre")
    @ResponseBody
    @ApiOperation(value = "Filtro de albuns por genero", response = String.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    }
    )
    public Optional<List<Disc>> filterByGenre(@RequestParam final enDiscGenre genre, @RequestParam final Pageable pageable) {
        return discCatalogBusiness.filterByGenre(genre, pageable);
    }
}
