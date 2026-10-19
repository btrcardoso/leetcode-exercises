# Non-Divisible Subset 

```
k = 4

entrada:
0 1 2 3 4 5 6 7 8
4 1 2 3 5 6 8 7 2

restos:
0 1 2 3 4 5 6 7 8 
0 1 2 3 1 2 0 3 2


quantos numeros tem resto 0, 1, 2, 3
              0,1,2,3
remainders = [2,2,3,2]   
```

opposite é o resto que combinado com i, produz uma soma divisivel por k.
representa os casos em que nao podemos fazer combinações.

```
opposite = i == 0 ? 0 : k-i;

k = 4
i = 0, opposite = 0
i = 1, opposite = 3
i = 2, opposite = 2
i = 3, opposite = 1
```
a iteração ocorre de i=0..k/2, pois depois de k/2 as operações só se repetirão.


No resultado, vc vai somar quem fará parte do maior conjunto possivel que respeite a propriedade 
(A soma de quaisquer dois valores do conjunto não é divisível por k)

```java
if (i == opposite) {
    result += Math.min(remainders[i], 1);                      // somente um poderá entrar no conjunto
} else {
    result += Math.max(remainders[i], remainders[opposite]);   // escolherá o que mais tem numeros pra entrar no conjunto
}
```





----

Outros casos

k = 6
             0  1  2  3  4  5 
remainders=[12,25,18,30,14,20]


Como montar meu maior conjunto

i = 0
    Somará somente  +1
i = 1, opposite = 5
    Somará do i=1, +25
i = 2, opposite = 4
    Somará do i=2, +18
i = 3
    Somará somente  +1

resulttado = 45















