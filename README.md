# TVGuide
A toolkit for working with TeamViewers API

## Usage

1. Create a RestTemplate (see Spring documentation)
2. Create a implementation of TeamViewerTokenProvider (or just use one like EnvironmentalVariableTokenProvider)
3. Configure the RestTemplate using RestTemplateConfigurer
4. Pass the configured RestTemplate to a handler (Like DeviceHandler) and call methods
 