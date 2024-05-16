/**
 * 평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다. DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다. 예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다. 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.
 * 하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다. 임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다. 그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
 * 임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자. 그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자. 이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.
 * 민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.
 */

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    // s는 DNA 문자열의 길이, p는 검사할 윈도우의 길이
    val (s, p) = readLine().split(" ").map { it.toInt() }
    // DNA 문자열 입력받음
    val dna = readLine()
    // 각 문자(A, C, G, T)가 윈도우에 최소 몇 개 있어야 하는지 입력받음
    val (a, c, g, t) = readLine().split(" ").map { it.toInt() }
    // 초기 윈도우(ss) 설정
    val ss = dna.substring(0, p)
    // 초기 윈도우 내의 A, C, G, T의 개수 계산
    var (sa, sc, sg, st) = listOf(
            ss.count { it == 'A' },
            ss.count { it == 'C' },
            ss.count { it == 'G' },
            ss.count { it == 'T' }
    )
    // 조건을 만족하는 윈도우의 개수를 세는 카운터
    var cnt = 0
    // 윈도우의 시작점과 끝점
    var start = 0
    var end = p - 1
    // 윈도우를 DNA 문자열 끝까지 슬라이드
    while (end <= s - 1) {
        // 현재 윈도우가 조건을 만족하는지 확인
        if (sa >= a && sc >= c && sg >= g && st >= t) {
            cnt++
        }
        // 윈도우의 시작점 문자에 따라 카운트 감소
        when (dna[start]) {
            'A' -> sa--
            'C' -> sc--
            'G' -> sg--
            'T' -> st--
        }
        // 윈도우를 한 칸 오른쪽으로 이동
        start++
        end++
        if (end >= s) break  // 윈도우의 끝점이 DNA 문자열의 끝을 넘어서면 종료

        // 윈도우의 새로운 끝점 문자에 따라 카운트 증가
        when (dna[end]) {
            'A' -> sa++
            'C' -> sc++
            'G' -> sg++
            'T' -> st++
        }
    }
    // 조건을 만족하는 윈도우의 총 개수 출력
    println(cnt)
}
