package id.uver.freesis.base_package.constant;

import lombok.Getter;

/*
 * Copyright 2025 Juned Juna
 *
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
public enum ResponseEnum {

    SUCCESS("200", "00", "Success");

    @Getter
    private final String httpCode;
    @Getter
    private final String respCode;
    @Getter
    private final String respMessage;

    ResponseEnum(String httpCode, String respCode, String respMessage) {
        this.httpCode = httpCode;
        this.respCode = respCode;
        this.respMessage = respMessage;
    }

}
