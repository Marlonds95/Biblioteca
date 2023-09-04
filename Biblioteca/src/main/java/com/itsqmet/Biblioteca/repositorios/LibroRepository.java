package com.itsqmet.Biblioteca.repositorios;

import com.itsqmet.Biblioteca.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
