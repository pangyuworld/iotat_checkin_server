package com.pang.card;

import org.junit.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author pang
 * @version V1.0
 * @ClassName: MacTest
 * @Package com.pang.card
 * @description:
 * @date 2019/11/23 13:14
 */
public class MacTest {
    @Test
    public void test() throws SocketException {
        InetAddress ia = null;
        try {
            ia = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        NetworkInterface parent = NetworkInterface.getByInetAddress(ia).getParent();
        byte[] mac =parent.getHardwareAddress();
        // byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        StringBuffer macStringBuffer = new StringBuffer("");
        if (mac == null) {
            return ;
        } else {
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    macStringBuffer.append("-");
                }
                int temp = mac[i] & 0xff;
                String str = Integer.toHexString(temp);
                if (str.length() == 1) {
                    macStringBuffer.append("0" + str);
                } else {
                    macStringBuffer.append(str);
                }
            }
            System.out.println(macStringBuffer.toString().toUpperCase());
        }
    }
}
