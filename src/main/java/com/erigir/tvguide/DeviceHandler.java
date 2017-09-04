package com.erigir.tvguide;

import com.erigir.tvguide.model.DeviceResponse;
import com.erigir.tvguide.model.TeamViewerDevice;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Builder
public class DeviceHandler {
  private static final Logger LOG = LoggerFactory.getLogger(DeviceHandler.class);
  private RestTemplate restTemplate;
  private static String ROOT = "https://webapi.teamviewer.com";

  public List<TeamViewerDevice> fetchAllDevices()
  {
    /*ResponseEntity<List<Map>> rateResponse =
        restTemplate.exchange(ROOT+"/api/v1/devices",
            HttpMethod.GET, null, new ParameterizedTypeReference<List<Map>>() {
            });
    List<Map> rval = rateResponse.getBody();
    */
    DeviceResponse rval = restTemplate.getForObject(ROOT+"/api/v1/devices", DeviceResponse.class);

    return rval.getDevices();
  }

}
