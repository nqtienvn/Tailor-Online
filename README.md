## 🏗️ Cấu trúc Microservice

### 1. Thành phần chính

* **API Gateway:** Cổng vào duy nhất của toàn hệ thống, tiếp nhận mọi request từ client.
* **Service Discovery (Eureka Server):** Giúp các service trong hệ thống tự động đăng ký và tìm kiếm nhau theo tên.
* **Các Service:** Bao gồm nhiều service độc lập (IAM, Catalog, Order, Storage, v.v...), mỗi service đảm nhiệm một chức năng riêng biệt.
* **Common / Shared Library:** Chứa các thành phần dùng chung như DTO, exception, constants, utils,...

### 2. Cách hoạt động

1. Client gửi request đến **API Gateway**.
2. API Gateway chuyển tiếp request tới **Service Discovery** để xác định địa chỉ thực tế của service cần gọi.
3. Request được định tuyến đến **service tương ứng** (ví dụ: `catalog-service`, `order-service`, ...).
4. Service xử lý logic nội bộ và phản hồi lại cho Gateway → trả về client.

---

## 🧩 Cấu trúc DDD (Domain-Driven Design)

### 1. Các tầng chính

#### **Presentation Layer**

* Là tầng **Controller**, tiếp nhận và phản hồi request từ client.
* Thực hiện điều hướng request đến application layer thông qua request dispatcher.

#### **Application Layer**

* Điều phối luồng xử lý giữa presentation và domain.
* Chịu trách nhiệm xử lý đầu vào/đầu ra, thực thi các **command** hoặc **query**.
* Không chứa business logic, chỉ đóng vai trò “điều phối”.

#### **Domain Layer**

* Là **trái tim** của ứng dụng.
* Chứa toàn bộ **business logic** và **nghiệp vụ cốt lõi**.
* Gồm các thành phần:

  * **Command:** Yêu cầu ghi dữ liệu hoặc hành động (create, update, delete).
  * **Query:** Yêu cầu đọc dữ liệu.
  * **Service:** Xử lý toàn bộ logic nghiệp vụ.
  * **Repository Interface:** Khai báo các hành vi thao tác với dữ liệu, không chứa code cụ thể.

#### **Infrastructure Layer**

* Là tầng **hạ tầng**, chịu trách nhiệm giao tiếp với hệ thống bên ngoài như cơ sở dữ liệu, API khác,...
* Cung cấp **implementation** cụ thể cho các repository của domain.
* Cũng có thể chứa mapper, config, persistence entity, v.v.

---

🧠 **Tóm gọn:**

> Microservice đảm bảo tính tách biệt và mở rộng;
> DDD đảm bảo kiến trúc trong từng service rõ ràng, dễ bảo trì, dễ mở rộng và phản ánh đúng nghiệp vụ thực tế.
