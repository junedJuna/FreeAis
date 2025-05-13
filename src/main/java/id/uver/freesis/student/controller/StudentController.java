package id.uver.freesis.student.controller;

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

import id.uver.freesis.base_package.dto.ResponseCommonEntity;
import id.uver.freesis.base_package.exception.DataNotFoundException;
import id.uver.freesis.student.dto.request.StudentRequest;
import id.uver.freesis.student.dto.response.StudentResponse;
import id.uver.freesis.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseCommonEntity<List<StudentResponse>> getStudentList(StudentRequest request) {
        return studentService.getAll();
    }
    @PostMapping("/save")
    public ResponseCommonEntity<StudentResponse> saveStudent(@RequestBody StudentRequest request) throws DataNotFoundException {
        return studentService.save(request);
    }

    @GetMapping("/get/{id}")
    public ResponseCommonEntity<StudentResponse> getStudentById(@PathVariable("id") String id) throws DataNotFoundException {
        return studentService.getStudentDetail(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseCommonEntity<StudentResponse> deleteStudent(@PathVariable("id") String id) throws DataNotFoundException {
        return studentService.delete(UUID.fromString(id));
    }
}
