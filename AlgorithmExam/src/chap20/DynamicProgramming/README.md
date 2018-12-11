# 20. Dynamic Programming  
 
## 피보나치 수열   
* 재귀 함수 문제점: 똑같은 값의 함수를 재실행 함. 많은 계산이 중복됨.  
* 해결  
1. 중간 계산 결과를 캐싱함으로써 중복 계산을 피함. (Memoizaion)  

```java
int fib(int n){
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
2. bottom-up 방식
```java 
int fib(int n){

	f[1]=f[2]=1;
	for(int i=3;i<=n;i++)
		f[i]=f[i-1]+[i-2];
	return f[n];	
}
```

## 이항계수
> nCr=(nr)=n!r!(n−r)!

![binomial](./binomial.svg)

```java
int binomial(int n, int k)
{
	for( int i = 0; i<=n ; i++){
		for(int j=0;j<=k && j<=i;j++){
			if( k==0 || n==k )
				binom[i][j] = 1;
			else
				binom[i][j] = binom[i-1][j-1] + binom[i-1][j];
		}
	}
	return binom[n][k];
} 
```
