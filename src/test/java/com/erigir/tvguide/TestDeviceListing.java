package com.erigir.tvguide;

import com.erigir.tvguide.model.TeamViewerDevice;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

import java.util.List;

public class TestDeviceListing {
  private static final Logger LOG = LoggerFactory.getLogger(TestDeviceListing.class);

  @Test
  public void testListAllDevices()
      throws Exception
  {
    DeviceHandler instance = DeviceHandler.builder().restTemplate(RestTemplateConfigurer.configureRestTemplate(new RestTemplate(), new EnvironmentalVariableTokenProvider())).build();
    List<TeamViewerDevice> list = instance.fetchAllDevices();

    assertNotNull (list);
    assertTrue(list.size()>0);
  }
}
