def solution(s):
    arr = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    answer = ""
    number = ""

    for word in s:
        if word.isnumeric():
            answer += word
            continue

        number += word
        if number in arr:
            answer += str(arr.index(number))
            number = ""


    return int(answer)