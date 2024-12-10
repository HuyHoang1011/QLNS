package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class themPhongBanTest {
	//	database{
	//	IT-Phòng IT
	//	MKT-Phòng Marketing
	//	KT-Phòng Kế Toán
	//}
	@Test
	public void deTrongMaVaDeTrongTen() {
		themPhongBan themPhongBan = new themPhongBan(); 
        String validMaPhongBan="";
        String validTenPhongBan="";
        assertEquals(false,themPhongBan.themPhongBan(validMaPhongBan, validTenPhongBan));
	}
	@Test
	public void deTrongTenPhongBan() {
		themPhongBan themPhongBan = new themPhongBan(); 
        String validMaPhongBan="TT";
        String validTenPhongBan="";
        assertEquals(false,themPhongBan.themPhongBan(validMaPhongBan, validTenPhongBan));
	}
	@Test
	public void deTrongMaPhongBan() {
		themPhongBan themPhongBan = new themPhongBan(); 
        String validMaPhongBan="";
        String validTenPhongBan="Phòng Truyền Thông";
        assertEquals(false,themPhongBan.themPhongBan(validMaPhongBan, validTenPhongBan));
	}
	@Test
	public void trungMaPhongBan() {
		themPhongBan themPhongBan = new themPhongBan(); 
        String validMaPhongBan="IT";
        String validTenPhongBan="Phòng Truyền Thông";
        assertEquals(false,themPhongBan.themPhongBan(validMaPhongBan, validTenPhongBan));
	}
	@Test
	public void trungTenPhongBan() {
		themPhongBan themPhongBan = new themPhongBan(); 
        String validMaPhongBan="TT";
        String validTenPhongBan="Phòng IT";
        assertEquals(false,themPhongBan.themPhongBan(validMaPhongBan, validTenPhongBan));
	}
	@Test
	public void tenPhongBanQuaNgan() {
		themPhongBan themPhongBan = new themPhongBan(); 
        String validMaPhongBan="YY";
        String validTenPhongBan="Ptt";
        assertEquals(false,themPhongBan.themPhongBan(validMaPhongBan, validTenPhongBan));
	}
	@Test
	public void hopLe() {
		themPhongBan themPhongBan = new themPhongBan(); 
        String validMaPhongBan="TT";
        String validTenPhongBan="Phòng Truyền Thông";
        assertEquals(true,themPhongBan.themPhongBan(validMaPhongBan, validTenPhongBan));
	}

	
	


}
