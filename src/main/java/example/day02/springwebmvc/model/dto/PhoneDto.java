package example.day02.springwebmvc.model.dto;

// PhoneDto 클래스: 전화번호 데이터를 담는 데이터 전송 객체 (DTO)
public class PhoneDto {
    // [1] 멤버변수: 전화번호 객체의 속성을 정의
    private int id;
    private String name;
    private String phone;

    // [2] 생성자: 객체 초기화를 위한 생성자들
    // 기본 생성자
    public PhoneDto() {
    }

    // 매개변수를 받는 생성자
    public PhoneDto(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    // [3] 메소드: 멤버변수에 접근하고 설정하기 위한 getter와 setter 메소드
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // [4] toString 오버라이딩: 객체의 문자열 표현을 정의
    @Override
    public String toString() {
        return "PhoneDto{" + "id=" + id + ", name='" + name + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
