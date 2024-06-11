def solution(board, h, w):
    # 상 하 좌 우
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    max_y = len(board)
    max_x = len(board[0])
    
    target_color = board[h][w]
    answer = 0
    
    for i in range(4):
        target_x = w + dx[i]
        target_y = h + dy[i]
        
        if target_x < 0 or target_y < 0 or target_y >= max_y or target_x >= max_x:
            continue
            
        if board[target_y][target_x] == target_color:
            answer += 1
    
    return answer
