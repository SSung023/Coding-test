def solution(k, score):
    answer = []
    honor = []  # 명예의 전당 점수를 담는 배열

    for i, today in enumerate(score):
        # 초기 k일까지는 모든 점수가 명예의 전당에 오름
        if i < k:
            honor.append(today)
            honor.sort()
        else:
            # k+1일부터는 k번째 순위의 가수 점수보다 높으면 명예의 전당에 오름
            if today > honor[0]:
                honor[0] = today
                honor.sort()

        answer.append(honor[0])

    return answer