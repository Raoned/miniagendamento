package com.engraonedourado.miniagendamento.mapper;

import com.engraonedourado.miniagendamento.dto.AgendamentoCreateRequest;
import com.engraonedourado.miniagendamento.dto.AgendamentoResponse;
import com.engraonedourado.miniagendamento.model.Agendamento;
import com.engraonedourado.miniagendamento.model.StatusAgendamento;

import java.time.LocalDateTime;

/**
 * Descrição da classe AgendamentoMapper.
 *
 * @author raone.santos
 * @since 15/11/2025
 */
public class AgendamentoMapper {

    public static Agendamento toEntity(AgendamentoCreateRequest req) {
        return Agendamento.builder()
                .titulo(req.titulo())
                .descricao(req.descricao())
                .dataInicio(req.dataInicio())
                .dataFim(req.dataFim())
                .usuario(req.usuario())
                .status(StatusAgendamento.AGENDADO)
                .criadoEm(LocalDateTime.now())
                .atualizadoEm(LocalDateTime.now())
                .build();
    }

    public static void merge(Agendamento entity, AgendamentoCreateRequest req) {
        if(req.titulo() != null) {
            entity.setTitulo(req.titulo());
        }
        if(req.descricao() != null) {
            entity.setDescricao(req.descricao());
        }
        if(req.dataInicio() != null) {
            entity.setDataInicio(req.dataInicio());
        }
        if(req.dataFim() != null) {
            entity.setDataFim(req.dataFim());
        }
    }


    public static AgendamentoResponse toResponse(Agendamento a) {
        return new AgendamentoResponse(
                a.getId(),
                a.getTitulo(),
                a.getDescricao(),
                a.getDataInicio(),
                a.getDataFim(),
                a.getStatus(),
                a.getUsuario(),
                a.getCriadoEm(),
                a.getAtualizadoEm()
        );
    }
}
