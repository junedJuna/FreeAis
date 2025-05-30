package id.uver.freesis.class_service.controller;

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
import id.uver.freesis.class_service.dto.request.ClassRequest;
import id.uver.freesis.class_service.dto.response.ClassResponse;
import id.uver.freesis.class_service.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @GetMapping("/get")
    public ResponseCommonEntity<List<ClassResponse>> getClassList(ClassRequest request) {
        return classService.getAll();
    }
    @PostMapping("/save")
    public ResponseCommonEntity<ClassResponse> saveClass(@RequestBody ClassRequest request) throws DataNotFoundException {
        return classService.save(request);
    }

    @GetMapping("/get/{id}")
    public ResponseCommonEntity<ClassResponse> getClassById(@PathVariable("id") String id) throws DataNotFoundException {
        return classService.getClassDetail(UUID.fromString(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseCommonEntity<ClassResponse> deleteClass(@PathVariable("id") String id) throws DataNotFoundException {
        return classService.delete(UUID.fromString(id));
    }
}
