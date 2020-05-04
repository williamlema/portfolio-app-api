package com.portfolio.app.api.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.portfolio.app.api.exception.NotFoundPortfolioException;
import com.portfolio.app.api.exception.TimelineException;
import com.portfolio.app.api.model.entity.Portfolio;
import com.portfolio.app.api.repository.PortfolioRepository;

import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioServiceSpec {

	@InjectMocks
	PortfolioService service;

	@Mock
	PortfolioRepository portfolioRepository;

	@Mock
	Twitter twitterService;

	@Test
	public void givenResquest_whenGetAll_thenReturnPortfolioList() {
		Portfolio p = new Portfolio(1L, "Test Desc", "url", "username", "tittle");
		List<Portfolio> list = Collections.singletonList(p);
		when(portfolioRepository.findAll()).thenReturn(list);

		List<Portfolio> value = service.getAll();

		assertThat(value).isInstanceOf(List.class);
		assertThat(value).isEqualTo(list);

		verify(portfolioRepository).findAll();
		verifyNoMoreInteractions(portfolioRepository);
	}

	@Test
	public void givenPortfolio_whenUpdate_thenReturnUpdatedPortfolio() {
		Portfolio p = new Portfolio(1L, "Test Desc", "url", "username", "tittle");
		when(portfolioRepository.saveAndFlush(p)).thenReturn(p);
		when(portfolioRepository.findById(1L)).thenReturn(Optional.of(p));

		Portfolio value = service.update(p);

		assertThat(value).isInstanceOf(Portfolio.class);
		assertThat(value).isEqualTo(p);

		verify(portfolioRepository).findById(1L);
		verify(portfolioRepository).saveAndFlush(p);
		verifyNoMoreInteractions(portfolioRepository);
	}
	
	@Test(expected = NotFoundPortfolioException.class)
	public void givenPortfolio_whenUpdate_thenReturnException() {
		Portfolio p = new Portfolio(1L, "Test Desc", "url", "username", "tittle");
		Optional<Portfolio> optional = Optional.empty();
		when(portfolioRepository.findById(1l)).thenReturn(optional);

		service.update(p);

	}

	@Test
	public void givenExistingPortfolioId_whenGet_thenReturnPortfolio() {
		Portfolio p = new Portfolio(1L, "Test Desc", "url", "username", "tittle");
		Optional<Portfolio> optional = Optional.of(p);
		when(portfolioRepository.findById(1l)).thenReturn(optional);

		Portfolio value = service.get(1L);

		assertThat(value).isInstanceOf(Portfolio.class);
		assertThat(value).isEqualTo(p);

		verify(portfolioRepository).findById(1L);
		verifyNoMoreInteractions(portfolioRepository);
	}

	@Test(expected = NotFoundPortfolioException.class)
	public void givenInvalidPortfolioId_whenGet_thenReturnException() {
		Optional<Portfolio> optional = Optional.empty();
		when(portfolioRepository.findById(1l)).thenReturn(optional);

		service.get(1L);

	}

	@Test(expected = NotFoundPortfolioException.class)
	public void givenPorfolioe_whenGetTimeLine_thenReturnException() throws TwitterException {
		when(portfolioRepository.findById(1l)).thenReturn(Optional.empty());

		service.getTimeLine(1L);

	}
	
	@Test(expected = TimelineException.class)
	public void givenPorfolioWithInvalidUserName_whenGetTimeLine_thenReturnException() throws TwitterException {
		Portfolio p = new Portfolio(1L, "Test Desc", "url", "username", "tittle");
		when(portfolioRepository.findById(1L)).thenReturn(Optional.of(p));
		when(twitterService.getUserTimeline("username", new Paging(1, 5))).thenThrow(new TwitterException("error"));

		service.getTimeLine(1L);

	}
}
