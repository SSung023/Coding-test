import heapq

def init(genres, plays):
    genre_info = {}
    play_info = {}
    
    for idx, genre in enumerate(genres):
        play = plays[idx]
        if genre not in genre_info:
            genre_info[genre] = [genre, play]
            play_info[genre] = [(-play, idx)]
            continue
            
        genre_info[genre][1] = genre_info[genre][1] + play
        heapq.heappush(play_info[genre], (-play, idx))
        
    genre_list = list(genre_info.values())
    genre_list.sort(reverse=True, key=lambda x: x[1])
    # print(genre_list)
    # print(play_info)
    return genre_info, play_info


def solution(genres, plays):
    answer = []
    genre_info, play_info = init(genres, plays)
    
    for genre, _ in sorted(genre_info.values(), key=lambda x: -x[1]):
        cnt = 0
        
        while play_info[genre]:
            if cnt >= 2:
                break
            max_value, idx = heapq.heappop(play_info[genre])
            answer.append(idx)
            cnt += 1
    
    return answer
