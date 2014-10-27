#import "BssidProvider.h"
#import <Cordova/CDV.h>
#import <Cordova/CDVPluginResult.h>
#import <SystemConfiguration/CaptiveNetwork.h>

@interface BssidProvider ()

@end

@implementation BssidProvider

- (void)getBSSID:(CDVInvokedUrlCommand*)command {
    // TODO need an Objective-C/iOS expert - any leaks here?
    CFArrayRef ifs = CNCopySupportedInterfaces();
    if (CFArrayGetCount(ifs) > 0) {
        // TODO just getting the 1st interface, not iterating... should we?
        CFDictionaryRef dict = CNCopyCurrentNetworkInfo(CFArrayGetValueAtIndex(ifs, 0));
        NSString *bssid = CFDictionaryGetValue(dict, kCNNetworkInfoKeyBSSID);
        if (bssid) {
		    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:bssid];
		    [self writeJavascript:[pluginResult toSuccessCallbackString:command.callbackId]];
        } else {
            CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"NO_BSSID"];
            [self writeJavascript:[pluginResult toErrorCallbackString:command.callbackId]];
        }
    } else {
        CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"NO_NET_INTERFACES"];
        [self writeJavascript:[pluginResult toErrorCallbackString:command.callbackId]];
    }
}
                             
@end
