package pe.entelgy.reto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.entelgy.reto.controller.response.RestResponse;
import pe.entelgy.reto.service.RetoService;


@RestController
@RequestMapping("/reto")
public class RetoController {

    @Autowired
    private RetoService retoService;

    @PostMapping("/rework")
    public ResponseEntity<Object> rework() {
        RestResponse response = new RestResponse(retoService.rework());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
