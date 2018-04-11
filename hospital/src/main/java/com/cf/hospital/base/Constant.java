/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cf.hospital.base;


import com.cf.hospital.BuildConfig;
import com.cf.hospital.R;

public class Constant {

    public static final String API_BASE_URL = BuildConfig.API_SERVER_URL;


    public static int[] hospitalNames() {
        return new int[]{
                R.string.zhe_yi,
                R.string.shi_yi,
                R.string.lin_an,
                R.string.sheng_zhong_yi
        };
    }
}
