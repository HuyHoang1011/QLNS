/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> hasTrangThai(Integer trangThai) {
        return (root, query, criteriaBuilder) -> {
            if (trangThai == null) {
                return null; // Nếu trạng thái không có trong request, không lọc theo trangThai
            }
            return criteriaBuilder.equal(root.get("trangThai"), trangThai); // Lọc theo trạng thái (1 hoặc 0)
        };
    }
}

