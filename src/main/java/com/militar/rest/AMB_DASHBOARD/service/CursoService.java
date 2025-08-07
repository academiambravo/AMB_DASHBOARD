package com.militar.rest.AMB_DASHBOARD.service;


import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseDto;
import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseListDto;
import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseSo;
import com.militar.rest.AMB_DASHBOARD.model.Curso;
import com.militar.rest.AMB_DASHBOARD.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;


    public GetCourseListDto getCourseList() {

        if (!cursoRepository.findAll().isEmpty())
            return GetCourseListDto.from(cursoRepository.findAll());

        throw new EntityNotFoundException("No courses found");
    }

    public GetCourseDto getCourseById(Integer id) {

        return cursoRepository.findById(id)
                .map(GetCourseDto::from)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + id));
    }

    public GetCourseDto getCourseByName(String name) {

        return cursoRepository.findByNombreCurso(name)
                .map(GetCourseDto::from)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with name: " + name));
    }

    @Transactional
    public void deleteCourse(Integer id) {
        cursoRepository.deleteById(id);
    }


    public Curso updateCourse(Integer id , GetCourseDto courseDto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + id));

        curso.setNombreCurso(courseDto.course_name());
        curso.setPrecio(Double.parseDouble(courseDto.course_price()));
        curso.setDescripcion(courseDto.course_description());
        curso.setDias(Integer.parseInt(courseDto.course_days()));
        curso.setFecha_creacion(courseDto.created_at());
        curso.setUsuario_creacion(courseDto.created_by());
        curso.setFecha_inicio(LocalDateTime.parse(courseDto.course_start()));
        curso.setFecha_fin(LocalDateTime.parse(courseDto.course_end()));
        curso.setHabilitado(courseDto.enabled());
        curso.setModo(courseDto.mode());

        return cursoRepository.save(curso);
    }

    public Curso createCourse(GetCourseDto courseDto) {
        Curso curso = Curso.builder()
                .nombreCurso(courseDto.course_name())
                .precio(Double.parseDouble(courseDto.course_price()))
                .descripcion(courseDto.course_description())
                .dias(Integer.parseInt(courseDto.course_days()))
                .fecha_creacion(LocalDateTime.now().toString())
                .usuario_creacion(courseDto.created_by())
                .fecha_inicio(LocalDateTime.parse(courseDto.course_start()))
                .fecha_fin(LocalDateTime.parse(courseDto.course_end()))
                .habilitado(courseDto.enabled())
                .modo(courseDto.mode())
                .build();

        return cursoRepository.save(curso);
    }

    public List<GetCourseSo> getCourseSo () {

        return cursoRepository.findAll()
                .stream()
                .map(GetCourseSo::from)
                .toList();
    }

    public void deleteCourseById(Integer id) {
        cursoRepository.deleteById(id);
    }
}
