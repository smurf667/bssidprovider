# bssidprovider
 Apache Cordova plug-in providing the BSSID (MAC address) of an existing wifi connection

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
