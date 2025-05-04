package id.uver.freesis.class_service.service.impl;

import id.uver.freesis.base_package.dto.CommonResponse;
import id.uver.freesis.class_service.dto.request.ClassRequest;
import id.uver.freesis.class_service.dto.response.ClassResponse;
import id.uver.freesis.class_service.entity.MstClass;
import id.uver.freesis.class_service.repository.ClassRepository;
import id.uver.freesis.class_service.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    public CommonResponse<List<ClassResponse>> getAll() {
        List<MstClass> classList = classRepository.findAll();
        CommonResponse<List<ClassResponse>> response = new CommonResponse<>();
        response.setRespCode("2001000");
        response.setRespMessage("Success");
        response.setData(mapToDtoList(classList));
        return response;
    }

    public CommonResponse<ClassResponse> getClassDetail(UUID id) {
        MstClass mstClass = classRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Class not found"));
        CommonResponse<ClassResponse> response = new CommonResponse<>();
        response.setRespCode("2001000");
        response.setRespMessage("Success");
        response.setData(mapToDto(mstClass));
        return response;
    }

    public CommonResponse<ClassResponse> save(ClassRequest request) {
        MstClass mstClass;
        if (request.getId() != null) {
            mstClass = classRepository.findById(UUID.fromString(request.getId())).orElseThrow(() -> new IllegalArgumentException("Class not found"));
        } else {
            mstClass = new MstClass();
        }
        mstClass.setClassCode(request.getClassCode());
        mstClass.setClassName(request.getClassName());
        mstClass.setClassDescription(request.getClassDescription());
        classRepository.save(mstClass);

        CommonResponse<ClassResponse> response = new CommonResponse<>();
        response.setRespCode("2001000");
        response.setRespMessage("Success");
        response.setData(mapToDto(mstClass));
        return response;
    }

    public CommonResponse<ClassResponse> delete(UUID id) {
        MstClass mstClass = classRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Class not found"));
        mstClass.setDeletedBy("SYSTEM");
        mstClass.setDeletedDate(LocalDateTime.now());
        classRepository.save(mstClass);

        CommonResponse<ClassResponse> response = new CommonResponse<>();
        response.setRespCode("2001000");
        response.setRespMessage("Success");
        response.setData(mapToDto(mstClass));
        return response;
    }

    private List<ClassResponse> mapToDtoList(List<MstClass> classList) {
        List<ClassResponse> dtoList = new ArrayList<>();
        for (MstClass mstClass : classList) {
            ClassResponse classResponse = new ClassResponse();
            classResponse.setId(mstClass.getId().toString());
            classResponse.setClassCode(mstClass.getClassCode());
            classResponse.setClassName(mstClass.getClassName());
            classResponse.setClassDescription(mstClass.getClassDescription());
            dtoList.add(classResponse);
        }
        return dtoList;
    }

    private ClassResponse mapToDto(MstClass mstClass) {
        ClassResponse classResponse = new ClassResponse();
        classResponse.setId(mstClass.getId().toString());
        classResponse.setClassCode(mstClass.getClassCode());
        classResponse.setClassName(mstClass.getClassName());
        classResponse.setClassDescription(mstClass.getClassDescription());
        return classResponse;
    }
}
