def solution(t, p):
    answer = 0

    sub_len = len(p)
    p = int(p)
    i = 0
    end = i + sub_len

    while end <= len(t):
        target = int((t[i:end]))
        if target <= p:
            answer += 1

        end += 1
        i += 1

    return answer