package com.alura.forohub.controller;

import com.alura.forohub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistro, UriComponentsBuilder uriComponentsBuilder) {

        if (topicoRepository.existsByTituloAndMensajeIgnoreCase(datosRegistro.titulo(), datosRegistro.mensaje())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un tópico con el mismo título y mensaje");
        }

        Topico topico = topicoRepository.save(new Topico(datosRegistro));
        DatosRespuestaTopico datosRespuesta = new DatosRespuestaTopico(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listadoTopicos(@PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable paginacion) {
        Page<DatosRespuestaTopico> pagina = topicoRepository.findAll(paginacion).map(DatosRespuestaTopico::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> detallarTopico(@PathVariable Long id) {
        var topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            var topico = topicoOptional.get();
            return ResponseEntity.ok(new DatosRespuestaTopico(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datosActualizar) {
        Optional<Topico> topicoBuscado = topicoRepository.findById(id);
        if (topicoBuscado.isPresent()) {
            Topico topico = topicoBuscado.get();
            if (datosActualizar.titulo() != null && datosActualizar.mensaje() != null) {
                if (topicoRepository.existsByTituloAndMensajeIgnoreCase(datosActualizar.titulo(), datosActualizar.mensaje())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).build();
                }
            }
            topico.actualizarDatos(datosActualizar);
            return ResponseEntity.ok(new DatosRespuestaTopico(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topicoBuscado = topicoRepository.findById(id);
        if (topicoBuscado.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
