package br.com.fiap.gh.historico.controller;

import br.com.fiap.gh.historico.dto.ConsultaDTO;
import br.com.fiap.gh.historico.services.ConsultaService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@PreAuthorize("hasRole('CONSULTA')")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @QueryMapping
    public ConsultaDTO buscarConsulta(@Argument Long idConsulta) {
        // return consultaService.buscarConsulta(idConsulta);
        return null; // placeholder
    }

    @QueryMapping
    public List<ConsultaDTO> buscarMinhasConsultas() {
        return consultaService.buscarMinhasConsultas();
    }

    @QueryMapping
    public List<ConsultaDTO> buscarMinhasConsultasFuturas() {
        // return consultaService.buscarMinhasConsultasFuturas();
        return List.of(); // placeholder
    }

    @QueryMapping
    @PreAuthorize("hasAuthority('VIEW_CONSULTA')")
    public List<ConsultaDTO> buscarTodasConsultasPaciente(@Argument Long idPaciente) {

        consultaService.listarPorPaciente(idPaciente);
        // return consultaService.buscarTodasConsultasPaciente(idPaciente);
        return List.of(); // placeholder
    }

    @QueryMapping
    public List<ConsultaDTO> buscarTodasConsultasMedico(@Argument Long idMedico) {
        // return consultaService.buscarTodasConsultasMedico(idMedico);
        return List.of(); // placeholder
    }

    @QueryMapping
    public List<ConsultaDTO> buscarConsultasFuturasPaciente(@Argument Long idPaciente) {
        // return consultaService.buscarConsultasFuturasPaciente(idPaciente);
        return List.of(); // placeholder
    }

    @QueryMapping
    public List<ConsultaDTO> buscarConsultasFuturasMedico(@Argument Long idMedico) {
        // return consultaService.buscarConsultasFuturasMedico(idMedico);
        return List.of(); // placeholder
    }
}
