package id.uver.freesis.student.service;

import id.uver.freesis.base_package.dto.ResponseCommonEntity;
import id.uver.freesis.base_package.exception.DataNotFoundException;
import id.uver.freesis.student.dto.request.StudentRequest;
import id.uver.freesis.student.dto.response.StudentResponse;

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
public interface StudentService {
    ResponseCommonEntity<List<StudentResponse>> getAll();
    ResponseCommonEntity<StudentResponse> save(StudentRequest request) throws DataNotFoundException;
    ResponseCommonEntity<StudentResponse> getStudentDetail(String id) throws DataNotFoundException;
    ResponseCommonEntity<StudentResponse> delete(UUID id) throws DataNotFoundException;
}
