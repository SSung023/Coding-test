class Solution {
    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        
        return new int[] {count.zero, count.one};
    }
    
    public Count count(int offsetY, int offsetX, int size, int[][] arr) {
        int h = size / 2; // 나눌 영역의 크기
        
        // 해당 영역을 검사하면서 다른 수가 발견되면 영역 쪼개기 필요
        for(int y = offsetY; y < offsetY + size; y++) {
            for(int x = offsetX; x < offsetX + size; x++) {
                // 다른 값을 가지고 있다면
                if(arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetY, offsetX, h, arr)
                        .add(count(offsetY, offsetX + h, h, arr))
                        .add(count(offsetY + h, offsetX, h, arr))
                        .add(count(offsetY + h, offsetX + h, h, arr));
                }
            }
        }
        
        if(arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
        
    }
    
    class Count {
        final int zero;
        final int one;
        
        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
        
        public Count add(Count count) {
            return new Count(this.zero + count.zero, this.one + count.one);
        }
    }
}
