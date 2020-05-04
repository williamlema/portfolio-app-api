package com.portfolio.app.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.portfolio.app.api.model.dto.Response;
import com.portfolio.app.api.model.dto.TweetContent;
import com.portfolio.app.api.model.entity.Portfolio;
import com.portfolio.app.api.service.IPortfolioService;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioControllerSpec {

	@InjectMocks
	private PortfolioController controller;

	@Mock
	private IPortfolioService service;

	@Test
	public void givenPortfolioId_whenGetPorfolio_thenReturnPorfolioInformation() {
		Portfolio p = new Portfolio(1L, "Test Desc", "url", "username", "tittle");
		when(service.get(1L)).thenReturn(p);

		ResponseEntity<Response<Portfolio>> response = controller.getPortfolio(1L);

		assertThat(response.getBody()).isInstanceOf(Response.class);
		assertThat(response.getBody().getData()).isEqualTo(p);

		verify(service).get(1L);
		verifyNoMoreInteractions(service);
	}

	@Test
	public void givenPortfolio_whenUpdatePortfolio_thenReturnUpdatedPorfolioInformation() {
		Portfolio p = new Portfolio(1L, "Test Desc", "url", "username", "tittle");
		when(service.update(p)).thenReturn(p);

		ResponseEntity<Response<Portfolio>> response = controller.updatePortfolio(p);

		assertThat(response.getBody()).isInstanceOf(Response.class);
		assertThat(response.getBody().getData()).isEqualTo(p);

		verify(service).update(p);
		verifyNoMoreInteractions(service);
	}

	@Test
	public void givenResquest_whenFindAll_thenReturnPorfolioInformation() {
		Portfolio p = new Portfolio(1L, "Test Desc", "url", "username", "tittle");
		List<Portfolio> list = Collections.singletonList(p);
		when(service.getAll()).thenReturn(list);

		ResponseEntity<Response<List<Portfolio>>> response = controller.findAll();

		assertThat(response.getBody()).isInstanceOf(Response.class);
		assertThat(response.getBody().getData()).isEqualTo(list);

		verify(service).getAll();
		verifyNoMoreInteractions(service);
	}

	@Test
	public void givenUsername_whenGetPortfolioTimeline_thenReturnRelatedTweetContent() {
		Long user = 1L;
		List<TweetContent> list = Collections.emptyList();
		when(service.getTimeLine(user)).thenReturn(list);

		ResponseEntity<Response<List<TweetContent>>> response = controller.getPortfolioTimeline(user);

		assertThat(response.getBody()).isInstanceOf(Response.class);
		assertThat(response.getBody().getData()).isEqualTo(list);

		verify(service).getTimeLine(user);
		verifyNoMoreInteractions(service);
	}
}
