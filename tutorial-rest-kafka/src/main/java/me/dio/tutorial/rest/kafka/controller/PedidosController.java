package me.dio.tutorial.rest.kafka.controller;

import lombok.RequiredArgsConstructor;
import me.dio.tutorial.rest.kafka.data.PedidoData;
import me.dio.tutorial.rest.kafka.services.RegistraEventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PedidosController {

    private final RegistraEventoService eventoService;

    @PostMapping(path = "/api/salva-pedido")
    public ResponseEntity<String> salvarPedido (@RequestBody PedidoData pedido){
        eventoService.adicionarEvento("salvarPedido", pedido);
        return ResponseEntity.ok("Sucesso");
    }
}
