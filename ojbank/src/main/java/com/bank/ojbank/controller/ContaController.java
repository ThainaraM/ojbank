package com.bank.ojbank.controller;

import com.bank.ojbank.dto.DepositoDTO;
import com.bank.ojbank.dto.SaqueDTO;
import com.bank.ojbank.dto.TransferenciaDTO;
import com.bank.ojbank.model.Conta;
import com.bank.ojbank.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/contas")
@RequiredArgsConstructor
public class ContaController {

    private final ContaRepository contaRepository;

    @PostMapping("/criar")
    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta) {
    Conta nova = contaRepository.save(conta);
        return ResponseEntity.ok(nova);
}

    @GetMapping
     public ResponseEntity<List<Conta>> listarContas() {
     List<Conta> contas = contaRepository.findAll();
        return ResponseEntity.ok(contas);
     }

    @GetMapping("/{id}/saldo")
    public ResponseEntity<Double> consultarSaldo(@PathVariable Long id) {
        return contaRepository.findById(id)
                .map(conta -> ResponseEntity.ok(conta.getSaldo()))
                .orElse(ResponseEntity.notFound().build());
    }
     
     @PostMapping("/depositar")
      public ResponseEntity<String> depositar(@RequestBody DepositoDTO dto) {
       System.out.println(">>> Recebido deposito: contaId=" + dto.getContaId() + ", valor=" + dto.getValor());

        return contaRepository.findById(dto.getContaId())
            .map(conta -> {
                conta.setSaldo(conta.getSaldo() + dto.getValor());
                contaRepository.save(conta);
                return ResponseEntity.ok("Depósito de R$ " + dto.getValor() + " realizado com sucesso.");
            })
            .orElse(ResponseEntity.notFound().build());
   }   

     @PostMapping("/sacar")
     public ResponseEntity<String> sacar(@RequestBody SaqueDTO dto) {
        System.out.println(">>> Recebido saque: contaId=" + dto.getContaId() + ", valor=" + dto.getValor());

        Optional<Conta> contaOptional = contaRepository.findById(dto.getContaId());

        if (contaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Conta conta = contaOptional.get();

        if (conta.getSaldo() < dto.getValor()) {
            return ResponseEntity.badRequest().body("Saldo insuficiente.");
        }

        conta.setSaldo(conta.getSaldo() - dto.getValor());
        contaRepository.save(conta);

        return ResponseEntity.ok("Saque de R$" + dto.getValor() + " realizado com sucesso!");
    }
    
      @PostMapping("/transferir")
      public ResponseEntity<String> transferir(@RequestBody TransferenciaDTO dto) {
     System.out.println(">>> Transferência: de " + dto.getOrigemId() + " para " + dto.getDestinoId() + " valor=" + dto.getValor());

      Optional<Conta> origemOpt = contaRepository.findById(dto.getOrigemId());
      Optional<Conta> destinoOpt = contaRepository.findById(dto.getDestinoId());

      if (origemOpt.isEmpty() || destinoOpt.isEmpty()) {
        return ResponseEntity.notFound().build();
     }

       Conta origem = origemOpt.get();
       Conta destino = destinoOpt.get();

      if (origem.getSaldo() < dto.getValor()) {
        return ResponseEntity.badRequest().body("Saldo insuficiente na conta de origem.");
     }

      origem.setSaldo(origem.getSaldo() - dto.getValor());
      destino.setSaldo(destino.getSaldo() + dto.getValor());

      contaRepository.save(origem);
      contaRepository.save(destino);

     return ResponseEntity.ok("Transferência de R$" + dto.getValor() + " realizada com sucesso.");
     }
    
}
   
            


