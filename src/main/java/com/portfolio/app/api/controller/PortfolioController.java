package com.portfolio.app.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.portfolio.app.api.model.dto.Response;
import com.portfolio.app.api.model.dto.TweetContent;
import com.portfolio.app.api.model.entity.Portfolio;
import com.portfolio.app.api.service.IPortfolioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static  com.portfolio.app.api.constant.Resource.PORTFOLIO;
import static  com.portfolio.app.api.constant.Resource.PORTFOLIO_ID;
import static  com.portfolio.app.api.constant.Resource.PORTFOLIO_TIME_LINE;

/**
 * RestController definition to expose Portfolio operation
 * 
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(PORTFOLIO)
@CrossOrigin
public class PortfolioController {

    private final IPortfolioService iPortfolioService;

    @Autowired
    public PortfolioController(IPortfolioService iPortfolioService) {
        this.iPortfolioService = iPortfolioService;
    }
    
    @GetMapping(PORTFOLIO_ID)
    public ResponseEntity<Response<Portfolio>> getPortfolio (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Portfolio>(this.iPortfolioService.get(id)));
    }

    @PatchMapping
    public ResponseEntity<Response<Portfolio>> updatePortfolio(@RequestBody @Valid Portfolio portfolio) {
        return ResponseEntity.status(HttpStatus.OK).body(new Response<Portfolio>(this.iPortfolioService.update(portfolio)));
    }

    @GetMapping
    public  ResponseEntity<Response<List<Portfolio>>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new Response<List<Portfolio>>(this.iPortfolioService.getAll()));
    }
    
    @GetMapping(PORTFOLIO_TIME_LINE)
    public ResponseEntity<Response<List<TweetContent>>> getPortfolioTimeline (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new Response<List<TweetContent>>(this.iPortfolioService.getTimeLine(id)));
    }

}
