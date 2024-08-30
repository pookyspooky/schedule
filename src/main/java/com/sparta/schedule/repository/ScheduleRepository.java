package com.sparta.schedule.repository;

import com.sparta.schedule.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Page<Schedule> findAll(Pageable pageable);
}
