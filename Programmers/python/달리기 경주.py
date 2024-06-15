def extract_dict(players):
    init_players = {}
    for i in range(len(players)):
        init_players[players[i]] = i
    return init_players;

def solution(players, callings):
    results = extract_dict(players)
    
    for call in callings:
        # 이름이 불린 선수의 현재 등수
        rank = results[call]
        # 추월당한 선수 이름
        overtaked = players[rank-1]
        
        # 선수의 순서를 서로 바꿈
        players[rank], players[rank-1] = players[rank-1], players[rank]
        
        # 딕셔너리에 적용
        results[call] = rank-1
        results[overtaked] = rank
    
    return players
