package com.portfolio.app.api.repository;

import com.portfolio.app.api.model.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to handle {@link Portfolio} entity from database
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */

public interface PortfolioRepository extends JpaRepository<Portfolio, Long>{
	
}