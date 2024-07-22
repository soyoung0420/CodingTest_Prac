# [level 1] 자연수 뒤집어 배열로 만들기 - 12932 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=python3) 

### 성능 요약

메모리: 10.1 MB, 시간: 0.01 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 07월 22일 20:11:23

### 문제 설명

<p>자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.</p>

<h5>제한 조건</h5>

<ul>
<li>n은 10,000,000,000이하인 자연수입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>12345</td>
<td>[5,4,3,2,1]</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges


# [TIL] 배열, 리스트

## java로 풀기 
### 풀이
long타입 자연수 n을 문자열로 변환 후 각 자리수를 10으로 나눈 나머지로 변환하여 배열에 순서대로 담았다.

### python으로 풀기 

str() : 문자열 변환함수 

리스트
- java에서의 배열로 사용하는 것을 파이썬에서는 리스트를 사용
- 요소의 자료형을 통일하지 않아도 됨
- list.append() : 요소 추가
- list.pop() : 요소 제거

처음에 혼동하여 nums = {} 로 선언 후에 풀이를 했더니 반환값이 {0: 4, 1: 3, 2: 2, 3: 1}로 나와서 실패가 떴다. 
{}로 선언할 경우 이는 딕셔너리로 인덱스와 값을 한 쌍으로 저장해준다. 
따라서 출력시 인덱스와 값이 한 쌍으로 나오게 되므로 문제에서 원하는 답에 부합하지 않았던 것! 

#### 딕셔너리 사용시
```python
def solution(n):
    nums = {}
    for i in range(len(str(n))):
        nums[i] = int(n % 10)
        n //= 10
    return nums
```

