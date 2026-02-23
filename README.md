# Student Management System

Bài tập Xây dựng Web App Quản lý Thông tin Sinh viên sử dụng Java Spring Boot, trong khuôn khổ bài lab môn Công Nghệ Phần Mềm Nâng Cao.

## 📋 Thông tin nhóm
| STT | Họ và tên | MSSV | Vai trò |
|-----|-----------|------|---------|
| 1 | Nguyễn Khánh Bình | 2210318 | Developer |

## 🌐 Public URL (Web Service)
> **Link Deploy:** https://binh-student-management.onrender.com/students
>
> *(Bài tập đã được deploy theo yêu cầu của Lab 5)*
>
> ⚠️ **Lưu ý nhỏ:** Do sử dụng gói Free của Render, Web Service sẽ tự động chuyển sang trạng thái "sleep" nếu không có truy cập trong vòng 15 phút. Ở lần truy cập đầu tiên sau đó, trang web có thể sẽ mất tới 5 phút để khởi động lại. Mong thầy kiên nhẫn chờ đợi.

## 🛠 Cài đặt và Hướng dẫn chạy (How to run)

### Yêu cầu hệ thống
- JDK 17+
- Maven
- PostgreSQL (nếu chạy local)

### Các bước chạy dự án
1. **Clone repository:**
   ```bash
   git clone https://github.com/BinhTurtle/student-management
   cd <ten-thu-muc-goc>
   ```
2. **Chạy project:**
   ```bash
   mvn spring-boot:run
   ```
   > *(Nếu chạy local, cần có PostgreSQL được cài đặt trên local)*
3. **Truy cập vào Web App:**
   Mở trình duyệt tại địa chỉ: `http://localhost:8080`

---

## 📝 Trả lời câu hỏi, bài tập lab

### Lab 1: Khởi Tạo & Kiến Trúc

**1. Kết quả thêm 10 dữ liệu vào Database:**

![Thêm 10 dữ liệu](images/lab1/1_them_10_du_lieu.png)

**2. Test trường hợp trùng ID (Unique Constraint):**

![Test trùng ID](images/lab1/2_test_trung_ID.png)

**3. Test ràng buộc Not Null:**

![Test Not Null](images/lab1/3_test_rang_buoc_notnull.png)


### Lab 2: Xây Dựng Backend REST API

**1. Test API getAll (Lấy danh sách sinh viên):**

![Get All API](images/lab2/1_getAll_api_test.png)

**2. Test API getByID (Trường hợp ID tồn tại):**

![Get By ID Valid](images/lab2/2_getByID_api_valid_test.png)

**3. Test API getByID (Trường hợp ID không tồn tại):**

![Get By ID Not Exist](images/lab2/3_getByID_api_notExist_test.png)


### Lab 3: Xây Dựng Frontend (SSR với Thymeleaf)

**1. Trang chủ với hiển thị giao diện có điều kiện:**

![Homepage Conditional Display](images/lab3/1_homepage_with_conditional_display.png)

**2. Chức năng tìm kiếm theo Tên hoặc Email:**

![Search by Name or Email](images/lab3/2_search_by_name_or_email.png)


### Lab 4: Hoàn Thiện Sản Phẩm

**1. Chức năng thêm sinh viên mới:**

![Add New Student](images/lab4/1_create_new_student_modal.png)

**2. Trang thông tin sinh viên chi tiết:**

![Student Detail](images/lab4/2_student_details_page.png)

**3. Form chỉnh sửa thông tin sinh viên:**

![Edit Student](images/lab4/3_student_info_edit_modal.png)

**4. Chức năng xóa sinh viên:**

![Delete Student](images/lab4/4_student_delete_confirm.png)