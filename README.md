# 🚀 MVP Backend

Spring Boot 기반의 MVP 백엔드 프로젝트입니다.
공통 응답 구조, 예외 처리, 페이징, 외부 API 연동 구조를 포함한 **확장 가능한 기본 아키텍처**를 목표로 합니다.

---

## 🛠 Tech Stack

* Java 17
* Spring Boot
* MyBatis
* PostgreSQL
* Gradle
* Swagger (SpringDoc OpenAPI)

---

## 📁 Project Structure

```
com.ktds.mvp.demo
├── common
│   ├── client        # 외부 API 호출 (WebClient)
│   ├── config        # 설정 (Swagger, WebClient 등)
│   ├── exception     # 공통 예외 처리
│   ├── paging        # 페이징 공통 객체
│   ├── response      # ApiResponse, ResponseCode
│   └── util          # DateUtils, StringUtils
│
├── brand
│   ├── controller
│   ├── service
│   ├── mapper        # MyBatis Mapper
│   └── dto
```

---

## ⚙️ 주요 기능

### ✅ 공통 응답 구조

* `ApiResponse<T>` 기반 응답 통일
* 성공 / 실패 코드 분리 관리

### ✅ 글로벌 예외 처리

* `GlobalExceptionHandler`
* `CustomException` 기반 처리

### ✅ 페이징 처리

* `PageRequest`, `PageResponse`
* MyBatis 기반 페이징

### ✅ 외부 API 연동

* `WebClient` 기반 공통 Client
* GET / POST / PUT / DELETE 지원
* 에러 처리 및 로깅 포함

### ✅ Swagger API 문서

* API 테스트 및 문서 자동화
* URL: `/swagger`

---

## 🗄 Database

* PostgreSQL 사용
* 스키마: `mvp`

### 예시 테이블

* brand
* model
* vehicle

---

## 🔧 실행 방법

### 1. DB 설정

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/ontology?currentSchema=mvp
    username: mvpuser
    password: ****
```

---

### 2. 서버 실행

```bash
./gradlew bootRun
```

---

### 3. Swagger 접속

```
http://localhost:8080/swagger
```

---

## 📌 API 예시

### 브랜드 목록 조회

```
GET /brands
```

Response:

```json
{
  "code": "S000",
  "message": "성공",
  "data": [
    {
      "id": 1,
      "name": "BMW"
    }
  ]
}
```

---

## 🔄 Git Workflow

```
main      - 운영
develop   - 개발
feature/* - 기능 개발
```

