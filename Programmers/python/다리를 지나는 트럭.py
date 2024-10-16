from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = deque([0] * bridge_length)
    answer = 0
    cur_weight = 0
    truck_idx = 0
    
    # 아직 건널 트럭이 남아있을 때
    while truck_idx < len(truck_weights):
        answer += 1
        
        # 다리에 트럭이 꽉 차있다면 pop
        if len(bridge) >= bridge_length:
            cur_weight -= bridge.popleft()
        
        # 트럭이 다리 위에 올라올 수 있을 때
        if cur_weight + truck_weights[truck_idx] <= weight:
            truck = truck_weights[truck_idx]
            cur_weight += truck
            truck_idx += 1
            bridge.append(truck)
        else:
            bridge.append(0)

    # 마지막 트럭이 진입하자마자 종료되므로 마지막 트럭이 지나갈 때까지의 시간을 추가
    answer += bridge_length

    return answer
