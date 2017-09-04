package com.erigir.tvguide;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RestTemplateConfigurer {
  public static Logger LOG = LoggerFactory.getLogger(RestTemplateConfigurer.class);

  /**
   * Adds an interceptor that provides the auth token to the rest template.
   * Returns the configured rest template to allow for easy command chaining
   * @param restTemplate RestTemplate to configure
   * @param teamViewerTokenProvider TeamViewerTokenProvider that will provide the login token
   * @throw IllegalStateException On null restTemplate or teamViewerTokenProvider
   * @return RestTemplate configured
   */
  public static RestTemplate configureRestTemplate(RestTemplate restTemplate, TeamViewerTokenProvider teamViewerTokenProvider)
    throws IllegalStateException
  {
    assert(restTemplate!=null);
    assert(teamViewerTokenProvider!=null);

    List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
    interceptors = (interceptors==null)?new LinkedList<>():interceptors;
    restTemplate.setInterceptors(interceptors);

    LOG.trace("Adding token provider {} to rest template", teamViewerTokenProvider.getClass());
    interceptors.add(new ClientHttpRequestInterceptor() {
      @Override
      public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        httpRequest.getHeaders().add("Authorization", "Bearer "+teamViewerTokenProvider.getToken());
        return clientHttpRequestExecution.execute(httpRequest, bytes);
      }
    });

    return restTemplate;
  }
}
