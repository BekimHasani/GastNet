package org.gastnet.usermicro.repository;

import java.util.List;

import org.gastnet.usermicro.entity.Report;
import org.gastnet.usermicro.enumeration.ReportStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long>{

	List<Report> findByReportStatus(ReportStatus reportStatus);
}
