# 18. ShortestPathProblem

### Single source
* 하나의 출발 노드 s로 부터 다른 모든 노드까지의 최단경로를 찾는다.  
예) 다익스트라 알고리즘  

### Single destination  
* 모든 노드로부터 하나의 목적지 노드까지의 최단 경로를 찾아라.
예) Single source 문제와 동일

### Single pair 
* 주어진 하나의 출발 노드 s로 부터 하나의 목적지 노드 t까지의 최단경로를 찾아라
* 최악의 경우 시간복잡도는 Single source 문제보다 나은 알고리즘이 없음.

### All pairs  
* 모든 노드 쌍에 대해서 최단 경로를 찾아라  

#### 음수 가중치.
알고리즘에 따라 음수 가중치가 있어도 작동하는 경우도 있고 그렇지 않은 경우도 있음.  
음수 사이클이 있으면 최단경로가 정의 되지 않음.

1. 다익스트라 알고리즘.
![Dijkstra_Animation](./Dijkstra_Animation.gif)


2. 플로이드-워셜 알고리즘
- 플로이드-워셜 알고리즘은 각각의 꼭짓점 쌍을 지나는 그래프의 모든 경로를 비교한다. 
- 모든지점이 지나가는 최단경로 계산... 
```
let dist be a |V| × |V| array of minimum distances initialized to ∞ (infinity)
  for each edge (u,v)
     dist\[u]\[v] ← w(u,v)  // 변 (u,v)의 가중치
  for each vertex v
     dist\[v]\[v] ← 0
  for k from 1 to |V|
     for i from 1 to |V|
        for j from 1 to |V|
           if dist\[i]\[j] > dist\[i]\[k] + dist\[k]\[j] 
              dist\[i]\[j] ← dist\[i]\[k] + dist\[k]\[j]
           end if
```