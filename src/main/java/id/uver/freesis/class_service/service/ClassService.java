package id.uver.freesis.class_service.service;

import id.uver.freesis.base_package.dto.CommonResponse;
import id.uver.freesis.class_service.dto.request.ClassRequest;
import id.uver.freesis.class_service.dto.response.ClassResponse;

import java.util.List;
import java.util.UUID;

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
public interface ClassService {
    public CommonResponse<List<ClassResponse>> getAll();
    public CommonResponse<ClassResponse> save(ClassRequest request);
    public CommonResponse<ClassResponse> getClassDetail(UUID id);
    public CommonResponse<ClassResponse> delete(UUID id);
}
