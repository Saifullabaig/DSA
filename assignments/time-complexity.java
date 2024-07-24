int a = 0, b = 0;
for (i = 0; i < N; i++) {
    a = a + Math.random();
}
for (j = 0; j < M; j++) {
    b = b + Math.random();
}
//3. O(N + M) time, O(1) space


int a = 0;
for (i = 0; i < N; i++) {
    for (j = N; j > i; j--) {
        a = a + i + j;
    }
}
//4. O(N*N)


int i, j, k = 0;
for (i = n / 2; i <= n; i++) {
    for (j = 2; j <= n; j = j * 2) {
        k = k + n / 2;
    }
}
//2. O(nLogn)


int a = 0, i = N;
while (i > 0) {
    a += i;
    i /= 2;
}
//4. O(log N)


for(int i=1;i<n;i++){
i*=k;
}
//3. O(logkn)


int value = 0;
for(int i=0;i<n;i++)
    for(int j=0;j<i;j++)
    value += 1;
//3. n(n-1)/2
