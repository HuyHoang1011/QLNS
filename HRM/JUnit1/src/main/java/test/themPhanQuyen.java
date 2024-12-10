package test;
import java.util.ArrayList;
public class themPhanQuyen {
    private String maNhomQuyen;
    private String tenNhomQuyen;

    // Constructor
    public themPhanQuyen(String maNhomQuyen, String tenNhomQuyen) {
        this.maNhomQuyen = maNhomQuyen;
        this.tenNhomQuyen = tenNhomQuyen;
    }
    public themPhanQuyen() {
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
		if(!isNhomQuyenExist(maNhomQuyen, tenNhomQuyen)) {
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
	    danhSachTenNhomQuyen.add(this.tenNhomQuyen);
	    danhSachMaNhomQuyen.add(this.maNhomQuyen);
	    danhSachMaNhomQuyen.add("ad1");		
	    danhSachTenNhomQuyen.add("ADMIN1");
	    danhSachMaNhomQuyen.add("ad2");	    
	    danhSachTenNhomQuyen.add("ADMIN2");
	    danhSachMaNhomQuyen.add("nv1");	    
	    danhSachTenNhomQuyen.add("NV1");

	    if (danhSachMaNhomQuyen.contains(maNhomQuyen)) {
	        return true; 
	    }
	    if (danhSachTenNhomQuyen.contains(tenNhomQuyen)) {
	        return true; 
	    }
	    return false; 
	}
}




