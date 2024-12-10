package test;
import java.util.ArrayList;
public class themPhongBan {
    private String maPhongBan;
    private String tenPhongBan;

    // Constructor
    public themPhongBan(String maPhongBan, String tenPhongBan) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
    }
    public themPhongBan() {
    }
	public boolean themPhongBan(String maPhongBan,String tenPhongBan) {
		System.out.println("Lưu thêm phòng ban");
		String maPhongBanTrim = maPhongBan.trim();
		String tenPhongBanTrim = tenPhongBan.trim();
		if(maPhongBanTrim.equals("")) {
			 System.out.println("Chưa nhập mã phòng ban!");
			return false;
		}
		if(tenPhongBanTrim.equals("")) {
			 System.out.println("Chưa nhập tên phòng ban!");
			return false;
		}
		if(isPhongBanExist(maPhongBanTrim,tenPhongBanTrim)) {
			 System.out.println("Mã phòng ban này đã tồn tại!");
			return false;
		}
		if(tenPhongBanTrim.length()<5) {
			 System.out.println("Tên phòng ban quá ngắn!");
			return false;
		}
		
		return true;
	}
	public boolean isPhongBanExist(String maPhongBan,String tenPhongBan) {
		ArrayList<String> danhSachMaPhongBan = new ArrayList<String>();
		ArrayList<String> danhSachTenPhongBan = new ArrayList<String>();
		danhSachMaPhongBan.add(this.maPhongBan);
		danhSachTenPhongBan.add(this.tenPhongBan);
		danhSachMaPhongBan.add("IT");		
		danhSachTenPhongBan.add("Phòng IT");
		danhSachMaPhongBan.add("MKT");	    
		danhSachTenPhongBan.add("Phòng Marketing");
		danhSachMaPhongBan.add("KT");	    
		danhSachTenPhongBan.add("Phòng Kế Toán");
	    if (danhSachMaPhongBan.contains(maPhongBan)) {
	        return true; 
	    }
	    return false; 
	}
}




