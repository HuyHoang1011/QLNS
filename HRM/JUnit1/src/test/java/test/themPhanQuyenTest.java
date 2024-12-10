package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class themPhanQuyenTest {
//	database{
//		ad1-ADMIN1
//		ad2-ADMIN2
//		nv1-NV1
//	}
	@Test
	public void hopLe() {
		themPhanQuyen themPhanQuyen = new themPhanQuyen();
        String validMaNhomQuyen="ad3";
        String validTenNhomQuyen="ADMIN3";
        assertEquals(true,themPhanQuyen.themNhomQuyen(validMaNhomQuyen, validTenNhomQuyen));
	}
	@Test
	public void deTrongMaNhomQuyen() {
		themPhanQuyen themPhanQuyen = new themPhanQuyen();
        String validMaNhomQuyen="";
        String validTenNhomQuyen="ADMIN3";
        assertEquals(false,themPhanQuyen.themNhomQuyen(validMaNhomQuyen, validTenNhomQuyen));
	}
	@Test
	public void deTrongTenNhomQuyen() {
		themPhanQuyen themPhanQuyen = new themPhanQuyen();
        String validMaNhomQuyen="ad3";
        String validTenNhomQuyen="";
        assertEquals(false,themPhanQuyen.themNhomQuyen(validMaNhomQuyen, validTenNhomQuyen));
	}
	@Test
	public void trungMaNhomQuyen() {
		themPhanQuyen themPhanQuyen = new themPhanQuyen();
        String validMaNhomQuyen="ad1";
        String validTenNhomQuyen="ADMIN3";
        assertEquals(false,themPhanQuyen.themNhomQuyen(validMaNhomQuyen, validTenNhomQuyen));
	}
	@Test
	public void deTrongMaVaDeTrongTen() {
		themPhanQuyen themPhanQuyen = new themPhanQuyen();
        String validMaNhomQuyen="";
        String validTenNhomQuyen="";
        assertEquals(false,themPhanQuyen.themNhomQuyen(validMaNhomQuyen, validTenNhomQuyen));
	}
}



