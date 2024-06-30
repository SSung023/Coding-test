def set_dict(keymap):
    dict = {}
    for keys in keymap:
        for i in range(len(keys)):
            key = keys[i]
            if key in dict:
                dict[key] = min(i + 1, dict[key])
                continue
            dict[key] = i + 1
    return dict

def check_is_possible(dict, target):
    result = 0
    for word in target:
        if word not in dict:
            return -1
        result += dict[word]
    return result

def solution(keymap, targets):
    answer = []
    dict = set_dict(keymap)
    
    for target in targets: 
        result = check_is_possible(dict, target)
        answer.append(result)
    
    return answer
