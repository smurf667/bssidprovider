#import <Cordova/CDVPlugin.h>

@interface BssidProvider : CDVPlugin

- (void)getBSSID:(CDVInvokedUrlCommand*)command;

@end