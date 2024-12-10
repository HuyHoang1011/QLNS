/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import DTO.PHONGBAN;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;



public class access_PHONGBANTest {

    @Before
    public void setUp() throws Exception {
        // Thiết lập cơ sở dữ liệu trước mỗi bài kiểm thử (nếu cần).
        // Có thể tạo dữ liệu giả để thử nghiệm.
    }

    @After
    public void tearDown() throws Exception {
        // Dọn dẹp cơ sở dữ liệu sau mỗi bài kiểm thử.
    }

    @Test
    public void testGetList() {
        // Kiểm tra việc lấy danh sách phòng ban
        ArrayList<PHONGBAN> result = access_PHONGBAN.getList();

        // Kiểm tra kết quả
        assertNotNull("Danh sách phòng ban không được null", result);
        assertTrue("Danh sách phòng ban phải có ít nhất 1 phòng", result.size() > 0);
    }

    @Test
    public void testIsTenPhongExists() {
        String tenPhong = "Phòng kinh doanh";

        // Kiểm tra xem tên phòng đã tồn tại chưa
        boolean result = access_PHONGBAN.isTenPhongExists(tenPhong);
        assertTrue("Tên phòng không tồn tại", result);

        // Kiểm tra với tên phòng không tồn tại
        tenPhong = "Phòng Không Tồn Tại";
        result = access_PHONGBAN.isTenPhongExists(tenPhong);
        assertFalse("Tên phòng không tồn tại", result);
    }

    @Test
    public void testGetMaSoTuTen() {
        String tenPhong = "Phòng Kinh doanh";

        // Lấy mã phòng từ tên phòng
        String result = access_PHONGBAN.getMaSoTuTen(tenPhong);
        assertNotNull("Mã phòng không được null", result);
        assertEquals("Mã phòng không đúng", "KD", result);  // Thay PKT01 bằng mã phòng thật trong CSDL
    }

    @Test
    public void testInsertPhongBan() {
        PHONGBAN phongBan = new PHONGBAN();
        phongBan.setMaPhong("PB001");
        phongBan.setTenPhong("Phòng Test");
        phongBan.setNgayThanhLap(LocalDate.now());
        phongBan.setMaTruongPhong("");

        // Kiểm tra việc thêm phòng ban mới
        try {
            access_PHONGBAN.insertPhongBan(phongBan);
            // Kiểm tra lại phòng ban đã được thêm chưa
            assertTrue("Thêm phòng ban không thành công", access_PHONGBAN.isMaPhongExists("PB001"));
        } catch (Exception e) {
            fail("Không được phép gây ra ngoại lệ: " + e.getMessage());
        }
    }

    @Test
    public void testDeletePhongBan() {
        String maPhong = "PB001";

        // Xóa phòng ban
        access_PHONGBAN.deletePhongBan(maPhong);

        // Kiểm tra lại xem phòng ban đã bị xóa chưa
        boolean result = access_PHONGBAN.isMaPhongExists(maPhong);
        assertFalse("Phòng ban không bị xóa", result);
    }

    @Test
    public void testUpdatePhongBan() {
        PHONGBAN phongBan = new PHONGBAN();
        phongBan.setMaPhong("PB001");
        phongBan.setTenPhong("cp");
        phongBan.setNgayThanhLap(LocalDate.now());
        phongBan.setMaTruongPhong("");

        // Cập nhật phòng ban
        access_PHONGBAN.updatePhongBan(phongBan);

        // Kiểm tra lại thông tin phòng ban đã được cập nhật chưa
        PHONGBAN updatedPhongBan = access_PHONGBAN.getList().stream()
                .filter(p -> p.getMaPhong().equals("TEST02"))
                .findFirst()
                .orElse(null);

        assertNotNull("Phòng ban không tồn tại", updatedPhongBan);
        assertEquals("Tên phòng không đúng", "cp", updatedPhongBan.getTenPhong());
        assertEquals("Mã trưởng phòng không đúng", "TP002", updatedPhongBan.getMaTruongPhong());
    }

    @Test
    public void testGetSoLuongNhanVien() {
        String maPhongBan = "PB001";

        // Lấy số lượng nhân viên của phòng ban
        int result = access_PHONGBAN.getSoLuongNhanVien(maPhongBan);

        // Kiểm tra kết quả
        assertTrue("Số lượng nhân viên phải lớn hơn hoặc bằng 0", result >= 0);
    }

    @Test
    public void testGetDanhSachPhongBan() {
        // Lấy danh sách phòng ban
        String[] result = access_PHONGBAN.getDanhSachPhongBan();

        // Kiểm tra kết quả
        assertNotNull("Danh sách phòng ban không được null", result);
        assertTrue("Danh sách phòng ban phải có ít nhất 1 phòng", result.length > 0);
    }
}
