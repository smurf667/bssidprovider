'use strict';

var exec = require('cordova/exec');

/**
 * BssidProvider provides the BSSID (MAC address) of an existing wifi connection.
 * 
 * @module BssidProvider
 */
function BssidProvider() {

	/**
	 * Returns the BSSID of the currently active wifi connection. If the BSSID cannot
	 * be determined, the error callback is invoked. If the BSSID can be determined,
	 * the success callback is invoked with the determined ID.
	 * @function getBSSID
	 * @param {function} successCallback function called in case of success (mandatory)
	 * @param {function} errorCallback function called in case of error (mandatory)
	 * @instance
	 * @memberof module:BssidProvider
	 */
	this.getBSSID = function(successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, 'BssidProvider', 'getBSSID', []);		
	};
	
}

var BssidProvider = new BssidProvider();
/* global module */
module.exports = BssidProvider;
