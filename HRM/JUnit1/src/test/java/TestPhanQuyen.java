
import static org.junit.Assert.*;

import org.junit.Test;

public class TestPhanQuyen {
//	database{
//		a-A
//		b-B
//		c-C
//	}
	@Test
	public void hopLe() {
		PhanQuyen themPhanQuyen = new PhanQuyen("d","D"); 
        String validMaNhomQuyen="e";
        String validTenNhomQuyen="E";
        assertEquals(true,themPhanQuyen.themNhomQuyen(validMaNhomQuyen, validTenNhomQuyen));
	}
	@Test
	public void deTrongMaNhomQuyen() {
		PhanQuyen themPhanQuyen = new PhanQuyen("d","D"); 
        String validMaNhomQuyen="";
        String validTenNhomQuyen="E";
        assertEquals(false,themPhanQuyen.themNhomQuyen(validMaNhomQuyen, validTenNhomQuyen));
	}
	@Test
	public void deTrongTenNhomQuyen() {
		PhanQuyen themPhanQuyen = new PhanQuyen("d","D"); 
        String validMaNhomQuyen="e";
        String validTenNhomQuyen="";
        assertEquals(false,themPhanQuyen.themNhomQuyen(validMaNhomQuyen, validTenNhomQuyen));
	}
	@Test
	public void trungMaNhomQuyen() {
		PhanQuyen themPhanQuyen = new PhanQuyen("d","D"); 
        String validMaNhomQuyen="d";
        String validTenNhomQuyen="D";
        assertEquals(false,themPhanQuyen.themNhomQuyen(validMaNhomQuyen, validTenNhomQuyen));
	}
	@Test
	public void deTrongMaVaDeTrongTen() {
		PhanQuyen themPhanQuyen = new PhanQuyen("d","D"); 
        String validMaNhomQuyen="";
        String validTenNhomQuyen="";
        assertEquals(false,themPhanQuyen.themNhomQuyen(validMaNhomQuyen, validTenNhomQuyen));
	}
	

}
