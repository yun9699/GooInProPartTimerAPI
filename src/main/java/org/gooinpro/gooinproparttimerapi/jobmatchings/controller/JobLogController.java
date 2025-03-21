package org.gooinpro.gooinproparttimerapi.jobmatchings.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gooinpro.gooinproparttimerapi.common.dto.PageRequestDTO;
import org.gooinpro.gooinproparttimerapi.common.dto.PageResponseDTO;
import org.gooinpro.gooinproparttimerapi.jobmatchings.dto.JobMatchingsListDTO;
import org.gooinpro.gooinproparttimerapi.jobmatchings.dto.JobMatchingsTimeDTO;
import org.gooinpro.gooinproparttimerapi.jobmatchings.dto.JobMatchingsWorkListDTO;
import org.gooinpro.gooinproparttimerapi.jobmatchings.service.JobMatchingsLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/part/api/v1/log")
@RequiredArgsConstructor
@Log4j2
public class JobLogController {

    private final JobMatchingsLogService jobMatchingsLogService;

    // 현재 내역 확인
    @GetMapping("/current")
    public ResponseEntity<List<JobMatchingsListDTO>> getCurrentJobs(@RequestParam Long pno) {
        log.info("현재 근무지 controller for pno: {}", pno);
        return ResponseEntity.ok(jobMatchingsLogService.getCurrentWorkplaces(pno));
    }

    // 과거 이력 확인
    @GetMapping("/past")
    public ResponseEntity<List<JobMatchingsListDTO>> getPastJobs(@RequestParam Long pno) {
        log.info("과거 근무지 controller for pno: {}", pno);
        return ResponseEntity.ok(jobMatchingsLogService.getPastWorkplaces(pno));
    }

    // 근무지 상세 정보 조회
    @GetMapping("/detail")
    public ResponseEntity<JobMatchingsListDTO> getJobsDetail(@RequestParam Long jmno) {
        log.info("근무지 상세 정보 조회 controller for jmno: {}", jmno);
        return ResponseEntity.ok(jobMatchingsLogService.getJobsDetail(jmno));
    }

    // 근무 매칭 ID로 고용주 ID 조회
    @GetMapping("/employer/{jmno}")
    public ResponseEntity<Long> getEmployerIdByJobMatchingId(@PathVariable Long jmno) {
        log.info("고용주 ID 조회 controller for jmno: {}", jmno);
        return ResponseEntity.ok(jobMatchingsLogService.getEmployerIdByJobMatchingId(jmno));
    }

    @GetMapping("/time")
    public ResponseEntity<JobMatchingsTimeDTO> getWorkplaceTimes(@RequestParam Long pno, @RequestParam Long jpno) {
        return ResponseEntity.ok(jobMatchingsLogService.getWorkplaceTimes(pno, jpno));
    }

    @GetMapping("/workList")
    public ResponseEntity<PageResponseDTO<JobMatchingsWorkListDTO>> getWorkPlaceList(PageRequestDTO pageRequestDTO, @RequestParam Long pno) {
        return ResponseEntity.ok(jobMatchingsLogService.getWorkPlaceList(pageRequestDTO, pno));
    }

}