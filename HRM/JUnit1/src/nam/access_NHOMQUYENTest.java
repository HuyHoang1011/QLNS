/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import DTO.NHOMQUYEN;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nguyenduyanh
 */
import DAO.access_NHOMQUYEN;
import DTO.NHOMQUYEN;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class access_NHOMQUYENTest {
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
    public void testInsertNHOMQUYEN() {
        String maNhomQuyen = "NQ001";
        String tenNhomQuyen = "Quản trị viên";

        // Kiểm tra việc thêm nhóm quyền mới vào cơ sở dữ liệu
        boolean result = access_NHOMQUYEN.insertNHOMQUYEN(maNhomQuyen, tenNhomQuyen);
        assertTrue("Thêm nhóm quyền không thành công", result);

        // Kiểm tra xem nhóm quyền đã được thêm thành công chưa (có thể thêm kiểm tra cơ sở dữ liệu nếu cần)
    }

    @Test
    public void testDeleteNHOMQUYEN() {
        String maNhomQuyen = "NQ001";

        // Kiểm tra việc xóa nhóm quyền
        boolean result = access_NHOMQUYEN.deleteNHOMQUYEN(maNhomQuyen);
        assertTrue("Xóa nhóm quyền không thành công", result);

        // Kiểm tra lại xem nhóm quyền đã bị xóa chưa
    }

    @Test
    public void testInsertCHITIETNHOMQUYEN() {
        String maNhomQuyen = "NQ001";
        String maChucNang = "1";  // Giả sử "1" là mã chức năng hợp lệ

        // Thêm chi tiết nhóm quyền vào cơ sở dữ liệu
        try {
            access_NHOMQUYEN.insertCHITIETNHOMQUYEN(maNhomQuyen, maChucNang);
            assertTrue("Thêm chi tiết nhóm quyền không thành công", true);
        } catch (Exception e) {
            fail("Không được phép gây ra ngoại lệ: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteCHITIETNHOMQUYEN() {
        String maNhomQuyen = "NQ001";

        // Xóa chi tiết nhóm quyền
        try {
            access_NHOMQUYEN.deleteCHITIETNHOMQUYEN(maNhomQuyen);
            assertTrue("Xóa chi tiết nhóm quyền không thành công", true);
        } catch (Exception e) {
            fail("Không được phép gây ra ngoại lệ: " + e.getMessage());
        }
    }

    @Test
    public void testGetChucNangTaiKhoan() {
        String username = "testUser";  // Thay bằng tên người dùng hợp lệ trong cơ sở dữ liệu

        // Lấy chức năng của tài khoản
        boolean[] result = access_NHOMQUYEN.getChucNangTaiKhoan(username);

        // Kiểm tra kết quả
        assertNotNull("Kết quả không được null", result);
        assertEquals("Mảng chức năng phải có độ dài là 38", 38, result.length);
    }

    @Test
    public void testGetDanhSachNhomQuyen() {
        // Lấy danh sách nhóm quyền từ cơ sở dữ liệu
        ArrayList<NHOMQUYEN> result = access_NHOMQUYEN.getDanhSachNhomQuyen();

        // Kiểm tra kết quả
        assertNotNull("Danh sách nhóm quyền không được null", result);
        assertTrue("Danh sách nhóm quyền phải có ít nhất 1 nhóm", result.size() > 0);
    }
}
