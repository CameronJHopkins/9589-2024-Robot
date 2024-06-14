import pywifi
import time

class NetworkManager:
    def __init__(self):
        self.wifi = pywifi.PyWiFi()
        self.iface = self.wifi.interfaces()[0]  # Assume the first wireless interface
        self.scan_results = []

    def scan_wifi_networks(self):
        try:
            self.scan_results = []
            self.iface.scan()
            time.sleep(1)
            scan_results = self.iface.scan_results()

            for result in scan_results:
                ssid = result.ssid
                signal_strength = result.signal
                self.scan_results.append({"ssid": ssid, "signal_strength": signal_strength})
            return self.scan_results
        except Exception as e:
            print(f"Error occurred during network scanning: {e}")
            return []

    def connect_to_wifi(self, network):
        try:
            profile = pywifi.Profile()
            profile.ssid = network["ssid"]
            profile.auth = pywifi.const.AUTH_ALG_OPEN
            profile.akm.append(pywifi.const.AKM_TYPE_NONE)

            self.iface.remove_all_network_profiles()
            tmp_profile = self.iface.add_network_profile(profile)

            self.iface.connect(tmp_profile)
            time.sleep(5)

            if self.iface.status() == pywifi.const.IFACE_CONNECTED:
                return True
            else:
                return False
        except Exception as e:
            print(f"Error occurred during Wi-Fi connection: {e}")
            return False
