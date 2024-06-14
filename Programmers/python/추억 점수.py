def solution(name, yearning, photo):
    answer = []
    score_dict = {}
    for i in range(len(name)):
        score_dict[name[i]] = yearning[i]
    
    for single_photo in photo:
        score = 0
        for person in single_photo:
            if person in score_dict:
                score += score_dict[person]
        answer.append(score)
        
    return answer
