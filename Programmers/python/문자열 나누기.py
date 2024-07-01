def solution(s):
    answer = 0
    target = s[0]
    same = 0
    diff = 0

    for i in range(len(s)):
        word = s[i]

        if same == diff:
            answer += 1
            target = s[i]
            same = 0
            diff = 0

        if word == target:
            same += 1
        else:
            diff += 1

    return answer