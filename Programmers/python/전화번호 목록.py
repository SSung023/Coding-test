# 주의점: 이중 for문은 O(n^2)로 효율성 테스트에서 떨어집니다.  

def solution(phone_book):  
    phone_book.sort()
    
    for idx in range(len(phone_book) - 1):
        prefix = phone_book[idx]
        prefix_len = len(prefix)
        target = phone_book[idx + 1]
        
        if prefix == target[:prefix_len]:
            return False
    
    return True
