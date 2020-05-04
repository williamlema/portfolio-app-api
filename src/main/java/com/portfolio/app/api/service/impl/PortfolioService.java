package com.portfolio.app.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.portfolio.app.api.exception.NotFoundPortfolioException;
import com.portfolio.app.api.exception.TimelineException;
import com.portfolio.app.api.model.dto.TweetContent;
import com.portfolio.app.api.model.entity.Portfolio;
import com.portfolio.app.api.repository.PortfolioRepository;
import com.portfolio.app.api.service.IPortfolioService;

import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation class for {@link IPortfolioService} interface
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
@Service
public class PortfolioService implements IPortfolioService {

    public final PortfolioRepository portfolioRepository;
    public final Twitter twitterService;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository, Twitter twitterService) {
        this.portfolioRepository = portfolioRepository;
        this.twitterService = twitterService;
    }

    @Override
    public List<Portfolio> getAll() {
        return this.portfolioRepository.findAll();
    }

    @Override
    public Portfolio get(Long id) {
        return this.portfolioRepository.findById(id)
                .orElseThrow(() -> new NotFoundPortfolioException(String.format("Portfolio with Id %d not found", id)));
    }

    @Override
    public Portfolio update(Portfolio portfolioInformation) {
    	if(this.portfolioRepository.findById(portfolioInformation.getId()).isPresent()) {
    		return this.portfolioRepository.saveAndFlush(portfolioInformation);
    	} else {
    		throw new NotFoundPortfolioException(String.format("Can update portfolio,  %1$s id does not exist in system", portfolioInformation.getId()));
    	}
    }
    
    @Override
    public List<TweetContent> getTimeLine(Long id) {
    	Portfolio portfolio = this.portfolioRepository.findById(id)
                .orElseThrow(() -> new NotFoundPortfolioException(String.format("Portfolio with Id %d not found", id)));
    	try {
			return this.twitterService.getUserTimeline(portfolio.getTwitterUserName(), new Paging(1, 5))
					.stream().map(s -> new TweetContent(s)).collect(Collectors.toList());
		} catch (TwitterException e) {
			throw new TimelineException(String.format("Error getting portfolio's timeline or user %1$s does not exist in twitter system", portfolio.getTwitterUserName()));
		}
    }

}
