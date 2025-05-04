package id.uver.freesis.base_package.util;

import id.uver.freesis.base_package.constant.ResponseEnum;
import id.uver.freesis.base_package.dto.ResponseCommonEntity;

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


public class ResponseBuilder {
    private ResponseBuilder(){}

    public static <T> ResponseCommonEntity<T> buildResponse(String code, String msg, T data) {
        ResponseCommonEntity<T> response = new ResponseCommonEntity<>();
        response.setRespCode(code);
        response.setRespMessage(msg);
        response.setData(data);
        return response;
    }

    public static <T> ResponseCommonEntity<T> buildResponse(ResponseEnum responseEnum, String serviceCode, T data) {
        ResponseCommonEntity<T> response = new ResponseCommonEntity<>();
        response.setRespCode(responseEnum.getHttpCode()+serviceCode+responseEnum.getRespCode());
        response.setRespMessage(responseEnum.getRespMessage());
        response.setData(data);
        return response;
    }
}
