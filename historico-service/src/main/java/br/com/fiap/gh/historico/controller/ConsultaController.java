package br.com.fiap.gh.historico.controller;

import br.com.fiap.gh.historico.dto.ConsultaDTO;
import br.com.fiap.gh.historico.dto.ConsultaInput;
import br.com.fiap.gh.historico.services.ConsultaService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

//Disponível em /graphql
@Controller
@PreAuthorize("hasRole('CONSULTA')")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @QueryMapping
    @PreAuthorize("hasAuthority('VIEW_CONSULTA')")
    public ConsultaDTO buscarConsulta(@Argument Long idConsulta) {

        return consultaService.buscarConsulta(idConsulta);
    }

    @QueryMapping
    @PreAuthorize("hasAuthority('VIEW_CONSULTA')")
    public List<ConsultaDTO> buscarMinhasConsultas() {

        //somente paciente
        return consultaService.buscarMinhasConsultas();
    }

    @QueryMapping
    @PreAuthorize("hasAuthority('VIEW_CONSULTA')")
    public List<ConsultaDTO> buscarMinhasConsultasFuturas() {
        //paciente
        return consultaService.buscarMinhasConsultasFuturas();
    }

    @QueryMapping
    @PreAuthorize("hasAuthority('VIEW_CONSULTA')")
    public List<ConsultaDTO> buscarTodasConsultasPaciente(@Argument Long idPaciente) {
        //paciente, medico, enfermeira
        return consultaService.buscarTodasConsultasPaciente(idPaciente);
    }

    @QueryMapping
    @PreAuthorize("hasAuthority('VIEW_CONSULTA')")
    public List<ConsultaDTO> buscarTodasConsultasMedico(@Argument Long idMedico) {

        return consultaService.buscarTodasConsultasMedico(idMedico);
    }

    @QueryMapping
    @PreAuthorize("hasAuthority('VIEW_CONSULTA')")
    public List<ConsultaDTO> buscarConsultasFuturasPaciente(@Argument Long idPaciente) {
        return consultaService.buscarConsultasFuturasPaciente(idPaciente);
    }

    @QueryMapping
    @PreAuthorize("hasAuthority('VIEW_CONSULTA')")
    public List<ConsultaDTO> buscarConsultasFuturasMedico(@Argument Long idMedico) {

         return consultaService.buscarConsultasFuturasMedico(idMedico);
    }

//    @MutationMapping somente via agendamento
//    @PreAuthorize("hasAuthority('INSERT_CONSULTA')")
//    public ConsultaDTO salvarConsulta(@Argument ConsultaInput input) {
//
//        return consultaService.salvarConsulta(input);
//    }
}
