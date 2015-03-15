# bssidprovider
 Apache Cordova plug-in providing the [BSSID](http://en.wikipedia.org/wiki/Service_set_%28802.11_network%29#Basic_service_set_identification_.28BSSID.29) (MAC address) of an existing wifi connection

This Apache Cordova plug-in provides the BSSID (MAC address) of an existing wifi connection.

It's been tested on iOS only, feedback on the Android implementation which I did "blindly" is welcome!

Usage:

```javascript
window.plugins.BssidProvider.getBSSID(
    function(id) {
        // success, id contains the MAC address of the wifi connection
    },
    function(reason) {
        // an error occurred
    }
);
```
