

import java.util.ArrayList;

public class PhanQuyen {
    private String maNhomQuyen;
    private String tenNhomQuyen;

    // Constructor
    public PhanQuyen(String maNhomQuyen, String tenNhomQuyen) {
        this.maNhomQuyen = maNhomQuyen;
        this.tenNhomQuyen = tenNhomQuyen;
    }
	public boolean themNhomQuyen(String maNhomQuyen,String tenNhomQuyen) {
		System.out.println("Lưu thêm nhóm quyền");
		String maNhomQuyenTrim = maNhomQuyen.trim();
		String tenNhomQuyenTrim = tenNhomQuyen.trim();
		if(maNhomQuyenTrim.equals("")) {
			System.out.println("Vui lòng nhập mã nhóm quyền!");
			return false;
		}else if(tenNhomQuyenTrim.equals("")) {
			System.out.println("Vui lòng nhập tên nhóm quyền!");
			return false;
		}
		if(isNhomQuyenExist(maNhomQuyen, tenNhomQuyen)) {
			System.out.println("Thêm nhóm quyền thành công!");
			//Thực hiện xử lý
			return true;
		}else {
			System.out.println("Vui lòng kiểm tra lại thông tin!");
			return false;
		}
	}
	public boolean isNhomQuyenExist(String maNhomQuyen, String tenNhomQuyen) {
		ArrayList<String> danhSachMaNhomQuyen = new ArrayList<String>();
	    ArrayList<String> danhSachTenNhomQuyen = new ArrayList<String>();
	    danhSachMaNhomQuyen.add("a");		
	    danhSachTenNhomQuyen.add("A");
	    danhSachMaNhomQuyen.add("b");	    
	    danhSachTenNhomQuyen.add("B");
	    danhSachMaNhomQuyen.add("c");	    
	    danhSachTenNhomQuyen.add("C");

	    if (danhSachMaNhomQuyen.contains(maNhomQuyen)) {
	        return true; 
	    }
	    if (danhSachTenNhomQuyen.contains(tenNhomQuyen)) {
	        return true; 
	    }
	    return false; 
	}
}