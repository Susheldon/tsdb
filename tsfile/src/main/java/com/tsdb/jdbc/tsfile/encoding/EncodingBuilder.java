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

package com.tsdb.jdbc.tsfile.encoding;

import com.tsdb.jdbc.common.data.DataType;
import com.tsdb.jdbc.common.exception.UnSupportedDataTypeException;
import com.tsdb.jdbc.tsfile.encoding.encode.Encoder;
import com.tsdb.jdbc.tsfile.encoding.encode.chimp.DoublePrecisionChimpEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.chimp.IntChimpEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.chimp.LongChimpEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.chimp.SinglePrecisionChimpEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.gorilla.DoublePrecisionEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.gorilla.IntGorillaEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.gorilla.LongGorillaEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.gorilla.SinglePrecisionEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.plain.PlainEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.sprintz.DoubleSprintzEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.sprintz.FloatSprintzEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.sprintz.IntSprintzEncoder;
import com.tsdb.jdbc.tsfile.encoding.encode.sprintz.LongSprintzEncoder;
import com.tsdb.jdbc.tsfile.conf.TSFileConfig;
import com.tsdb.jdbc.tsfile.conf.TSFileDescriptor;

public abstract class EncodingBuilder {

    TSFileConfig tsFileConfig = TSFileDescriptor.getInstance().getConf();


    public static EncodingBuilder getEncodingBuilder(TSEncoding type) {
        switch (type) {
            case PLAIN:
                return new Plain();
            case GORILLA:
                return new Gorilla();
            case CHIMP:
                return new Chimp();
            case SPRINTZ:
                return new Sprintz();

            default:
                throw new UnsupportedOperationException(type.toString());
        }
    }

    public abstract Encoder getEncoder(DataType type);


    /**
     * for all DataType.
     */
    public static class Plain extends EncodingBuilder {
        int maxStringLength = tsFileConfig.getMaxStringLength();

        @Override
        public Encoder getEncoder(DataType type) {
            return new PlainEncoder(type, maxStringLength);
        }


    }


    /**
     * for FLOAT, DOUBLE, INT, LONG.
     */
    public static class Chimp extends EncodingBuilder {

        @Override
        public Encoder getEncoder(DataType type) {
            switch (type) {
                case FLOAT:
                    return new SinglePrecisionChimpEncoder();
                case DOUBLE:
                    return new DoublePrecisionChimpEncoder();
                case INTEGER:
                    return new IntChimpEncoder();
                case BIGINT:
                    return new LongChimpEncoder();
                default:
                    throw new UnSupportedDataTypeException("CHIMP doesn't support data type: " + type);
            }
        }


    }

    /**
     * for FLOAT, DOUBLE, INT, LONG.
     */
    public static class Gorilla extends EncodingBuilder {

        @Override
        public Encoder getEncoder(DataType type) {
            switch (type) {
                case FLOAT:
                    return new SinglePrecisionEncoder();
                case DOUBLE:
                    return new DoublePrecisionEncoder();
                case INTEGER:
                    return new IntGorillaEncoder();
                case BIGINT:
                    return new LongGorillaEncoder();
                default:
                    throw new UnSupportedDataTypeException("GORILLA doesn't support data type: " + type);
            }
        }


    }

    /**
     * for FLOAT, DOUBLE, INT, LONG.
     */
    public static class Sprintz extends EncodingBuilder {
        @Override
        public Encoder getEncoder(DataType type) {
            switch (type) {
                case INTEGER:
                    return new IntSprintzEncoder();
                case BIGINT:
                    return new LongSprintzEncoder();
                case FLOAT:
                    return new FloatSprintzEncoder();
                case DOUBLE:
                    return new DoubleSprintzEncoder();
                default:
                    throw new UnSupportedDataTypeException("Sprintz doesn't support data type: " + type);
            }
        }


    }

}
