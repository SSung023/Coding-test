def solution(price, money, count):
    answer = 0
    expected = 0

    for i in range(1, count + 1):
        expected += price * i

    if expected - money < 0:
        return 0

    return expected - money