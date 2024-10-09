def solution(nums):
    answer = len(nums) // 2
    phonekemon = set()
    
    for num in nums:
        phonekemon.add(num)
    
    phonekemon_len = len(phonekemon)
    
    return min(phonekemon_len, answer)
