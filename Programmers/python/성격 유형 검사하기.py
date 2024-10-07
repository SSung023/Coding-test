# 2022 KAKAO TECH INTERNSHIP - 성격 유형 검사하기

def find(personal, type1, type2):
    weight1 = personal[type1]
    weight2 = personal[type2]
    
    if weight1 == weight2:
        return type1 if type1 < type2 else type2
    
    return type1 if weight1 > weight2 else type2
    

def solution(survey, choices):
    answer = ''
    personal = {'R':0, 'T':0, 'C':0, 'F':0, 'J':0, 'M':0, 'A':0, 'N':0}
    weight = [-3, -2, -1, 0, 1, 2, 3]
    length = len(survey)
    
    for i in range(0, length):
        negative = survey[i][0]
        positive = survey[i][1]
        choice = choices[i] - 1
        
        if weight[choice] > 0:
            personal[positive] = personal[positive] + weight[choice]
        else: 
            personal[negative] = personal[negative] + (weight[choice] * -1)
    
    answer += find(personal, 'R', 'T')
    answer += find(personal, 'C', 'F')
    answer += find(personal, 'J', 'M')
    answer += find(personal, 'A', 'N')
    
    return answer
