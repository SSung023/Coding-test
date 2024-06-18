def search_start(park):
    for y in range(len(park)):
        for x in range(len(park[y])):
            if park[y][x] == "S":
                return y, x
            
def get_direction(dir):
    if dir == "E":
        return 0, 1
    if dir == "W":
        return 0, -1
    if dir == "N":
        return -1, 0
    if dir == "S":
        return 1, 0
    
def can_move(park, y, x, dir, distance):
    max_y = len(park) - 1
    max_x = len(park[0]) - 1
    dy, dx = get_direction(dir)
    
    for i in range(1, distance+1):
        next_y = y + dy * i
        next_x = x + dx * i                
        if next_y < 0 or next_y > max_y:
            return False;
        if next_x < 0 or next_x > max_x:
            return False;
            
        if park[next_y][next_x] == "X":
            return False;
    return True;


def solution(park, routes):
    answer = []
    y, x = search_start(park);
    
    for route in routes:
        order = route.split(" ");
        dir = order[0]
        distance = int(order[1])
        dy, dx = get_direction(dir)
        
        next_y = y + dy * distance 
        next_x = x + dx * distance 
                             
        if can_move(park, y, x, dir, distance) == True:
            y = next_y
            x = next_x
    
    answer.append(y)
    answer.append(x)
    return answer
