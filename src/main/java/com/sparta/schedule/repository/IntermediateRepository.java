package com.sparta.schedule.repository;

import com.sparta.schedule.entity.Intermediate;
import com.sparta.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IntermediateRepository extends JpaRepository<Intermediate, Long> {
    List<Intermediate> findAllBySchedule(Schedule schedule);
}
