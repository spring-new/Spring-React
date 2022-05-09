package com.sin.test.jdk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class ip {
    @Autowired
     InetAddress inetAddress;

    //获取本机IP
    public static String getLocalIP() {
        try{
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()){
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()){
                    InetAddress ip = (InetAddress) addresses.nextElement();
                    if (ip != null
                            && ip instanceof Inet4Address
                            && !ip.isLoopbackAddress() //loopback地址即本机地址，IPv4的loopback范围是127.0.0.0 ~ 127.255.255.255
                            && ip.getHostAddress().indexOf(":")==-1){
                        return ip.getHostAddress();
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public  String InetAddress2() {

        try {
            System.out.println(inetAddress.getCanonicalHostName());
            System.out.println(inetAddress.getAddress());

            System.out.println(inetAddress.getCanonicalHostName());
            System.out.println(inetAddress.isAnyLocalAddress());
            System.out.println(inetAddress.isLinkLocalAddress());
            System.out.println(inetAddress.isLoopbackAddress());
            System.out.println(inetAddress.isMCGlobal());
            System.out.println(inetAddress.isMulticastAddress());
        } catch (Exception exception) {
        }
        return "s";
    }

    public static void main(String[] args) {
        getLocalIP();
    }
}
