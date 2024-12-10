/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/controller-nhanvien")
public class NhanVienController {

    private final EmployeeService employeeService;
@Autowired
private EmployeeRepository employeeRepository;
    @Autowired
    public NhanVienController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
public ResponseEntity<ResponseDTO> createEmployee(@RequestBody Employee employee) {
    // Kiểm tra nếu mã nhân viên bị trống
    if (employee.getMaNhanVien() == null || employee.getMaNhanVien().isEmpty()) {
        ResponseDTO response = new ResponseDTO(
            "Fail",
            "Mã nhân viên không được để trống",
            null,  // Không có dữ liệu trả về trong trường hợp này
            null,  // Không có lỗi chi tiết
            null   // Không có dữ liệu danh sách
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);  // Trả về mã lỗi 400 Bad Request
    }

    // Kiểm tra nếu mã nhân viên chứa ký tự đặc biệt
    if (!employee.getMaNhanVien().matches("^[a-zA-Z0-9]*$")) {
        ResponseDTO response = new ResponseDTO(
            "Fail",
            "Mã nhân viên không được chứa ký tự đặc biệt",
            null,  // Không có dữ liệu trả về trong trường hợp này
            null,  // Không có lỗi chi tiết
            null   // Không có dữ liệu danh sách
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);  // Trả về mã lỗi 400 Bad Request
    }

    // Kiểm tra nếu mã nhân viên đã tồn tại trong cơ sở dữ liệu
    if (employeeRepository.existsByMaNhanVien(employee.getMaNhanVien())) {
        ResponseDTO response = new ResponseDTO(
            "Fail",
            "Mã nhân viên đã tồn tại",
            null,  // Không có dữ liệu trả về trong trường hợp này
            null,  // Không có lỗi chi tiết
            null   // Không có dữ liệu danh sách
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);  // Trả về mã lỗi 400 Bad Request
    }

    // Nếu mã nhân viên hợp lệ và không trùng, tiến hành lưu nhân viên
    try {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        ResponseDTO response = new ResponseDTO(
            "ok",
            "Thêm nhân viên thành công",
            savedEmployee,  // Dữ liệu là nhân viên vừa lưu
            null,  // Không có lỗi chi tiết
            null   // Không có dữ liệu danh sách
        );
        return new ResponseEntity<>(response, HttpStatus.OK);  // Trả về mã thành công 200 OK
    } catch (Exception e) {
        // Xử lý khi có lỗi
        ResponseDTO response = new ResponseDTO(
            "error",
            "Thêm nhân viên thất bại",
            null,
            e.getMessage(),  // Lỗi chi tiết
            null
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);  // Trả về mã lỗi 500
    }
}


    @PutMapping("/update")
public ResponseEntity<ResponseDTO> updateEmployee(@RequestBody Employee employee) {
    // Kiểm tra nếu mã nhân viên trống
    if (employee.getMaNhanVien() == null || employee.getMaNhanVien().isEmpty()) {
        ResponseDTO response = new ResponseDTO(
            "Fail",
            "Mã nhân viên không được để trống",
            null,
            null,
            null
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);  // Trả về mã lỗi 400
    }

    // Kiểm tra nếu mã nhân viên có chứa ký tự đặc biệt
    if (!employee.getMaNhanVien().matches("[a-zA-Z0-9]+")) {  // Chỉ cho phép ký tự chữ và số
        ResponseDTO response = new ResponseDTO(
            "Fail",
            "Mã nhân viên không được chứa ký tự đặc biệt",
            null,
            null,
            null
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);  // Trả về mã lỗi 400
    }

    // Kiểm tra xem mã nhân viên có tồn tại trong hệ thống không
    Employee existingEmployee = employeeService.getAllEmployees().stream()
        .filter(e -> e.getMaNhanVien().equals(employee.getMaNhanVien()))
        .findFirst()
        .orElse(null);

    if (existingEmployee == null) {
        ResponseDTO response = new ResponseDTO(
            "Fail",
            "Mã nhân viên không tồn tại",
            null,
            null,
            null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);  // Trả về mã lỗi 404
    }

    // Cập nhật các thông tin nhân viên
    try {
        existingEmployee.setMaPhong(employee.getMaPhong());
        existingEmployee.setMaTrinhDo(employee.getMaTrinhDo());
        existingEmployee.setMaChucVu(employee.getMaChucVu());
        existingEmployee.setMaHopDong(employee.getMaHopDong());
        existingEmployee.setNgayBatDauThuViec(employee.getNgayBatDauThuViec());
        existingEmployee.setNgayKetThucThuViec(employee.getNgayKetThucThuViec());
        existingEmployee.setLuongThuViec(employee.getLuongThuViec());
        existingEmployee.setTrangThai(employee.getTrangThai());
        existingEmployee.setCmnd(employee.getCmnd());

        // Lưu lại thông tin đã cập nhật
        employeeService.saveEmployee(existingEmployee);

        // Trả về phản hồi thành công
        ResponseDTO response = new ResponseDTO(
            "ok",
            "Cập nhật nhân viên thành công",
            existingEmployee,  // Dữ liệu là nhân viên đã được cập nhật
            null,
            null
        );
        return new ResponseEntity<>(response, HttpStatus.OK);  // Trả về mã lỗi 200 OK
    } catch (Exception e) {
        // Xử lý lỗi khi có vấn đề xảy ra trong quá trình cập nhật
        ResponseDTO response = new ResponseDTO(
            "error",
            "Cập nhật nhân viên thất bại",
            null,
            e.getMessage(),
            null
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);  // Trả về mã lỗi 500
    }
}

    @DeleteMapping("/delete")
public ResponseEntity<ResponseDTO> deleteEmployee(@RequestBody Employee employee) {
    // Kiểm tra nếu mã nhân viên bị để trống
    if (employee.getMaNhanVien() == null || employee.getMaNhanVien().trim().isEmpty()) {
        ResponseDTO response = new ResponseDTO(
            "Fail",
            "Mã nhân viên không được để trống",
            null,
            null,
            null
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Kiểm tra mã nhân viên có chứa ký tự đặc biệt
    if (!employee.getMaNhanVien().matches("[a-zA-Z0-9]+")) {
        ResponseDTO response = new ResponseDTO(
            "Fail",
            "Mã nhân viên không hợp lệ (không chứa ký tự đặc biệt)",
            null,
            null,
            null
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Kiểm tra nếu nhân viên không tồn tại
    Employee existingEmployee = employeeService.getEmployeeByMaNhanVien(employee.getMaNhanVien());
    if (existingEmployee == null) {
        ResponseDTO response = new ResponseDTO(
            "Fail",
            "Mã nhân viên không tìm thấy",
            null,
            null,
            null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Xoá nhân viên
    try {
        employeeService.deleteEmployee(employee.getMaNhanVien());
        ResponseDTO response = new ResponseDTO(
            "Success",
            "Nhân viên đã được xoá thành công",
            null,
            null,
            null
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
        ResponseDTO response = new ResponseDTO(
            "Error",
            "Có lỗi khi xoá nhân viên",
            null,
            e.getMessage(),
            null
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    @GetMapping("/show-all")
public ResponseEntity<ResponseDTO> getAllEmployees() {
    // Logic lấy tất cả nhân viên
    try {
        List<Employee> employees = employeeService.getAllEmployees();

        // Kiểm tra nếu danh sách nhân viên rỗng
        if (employees.isEmpty()) {
            ResponseDTO response = new ResponseDTO("ok", "Không có nhân viên nào", null, null, null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        // Trả về danh sách nhân viên nếu có dữ liệu
        ResponseDTO response = new ResponseDTO("ok", "Lấy tất cả nhân viên thành công", employees, null, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
        ResponseDTO response = new ResponseDTO("error", "Lỗi khi lấy danh sách nhân viên", null, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @GetMapping("/find-nhanvien")
public ResponseEntity<ResponseDTO> findEmployeeByMaNhanVien(@RequestBody Employee employee) {
    // Tìm nhân viên theo mã nhân viên trong body
    Optional<Employee> employeeOpt = employeeService.findEmployeeByMaNhanVien(employee.getMaNhanVien());

    if (employeeOpt.isPresent()) {
        // Nếu tìm thấy nhân viên
        ResponseDTO response = new ResponseDTO("ok", "Tìm nhân viên thành công", employeeOpt.get(), null, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
        // Nếu không tìm thấy nhân viên
        ResponseDTO response = new ResponseDTO("fail", "Mã nhân viên không tồn tại", null, null, null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
@GetMapping("/filter")
    public ResponseEntity<ResponseDTO> filterByTrangThai(@RequestBody Map<String, Integer> filters) {
        Integer trangThai = filters.get("filter-trangThai");

        if (trangThai == null) {
            // Trả về thông báo nếu không có filter-trangThai
            ResponseDTO response = new ResponseDTO("fail", "Trạng thái không hợp lệ", null, null, null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        List<Employee> employees = employeeService.findEmployeesByTrangThai(trangThai);
        
        if (employees.isEmpty()) {
            ResponseDTO response = new ResponseDTO("fail", "Không tìm thấy nhân viên với trạng thái " + trangThai, null, null, null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        
        ResponseDTO response = new ResponseDTO("ok", "Lọc nhân viên thành công", employees, null, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

@GetMapping("/arrange")
    public ResponseEntity<ResponseDTO> arrangeEmployee(
            @RequestParam(value = "sort-maNhanVien", defaultValue = "no") String sortMaNhanVien,
            @RequestParam(value = "sort-ngayBatDauThuViec", defaultValue = "no") String sortNgayBatDauThuViec,
            @RequestParam(value = "sort-luongThuViec", defaultValue = "no") String sortLuongThuViec) {
        
        // Convert các tham số "yes" và "no" thành boolean true/false
        boolean sortByMaNhanVien = sortMaNhanVien.equals("yes");
        boolean sortByNgayBatDauThuViec = sortNgayBatDauThuViec.equals("yes");
        boolean sortByLuongThuViec = sortLuongThuViec.equals("yes");

        // Gọi Service để lấy kết quả sắp xếp theo yêu cầu
        List<Employee> employees = employeeService.arrangeEmployees(sortByMaNhanVien, sortByNgayBatDauThuViec, sortByLuongThuViec);

        if (employees.isEmpty()) {
            ResponseDTO response = new ResponseDTO("fail", "Không có nhân viên", null, null, null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        ResponseDTO response = new ResponseDTO("ok", "Sắp xếp nhân viên thành công", employees, null, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
