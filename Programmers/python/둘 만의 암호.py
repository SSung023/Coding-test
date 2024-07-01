def get_skip_index(skip):
    skip_index = []
    for word in skip:
        skip_index.append(ord(word) - 97)
    return skip_index

def increase_idx(word_idx):
    if word_idx + 1 > 25:
        return 0
    return word_idx + 1

def get_converted(word, skip_index, index):
    word_idx = ord(word) - 97
    i = 0

    while i < index:
        word_idx = increase_idx(word_idx)
        if word_idx in skip_index:
            continue
        i += 1

    result = chr(word_idx + 97)
    return result

def solution(s, skip, index):
    answer = ''
    skip_index = get_skip_index(skip)

    for word in s:
        converted = get_converted(word, skip_index, index)
        answer += converted

    return answer