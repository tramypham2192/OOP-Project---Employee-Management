import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String optionDuocChon = chonOption(sc);
        ArrayList<GiamDoc> listGiamDoc = new ArrayList<>();
        ArrayList<TruongPhong> listTruongPhong = new ArrayList<>();
        ArrayList<NhanVien> listNhanVienCapDuoi = new ArrayList<>();
        ArrayList<ArrayList> danhSachToanBoCongNhanVien = new ArrayList<>();
        danhSachToanBoCongNhanVien.add(listGiamDoc);
        danhSachToanBoCongNhanVien.add(listTruongPhong);
        danhSachToanBoCongNhanVien.add(listNhanVienCapDuoi);
        while (!(optionDuocChon.equals("Exit"))){
            danhSachToanBoCongNhanVien = manage(sc, optionDuocChon, danhSachToanBoCongNhanVien);
            optionDuocChon = chonOption(sc);
        }
    }

    public static ArrayList<ArrayList> manage(Scanner sc, String option, ArrayList<ArrayList> danhSachToanBoCongNhanVien) {
        switch (option) {
            case "1":
                ArrayList<GiamDoc> danhSachGiamDoc = danhSachToanBoCongNhanVien.get(0);
                ArrayList<TruongPhong> danhSachTruongPhong = danhSachToanBoCongNhanVien.get(1);
                System.out.println("Nhap vao thong tin cong ty ");

                //THEM THONG TIN CAC GIAM DOC
                System.out.println("Nhap vao so luong giam doc: ");
                int soLuongGiamDoc = sc.nextInt();
                //tao array list giam doc
                for (int i = 1; i <= soLuongGiamDoc; i++) {
                    System.out.println("Nhap vao ma so cua giam doc thu " + i + ":");
                    String maSo = sc.next();
                    System.out.println("Nhap vao ho ten cua giam doc thu " + i + ":");
                    String hoTen = sc.next();
                    System.out.println("Nhap vao so dien thoai cua giam doc thu " + i + ":");
                    String soDienThoai = sc.next();
                    System.out.println("Nhap vao so ngay lam viec cua giam doc thu " + i + ":");
                    int soNgayLamViec = sc.nextInt();
                    System.out.println("Nhap vao so co phan nam giu cua giam doc thu " + i + ":");
                    double coPhanNamGiu = sc.nextDouble();
                    GiamDoc newGiamDocObj = new GiamDoc(maSo, hoTen, soDienThoai, soNgayLamViec, 300, coPhanNamGiu); //300 la luong giam doc 1 ngay
                    danhSachGiamDoc.add(newGiamDocObj);
                    System.out.println("Danh sach giam doc den thoi diem hien tai: ");
                    //liet ke danh sach giam doc
                    for (GiamDoc gd : danhSachGiamDoc) gd.lietKeThongTinNhanVien();
                }

                //THEM THONG TIN CAC TRUONG PHONG
                System.out.println("Nhap vao so luong truong phong: ");
                int soLuongTruongPhong = sc.nextInt();
                //tao array list truong phong
                for (int i = 1; i <= soLuongTruongPhong; i++) {
                    System.out.println("Nhap vao ma so cua truong phong thu " + i + ":");
                    String maSo = sc.next();
                    System.out.println("Nhap vao ho ten cua truong phong thu " + i + ":");
                    String hoTen = sc.next();
                    System.out.println("Nhap vao so dien thoai cua truong phong thu " + i + ":");
                    String soDienThoai = sc.next();
                    System.out.println("Nhap vao so ngay lam viec cua truong phong thu " + i + ":");
                    int soNgayLamViec = sc.nextInt();
                    System.out.println("Nhap vao so luong nhan vien cap duoi cua truong phong thu " + i + ":");
                    int soLuongNhanVienCapDuoi = sc.nextInt();
                    TruongPhong newTruongPhongObj = new TruongPhong(maSo, hoTen, soDienThoai, soNgayLamViec, 200, soLuongNhanVienCapDuoi);
                    danhSachTruongPhong.add(newTruongPhongObj);
                    System.out.println("Danh sach truong phong den thoi diem hien tai: ");
                    for (TruongPhong tp : danhSachTruongPhong) {
                        tp.lietKeThongTinNhanVien();
                        System.out.println("So nhan vien cap duoi: " + tp.getSoLuongNVcapDuoi());
                    }
                }
                break;

            case "2":
                //Lay ra danh sach toan bo cong nhan vien trong cong ty roi lay ra danh sach truong phong dang co
                ArrayList<TruongPhong> danhSachTruongPhongDangCo = danhSachToanBoCongNhanVien.get(1);
                ArrayList<NhanVien> danhSachNhanVienCapDuoiDangCo = danhSachToanBoCongNhanVien.get(2);
                //Nhap thong tin truong phong can them nhan vien
                System.out.println("Nhap vao ma so cua truong phong can phan bo them nhan vien: ");
                String maSoCuaTruongPhongCanThemNhanVien = sc.next();
                //Tinh so nhan vien can them vao cho truong phong co ma so nhu tren va get danh sach nhan vien cap duoi hien tai truong
                //phong co ma so nhu tren dang co
                int soNhanVienCanThem = 0;
                for (int i = 0; i < danhSachTruongPhongDangCo.size(); i++){
                    if (danhSachTruongPhongDangCo.get(i).getMaSo().equals(maSoCuaTruongPhongCanThemNhanVien)){
                        soNhanVienCanThem = danhSachTruongPhongDangCo.get(i).getSoLuongNVcapDuoi() - danhSachTruongPhongDangCo.get(i).danhSachNhanVienDuoiQuyen.size();
                    }
                }
                System.out.println("Truong phong co ma so " + maSoCuaTruongPhongCanThemNhanVien + " can duoc them " + soNhanVienCanThem + " nhan vien" );
                //Them vao thong tin cac nhan vien phan bo cho truong phong co ma so nhu tren
                //Neu truong phong co du so nhan vien duoc khoi tao luc ban dau roi nhung van muon add them nhan vien
                if (soNhanVienCanThem == 0){
                    System.out.println("Hien tai truong phong nay co du so nhan vien duoc phan cong ban dau roi. Ban van muon them nhan vien?");
                    String cauTraLoi = sc.next();
                    if (cauTraLoi.equals("Them")){
                        System.out.println("Nhap vao ma so cua nhan vien :");
                        String maSo = sc.next();
                        System.out.println("Nhap vao ho ten cua nhan vien:");
                        String hoTen = sc.next();
                        System.out.println("Nhap vao so dien thoai cua nhan vien:");
                        String soDienThoai = sc.next();
                        System.out.println("Nhap vao so ngay lam viec cua nhan vien:");
                        int soNgayLamViec = sc.nextInt();
                        NhanVien nhanVienObj = new NhanVien(maSo, hoTen, soDienThoai, soNgayLamViec, 100, maSoCuaTruongPhongCanThemNhanVien);
                        danhSachNhanVienCapDuoiDangCo.add(nhanVienObj);
                        System.out.println("Truong phong co ma so " + maSoCuaTruongPhongCanThemNhanVien + "co list nhan vien sau khi them nhan vien vua roi nhu sau: ");
                        for (NhanVien nv : danhSachNhanVienCapDuoiDangCo){
                            nv.lietKeThongTinNhanVien();
                        }
                    }
                }
                //Neu truong phong chua co du so nhan vien duoc phan cong ban dau thi them nhu binh thuong
                else {
                    System.out.println("Nhap thong tin cua nhan vien can them vao cho truong phong co ma so la " + maSoCuaTruongPhongCanThemNhanVien + ":");
                    for (int i = 1; i <= soNhanVienCanThem; i++){
                        System.out.println("Nhap vao ma so cua nhan vien thu " + i + ":");
                        String maSo = sc.next();
                        System.out.println("Nhap vao ho ten cua nhan vien thu " + i + ":");
                        String hoTen = sc.next();
                        System.out.println("Nhap vao so dien thoai cua nhan vien thu " + i + ":");
                        String soDienThoai = sc.next();
                        System.out.println("Nhap vao so ngay lam viec cua nhan vien thu " + i + ":");
                        int soNgayLamViec = sc.nextInt();
                        NhanVien nhanVienObj = new NhanVien(maSo, hoTen, soDienThoai, soNgayLamViec, 100, maSoCuaTruongPhongCanThemNhanVien);
                        danhSachNhanVienCapDuoiDangCo.add(nhanVienObj);
                    }
                    System.out.println("Truong phong co ma so " + maSoCuaTruongPhongCanThemNhanVien + "co list nhan vien sau khi them nhan vien vua roi nhu sau: ");
                    for (NhanVien nv : danhSachNhanVienCapDuoiDangCo){
                        nv.lietKeThongTinNhanVien();
                    }
                }
                break;

            case "3":
                ArrayList<NhanVien> danhSachNhanVien = danhSachToanBoCongNhanVien.get(2);
                System.out.println("Ban can thay doi thong tin nhan vien hay xoa nhan vien do khoi danh sach nhan vien?: ");
                String luaChon = sc.next();
                if (luaChon.equals("thaydoi")){
                    System.out.println("Nhap thong tin ma so nhan vien can thay doi thong tin: ");
                    String maSoNVThayDoiInfo = sc.next();
                    for (int i = 0; i < danhSachNhanVien.size(); i++){
                        danhSachNhanVien.get(i).lietKeThongTinNhanVien();
                        if (danhSachNhanVien.get(i).getMaSo().equals(maSoNVThayDoiInfo)){
                            System.out.println("Nhap thong tin can thay doi (ho ten/so dien thoai/so ngay lam viec):");
                            String thongTinCanThayDoi = sc.next();
                            if (thongTinCanThayDoi.equals("hoten")){
                                System.out.println("Nhap vao ho ten chinh xac cua nhan vien: ");
                                String hoTenChinhXac = sc.nextLine();
                                danhSachNhanVien.get(i).setHoTen(hoTenChinhXac);
                                System.out.println("Thong tin cua nhan vien co ma so " + maSoNVThayDoiInfo + " sau khi thay doi ho ten la:");
                                danhSachNhanVien.get(i).lietKeThongTinNhanVien();
                            }
                        }
                }
                if (luaChon.equals("xoa")){
                    System.out.println("Nhap thong tin ma so nhan vien can xoa: ");
                    String maSoNVXoa = sc.next();
                    for (int i = 0; i < danhSachNhanVien.size(); i++) {
                        danhSachNhanVien.remove(i);
                    }
                    System.out.println("Danh sach nhan vien sau khi xoa:");
                    for (NhanVien nv : danhSachNhanVien){
                        nv.lietKeThongTinNhanVien();
                    }
                }
                }

            case "4":
                System.out.println("danh sach toan bo cong nhan vien: ");
                for (int i = 0; i < danhSachToanBoCongNhanVien.size(); i++){
                    System.out.println(danhSachToanBoCongNhanVien.get(i));
                }
                System.out.println("Danh sach cac giam doc: ");
                ArrayList<GiamDoc> listGiamDoc = danhSachToanBoCongNhanVien.get(0);
                for (int i = 0; i < listGiamDoc.size() ; i++){
                    listGiamDoc.get(i).lietKeThongTinNhanVien();
                }
                System.out.println("Danh sach cac truong phong: ");
                ArrayList<TruongPhong> listTruongPhong = danhSachToanBoCongNhanVien.get(1);
                for (TruongPhong tp : listTruongPhong){
                    tp.lietKeThongTinNhanVien();
                }
                System.out.println("Danh sach cac nhan vien cap duoi cua truong phong: ");
                ArrayList<NhanVien> listNhanVienCapDuoi = danhSachToanBoCongNhanVien.get(2);
                for (NhanVien nv : listNhanVienCapDuoi){
                    nv.lietKeThongTinNhanVien();
                }
                break;

            case "5":
                //tong luong cac giam doc
                int tongLuongGiamDoc = 0;
                ArrayList<GiamDoc> lstGD = danhSachToanBoCongNhanVien.get(0);
                for (GiamDoc gd : lstGD){
                    tongLuongGiamDoc += gd.getLuongTheoNgay() * gd.getSoNgayLamViec();
                }
                System.out.println("Tong luong cua cac giam doc: " + tongLuongGiamDoc);
                //tong luong cac truong phong
                int tongLuongTruongPhong = 0;
                ArrayList<TruongPhong> lstTP = danhSachToanBoCongNhanVien.get(1);
                for (TruongPhong tp : lstTP){
                    tongLuongTruongPhong += tp.getLuongTheoNgay() * tp.getSoNgayLamViec();
                }
                System.out.println("Tong luong cua cac truong phong: " + tongLuongTruongPhong);
                //tong luong nhan vien cap duoi
                int tongLuongNVCapDuoi = 0;
                ArrayList<NhanVien> lstNV = danhSachToanBoCongNhanVien.get(2);
                for (NhanVien nv : lstNV){
                    tongLuongNVCapDuoi += nv.getLuongTheoNgay() * nv.getSoNgayLamViec();
                }
                System.out.println("Tong luong cua cac nhan vien cap duoi: " + tongLuongNVCapDuoi);

                System.out.println("Tong luong cua toan bo cong nhan vien la: " + String.valueOf(tongLuongGiamDoc + tongLuongTruongPhong + tongLuongNVCapDuoi));
                break;

            case "6":
                ArrayList<NhanVien> listNV = danhSachToanBoCongNhanVien.get(2);
                ArrayList<Integer> listLuongNV = new ArrayList<>();
                for (NhanVien nv : listNV){
                    listLuongNV.add(nv.getLuongTheoNgay() * nv.getSoNgayLamViec());
                }
                int maxSalaryNhanvien = 0;
                int indexNVmaxSalary = 0;
                for (int i = 0; i < listLuongNV.size(); i++){
                    if (maxSalaryNhanvien < listLuongNV.get(i)){
                        maxSalaryNhanvien = listLuongNV.get(i);
                        indexNVmaxSalary = i;
                    }
                }
                System.out.println("Nhan vien co ma so " + listNV.get(indexNVmaxSalary).getMaSo() + " la nhan vien co luong cao nhat trong thang nay");
                break;

            case "7":
                ArrayList<TruongPhong> listTP = danhSachToanBoCongNhanVien.get(1);
                int maxSoLuongNVcapDuoi = 0;
                int indexCuaTPcoMaxSoNVcapDuoi = 0;
                for (int i = 0; i < listTP.size(); i++){
                    if (maxSoLuongNVcapDuoi < listTP.get(i).getSoLuongNVcapDuoi()){
                        maxSoLuongNVcapDuoi = listTP.get(i).getSoLuongNVcapDuoi();
                        indexCuaTPcoMaxSoNVcapDuoi = i;
                    }
                }
                System.out.println("Truong phong co ma so " + listTP.get(indexCuaTPcoMaxSoNVcapDuoi).getMaSo() + " la truong phong co" +
                        " so luong nhan vien duoi quyen nhieu nhat (" + listTP.get(indexCuaTPcoMaxSoNVcapDuoi).getSoLuongNVcapDuoi() +" nhan vien)" );

            case "8":
                ArrayList<NhanVien> listNVien = danhSachToanBoCongNhanVien.get(2);
                Map<String, NhanVien> map = new HashMap<>();
                for (int i = 0; i < listNVien.size(); i++){
                    map.put(listNVien.get(i).getHoTen(), listNVien.get(i));
                }
                TreeMap<String, NhanVien> sorted = new TreeMap<>(map);
                System.out.println("list nhan vien sau khi sort ten theo alphabet la: ");
                Iterator<NhanVien> iterator = sorted.values().iterator();
                while(iterator.hasNext()){
                    iterator.next().lietKeThongTinNhanVien();
                }

            case "9":
                ArrayList<NhanVien> listEmployee = danhSachToanBoCongNhanVien.get(2);
                Map<Integer, NhanVien> sortedSalaryMap = new TreeMap<Integer, NhanVien>(Collections.reverseOrder());
                for (int i = 0; i < listEmployee.size(); i++){
                    Integer luongNV = 100 * listEmployee.get(i).getSoNgayLamViec();
                    sortedSalaryMap.put(luongNV, listEmployee.get(i));
                }
                System.out.println("List nhan vien sau khi sort theo luong giam dan la: ");
                Iterator<NhanVien> salaryIterator = sortedSalaryMap.values().iterator();
                while(salaryIterator.hasNext()){
                    salaryIterator.next().lietKeThongTinNhanVien();
                }
                break;

            case "10":
                ArrayList<GiamDoc> listGD = danhSachToanBoCongNhanVien.get(0);
                double maxCoPhanNamGiu = 0;
                int indexCoPhanMax = 0;
                for (int i = 0; i < listGD.size(); i++){
                    if (maxCoPhanNamGiu < listGD.get(i).getCoPhanNamGiu()){
                        maxCoPhanNamGiu = listGD.get(i).getCoPhanNamGiu();
                        indexCoPhanMax = i;
                    }
                }
                System.out.println("Giam doc co so co phan nhieu nhat co ma so giam doc la: " + listGD.get(indexCoPhanMax).getMaSo());
                break;

            case "11":
                ArrayList<GiamDoc> listGDoc = danhSachToanBoCongNhanVien.get(0);
                for (int i = 0; i < listGDoc.size(); i++){
                    System.out.println("Giam doc co ma so " + listGDoc.get(i).getMaSo() + " co thu nhap thang nay la: " + listGDoc.get(i).thuNhapCuaGiamDoc(listGDoc.get(i).getSoNgayLamViec()));
                }
                break;
        }
        return danhSachToanBoCongNhanVien;
    }

    public static String chonOption(Scanner sc){
        System.out.println("Cac chuc nang: ");
        System.out.println("1. Nhap thong tin cong ty");
        System.out.println("2. Phan bo nhan vien vao truong phong");
        System.out.println("3. Them, xoa thong tin nhan su bat ki");
        System.out.println("4. Xuat ra thong tin toan bo nguoi trong cong ty");
        System.out.println("5- Tinh va xuat tong luong cho toan cong ty");
        System.out.println("6. Tim nhan vien co luong cao nhat");
        System.out.println("7. Tim truong phong co so luong nhan vien duoi quyen nhieu nhat");
        System.out.println("8. Sap xep nhan vien toan cong ty theo thu tu abc");
        System.out.println("9. Sap xep nhan vien theo thu tu luong giam dan");
        System.out.println("10. Tim giam doc co so luong co phan nhieu nhat");
        System.out.println("11. Tinh va xuat tong thu nhap cua tung giam doc");
        System.out.println("Exit");

        System.out.println("Hay chon 1 chuc nang: ");
        String option = sc.next();
        return option;
    }


}