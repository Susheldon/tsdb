/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.tsdb.jdbc;

public class Config {

    private Config() {
        // Empty constructor
    }

    /** The required prefix for the connection URL. */
    public static final String TSDB_URL_PREFIX = "jdbc:tsdb://";
    

    public static final String TSDB_ERROR_PREFIX = "Error";

    static final String TSDB_DEFAULT_HOST = "localhost";
    /** If host is provided, without a port. */
    static final int TSDB_DEFAULT_PORT = 6667;

    /** TsFile's default database name. */
    static final String DEFAULT_DATABASE_NAME = "default";

    static final String AUTH_USER = "user";
    static final String DEFAULT_USER = "user";

    static final String AUTH_PASSWORD = "password";
    static final String DEFAULT_PASSWORD = "password";

    static final int RETRY_NUM = 3;
    static final long RETRY_INTERVAL_MS = 1000;

    public static final int DEFAULT_FETCH_SIZE = 5000;
    static final int DEFAULT_CONNECTION_TIMEOUT_MS = 0;

    public static final String VERSION = "version";

    static final Constant.Version DEFAULT_VERSION = Constant.Version.V_0_1;
    public static final String JDBC_DRIVER_NAME = "com.tsdb.jdbc.Driver";

    public static boolean rpcThriftCompressionEnable = false;

    /** Key of thrift default buffer size. */
    public static final String DEFAULT_BUFFER_CAPACITY = "thrift_default_buffer_capacity";

    /** Key of thrift max frame size. */
    public static final String THRIFT_FRAME_MAX_SIZE = "thrift_max_frame_size";

    /** Key of underlying transport socketTimeout and connectionTimeout. */
    public static final String NETWORK_TIMEOUT = "network_timeout";

    /** Key of connection's time zone. */
    public static final String TIME_ZONE = "time_zone";

    public static final String USE_SSL = "use_ssl";

    public static final String TRUST_STORE = "trust_store";

    public static final String TRUST_STORE_PWD = "trust_store_pwd";
}
