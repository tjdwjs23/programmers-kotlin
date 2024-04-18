/**
* 땅을 나타내고 물을 나타내는 row x col grid지도를 보여 줍니다 .grid[i][j] = 1grid[i][j] = 0
* 그리드 셀은 수평/수직 (대각선이 아님)으로 연결됩니다 . 은 grid완전히 물로 둘러싸여 있으며 정확히 하나의 섬(즉, 연결된 하나 이상의 육지 셀)이 있습니다.
* 섬에는 "호수"가 없습니다. 이는 내부의 물이 섬 주변의 물과 연결되어 있지 않음을 의미합니다. 한 셀은 변의 길이가 1인 정사각형입니다. 그리드는 직사각형이고 너비와 높이가 100을 초과하지 않습니다. 섬의 둘레를 결정합니다.

* 예시 1:
* 입력: 그리드 = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 출력: 16
 설명: 둘레는 위 이미지의 16개의 노란색 줄무늬입니다.
 
* 예시 2:
* 입력: 그리드 = [[1]]
*  출력: 4

* 예시 3:
* 입력: 그리드 = [[1,0]]예
*  출력: 4

*/

class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
      var answer = 0
  
      // 각 행에 대해 반복
      grid.forEachIndexed { i, row ->
          // 각 열에 대해 반복
          row.forEachIndexed { j, value ->
              if (value == 1) {
                  // 상단 확인: 현재 위치가 첫 번째 행이거나 상단이 물(0)인 경우
                  if (i == 0 || grid[i - 1][j] == 0) answer++
                  // 하단 확인: 현재 위치가 마지막 행이거나 하단이 물(0)인 경우
                  if (i == grid.lastIndex || grid[i + 1][j] == 0) answer++
                  // 왼쪽 확인: 현재 위치가 첫 번째 열이거나 왼쪽이 물(0)인 경우
                  if (j == 0 || grid[i][j - 1] == 0) answer++
                  // 오른쪽 확인: 현재 위치가 마지막 열이거나 오른쪽이 물(0)인 경우
                  if (j == row.lastIndex || grid[i][j + 1] == 0) answer++
              }
          }
      }
      return answer
  }
}
