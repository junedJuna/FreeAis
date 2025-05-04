package id.uver.freesis.class_service.service.impl;

import id.uver.freesis.base_package.constant.ResponseEnum;
import id.uver.freesis.base_package.dto.ResponseCommonEntity;
import id.uver.freesis.base_package.exception.DataNotFoundException;
import id.uver.freesis.base_package.util.ResponseBuilder;
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
    public static final String CLASS_NOT_FOUND = "Class not found";
    private String serviceCode = "10";

    private final ClassRepository classRepository;

    public ResponseCommonEntity<List<ClassResponse>> getAll() {
        List<MstClass> classList = classRepository.findAll();
        return ResponseBuilder.buildResponse(ResponseEnum.SUCCESS, serviceCode, mapToDtoList(classList));
    }

    public ResponseCommonEntity<ClassResponse> getClassDetail(UUID id) throws DataNotFoundException {
        MstClass mstClass = classRepository.findById(id).orElseThrow(() -> new DataNotFoundException(CLASS_NOT_FOUND));
        return ResponseBuilder.buildResponse(ResponseEnum.SUCCESS, serviceCode, mapToDto(mstClass));
    }

    public ResponseCommonEntity<ClassResponse> save(ClassRequest request) throws DataNotFoundException {
        MstClass mstClass;
        if (request.getId() != null) {
            mstClass = classRepository.findById(UUID.fromString(request.getId())).orElseThrow(() -> new DataNotFoundException(CLASS_NOT_FOUND));
        } else {
            mstClass = new MstClass();
        }
        mstClass.setClassCode(request.getClassCode());
        mstClass.setClassName(request.getClassName());
        mstClass.setClassDescription(request.getClassDescription());
        classRepository.save(mstClass);

        return ResponseBuilder.buildResponse(ResponseEnum.SUCCESS, serviceCode, mapToDto(mstClass));
    }

    public ResponseCommonEntity<ClassResponse> delete(UUID id) throws DataNotFoundException {
        MstClass mstClass = classRepository.findById(id).orElseThrow(() -> new DataNotFoundException(CLASS_NOT_FOUND));
        mstClass.setDeletedBy("SYSTEM");
        mstClass.setDeletedDate(LocalDateTime.now());
        classRepository.save(mstClass);

        return ResponseBuilder.buildResponse(ResponseEnum.SUCCESS, serviceCode, mapToDto(mstClass));
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
