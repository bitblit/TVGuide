package com.erigir.tvguide.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class TeamViewerDevice {
  private static final Logger LOG = LoggerFactory.getLogger(TeamViewerDevice.class);

  @JsonProperty("remotecontrol_id")
  private String remoteControlId;
  @JsonProperty("device_id")
  private String deviceId;
  @JsonProperty("alias")
  private String alias;
  @JsonProperty("groupid")
  private String groupId;
  @JsonProperty("online_state")
  private String onlineState;
  @JsonProperty("assigned_to")
  private String assignedTo;
  @JsonProperty("supported_features")
  private String supportedFeatures;

}
