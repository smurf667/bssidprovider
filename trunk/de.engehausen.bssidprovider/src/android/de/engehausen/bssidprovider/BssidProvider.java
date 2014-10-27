package de.engehausen.bssidprovider;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class BssidProvider extends CordovaPlugin {

	private static final String TAG = "BssidProvider";

	private static final String ACTION_GET_BSSID = "getBSSID";
	
	@Override
	public boolean execute(final String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (ACTION_GET_BSSID.equals(action)) {
			cordova.getThreadPool().execute(new Runnable() {
				@Override
				public void run() {
					final WifiManager wifiManager = (WifiManager) cordova.getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
					if (wifiManager != null) {
					    final WifiInfo wifiInfo = wifiManager.getConnectionInfo();
					    if (wifiInfo != null) {
						    final String result = wifiInfo.getBSSID();
						    if (result != null) {
						    	callbackContext.success(result);
						    } else {
								reportError(callbackContext, "NO_BSSID");
						    }
					    } else {
							reportError(callbackContext, "NO_WIFI_INFO");
					    }
					} else {
						reportError(callbackContext, "NO_WIFI_MANAGER");
					}
				}				
			});
			return true;
		} else {
			callbackContext.error("NO_FUNCTION_"+action);
			return false;
		}
	}
	
	private void reportError(final CallbackContext ctx, final String msg) {
		Log.d(TAG, msg);		
		ctx.error(msg);
	}
	
}