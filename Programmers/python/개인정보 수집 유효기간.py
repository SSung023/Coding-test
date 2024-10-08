# 놓친 부분
# 문제를 끝까지 꼼꼼하게 읽자. 유효기간은 12 미만이 아니다. 1 이상 100이하이다. 이 말은 곧 1년을 넘을 수 있다는 말이다. 

def get_term_map(terms):
    term_map = {}

    for term in terms:
        splits = term.split(" ")
        term_map[splits[0]] = int(splits[1])
    return term_map

def get_full(year, month, day):
    return int(str(year) + str(month).zfill(2) + str(day).zfill(2))

def convert_to_int(date):
    year, month, day = map(int, date.split('.'))
    return int(str(year) + str(month).zfill(2) + str(day).zfill(2))

# date: '2021.05.02'  duration: 6
def get_end_date(date, duration):
    # 2021, 5, 2
    year, month, day = map(int, date.split('.'))
    
    plus_year = duration // 12
    plus_month = duration % 12
    
    year += plus_year
    month += plus_month
    
    if (month > 12):
        year += 1
        month -= 12
    
    day -= 1
    if (day <= 0):
        day = 28
        month -= 1
        if(month <= 0):
            month = 12
            year -=1
    
    end_date = get_full(year, month, day)
    return end_date
    


def solution(today, terms, privacies):
    answer = []
    term_map = get_term_map(terms)
    today = convert_to_int(today)
    
    for i in range(len(privacies)):
        privacy = privacies[i]
        date, term = privacy.split(" ")
        duration = term_map[term]
        end_date = get_end_date(date, duration)
        if(today > end_date):
            answer.append(i + 1)
    
    return answer
