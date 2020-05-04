package com.portfolio.app.api.service;


import com.portfolio.app.api.model.dto.TweetContent;
import com.portfolio.app.api.model.entity.Portfolio;

import java.util.List;

/**
 * CRUD operation for {@link Portfolio} entity
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
public interface IPortfolioService {

    /**
     * Retrieve all portfolios in system
     *
     * @return
     */
    List<Portfolio> getAll();

    /**
     * Retrieve single portfolio information
     *
     * @param id
     * @return
     */
    Portfolio get(Long id);

    /**
     * Update portfolio information
     *
     * @param portfolioInformation
     * @return
     */
    Portfolio update(Portfolio portfolioInformation);
    
    /**
     * Get twitter time line from specific portfolio id
     * 
     * @param id
     * @return
     */
    List<TweetContent> getTimeLine(Long id) ;

}
