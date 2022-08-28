package com.talkfree.talkfreebackend.util;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public interface DeviceResolver {

    Device resolverDevice(HttpServletRequest request);
}
