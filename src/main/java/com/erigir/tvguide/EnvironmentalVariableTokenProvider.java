package com.erigir.tvguide;

public class EnvironmentalVariableTokenProvider implements TeamViewerTokenProvider{
  private static final String ENV_VAR_NAME="TEAMVIEWER_SCRIPT_TOKEN";
  @Override
  public String getToken() {
    String rval = System.getenv(ENV_VAR_NAME);
    if (rval==null || rval.trim().length()==0)
    {
      rval = System.getProperty(ENV_VAR_NAME);
    }
    if (rval==null || rval.trim().length()==0)
    {
      throw new IllegalStateException("Neither environmental variable nor system property "+ENV_VAR_NAME+" set");
    }
    return rval;
  }
}
