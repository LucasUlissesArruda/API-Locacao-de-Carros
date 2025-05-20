@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.criarReserva(reserva);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.buscarPorId(id);
        return ResponseEntity.ok(reserva);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Reserva> atualizarStatus(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        String status = payload.get("status");
        Reserva reservaAtualizada = reservaService.atualizarStatus(id, status);
        return ResponseEntity.ok(reservaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        reservaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
