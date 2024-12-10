/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee saveEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

//    public List<Employee> getAllEmployees() {
//        return employees;
//    }
    public List<Employee> getAllEmployees() {
    return employeeRepository.findAll(); // Lấy tất cả nhân viên từ repository
}
    // Tìm kiếm nhân viên theo mã
    public Employee getEmployeeByMaNhanVien(String maNhanVien) {
        return employees.stream()
                .filter(e -> e.getMaNhanVien().equals(maNhanVien))
                .findFirst()
                .orElse(null);  // Trả về null nếu không tìm thấy
    }

    // Xoá nhân viên theo mã
    public void deleteEmployee(String maNhanVien) {
        employees.removeIf(e -> e.getMaNhanVien().equals(maNhanVien));
    }
     public Optional<Employee> findEmployeeByMaNhanVien(String maNhanVien) {
    // Sử dụng phương thức findByMaNhanVien trong repository
    return Optional.ofNullable(employeeRepository.findByMaNhanVien(maNhanVien));
}
public List<Employee> findEmployeesByTrangThai(Integer trangThai) {
        Specification<Employee> specification = EmployeeSpecification.hasTrangThai(trangThai);
        return employeeRepository.findAll(specification); // Sử dụng Specification để lọc theo trạng thái
    }

public List<Employee> arrangeEmployees(boolean sortByMaNhanVien, boolean sortByNgayBatDauThuViec, boolean sortByLuongThuViec) {
    List<Sort.Order> orders = new ArrayList<>();

    // Thêm Sort.Order vào danh sách orders tùy theo yêu cầu
    if (sortByLuongThuViec) {
        orders.add(Sort.Order.asc("luongThuViec").nullsLast()); // Chỉnh lại nếu muốn nullsLast()
    }
    if (sortByNgayBatDauThuViec) {
        orders.add(Sort.Order.asc("ngayBatDauThuViec").nullsLast()); // Chỉnh lại nếu muốn nullsLast()
    }
    if (sortByMaNhanVien) {
        orders.add(Sort.Order.asc("maNhanVien").nullsLast()); // Chỉnh lại nếu muốn nullsLast()
    }

    // Nếu không có trường nào được yêu cầu sắp xếp, mặc định trả về danh sách không sắp xếp
    if (orders.isEmpty()) {
        return employeeRepository.findAll();
    }

    // Tạo Sort từ danh sách orders và thực hiện sắp xếp
    Sort sort = Sort.by(orders);
    return employeeRepository.findAll(sort);
}
}

