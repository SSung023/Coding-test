def get_closet(clothes):
    closet = {}
    for name, types in clothes:
        if types not in closet.keys():
            closet[types] = 0
        closet[types] = (closet[types] + 1)
        
    return closet
            
def solution(clothes):
    answer = 1
    closet = get_closet(clothes)
    
    for num in closet.values():
        answer *= (num + 1)
    
    return answer - 1
