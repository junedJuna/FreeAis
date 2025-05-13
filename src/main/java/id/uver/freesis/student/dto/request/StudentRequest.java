package id.uver.freesis.student.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
@Getter
@Setter
public class StudentRequest {
    private String studentId;
    private String firstName;
    private String lastName;
    private String year;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private LocalDateTime dateOfBirth;
    private String placeOfBirth;
    private String nationality;
}
