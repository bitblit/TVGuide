package com.erigir.tvguide.model;

import lombok.Data;

import java.util.List;

@Data
public class DeviceResponse {
  private List<TeamViewerDevice> devices;
}
