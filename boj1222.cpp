#include <iostream>
using namespace std;

int arr[2000001];

int main() {	
	/*
	참가 가능한 학교 수 * 팀 인원이 최대가 되어야 함.
	팀 인원이 해당 학교 학생 수의 약수여야 참가 가능	
	*/

	int n;
	cin >> n;

	// 각 학교의 학생 수를 입력으로 받을때 해당 수의 약수를 모두 구함 (O(sqrt(n))	
	// 배열을 통해 1~2000000까지 수 중에 각 학교 학생 수의 약수가 되는 경우는 모두 몇 번인지 카운트
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		for (int j = 1; j * j <= num; j++) {
			if (j * j == num) arr[j]++;
			else if (num % j == 0) {
				arr[j]++;
				arr[num / j]++;
			}
		}
	}

	long long max = arr[1];
	for (long long i = 2; i <= 2000000; i++) {
		if (arr[i]>1 && max < i * arr[i]) max = i * arr[i];
	}
	cout << max;
}
