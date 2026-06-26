Sinh viên thực hiện:

Đỗ Đình Sách

MSV: 12922024 Lớp: 12523T.1

Đỗ Thị Bình

MSV: 10123035 Lớp: 12523T.1 

Giảng viên hướng dẫn: ThS.Bùi Đức Thọ


# 💻 LaptopShop - Ứng dụng Quản lý Cửa hàng máy tính trên Android
## Giới thiệu
**LaptopShop** là ứng dụng quản lý cửa hàng máy tính được phát triển trên nền tảng Android nhằm hỗ trợ quản lý hoạt động kinh doanh và bán hàng một cách hiệu quả.
Ứng dụng cho phép quản trị viên quản lý sản phẩm, đơn hàng, khách hàng, nhà cung cấp, kho hàng và voucher; đồng thời hỗ trợ khách hàng tìm kiếm sản phẩm, thêm vào giỏ hàng và đặt hàng trực tiếp trên ứng dụng.
Dự án được xây dựng phục vụ học tập trong môn **Phát triển ứng dụng di động** tại **Trường Đại học Sư phạm Kỹ thuật Hưng Yên**.
---
# Mục tiêu đề tài
* Xây dựng ứng dụng quản lý cửa hàng laptop trên nền tảng Android.
* Hỗ trợ khách hàng xem và đặt mua sản phẩm.
* Hỗ trợ quản trị viên quản lý sản phẩm, kho và đơn hàng.
* Thống kê doanh thu và tình trạng bán hàng.
* Lưu trữ dữ liệu bằng SQLite.
* Thiết kế giao diện thân thiện, dễ sử dụng.
---
# Chức năng chính
## Khách hàng
* Đăng ký tài khoản.
* Đăng nhập.
* Xem danh sách laptop.
* Xem chi tiết sản phẩm.
* Tìm kiếm sản phẩm.
* Lọc sản phẩm theo:

  * Hãng
  * Loại laptop
  * CPU
  * RAM
  * Ổ cứng
  * Kích thước màn hình
  * Độ phân giải
  * Tần số quét
* Thêm sản phẩm vào giỏ hàng.
* Đặt hàng.
* Áp dụng voucher giảm giá.
* Theo dõi trạng thái đơn hàng.
* Quản lý thông tin cá nhân.
---
## Quản trị viên
### Quản lý sản phẩm
* Thêm sản phẩm.
* Cập nhật sản phẩm.
* Xóa sản phẩm.
* Tìm kiếm sản phẩm.
### Quản lý danh mục
* Thêm.
* Cập nhật.
* Xóa.
### Quản lý thương hiệu
* Thêm.
* Cập nhật.
* Xóa.
### Quản lý nhà cung cấp
* Thêm.
* Cập nhật.
* Xóa.
### Quản lý đơn nhập
* Lập phiếu nhập.
* Xem chi tiết phiếu nhập.
* Cập nhật tồn kho.
### Quản lý đơn hàng
* Xác nhận đơn hàng.
* Cập nhật trạng thái đơn hàng.
* Theo dõi tiến trình xử lý đơn hàng.
* Hủy đơn hàng.
### Quản lý Voucher
* Thêm voucher.
* Cập nhật voucher.
* Xóa voucher.
* Kích hoạt hoặc khóa voucher.
### Thống kê
* Doanh thu.
* Đơn hàng.
* Sản phẩm bán chạy.
* Số lượng tồn kho.
---
# Công nghệ sử dụng
* **Ngôn ngữ lập trình:** Java
* **IDE:** Android Studio
* **Thiết kế giao diện:** XML
* **Cơ sở dữ liệu:** SQLite
* **Build Tool:** Gradle
* **Android SDK**
* **RecyclerView**
* **Material Components**
---
# Kiến trúc dự án
Dự án được tổ chức theo mô hình phân lớp nhằm tách biệt phần giao diện, dữ liệu và xử lý chức năng, giúp mã nguồn dễ bảo trì và mở rộng.
```text
UI
│
├── Data
│
└── SQLite Database
```
---
# Cấu trúc thư mục
```text
app/
│
├── manifests/
│   └── AndroidManifest.xml
│
├── java/
│   └── com.example.laptopshop/
│       │
│       ├── data/
│       │   ├── dao/
│       │   ├── db/
│       │   └── model/
│       │
│       ├── ui/
│       │   ├── admin/
│       │   ├── auth/
│       │   ├── cart/
│       │   ├── checkout/
│       │   ├── home/
│       │   ├── orders/
│       │   ├── products/
│       │   └── profile/
│       │
│       └── utils/
│
├── res/
│   ├── anim/
│   ├── color/
│   ├── drawable/
│   ├── layout/
│   ├── menu/
│   ├── mipmap/
│   ├── values/
│   └── xml/
│
└── Gradle Scripts/
```
---
# Cơ sở dữ liệu
Ứng dụng sử dụng SQLite để lưu trữ dữ liệu cục bộ.
Các bảng chính:
* TaiKhoan
* KhachHang
* DanhMuc
* ThuongHieu
* SanPham
* GioHang
* DonHang
* ChiTietDonHang
* HoaDonNhap
* ChiTietHoaDonNhap
* Voucher
---
# Yêu cầu môi trường
* Windows 10/11
* Android Studio
* Android SDK
* JDK 17
---
# Cài đặt
Clone dự án:
```bash
git clone https://github.com/DoDinhSach/LaptopShop.git
```
Sau đó:
1. Mở Android Studio.
2. Chọn **Open Project**.
3. Chọn thư mục dự án.
4. Chờ Gradle Sync hoàn tất.
5. Kết nối thiết bị Android hoặc khởi động Android Emulator.
6. Nhấn **Run** để chạy ứng dụng.
---
# Hướng dẫn sử dụng
## Đối với khách hàng
1. Đăng ký hoặc đăng nhập tài khoản.
2. Tìm kiếm laptop theo nhu cầu.
3. Thêm sản phẩm vào giỏ hàng.
4. Áp dụng voucher (nếu có).
5. Xác nhận đặt hàng.
6. Theo dõi trạng thái đơn hàng.
## Đối với quản trị viên
1. Đăng nhập hệ thống.
2. Quản lý sản phẩm.
3. Quản lý danh mục và thương hiệu.
4. Quản lý kho và đơn nhập.
5. Quản lý đơn hàng.
6. Quản lý voucher.
7. Theo dõi thống kê doanh thu.
---
# Kết quả đạt được
* Xây dựng thành công ứng dụng quản lý cửa hàng laptop trên Android.
* Quản lý đầy đủ sản phẩm, khách hàng, nhà cung cấp và đơn hàng.
* Hỗ trợ khách hàng đặt mua sản phẩm trực tuyến.
* Quản lý voucher giảm giá.
* Thống kê doanh thu và sản phẩm bán chạy.
* Giao diện trực quan, dễ sử dụng.
* Dữ liệu được lưu trữ ổn định bằng SQLite.
---
# Hướng phát triển
Trong tương lai, hệ thống có thể được mở rộng với các chức năng:
* Đồng bộ dữ liệu bằng Firebase.
* Thanh toán trực tuyến.
* Đăng nhập bằng Google.
* Quản lý nhiều chi nhánh.
* Xuất hóa đơn PDF.
* Sao lưu dữ liệu lên Cloud.
* Thống kê bằng biểu đồ.
* Quét mã QR và mã vạch sản phẩm.
* Phát triển phiên bản Web Admin.
---
# Tài liệu tham khảo
* Android Developers Documentation
* Java Documentation
* SQLite Documentation
* Android Studio Documentation
* Giáo trình Phát triển ứng dụng di động
* Giáo trình Công nghệ phần mềm
* Giáo trình Phân tích và thiết kế hệ thống thông tin
---
# Giấy phép
Dự án được phát triển phục vụ mục đích học tập và nghiên cứu tại **Trường Đại học Sư phạm Kỹ thuật Hưng Yên**.
