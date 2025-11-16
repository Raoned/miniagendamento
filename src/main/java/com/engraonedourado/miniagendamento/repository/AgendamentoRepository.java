package com.engraonedourado.miniagendamento.repository;

import com.engraonedourado.miniagendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

/**
 * Descrição da interface AgendamentoRepository.
 *
 * @author raone.santos
 * @since 15/11/2025
 */
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query("""
            SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END
                FROM Agendamento a
                WHERE a.
""")
    boolean existsConflito(@Param("usuario") String usuario,
                           @Param("inicio")LocalDateTime inicio,
                           @Param("fim") LocalDateTime fim,
                           @Param("ignoreId") Long ignoreId);

}
