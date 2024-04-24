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

package com.tsdb.common.config;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TSDBConstant {

    public static final String GLOBAL_DB_NAME = "TSDB";
    public static final Charset STRING_CHARSET = StandardCharsets.UTF_8;

    public static final int OBJECT_HEADER_SIZE = System.getProperty("java.vm.compressedOopsMode") == null ? 16 : 12;

    public static final String TSDB_THREADPOOL_PACKAGE = "com.tsdb.threadpool";
}
