package ShareData.browser.serviciu;

import configFile.configNode.DriverConfigNode;

public interface BrowserService {
    void openBrowser(DriverConfigNode driverConfigNode);
    Object getBrowserOptions(DriverConfigNode driverConfigNode);

}
