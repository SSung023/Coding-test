def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):
        line = ""
        
        binary1 = bin(arr1[i])[2:].zfill(n)
        binary2 = bin(arr2[i])[2:].zfill(n)
        
        map_len = len(binary1)
        # print(map_len)
        for k in range(map_len):
            target1 = int(binary1[k])
            target2 = int(binary2[k])
            
            # print("{}, {}".format(target1, target2))
            
            # 둘 중 하나라도 1(벽)이라면
            if target1 or target2:
                # print("벽")
                line += "#"
            else:
                # print("공간")
                line += " "
        answer.append(line)
        # print()
    
    return answer
