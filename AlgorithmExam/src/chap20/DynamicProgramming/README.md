# 20. Dynamic Programming
 
## 피보나치 수열
* 재귀 함수 문제점: 똑같은 값의 함수를 재실행 함. 많은 계산이 중복됨.
* 해결
> 중간 계산 결과를 캐싱함으로써 중복 계산을 피함. (Memoizaion)
```java
int fib(int n)
{
	if( n==1 || n==2 )
		return 1;
	else if( f[n] > -1 )
		return f[n];
	else {
		f[n] = fib(n-2)+ fib(n-1);
		return f[n];
	}
}
```