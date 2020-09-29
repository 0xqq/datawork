/*-
 * <<
 * task
 * ==
 * Copyright (C) 2019 - 2020 sia
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * >>
 */

package top.dataworks.task.core.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author: pengfeili23
 * @Description: 网络测试工具：ping 与 telnet
 * @date: 2018年6月27日 下午5:47:14
 */
public class NetHelper {

    private NetHelper() {
    }

    private final static int TIMEOUT = 5000;

    /**
     * ping 远程IP
     *
     * @param ipStr
     * @return
     */
    public static boolean ping(String ipStr) {

        try {
            InetAddress inetAddress = InetAddress.getByName(ipStr);
            if (inetAddress.isReachable(TIMEOUT)) {
                return true;
            }
        } catch (Exception e) {
            // ignore
        }
        return false;
    }

    /**
     * telnet 远程IP和port
     *
     * @param hostname
     * @param port
     * @return
     */
    public static boolean telnet(String hostname, int port) {

        Socket server = null;
        try {
            server = new Socket();
            InetSocketAddress address = new InetSocketAddress(hostname, port);
            server.connect(address, TIMEOUT);
            return true;
        } catch (Exception e) {
            // ignore
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    // ignore
                }
            }
        }
        return false;
    }

}
