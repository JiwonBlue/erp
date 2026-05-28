# 🏢 ERP 프로젝트
> **Spring Boot & React로 구현한 ERP 웹 사이트**
>
> 프로젝트 기간: 2023.09.13 ~ 2023.11.08 (팀 프로젝트)

## 🛠️ 사용 기술 및 라이브러리
- AWS, GitHub, Java, My SQL, React, Spring Boot

---

## 📱 담당한 기능
- 프로젝트 팀장(총괄 진행), 기획, DB설계
- 백엔드 폴더구조 세팅(도메인형 구조, global 폴더 생성)
- 깃허브 브랜치 세팅, 브랜치 보호 세팅
- 기본적인 CRUD 기능들 세팅(Postman을 활용해 테스트까지)
- 게시판, 영화 페이지 구현
- Spring Security Config Url나누기
- AWS와 인텔리제이 연결
- TMDB API 사용, Json 형태 데이터를 파싱 후 DB에 저장해서 활용

---

## 🔍 프로젝트 상세 (토글을 클릭하여 확인)

<details>
<summary>📐 기획 및 설계 단계 (클릭)</summary>

![1](images/1.jpg)
![2](images/2.jpg)
![3](images/3.jpg)
![4](images/4.jpg)
![5](images/5.jpg)
![6](images/6.jpg)
![7](images/7.jpg)
![8](images/8.jpg)
![9](images/9.jpg)
![10](images/10.jpg)
![11](images/11.jpg)
</details>

<details>
<summary>💻 주요 구현 화면 (클릭)</summary>

![design_32](images/design_32.jpg)
![design_37](images/design_37.jpg)
![design_38](images/design_38.jpg)
![design_39](images/design_39.jpg)
![design_40](images/design_40.jpg)
![design_41](images/design_41.jpg)
![design_42](images/design_42.jpg)
![design_43](images/design_43.jpg)
![design_44](images/design_44.jpg)
![design_45](images/design_45.jpg)
![design_46](images/design_46.jpg)
![design_47](images/design_47.jpg)
![design_48](images/design_48.jpg)
![design_49](images/design_49.jpg)
![design_50](images/design_50.jpg)
![design_51](images/design_51.jpg)
![design_52](images/design_52.jpg)
![design_53](images/design_53.jpg)
![design_54](images/design_54.jpg)
</details>

---

## 💡 깨달은 점
- 이전 프로젝트에서는 Controller, Repository 등으로 폴더를 묶는 **계층형 구조**였다면, 이번 프로젝트에서는 도메인형 구조를 활용해보았다. Controller에서 매핑할때 기준이 모호해지는 경우도 생기지만 기준을 잘 정해둔다면 계층형보다 깔끔해 보인다.
- **깃허브**에서 팀원들 별로 브랜치를 나눠둔 후 developer 브랜치를 보호해 풀 리퀘스트를 받아서 merge하는 방식으로 협업했다.
- **Postman**을 활용해 기본적인 기능들을 전부 테스트해보고 세팅해두었다. 내가 테스트해둔 샘플을 저장해 팀원들끼리 공유할 수 있어서 편리했다.
- **Spring Security** Config에서 Url을 나누고 권한을 고민하는 과정에서 프로젝트를 좀 더 디테일하게 고민해보고 이해할 수 있었다.
- **AWS**랑 인텔리제이 연결해 DB를 팀원들끼리 공유하며 사용해보니 확실히 편리하다는 것을 느꼈다.
- 팀원들끼리의 불화를 중재하는 경험을 하게 되었다.
- **MVC** 패턴에 대한 이해도 상승
