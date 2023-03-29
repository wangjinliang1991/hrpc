package com.example.rpc.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

@Slf4j
public class IpUtil {
    public static String getHostAddress() {
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("can not get server host.",e);
        }
        return host;
    }

    public static String getRealIp() {
        String localIp = null;
        String netIp = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            boolean finded = false;
            InetAddress ip = null;
            // traversal network interface
            while (networkInterfaces.hasMoreElements() && !finded) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                // traversal ip
                while (addresses.hasMoreElements()) {
                    ip = addresses.nextElement();
                    if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() &&
                            ip.getHostAddress().indexOf(":") == -1) {
                        // get real ip
                        netIp = ip.getHostAddress();
                        finded = true;
                        break;
                    } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() &&
                            ip.getHostAddress().indexOf(":") == -1) {
                        // not local
                        localIp = ip.getHostAddress();
                    }
                }
            }

            // get real ip first
            if (netIp != null && !"".equals(netIp)) {
                return netIp;
            } else {
                return localIp;
            }
        } catch (SocketException e) {
            log.error("get real ip failed",e);
        }
        return null;
    }
}
