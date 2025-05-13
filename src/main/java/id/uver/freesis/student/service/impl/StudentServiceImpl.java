package id.uver.freesis.student.service.impl;

import id.uver.freesis.base_package.constant.ResponseEnum;
import id.uver.freesis.base_package.dto.ResponseCommonEntity;
import id.uver.freesis.base_package.exception.DataNotFoundException;
import id.uver.freesis.base_package.util.ResponseBuilder;
import id.uver.freesis.student.dto.request.StudentRequest;
import id.uver.freesis.student.dto.response.StudentResponse;
import id.uver.freesis.student.entity.MstStudent;
import id.uver.freesis.student.repository.StudentRepository;
import id.uver.freesis.student.service.StudentService;
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
public class StudentServiceImpl implements StudentService {
    public static final String STUDENT_NOT_FOUND = "Student not found";
    private String serviceCode = "10";

    private final StudentRepository studentRepository;

    public ResponseCommonEntity<List<StudentResponse>> getAll() {
        List<MstStudent> classList = studentRepository.findAll();
        return ResponseBuilder.buildResponse(ResponseEnum.SUCCESS, serviceCode, mapToDtoList(classList));
    }

    public ResponseCommonEntity<StudentResponse> getStudentDetail(String id) throws DataNotFoundException {
        MstStudent mstStudent = studentRepository.findOneByStudentId(id).orElseThrow(() -> new DataNotFoundException(STUDENT_NOT_FOUND));
        return ResponseBuilder.buildResponse(ResponseEnum.SUCCESS, serviceCode, mapToDto(mstStudent));
    }

    public ResponseCommonEntity<StudentResponse> save(StudentRequest request) throws DataNotFoundException {
        MstStudent mstClass = new MstStudent();
        studentRepository.save(mstClass);

        return ResponseBuilder.buildResponse(ResponseEnum.SUCCESS, serviceCode, mapToDto(mstClass));
    }

    public ResponseCommonEntity<StudentResponse> delete(UUID id) throws DataNotFoundException {
        MstStudent mstClass = studentRepository.findById(id).orElseThrow(() -> new DataNotFoundException(STUDENT_NOT_FOUND));
        mstClass.setDeletedBy("SYSTEM");
        mstClass.setDeletedDate(LocalDateTime.now());
        studentRepository.save(mstClass);

        return ResponseBuilder.buildResponse(ResponseEnum.SUCCESS, serviceCode, mapToDto(mstClass));
    }

    private List<StudentResponse> mapToDtoList(List<MstStudent> studentList) {
        List<StudentResponse> dtoList = new ArrayList<>();
        for (MstStudent mstStudent : studentList) {
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setStudentId(mstStudent.getStudentId());
            studentResponse.setFirstName(mstStudent.getFirstName());
            studentResponse.setLastName(mstStudent.getLastName());
            studentResponse.setEmail(mstStudent.getEmail());
            studentResponse.setPhone(mstStudent.getPhone());
            studentResponse.setAddress(mstStudent.getAddress());
            studentResponse.setCity(mstStudent.getCity());
            studentResponse.setState(mstStudent.getState());
            studentResponse.setZip(mstStudent.getZip());
            studentResponse.setGender(mstStudent.getGender());
            studentResponse.setDateOfBirth(mstStudent.getDateOfBirth());
            studentResponse.setNationality(mstStudent.getNationality());
            studentResponse.setYear(mstStudent.getYear());
            studentResponse.setPlaceOfBirth(mstStudent.getPlaceOfBirth());

            dtoList.add(studentResponse);
        }
        return dtoList;
    }

    private StudentResponse mapToDto(MstStudent mstStudent) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentId(mstStudent.getStudentId());
        studentResponse.setFirstName(mstStudent.getFirstName());
        studentResponse.setLastName(mstStudent.getLastName());
        studentResponse.setEmail(mstStudent.getEmail());
        studentResponse.setPhone(mstStudent.getPhone());
        studentResponse.setAddress(mstStudent.getAddress());
        studentResponse.setCity(mstStudent.getCity());
        studentResponse.setState(mstStudent.getState());
        studentResponse.setZip(mstStudent.getZip());
        studentResponse.setGender(mstStudent.getGender());
        studentResponse.setDateOfBirth(mstStudent.getDateOfBirth());
        studentResponse.setNationality(mstStudent.getNationality());
        studentResponse.setYear(mstStudent.getYear());
        studentResponse.setPlaceOfBirth(mstStudent.getPlaceOfBirth());
        return studentResponse;
    }
}
