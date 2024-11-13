# 일정 관리
---
## API
| 기능       | Method | URL                             | request                                | response | 상태코드                          |
|----------|--------|---------------------------------|----------------------------------------|----------|-------------------------------|
| 일정 생성    | POST   | body : userName, title,contents | body : userName, title,contents            | 등록 정보    | 201 : 정상 생성 <br/>404 : 생성 실패  |
| 전체 일정 조회 | GET    |                           |             | 다건 정보    | 200 : 정상 조회 <br/> 404 : 조회 실패 |
| 선택 일정 조회 | GET    | /schedules/{id}                 | param : id                             | 단건 정보    | 200 : 정상 조회 <br/> 404 : 조회 실패 |
| 일정 수정 | PATCH  | /schedules/{id}                 | param : id <br/> body : title, contents | 단건 정보    | 200 : 정상 수정 <br/> 404 : 수정 실패 |
| 일정 삭제 | DELETE | /schedules/{id}                 | param : id                             | -        | 200 : 정상 삭제 <br/>404 : 삭제 실패  |
--- 
<details>
  <summary>일정 생성</summary>

| key         | TYPE         | COMMENT | NULL 여부 |
|-------------|--------------|---------|---------|
| id          | BIGINT       | 일정 id   | N       |
| userName    | VARCHAR(20)  | 작성 유저명  | N       |
| title       | VARCHAR(200) | 일정 내용 제목   | N       |
| contents    | VARCHAR(200) | 일정 내용 내용   | N       |
| createAt | DATETIME    | 생성일     | N       |
| modifiedAt | DATETIME    | 수정일     | N       |

RequestBody
```
url : 'http://localhost:8080/schedules' 
```

```sql
{
    "userName" : "작성 유저명", 
    "title" : "일정 내용 제목", 
    "contents" : "일정 내용 내용", 
}
```
ResopnseBody

성공 시 : 201 CREATED
```sql
{
    "id" : 1, 
    "userName" : "작성 유저명", 
    "title" : "일정 내용 제목", 
    "contents" : "일정 내용 내용", 
    "createAt" : "YYYY-DD-MM HH-MM-SS", 
    "modifiedAt" : "YYYY-DD-MM HH-MM-SS"
}
```

실패 시 : 404 BAD REQUEST

</details>
<details>
  <summary>전체 일정 조회</summary>

| key         | TYPE         | COMMENT | NULL 여부 |
|-------------|--------------|---------|---------|
| id          | BIGINT       | 일정 id   | N       |
| userName    | VARCHAR(20)  | 작성 유저명  | N       |
| title       | VARCHAR(200) | 일정 제목   | N       |
| contents    | VARCHAR(200) | 일정 내용   | N       |
| createAt | DATETIME    | 생성일     | N       |
| modifiedAt | DATETIME    | 수정일     | N       |

RequestBody

```
url : 'http://localhost:8080/schedules?userName = {userName}&modifiedAt = {modifiedAt}' 
```


ResopnseBody

성공 시 : 200 OK
```sql
{
    "id" : 1, 
    "contents" : "일정 내용", 
    "userName" : "작성 유저명", 
    "createAt" : "YYYY-DD-MM", 
    "modifiedAt" : "YYYY-DD-MM"
}
```

실패 시 : 404 NOT FOUND

</details>


<details>
  <summary>선택 일정 조회</summary>

| key        | TYPE         | COMMENT | NULL 여부 |
|------------|--------------|---------|---------|
| id         | BIGINT       | 일정 id   | N       |
| title      | VARCHAR(200) | 일정 제목   | N       |
| contents   | VARCHAR(200) | 일정 내용   | N       |
| userName   | VARCHAR(20)  | 작성 유저명  | N       |
| createAt | DATETIME    | 생성일     | N       |
| modifiedAt | DATETIME     | 수정일     | N       |

RequestBody

```
url : 'http://localhost:8080/schedules/{id}' 
```

ResopnseBody

성공 시 : 200 OK
```sql
{
    "id" : 1, 
    "title" : "일정 제목",
    "contents" : "일정 내용", 
    "userName" : "작성 유저명", 
    "createAt" : "YYYY-DD-MM", 
    "modifiedAt" : "YYYY-DD-MM"
}
```

실패 시 : 404 NOT FOUND

</details>

<details>
  <summary>선택 일정 수정</summary>

| key        | TYPE         | COMMENT | NULL 여부 |
|------------|--------------|---------|---------|
| id         | BIGINT       | 일정 id   | N       |
| title      | VARCHAR(200) | 일정 제목   | N       |
| contents   | VARCHAR(200) | 일정 내용   | N       |
| userName   | VARCHAR(20)  | 작성 유저명  | N       |
| modifiedAt | DATETIME    | 수정일     | N       |

RequestBody

```
url : 'http://localhost:8080/schedules/{id}' 
```

```sql
{
    "title" : "일정 제목",
    "contents" : "일정 내용", 
    "userName" : "작성 유저명"
}
```
ResopnseBody

성공 시 : 200 OK
```sql
{
    "id" : 1, 
    "title" : "일정 제목",
    "contents" : "일정 내용", 
    "userName" : "작성 유저명", 
    "modifiedAt" : "YYYY-DD-MM"
}
```

실패 시 : 404 NOT FOUND

</details>

<details>
  <summary>일정 삭제</summary>

RequestBody

```
url : 'http://localhost:8080/schedules/{id}' 
```

```sql
{
}
```
ResopnseBody

성공 시 : 200 OK
```sql
{
}
```

실패 시 : 404 NOT FOUND

</details>