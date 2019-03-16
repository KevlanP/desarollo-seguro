package com.utad.desarrollo.seguro.controller.api;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utad.desarrollo.seguro.dto.DummyRequestBodyDto;
import com.utad.desarrollo.seguro.dto.DummyRequestBodySubAttribute;
import com.utad.desarrollo.seguro.dto.DummyResponseDto;

/**
 * @author Pavel
 *las validaciones se realizan con anotaciones @author Pavel como esta
 *final se utiliza en metodos constantes 
 */
@RestController
@RequestMapping("/api/dummy")
@Validated
public class DummyApiController {

    /**
     * @logger
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @param param1 parametro de entrada
     * @return devuelve una respuesta
     * 
     *         vpath-var1 variable de ruta esta viene desde el navegador
     *         
     */
    @GetMapping("/dummy-get/{path-var1}/otra-cosa/{path-var2}")
    public DummyResponseDto get(
            @RequestParam(name = "param1", required = false, defaultValue = "value")  @NotBlank String param1,
            @RequestParam(name = "param2", required = true) @Min(2) @Max(5) @NotNull Long param2,
            @PathVariable(name = "path-var1", required = true) @NotBlank  @Pattern(regexp="[0-9]") String param3,
            @PathVariable(name = "path-var2", required = true)@NotBlank  String param4) {

     //   logger.info("Request: GET /api/dummy/dummy-get; param1: {}", param1);

        DummyResponseDto response = new DummyResponseDto();

        if (param1.equals("hola")) {
            response.setSuccess(true);
        } else {
            response.setSuccess(false);

        }
        // response.setSuccess(true);

        return response;

    }

    /**
     * @param body
     * @return
     */
    @PostMapping("/dummy-post")
    public  DummyResponseDto post(
            @RequestBody(required = true) @Valid DummyRequestBodyDto body) {

        logger.info("Request: POST /api/dummy/dummy-post");
        logger.info(body.getAttribute1());
        logger.info(body.getAttribute2().toString());
        logger.info(body.getAttribute3().getSubAttribute1());

        for (String str : body.getAttribute4()) {
            logger.info(str);
        }

        for (DummyRequestBodySubAttribute subAttribute : body.getAttribute5()) {
            logger.info(subAttribute.getSubAttribute1());
            logger.info(subAttribute.getSubAttribute2().toString());
        }

        DummyResponseDto response = new DummyResponseDto();
        response.setSuccess(true);

        return response;

    }


}
